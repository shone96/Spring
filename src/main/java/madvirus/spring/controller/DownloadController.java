package madvirus.spring.controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {
	//File 객체를 "download"뷰에 전달하는 컨트롤러
	//파일 다운로드를 위한 뷰는 jsp나 velocity가 아니기 때문에 커스텀 뷰 Class를 구현해 주어야 한다
	private WebApplicationContext context = null;
	
	@RequestMapping("/file")
	public ModelAndView download() throws Exception{
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);//download뷰로 File 객체(downloadFile)의 값을  "downloadFile"이름으로 리턴(?)
	}
	
	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
		return new File(path);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}
