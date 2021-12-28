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
	//File ��ü�� "download"�信 �����ϴ� ��Ʈ�ѷ�
	//���� �ٿ�ε带 ���� ��� jsp�� velocity�� �ƴϱ� ������ Ŀ���� �� Class�� ������ �־�� �Ѵ�
	private WebApplicationContext context = null;
	
	@RequestMapping("/file")
	public ModelAndView download() throws Exception{
		File downloadFile = getFile();
		return new ModelAndView("download", "downloadFile", downloadFile);//download��� File ��ü(downloadFile)�� ����  "downloadFile"�̸����� ����(?)
	}
	
	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/����.txt");
		return new File(path);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}
