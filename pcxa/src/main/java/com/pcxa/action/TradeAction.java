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
import com.pcxa.model.Shop;
import com.pcxa.model.Trade;
import com.pcxa.model.TradeClassification;
import com.pcxa.service.TradeService;
/**
 * 
 * ����ƣ�TradeAction   
 * �������� ������Ȧ��������ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-5-4 ����2:19:10   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-5-4 ����2:19:10   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayTrade"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
public class TradeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1013233661638202362L;

	@Resource
	private TradeService tradeServiceImpl ;
	
	private Integer id;
	private Integer trade_classification;
	private String name;
	private String picture_link;
	private String brief_introduction;
	private String introduction;
	private String address;
	private String phone;
	private String bus;
	private Integer weight = -1;
	private Shop shop;
	private Trade trade ;
	private List<Trade> tradeList ;
	private List<TradeClassification> tradeClassificationList ;
	/**
	 * 
	 * չʾ���еĹ�������
	 * @return String
	 * @throws
	 */
	@Action(value = "displayTrade",results = { @Result(name = "success", location = "/seller/displayTrade.jsp")}) 
	public String displayTrade() throws Exception{
		tradeList = tradeServiceImpl.findAllTrade() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ��ת��������̵�ҳ��
	 * @return String
	 * @throws
	 */
	@Action(value = "insertTradePage",results = { @Result(name = "success", location = "/seller/insertTrade.jsp")}) 
	public String insertTradePage() throws Exception{
		tradeClassificationList = tradeServiceImpl.findAllTradeClassification() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * �������
	 * @return String
	 * @throws
	 */
	@Action(value = "insertTrade") 
	public String insertTrade() throws Exception{
		shop = (Shop) ActionContext.getContext().getSession().get("shop") ;
		TradeClassification tradingClassification = tradeServiceImpl.getTradeClassification(trade_classification) ;
		trade = new Trade(shop, tradingClassification, name, picture_link, brief_introduction, introduction, address, phone, bus, weight) ;
		tradeServiceImpl.insert(trade) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ��ת���޸����̵�ҳ��
	 * @return String
	 * @throws
	 */
	@Action(value = "modifyTradePage",results = { @Result(name = "success", location = "/seller/modifyTrade.jsp")}) 
	public String modifyTradePage() throws Exception{
		trade = tradeServiceImpl.get(id) ;
		trade_classification = trade.getTradeClassification().getTradeClassificationId() ;
		tradeClassificationList = tradeServiceImpl.findAllTradeClassification() ;
		return SUCCESS ;
	}
	/**
	 * 
	 * �޸�����
	 * @return String
	 * @throws
	 */
	@Action(value = "modifyTrade") 
	public String modifyTrade() throws Exception{
		trade = tradeServiceImpl.get(id) ;
		TradeClassification tradeClassification = tradeServiceImpl.getTradeClassification(trade_classification) ;
		trade.setName(name);
		trade.setAddress(address) ;
		trade.setBus(bus) ;
		trade.setPhone(phone) ;
		trade.setBriefIntroduction(brief_introduction) ;
		trade.setIntroduction(introduction) ;
		trade.setPictureLink(picture_link) ;
		trade.setTradeClassification(tradeClassification) ;
		tradeServiceImpl.update(trade) ;
		return SUCCESS ;
	}
	/**
	 * 
	 * ɾ������
	 * @return String
	 * @throws
	 */
	@Action(value = "deleteTrade") 
	public String deleteTrade() throws Exception{
		trade = tradeServiceImpl.get(id) ;
		tradeServiceImpl.delete(trade);
		return SUCCESS ;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTrade_classification() {
		return trade_classification;
	}
	public void setTrade_classification(Integer trade_classification) {
		this.trade_classification = trade_classification;
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
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public List<Trade> getTradeList() {
		return tradeList;
	}
	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}
	public List<TradeClassification> getTradeClassificationList() {
		return tradeClassificationList;
	}
	public void setTradeClassificationList(
			List<TradeClassification> tradeClassificationList) {
		this.tradeClassificationList = tradeClassificationList;
	}
	
}
