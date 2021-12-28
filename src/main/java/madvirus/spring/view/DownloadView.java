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

//���� download�� ���� Ŀ���� �� Class
public class DownloadView extends AbstractView{
	
	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		File file = (File) model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());//���� ũ�� ����
		
		String userAgent = request.getHeader("User-Agent");//get ������ ����
		
		boolean ie = false; 
		if(userAgent.contains("MISE") || userAgent.contains("Trident")) {//���ͳݺ�����(IE) üũ
			ie = true;
		}
		String fileName = null;
		if(ie) {//IE
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}else {//ũ���̳� �׿�
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");//Content-Disposition ����� �̿��ؼ� ���۵Ǵ� ���� �̸��� ���
		response.setHeader("Content-Transfer-Encoding", "binary");//���۵Ǵ� �������� ���ڵ��� ���̳ʸ� Ÿ������ ���
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
		out.flush();//���� ����
	}
}
