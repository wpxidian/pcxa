package com.pcxa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pcxa.model.*;
import com.pcxa.service.GoodsService;
import com.pcxa.service.IndentService;
/**
 * 
 * ����ƣ�IndentAction   
 * ��������������������ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-4-29 ����9:47:16   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-4-29 ����9:47:16   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
@Controller  
@Namespace("/seller")  
@ParentPackage("struts-default")
public class IndentAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4805180072231488074L;
	
	private int goodsId = -1 ;
	private int trade_condition = -1 ;	
	private List<Goods> goodsList ;
	private List<Indent> indentList ;
	private IndentService indentServiceImpl ;
	private GoodsService goodsServiceImpl ;
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Indent> getIndentList() {
		return indentList;
	}

	public void setIndentList(List<Indent> indentList) {
		this.indentList = indentList;
	}
	public void setGoodsServiceImpl(GoodsService goodsServiceImpl) {
		this.goodsServiceImpl = goodsServiceImpl;
	}

	public void setIndentServiceImpl(IndentService indentServiceImpl) {
		this.indentServiceImpl = indentServiceImpl;
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getTrade_condition() {
		return trade_condition;
	}
	public void setTrade_condition(int trade_condition) {
		this.trade_condition = trade_condition;
	}
		
	/**
	 * չʾ����
	 * @return
	 * @throws Exception
	 */
	@Action(value = "displayIndent",results = { @Result(name = "success", location = "/seller/displayIndent.jsp")}) 
	public String display() throws Exception{
		//indentList = indentServiceImpl.findAllIndents() ;
		if(trade_condition == -1 && goodsId == -1){
			indentList = indentServiceImpl.findAllIndents();
		}else if(goodsId == -1){
			indentList = indentServiceImpl.findIndentsByTradeCondition(trade_condition);
		}else if(trade_condition == -1){
			indentList = indentServiceImpl.findIndentsByGoodsId(goodsId);
		}else{
			indentList = indentServiceImpl.findIndentsByTradeConAndGoodsId(trade_condition, goodsId);
		}
		Shop shop = (Shop) ServletActionContext.getRequest().getSession().getAttribute("shop") ;
		goodsList = goodsServiceImpl.findGoodsByShopId(shop.getShopId()) ;
		return SUCCESS;
	}

}
