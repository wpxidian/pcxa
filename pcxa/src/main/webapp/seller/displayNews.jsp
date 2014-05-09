<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理新闻</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />
	
		<script type="text/javascript" charset="utf-8" src="js/jquery-1.7.2.min.js"></script>
	</head>
	<body>
		<div class="container">
		<div><a href="insertNews.jsp">添加新闻</a></div>
		<table style="width:100%;"  border="1">
		<tr>
			<th width="25%">新闻标题</th>
			<th>图片</th>
			<th>发布时间</th>
			<th>正文</th>
			<th>操作</th> 
		</tr>
		<s:iterator value="newsList" var="news" >
		<tr>
			<td>${news.title}</td>
			<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${news.pictureLink}" /></td>
			<td>${news.time}</td>
			<td><%--${news.introduction}--%></td>
			<td><a href="modifyNewsPage?id=${news.newsId}">修改</a>&nbsp;&nbsp;&nbsp;<a href="deleteNews?id=${news.newsId}">删除</a></td>
		</tr>
		 </s:iterator>
		</table>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				<%
					URLHelper.alertMessage(request,out);
				%>
			});
		</script>
	</body>
</html>
