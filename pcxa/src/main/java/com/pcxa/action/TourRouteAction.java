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
import com.pcxa.model.TourRoute;
import com.pcxa.model.TourRouteClassification;
import com.pcxa.service.TourRouteService;
/**
 * 
 * ����ƣ�TourRouteAction   
 * ����������Ʒ��·�Ŀ�����ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:50:40   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:50:40   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller
@Namespace("/seller")
@ParentPackage("struts-default")
@Results(
			{
			 @Result(name="success",type="chain",location="displayTourRoute"),
			 @Result(name="error",location="/seller/error.jsp")
			}
		)
public class TourRouteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075193703437396881L;
	@Resource
	private TourRouteService tourRouteServiceImpl ;
	
	private Integer id;
	private Shop shop;
	private Integer route_classification;
	private String name;
	private String picture_link;
	private String brief_introduction;
	private String introduction;
	private Integer weight=-1;

	private TourRoute tourRoute ;
	private List<TourRoute> tourRouteList ;
	private List<TourRouteClassification> tourRouteClassificationList ;
	
	/**
	 * ��ת�޸�������·ҳ��
	 * @return
	 * @throws Exception
	 */
	@Action(value = "insertTourRoutePage",results = { @Result(name = "success", location = "/seller/insertTourRoute.jsp")})
	public String insertTourRoutePage() throws Exception{
		tourRouteClassificationList = tourRouteServiceImpl.findAllTourRouteClassification() ;
		return SUCCESS ;
	}
	/**
	 * ���������·
	 * @return
	 * @throws Exception
	 */
	@Action(value="insertTourRoute")
	public String insertTourRoute() throws Exception{
		shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		TourRouteClassification routeClassification = tourRouteServiceImpl.getTourRouteClassification(route_classification) ;
		tourRoute = new TourRoute(shop, routeClassification, name, picture_link, brief_introduction, introduction, weight) ;
		tourRouteServiceImpl.insert(tourRoute) ;
		return SUCCESS;
	}
	/**
	 * ɾ��������·
	 * @return
	 * @throws Exception
	 */
	@Action(value="deleteTourRoute")
	public String deleteTourRoute() throws Exception{
		tourRoute = tourRouteServiceImpl.get(id) ;
		tourRouteServiceImpl.delete(tourRoute) ;
		return SUCCESS ;
	}
	/**
	 * ��ȡ�޸�������·ҳ��
	 * @return
	 * @throws Exception
	 */
	@Action(value="modifyTourRoutePage",results={@Result(name="success",location="/seller/modifyTourRoute.jsp")})
	public String modifyTourRoutePage() throws Exception{
		tourRoute = tourRouteServiceImpl.get(id) ;
		route_classification = tourRoute.getTourRouteClassification().getTourRouteClassificationId() ;
		return SUCCESS;
	}
	/**
	 * �޸�������·
	 * @return
	 * @throws Exception
	 */
	@Action(value="modifyTourRoute")
	public String modifyTourRoute() throws Exception{
		tourRoute = tourRouteServiceImpl.get(id) ;
		tourRoute.setName(name) ;
		tourRoute.setBriefIntroduction(brief_introduction) ;
		tourRoute.setIntroduction(introduction);
		tourRoute.setPictureLink(picture_link);
		tourRouteServiceImpl.update(tourRoute);
		return SUCCESS;
	}
	/**
	 * չʾ������·
	 * @return
	 * @throws Exception
	 */
	@Action(value="displayTourRoute",results={@Result(name="success",location="/seller/displayTourRoute.jsp")})
	public String display() throws Exception{
		tourRouteList = tourRouteServiceImpl.findAllTourRoute() ;
		return SUCCESS ;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
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
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public TourRoute getTourRoute() {
		return tourRoute;
	}
	public void setTourRoute(TourRoute tourRoute) {
		this.tourRoute = tourRoute;
	}
	public List<TourRoute> getTourRouteList() {
		return tourRouteList;
	}
	public void setTourRouteList(List<TourRoute> tourRouteList) {
		this.tourRouteList = tourRouteList;
	}
	public List<TourRouteClassification> getTourRouteClassificationList() {
		return tourRouteClassificationList;
	}
	public void setTourRouteClassificationList(
			List<TourRouteClassification> tourRouteClassificationList) {
		this.tourRouteClassificationList = tourRouteClassificationList;
	}
	public void setTourRouteServiceImpl(TourRouteService tourRouteServiceImpl) {
		this.tourRouteServiceImpl = tourRouteServiceImpl;
	}
	public Integer getRoute_classification() {
		return route_classification;
	}
	public void setRoute_classification(Integer route_classification) {
		this.route_classification = route_classification;
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
}
