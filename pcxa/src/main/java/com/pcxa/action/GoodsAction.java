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
import com.pcxa.model.*;
import com.pcxa.service.GoodsService;

@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
@Results(
		   {
		   @Result(name="success",type="chain",location="displayGoods"),
		   @Result(name="error",location="/seller/error.jsp")
		   }
		)
/**
 * 
 * ����ƣ�GoodsAction   
 * ����������Ʒ��������ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:48:27   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:48:27   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class GoodsAction extends ActionSupport{

	private static final long serialVersionUID = 6730598638127340776L;
	@Resource 
	private GoodsService goodsServiceImpl ;
	
	private Integer id ;
	private String name ;
	private Integer quantity_left ;
	private float price ;
	private String send_method ;
	private Integer goods_classification ;
	private String introduction ;
	private String picture_link ;
	private Integer weight = -1;
	private Integer state = -1;
	private Goods goods ;
	private List<Goods> goodsList ;
	private List<GoodsClassification> goodsClassificationList ;
		
	public List<GoodsClassification> getGoodsClassificationList() {
		return goodsClassificationList;
	}
	public void setGoodsClassificationList(
			List<GoodsClassification> goodsClassificationList) {
		this.goodsClassificationList = goodsClassificationList;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity_left() {
		return quantity_left;
	}

	public void setQuantity_left(int quantity_left) {
		this.quantity_left = quantity_left;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSend_method() {
		return send_method;
	}

	public void setSend_method(String send_method) {
		this.send_method = send_method;
	}

	public int getGoods_classification() {
		return goods_classification;
	}

	public void setGoods_classification(int goods_classification) {
		this.goods_classification = goods_classification;
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

	/**
	 * 
	 * @Description: �����Ʒҳ��
	 * @param @return
	 * @return String
	 * @throws
	 */
	@Action(value = "insertGoodsPage",results = { @Result(name = "success", location = "/seller/insertGoods.jsp")}) 
	public String insertGoodsPage() throws Exception{
		goodsClassificationList = goodsServiceImpl.getAllClassification() ;
		return SUCCESS ;
	}
	/**
	 *�����Ʒ
	 * @return
	 */
	@Action(value = "insertGoods") 
	public String insertGoods() throws Exception{
		//ActionContext.getContext().getSession().get("shop") ;
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		GoodsClassification goodsClassification = goodsServiceImpl.getClassification(goods_classification) ;
		goods = new Goods(shop, goodsClassification, name, weight, introduction, quantity_left, price, picture_link, send_method, state) ;
		if(goodsServiceImpl.insert(goods)>0){
			return SUCCESS ;
		}else{
			return ERROR ;
		}
	}
	/**
	 * �޸���Ʒ��Ϣ
	 * @throws Exception
	 */
	@Action(value = "modifyGoods") 
	public String modifyGoods() throws Exception{
		goods = goodsServiceImpl.get(id) ;
		GoodsClassification goodsClassification = goodsServiceImpl.getClassification(goods_classification) ;
		goods.setName(name) ;
		goods.setQuantityLeft(quantity_left) ;
		goods.setPrice(price) ;
		goods.setSendMethod(send_method) ;
		goods.setGoodsClassification(goodsClassification) ;
		goods.setIntroduction(introduction) ;
		goods.setPictureLink(picture_link) ;
		goodsServiceImpl.update(goods) ;
		return SUCCESS ;
	}
	/**
	 * ��Ʒ�������߹���
	 * @throws Exception
	 */
	@Action(value = "changeState") 
	public String changeState() throws Exception{
		goods = goodsServiceImpl.get(getId()) ;
		if(goods.getState()==0){
			goods.setState(1);
			goodsServiceImpl.update(goods) ;
			return SUCCESS ;
		}else if(goods.getState()==1){
			goods.setState(0);
			goodsServiceImpl.update(goods) ;
			return SUCCESS ;
		}
		return ERROR ;
	}
	/**
	 * չʾ��Ʒ
	 * @return
	 * @throws Exception
	 */
	@Action(value = "displayGoods",results = { @Result(name = "success", location = "/seller/displayGoods.jsp")}) 
	public String displayGoods() throws Exception{
		Shop shop = (Shop)ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		int shopId = shop.getShopId() ;
		goodsList = goodsServiceImpl.findGoodsByShopId(shopId) ;
		return SUCCESS ;
	}
	/**
	 * ��ȡ��Ҫ����Ʒ
	 * @return
	 * @throws Exception
	 */
	@Action(value = "modifyGoodsPage",results = { @Result(name = "success", location = "/seller/modifyGoods.jsp")}) 
	public String modifyGoodsPage() throws Exception{
		goods = goodsServiceImpl.get(id) ;
		this.send_method = goods.getSendMethod() ;
		this.goods_classification = goods.getGoodsClassification().getGoodsClassificationId() ;
		goodsClassificationList = goodsServiceImpl.getAllClassification() ;
		return SUCCESS ;
	}
}
