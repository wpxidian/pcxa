<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理商品信息</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />
	</head>
	<body>
		<div class="container">
		<div><a href="insertGoodsPage">添加商品</a></div>
		<table style="width:100%" border="1">
		<tr>
			<th>商品名称</th>
			<th>景区主图片</th>
			<th>剩余数量</th>
			<th>价格</th>
			<th>商品类别</th>
			<th width="30%">商品介绍</th>
			<th>配送方式</th>
			<th>审核状态</th>
			<th>商品状态</th>
			<th>操作</th> 
		</tr>
			<s:iterator value="goodsList" var="goods" >
				<tr>
					<td>${goods.name}</td>
					<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${goods.pictureLink}" /></td>
					<td>${goods.quantityLeft}</td>
					<td>${goods.price}</td>
					<td>${goods.goodsClassification.name}</td>
					<td>${goods.introduction}</td>
					<td>${goods.sendMethod}</td>
					<td>
						<s:if test="#goods.weight==-1">
							未审核
						</s:if>
						<s:elseif test="#goods.weight==0">
							已审核
						</s:elseif>
						<s:elseif test="#goods.weight>0">
							高级会员信息
						</s:elseif>
					</td>
					<td>
						<s:if test="#goods.state==0">
							商品未上线
						</s:if>
						<s:elseif test="#goods.state==1">
							商品已上线
						</s:elseif>
					</td> 
					<td>
						<a href="modifyGoodsPage?id=${goods.goodsId}">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="changeState?id=${goods.goodsId}">
							<s:if test="#goods.state==0">
								申请上线
							</s:if>
							<s:elseif test="#goods.state==1">
								申请下线
							</s:elseif>
						</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		</div>
	</body>
</html>
