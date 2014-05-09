package com.pcxa.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.service.ShopService;
/**
 * 
 * 类名称：LoginAndLogoutAction   
 * 类描述：   
 * 创建人：WangPeng  
 * 创建时间：2014-5-5 下午4:38:07   
 * 修改人：WangPeng   
 * 修改时间：2014-5-5 下午4:38:07   
 * 修改备注：   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",location="/seller/main.jsp"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class LoginAndLogoutAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7928744533898446843L;

	@Resource 
	private ShopService shopServiceImpl ;
	
	private String username ;	
	private String password ;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 商铺登录
	 * @return
	 */
	@Action(value = "login") 
	public String login(){
		if(shopServiceImpl.validUser(getUsername(), getPassword())){
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 注销退出
	 * @return String
	 */
	@Action(value = "logout") 
	public String logout(){
		ActionContext.getContext().getSession().remove("shop") ;
		return SUCCESS;
	}
}
