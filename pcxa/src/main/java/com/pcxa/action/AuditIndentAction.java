package com.pcxa.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.model.Indent;
import com.pcxa.service.IndentService;
/**
 * 
 * ����ƣ�AuditIndentAction   
 * ��������������֤������ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:52:57   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:52:57   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayIndent"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class AuditIndentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8296164392163772564L;
	@Resource
	private IndentService indentServiceImpl ;
	
	private String submit ;
	private String[] ids ;

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Action(value = "auditIndent")
	public String execute() throws Exception {
		if(ids == null || ids.length == 0 || submit.equals("")){
			return ERROR ;
		}else{
			if(submit.equals("���Ϊ�ѷ���")){
				for(String id : ids){
					int idInt = Integer.parseInt(id) ;
					Indent indent = indentServiceImpl.get(idInt) ;
					indent.setTradeCondition(1) ;
					indentServiceImpl.update(indent) ;
				}
			}else{
				for(String id : ids){
					int idInt = Integer.parseInt(id) ;
					Indent indent = indentServiceImpl.get(idInt) ;
					indent.setTradeCondition(0) ;
					indentServiceImpl.update(indent) ;
				}
			}
			return SUCCESS ;
		}
	}
}
