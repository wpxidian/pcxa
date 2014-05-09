<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<title>管理订单</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />

	<script type="text/javascript" charset="utf-8" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/common.js"></script>
  </head>
  <body>
   <div class="container">
 	 <form action="displayIndent">
			处理类型：
	 		<s:select list="#{'0':'已下单','1':'已发货','2':'已确认收货'}" name="trade_condition" value="trade_condition"
				headerKey="-1" headerValue="--所有--">				
			</s:select>
	 		商品名称：
	 		<s:select  list="goodsList" name="goodsId" listKey="goodsId" listValue="name" value="goodsId"
	 			headerKey="-1" headerValue="--所有--">				
			</s:select>
	 		<input type="submit" value="查询"/>
	</form>
	<form id="auditShopForm" action="auditIndent" method="post">
	<input type="submit" name="submit" value="标记为已发货"/>
	<input type="submit" name="submit" value="标记为已下单（及重新标记为未发货状态慎用！）"/>
	<table style="width:100%;"  border="1">
		<tr>
			<th>选择</th>
			<th>订单号</th>
			<th style="width:200px;">商品名称</th>
			<th>企业名称</th>
			<th>买家账号</th>
			<th>商品数量</th>
			<th>单价</th>
			<th>送货方式</th>
			<th>联系电话</th>
			<th>地址</th>
			<th>下单时间</th>
			<th>订单状态</th>
		</tr>
		 <s:iterator value="indentList" var="indent" >
		 	<tr>
		 		<td><input type="checkbox" name="ids" value="${indent.indentId}"/></td>
				<td>${indent.number}</td>
				<td>${indent.goods.name}</td>
				<td>${indent.goods.shop.name}</td>
				<td>${indent.user.username}</td>
				<td>${indent.count}</td>
				<td>${indent.price}元</td>
				<td>${indent.goods.sendMethod}</td>
				<td>${indent.phone}</td>
				<td>
					<s:if test="#indent.goods.sendMethod=='快递运输'">
						${indent.address} 
					</s:if>
					<s:else>
						无需地址
					</s:else>
				</td>
				<td>${indent.buyTime}</td>
				<td>
					<s:if test="#indent.tradeCondition==0">
						已下单
					</s:if>
					<s:elseif test="#indent.tradeCondition==1">
						已发货
					</s:elseif>
					<s:elseif test="#indent.tradeCondition==2">
						已收货
					</s:elseif>
				</td>
			</tr>
		 </s:iterator>
		</table>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$.formValidator.initConfig({formID:"auditShopForm",theme:'Default',debug:false,onSuccess:function(){
				if($(":checkbox[name='ids']:checked").length<1){
				 alert("请至少选择一个商铺信息");
				 return false;
				}else{return true;}
				}});
		});
	</script>
	</body>
</html>
