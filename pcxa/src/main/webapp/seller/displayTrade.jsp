<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理商铺信息</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/manageFood.css" />
		<link rel="stylesheet" type="text/css" href="js/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" type="text/css" href="js/kindeditor/plugins/code/prettify.css" />
		<link rel="stylesheet" type="text/css" href="js/uploadify/uploadify.css" />
		
		<script type="text/javascript" charset="utf-8" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/formValidator-4.1.3.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/formValidatorRegex.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/common.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/kindeditor/kindeditor.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/kindeditor/lang/zh_CN.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/kindeditor/plugins/code/prettify.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/uploadify/jquery.uploadify-3.1.min.js"></script>
	</head>
	<body>
		<div class="container">
		<div><a href="insertTradePage">添加商铺</a></div>
		<table  border="1" style="width:100%;">
		<tr>
			<th>商铺名称</th>
			<th>商铺简介</th> 
			<th>商铺地址</th>
			<th>商铺主图片</th>
			<th>所属商圈</th>
			<th>交通信息</th>
			<th>联系电话</th>
			<th>审核状况</th>
			<th>商铺介绍</th>
			<th>商铺图片</th>
			<th>操作</th> 
		</tr>
			<s:iterator value="tradeList" var="trade" >
				<tr>
					<td >${trade.name}</td>
					 <td style="width:10%;">${trade.briefIntroduction}</td>	 			
					<td style="width:6%;">${trade.address}</td>
					<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${trade.pictureLink}" /></td>
					<td>${trade.tradeClassification.name}</td>
					<td style="width:6%;">${trade.bus}</td>
					<td style="width:6%;">${trade.phone}</td>
					<td>
						<s:if test="#trade.weight==-1">
							未审核
						</s:if>
						<s:elseif test="#trade.weight==0">
							已审核
						</s:elseif>
						<s:elseif test="#trade.weight>0">
							高级会员
						</s:elseif>	
					</td> 
					<td><%--${trade.introduction}--%></td>
					<td>
						张&nbsp;&nbsp;
						 <%--<%=URLHelper.managePictures(trading_picture, "trading", "manageTrade.jsp")%>--%>
					</td>						
				 	<td>
				 		<a href="modifyTradePage?id=${trade.tradeId}">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="deleteTrade?id=${trade.tradeId}">删除</a>
					 </td>
				</tr>
			</s:iterator>
		</table>
		</div>
	</body>
</html>
