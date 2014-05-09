package com.pcxa.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.model.Entertainment;
import com.pcxa.model.EntertainmentClassification;
import com.pcxa.model.Shop;
import com.pcxa.service.EntertainmentService;
/**
 * 
 * ����ƣ�EntertainmentAction   
 * ���������������ֿ�������ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����10:52:09   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����10:52:09   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayEntertainment"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class EntertainmentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6798114738670104833L;

	@Resource
	private EntertainmentService entertainmentServiceImpl ;
	
	private Integer id;
	private Integer entertainment_classification;
	private String name;
	private String picture_link;
	private String brief_introduction;
	private String introduction;
	private String address;
	private String phone;
	private String bus;
	private Integer weight = -1; 
	private Entertainment entertainment ;
	private List<Entertainment> entertainmentList ;
	private List<EntertainmentClassification> entertainmentClassificationList ;
	/**
	 * 
	 * չʾ���е���������
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="displayEntertainment",results={@Result(name="success",location="/seller/displayEntertainment.jsp")})
	public String displayEntertainment() throws Exception{
		entertainmentList = entertainmentServiceImpl.findAllEntertainment() ;
		entertainmentClassificationList = entertainmentServiceImpl.getAllClassification() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ��ת����������ֽ���
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="insertEntertainmentPage",results={@Result(name="success",location="/seller/insertEntertainment.jsp")})
	public String insertEntertainmentPage() throws Exception{
		entertainmentClassificationList = entertainmentServiceImpl.getAllClassification() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * �����������
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="insertEntertainment")
	public String insertEntertainment() throws Exception{
		Shop shop = (Shop)ActionContext.getContext().getSession().get("shop") ;
		EntertainmentClassification entertainmentClassification = entertainmentServiceImpl.getClassification(entertainment_classification) ;
		entertainment = new Entertainment(shop, entertainmentClassification, name, picture_link, brief_introduction, 
				introduction, address, phone, bus, weight) ;
		entertainmentServiceImpl.insert(entertainment) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ��ת�����������ֽ���
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="modifyEntertainmentPage",results={@Result(name="success",location="/seller/modifyEntertainment.jsp")})
	public String modifyFoodPage() throws Exception{
		entertainment = entertainmentServiceImpl.get(id) ;
		entertainment_classification = entertainment.getEntertainmentClassification().getEntertainmentClassificationId();
		entertainmentClassificationList = entertainmentServiceImpl.getAllClassification() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ������������
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="modifyEntertainment")
	public String modifyEntertainment() throws Exception{
		entertainment = entertainmentServiceImpl.get(id) ;
		EntertainmentClassification entertainmentClassification = entertainmentServiceImpl.getClassification(entertainment_classification) ;
		entertainment.setName(name) ;
		entertainment.setAddress(address) ;
		entertainment.setBus(bus) ;
		entertainment.setPhone(phone) ;
		entertainment.setEntertainmentClassification(entertainmentClassification) ;
		entertainment.setBriefIntroduction(brief_introduction) ;
		entertainment.setIntroduction(introduction) ;
		entertainment.setPictureLink(picture_link) ;
		entertainmentServiceImpl.update(entertainment) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ɾ����������
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="deleteEntertainment")
	public String deleteEntertainment() throws Exception{
		entertainment = entertainmentServiceImpl.get(id) ;
		entertainmentServiceImpl.delete(entertainment) ;
		return SUCCESS ;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEntertainment_classification() {
		return entertainment_classification;
	}
	public void setEntertainment_classification(Integer entertainment_classification) {
		this.entertainment_classification = entertainment_classification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture_link() {
		return picture_link;
	}
	public void setPicture_link(String picture_link) {
		this.picture_link = picture_link;
	}
	public String getBrief_introduction() {
		return brief_introduction;
	}
	public void setBrief_introduction(String brief_introduction) {
		this.brief_introduction = brief_introduction;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Entertainment getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(Entertainment entertainment) {
		this.entertainment = entertainment;
	}
	public List<Entertainment> getEntertainmentList() {
		return entertainmentList;
	}
	public void setEntertainmentList(List<Entertainment> entertainmentList) {
		this.entertainmentList = entertainmentList;
	}
	public List<EntertainmentClassification> getEntertainmentClassificationList() {
		return entertainmentClassificationList;
	}
	public void setEntertainmentClassificationList(
			List<EntertainmentClassification> entertainmentClassificationList) {
		this.entertainmentClassificationList = entertainmentClassificationList;
	}
	
}
