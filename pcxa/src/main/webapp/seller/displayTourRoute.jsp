<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>        
    <title>旅游路线管理</title>
	<link rel="stylesheet" type="text/css" href="css/manageFood.css">
	<link rel="stylesheet" type="text/css" href="css/common.css">
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
	  <div><a href="insertTourRoutePage">添加旅游路线</a></div>
	  <br />
	  <table style="width:100%;"  border="1">
		   <tr>
		    <th>名称</th>
		    <th width="30%">简介</th>
		    <th>主图片</th>
		    <th>路线介绍</th>
		    <th>是否通过审核</th>
		    <th>操作</th>
		   </tr>
	       <s:iterator value="tourRouteList" var="tourRoute" >
	         <tr>
	           <td>${tourRoute.name}</td>
	           <td class="brief_introduction">${tourRoute.briefIntroduction}</td>
	           <td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${tourRoute.pictureLink}"/></td>
	           <td><%-- ${tourRoute.introduction} --%></td>
	           <td>
	           		<s:if test="#tourRoute.weight==-1">
						未审核
					</s:if>
					<s:elseif test="#tourRoute.weight==0">
						已审核
					</s:elseif>
					<s:else>
						高级会员
					</s:else> 
	            </td>
	            <td><a href="modifyTourRoutePage?id=${tourRoute.tourRouteId}">修改</a>&nbsp;&nbsp;&nbsp;
	            	<a href="deleteTourRoute?id=${tourRoute.tourRouteId}">删除</a>
	            </td>
	         </tr>      
	       </s:iterator>
	  </table>
   </div>	
  </body>
</html>
