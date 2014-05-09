package com.pcxa.action;

import java.util.List;

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
import com.pcxa.model.TouristClassification;
import com.pcxa.model.TouristSpot;
import com.pcxa.service.TouristSpotService;
/**
 * 
 * ����ƣ�TouristSpotAction   
 * �������� ���ξ���Ŀ�����ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:50:25   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:50:25   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller
@Namespace("/seller")
@ParentPackage("struts-default")
@Results(
			{
			 @Result(name="success",type="chain",location="displayTouristSpot"),
			 @Result(name="error",location="/seller/error.jsp")
			}
		)
public class TouristSpotAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 81089251429658395L;
	@Resource
	private TouristSpotService touristSpotServiceImpl ;
	
	private Integer id ;
	private String name;
	private String brief_introduction;
	private String introduction;
	private float longitude;
	private float latitude;
	private String address;
	private String picture_link;
	private Integer grade;
	private Integer tourists_classification;
	private Integer weight;
	private String bus;
	private String phone;
	
	private TouristSpot touristSpot ;
	private List<TouristSpot> touristSpotList ;
	private List<TouristClassification> touristClassificationList ;
	
	/**
	 * չʾ����
	 * @return
	 * @throws Exception
	 */
	@Action(value = "displayTouristSpot",results = { @Result(name = "success", location = "/seller/displayTouristSpot.jsp")})
	public String displayTouristSpot() throws Exception{
		touristSpotList = touristSpotServiceImpl.findAllTouristSpot() ;
		return SUCCESS ;
	}
	/**
	 * ��ȡ��Ҫ�޸ĵľ���
	 * @return
	 * @throws Exception
	 */
	@Action(value = "modifyTouristSpotPage",results = { @Result(name = "success", location = "/seller/modifyTouristSpot.jsp")})
	public String modifyTouristSpotPage() throws Exception{
		touristSpot = touristSpotServiceImpl.get(id) ;
		grade = touristSpot.getGrade() ;
		tourists_classification = touristSpot.getTouristClassification().getTouristClassificationId() ;
		touristClassificationList = touristSpotServiceImpl.findAllTouristClassification() ;
		return SUCCESS ;
	}
	/**
	 * ���¾���
	 * @throws Exception
	 */
	@Action(value = "modifyTouristSpot")
	public String modifyTouristSpot() throws Exception{
		TouristClassification touristClassification = touristSpotServiceImpl.getTouristClassification(tourists_classification) ;
		TouristSpot touristSpot = touristSpotServiceImpl.get(id) ;
		touristSpot.setName(name) ;
		touristSpot.setAddress(address) ;
		touristSpot.setBus(bus) ;
		touristSpot.setPhone(phone) ;
		touristSpot.setGrade(grade) ;
		touristSpot.setTouristClassification(touristClassification) ;
		touristSpot.setLatitude(latitude) ;
		touristSpot.setLongitude(longitude) ;
		touristSpot.setBriefIntroduction(brief_introduction) ;
		touristSpot.setIntroduction(brief_introduction) ;
		touristSpot.setPictureLink(picture_link) ;
		touristSpotServiceImpl.update(touristSpot) ;
		return SUCCESS ;
	}
	/**
	 * ��Ӿ����ҳ��
	 * @return
	 * @throws Exception
	 */
	@Action(value = "insertTouristSpotPage",results = { @Result(name = "success", location = "/seller/insertTouristSpot.jsp")})
	public String insertTouristSpotPage() throws Exception{
		touristClassificationList = touristSpotServiceImpl.findAllTouristClassification() ;
		return SUCCESS ;
	}
	/**
	 * ��Ӿ���
	 * @throws Exception
	 */
	@Action(value = "insertTouristSpot")
	public String insertTouristSpot() throws Exception{
		Shop shop = (Shop)ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		TouristClassification touristClassification = touristSpotServiceImpl.getTouristClassification(tourists_classification) ;
		touristSpot = new TouristSpot(shop, touristClassification, name, brief_introduction, brief_introduction, longitude, latitude, address, picture_link, grade, weight, bus, phone);
		if(touristSpotServiceImpl.insert(touristSpot)>0){
			return SUCCESS ;
		}else{
			return ERROR ;
		}
	}
	/**
	 * ɾ���
	 * @throws Exception
	 */
	@Action(value = "deleteTouristSpot")
	public String deleteTouristSpot() throws Exception{
		touristSpot = touristSpotServiceImpl.get(id) ;
		touristSpotServiceImpl.delete(touristSpot) ;
		return SUCCESS ;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture_link() {
		return picture_link;
	}
	public void setPicture_link(String picture_link) {
		this.picture_link = picture_link;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getTourists_classification() {
		return tourists_classification;
	}
	public void setTourists_classification(Integer tourists_classification) {
		this.tourists_classification = tourists_classification;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	

	public TouristSpot getTouristSpot() {
		return touristSpot;
	}
	public void setTouristSpot(TouristSpot touristSpot) {
		this.touristSpot = touristSpot;
	}
	public List<TouristSpot> getTouristSpotList() {
		return touristSpotList;
	}
	public void setTouristSpotList(List<TouristSpot> touristSpotList) {
		this.touristSpotList = touristSpotList;
	}
	public List<TouristClassification> getTouristClassificationList() {
		return touristClassificationList;
	}
	public void setTouristClassificationList(
			List<TouristClassification> touristClassificationList) {
		this.touristClassificationList = touristClassificationList;
	}
	
}
