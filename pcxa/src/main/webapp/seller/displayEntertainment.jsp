<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>休闲娱乐管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/manageEntertainment.css" />
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
  <div><a href="insertEntertainmentPage">添加新的休闲娱乐项目</a></div>
   <table border="1">
   	<tr>
   		<th>娱乐项目名称</th>
   		<th>娱乐项目主图片</th>
   		<th>娱乐项目类别</th>
   		<th>娱乐项目简介</th>
   		<th>娱乐项目介绍</th>
   		<th>娱乐项目地址</th>
   		<th>联系电话</th>
   		<th>交通信息</th>   		
   		<th>娱乐项目图片</th>
   		<th>审核状态</th>  
   		<th colspan="2">操作</th> 		
   	</tr>
   	<s:iterator value="entertainmentList" var="entertainment" >
   	<tr>  
   		<td>${entertainment.name}</td>
   		<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${entertainment.pictureLink}"/></td>
   		<td>${entertainment.entertainmentClassification.name}</td>
   		<td class="brief_introduction">${entertainment.briefIntroduction}</td>
   		<td></td>
   		<td>${entertainment.address}</td>
   		<td>${entertainment.phone}</td>
   		<td class="bus">${entertainment.bus}</td>
   		<td>
   			<s:property value="#entertainment.entertainmentPictures.size" />张图片&nbsp;&nbsp;
   			<%-- <%=URLHelper.managePictures(entertainment_picture, "entertainment", "manageEntertainment.jsp")%> --%>
   		</td>  				
							 
   		<td><s:if test="#entertainment.weight==-1">
				未审核
			</s:if>
			<s:elseif test="#entertainment.weight==0">
				已审核
			</s:elseif>
			<s:elseif test="#entertainment.weight>0">
				高级会员
			</s:elseif>
		</td>
   		<td><a href="modifyEntertainmentPage?id=${entertainment.entertainmentId}">修改</a>&nbsp;&nbsp;&nbsp;
   			<a href="deleteEntertainment?id=${entertainment.entertainmentId}">删除</a>
   		</td>
   	</tr>
   	</s:iterator>
   </table>    
   </div>
  </body>
</html>
