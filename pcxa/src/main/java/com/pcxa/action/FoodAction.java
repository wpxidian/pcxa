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
import com.pcxa.model.Food;
import com.pcxa.model.Shop;
import com.pcxa.service.FoodService;

/**
 * 
 * ����ƣ�FoodAction   
 * �������� ��ʳ�Ŀ�����ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����4:44:48   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����4:44:48   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller
@Namespace("/seller")
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayFood"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class FoodAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6446351654588787776L;
	@Resource
	private FoodService foodServiceImpl ;
	
	private Integer id ;
	private String name ;
	private String brief_introduction ;
	private String introduction ;
	private String picture_link ;
	private String address ;
	private String phone ;
	private String bus ;
	private String link ;
	private Integer weight = -1;
	private Food food ;
	private List<Food> foodList ;
	/**
	 * 
	 * չʾ���е���ʳ
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="displayFood",results={@Result(name="success",location="/seller/displayFood.jsp")})
	public String displayFood() throws Exception{
		foodList = foodServiceImpl.findAllFood() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * �����ʳ
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="insertFood")
	public String insertFood() throws Exception{
		Shop shop = (Shop)ActionContext.getContext().getSession().get("shop") ;
		food = new Food(shop, name, brief_introduction, introduction, picture_link, address, phone, bus, weight, link) ;
		foodServiceImpl.insert(food) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * @Description: TODO
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="modifyFoodPage",results={@Result(name="success",location="/seller/modifyFood.jsp")})
	public String modifyFoodPage() throws Exception{
		food = foodServiceImpl.get(id) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ������ʳ
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="modifyFood")
	public String modifyFood() throws Exception{
		food = foodServiceImpl.get(id) ;
		food.setName(name) ;
		food.setBriefIntroduction(brief_introduction) ;
		food.setIntroduction(introduction) ;
		food.setPictureLink(picture_link) ;
		food.setAddress(address) ;
		food.setPhone(phone) ;
		food.setBus(bus) ;
		food.setLink(link) ;
		foodServiceImpl.update(food) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ɾ����ʳ
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@Action(value="deleteFood")
	public String deleteFood() throws Exception{
		food = foodServiceImpl.get(id) ;
		foodServiceImpl.delete(food) ;
		return SUCCESS ;
	}
	
	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
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
	public String getPicture_link() {
		return picture_link;
	}
	public void setPicture_link(String picture_link) {
		this.picture_link = picture_link;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
}
