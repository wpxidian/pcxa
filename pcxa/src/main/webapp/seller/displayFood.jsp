<%@ page import="com.pcxa.util.URLHelper"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>        
    <title>餐饮商铺管理</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />
  </head>
  <body>
	  <div class="container">
	  <div><a href="insertFood.jsp">添加特色美食</a></div>
	  <br />
	  <table style="width:100%" border="1">
	   <tr>
	    <th>名称</th>
	    <th>简介</th>
	    <th>主图片</th>
	    <th>店铺介绍</th>
	    <th>地址</th>
	    <th>电话</th>
	    <th>公交信息</th>
	    <th>链接</th>
	    <th>是否通过审核</th>
	    <th>操作</th>
	   </tr>
	  	 <s:iterator value="foodList" var="food" >
	         <tr>
	           <td style="width:10%;">${food.name}</td>
	           <td style="width:10%;" class="brief_introduction" >${food.briefIntroduction}</td>
	           <td style="width:10%;"><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${food.pictureLink}"/></td>
	           <td style="width:10%;"><%--${food.introduction}--%></td>
	           <td style="width:10%;" class="address">${food.address}</td>
	           <td style="width:10%;">${food.phone}</td>
	           <td style="width:10%;" class="bus">${food.bus}</td>
	           <td style="width:10%;">${food.link}</td>
	           <td style="width:10%;">
	           		<s:if test="#food.weight==-1">
							未审核
						</s:if>
						<s:elseif test="#food.weight==0">
							已审核
						</s:elseif>
						<s:elseif test="#food.weight>0">
							高级会员信息
						</s:elseif>
	            </td>
	            <td style="width:10%;"><a href="modifyFoodPage?id=${food.foodId}">修改</a>&nbsp;&nbsp;&nbsp;
	            	<a href="deleteFood?id=${food.foodId}">删除</a>
	            </td>
	         </tr>
	   </s:iterator>       
	  </table>
	   </div>
  </body>
</html>
