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
import com.pcxa.model.Hotel;
import com.pcxa.model.Shop;
import com.pcxa.service.HotelService;
/**
 * 
 * ����ƣ�HotelAction   
 * �������� �Ƶ��������ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:22:58   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:22:58   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayHotel"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class HotelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6671106270144934024L;
	@Resource
	private HotelService hotelServiceImpl ;
	
	private Integer id ;
	private String name ;
	private String phone ;
	private String link ;
	private String star ;
	private String address ;
	private String brief_introduction ;
	private String introduction ;
	private String picture_link ;
	private String bus ;
	private Integer weight = -1 ;	
	private Hotel hotel ;
	private List<Hotel> hotelList ;
	/**
	 * 
	 * չʾ���оƵ�
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="displayHotel",results={@Result(name="success",location="/seller/displayHotel.jsp")})
	public String displayHotel() throws Exception{
		hotelList = hotelServiceImpl.findAllHotel() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ��ӾƵ���Ϣ
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="insertHotel")
	public String insertHotel() throws Exception{
		Shop shop = (Shop)ActionContext.getContext().getSession().get("shop") ;
		hotel = new Hotel(shop, name, picture_link, introduction, star, link, brief_introduction, address, phone, bus, weight) ;
		hotelServiceImpl.insert(hotel) ;
		return SUCCESS ;
	}
	/**
	 * ��ȡ�޸ľƵ��ҳ��
	 * @param @return
	 * @return String
	 * @throws
	 */
	@Action(value="modifyHotelPage",results={@Result(name="success",location="/seller/modifyHotel.jsp")})
	public String modifyHotelPage() throws Exception{
		hotel = hotelServiceImpl.get(id) ;
		star = hotel.getStar() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ���¾Ƶ���Ϣ
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="modifyHotel")
	public String modifyHotel() throws Exception{
		hotel = hotelServiceImpl.get(id) ;
		hotel.setName(name) ;
		hotel.setPhone(phone) ;
		hotel.setAddress(address) ;
		hotel.setLink(link) ;
		hotel.setStar(star) ;
		hotel.setBus(bus) ;
		hotel.setBriefIntroduction(brief_introduction) ;
		hotel.setIntroduction(introduction) ;
		hotel.setPictureLink(picture_link) ;
		hotelServiceImpl.update(hotel) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ɾ��Ƶ�
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="deleteHotel")
	public String deleteHotel() throws Exception{
		hotel = hotelServiceImpl.get(id) ;
		hotelServiceImpl.delete(hotel) ;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPicture_link() {
		return picture_link;
	}
	public void setPicture_link(String picture_link) {
		this.picture_link = picture_link;
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Hotel> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	

}
