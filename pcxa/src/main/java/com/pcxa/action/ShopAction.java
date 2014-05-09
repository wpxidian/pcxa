package com.pcxa.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result; 
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.model.Shop;
import com.pcxa.service.ShopService;
/**
 * 
 * ����ƣ�ShopAction   
 * �����������̿�������ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:50:05   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:50:05   
 * �޸ı�ע��   
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
public class ShopAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -148237404943062149L;
	@Resource 
	private ShopService shopServiceImpl ;

	private String newPassword ;
	private String name ;
	private String introduction ;
	private String mail_box ;
	private String phone ;
	private String account ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getMail_box() {
		return mail_box;
	}
	public void setMail_box(String mail_box) {
		this.mail_box = mail_box;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * ������ҵ����
	 * @return
	 * @throws Exception
	 */
	@Action(value = "modifyPassword") 
	public String modifyPassword() throws Exception {
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		if(shop != null){
			if(shopServiceImpl.validUser(shop.getUsername(), shop.getPassword())){
				shop.setPassword(newPassword) ;
				if(shopServiceImpl.update(shop)){
					return SUCCESS ;
				}
				return ERROR ;
			}
		}	
		return ERROR ;
	}
	/**
	 * ������ҵ��Ϣ
	 * @return
	 */
	@Action(value = "modifyShopInfo") 
	public String modifyShopInfo(){
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		if(shop != null){
			shop.setName(name) ;
			shop.setIntroduction(introduction) ;
			shop.setMailBox(mail_box) ;
			shop.setPhone(phone) ;
			shop.setAccount(account) ;
			if(shopServiceImpl.update(shop)){
				return SUCCESS ;
			}
			return ERROR ;
		}
		return ERROR ;
	}
}
