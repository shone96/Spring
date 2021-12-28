package madvirus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	
	private Authenticator authenticator;
	
	@ModelAttribute("login")//login객체의 초기화 작업을 수행 LoginCommand자바빈 값으로 초기화
	public LoginCommand formBacking() {
		return new LoginCommand(); 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST) //loginForm에서 submit클릭시
	public String submit(@ModelAttribute("login") LoginCommand loginCommand, BindingResult result) {
		new LoginCommandValidator().validate(loginCommand, result);
		if(result.hasErrors()) {//유효성 검사후 에러가 있을시 다시 loginForm.jsp로 리턴
			return "loginForm";
		}
		try {
			//Authenticator 인터페이스객체에 값이 있을시 loginSuccess.jsp로 리턴
			authenticator.authenticate(loginCommand.getId(), loginCommand.getPassword());
			return "loginSuccess";
		}catch(AuthenticationException ex) {
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getId() }, null);
			return "loginForm";
		}
	}
	
	@ModelAttribute("loginTypes") //<select> 태그에서 사용될 옵션 목록을 loginTypes 명칭으로 전달
	protected List<String> referenceData() throws Exception {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("가입회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

}
