package com.pcxa.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.util.URLHelper;

/**
 * 
 * ����ƣ�FileUploadAction   
 * ���������ļ��ϴ��Ŀ�����ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:53:27   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:53:27   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller
@Namespace("/seller")
@ParentPackage("struts-default")
public class FileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4896241199194467619L;

	private List<File> uploadify = null;  	   
    private List<String> uploadifyFileName = null;  //�ϴ��ļ��� �б�     
    
    public List<File> getUploadify() {
		return uploadify;
	}
   
	public void setUploadify(List<File> uploadify) {
		this.uploadify = uploadify;
	}

	public List<String> getUploadifyFileName() {
		return uploadifyFileName;
	}

	public void setUploadifyFileName(List<String> uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}

    /** 
     * ���� �ļ�
     *  
     * @return 
     * @throws Exception 
     */ 
	@Action("fileUpload")
	public void fileUpload() throws Exception {
		String fileName = null ;
		String extName = null ;
		String savePath = ServletActionContext.getServletContext().getRealPath(URLHelper.uploadFolder) ;
		 try {  
            int i=0;
            for (File file : getUploadify()) {  
                //�ļ������磺ID.�ļ���׺  
            	fileName = getUploadifyFileName().get(i) ;
            	if (fileName.lastIndexOf(".") >= 0) {
					extName = fileName.substring(fileName.lastIndexOf("."));
				}
            	fileName = UUID.randomUUID().toString() ;
                FileOutputStream fos = new FileOutputStream(savePath + "\\"  
                        + fileName + extName);  
                FileInputStream fis = new FileInputStream(file);  
                byte[] buffer = new byte[1024];  
                int len = 0;  
                while ((len = fis.read(buffer)) > 0) {  
                    fos.write(buffer, 0, len);  
                }  
                fos.close();  
                fis.close();  
                i++;  
	        }  
	     }catch (Exception e) {  
	         e.printStackTrace() ;
	     }
		 ServletActionContext.getResponse().getWriter().print(fileName + extName);
	}  
}
