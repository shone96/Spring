package madvirus.spring.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 download를 위한 커스텀 뷰 Class
public class DownloadView extends AbstractView{
	
	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		File file = (File) model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());//파일 크기 설정
		
		String userAgent = request.getHeader("User-Agent");//get 브라우저 정보
		
		boolean ie = false; 
		if(userAgent.contains("MISE") || userAgent.contains("Trident")) {//인터넷브라우저(IE) 체크
			ie = true;
		}
		String fileName = null;
		if(ie) {//IE
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}else {//크롬이나 그외
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");//Content-Disposition 헤더를 이용해서 전송되는 파일 이름을 명시
		response.setHeader("Content-Transfer-Encoding", "binary");//전송되는 데이터의 인코딩이 바이너리 타입으로 명시
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}finally {
			if(fis != null) {
				try {
					fis.close();
				}catch(IOException ex) {
					
				}
			}
		}
		out.flush();//파일 전송
	}
}
