<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title>酒店住宿管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/manageHotel.css" />
  </head>  
  <body>
	<div class="container">
	<div><a href="insertHotel.jsp">添加新的酒店</a></div>
		<table border="1">
			<tr>
				<th width="10%">酒店名称</th>
				<th>酒店简介</th>		
				<th width="6%">酒店介绍</th>		
				<th>酒店主图片</th>
				<th>酒店链接</th>
				<th width="6%">酒店星级</th>
				<th>酒店地址</th>
				<th width="15%">交通信息</th>
				<th width="6%">联系电话</th>
				<th width="6%">审核状态</th>
				<th width="6%">操作</th> 
			</tr>
			<s:iterator value="hotelList" var="hotel" >
			<tr>
				<td>${hotel.name}</td>
				<td class="brief_introduction">${hotel.briefIntroduction}</td>
				<td><%-- ${hote.introduction} --%></td>
				<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${hotel.pictureLink}" /></td>	
				<td>${hotel.link}</td>
				<td>${hotel.star}星级</td>
				<td>${hotel.address}</td>
				<td class="bus">${hotel.bus}</td>		
				<td>${hotel.phone}</td>	
				<td>
					<s:if test="#hotel.weight==-1">
						未审核
					</s:if>
					<s:elseif test="#hotel.weight==0">
						已审核
					</s:elseif>
					<s:elseif test="#hotel.weight>0">
						高级会员信息
					</s:elseif>
				</td> 
				<td><a href="modifyHotelPage?id=${hotel.hotelId}">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="deleteHotel?id=${hotel.hotelId}">删除</a>
				</td>							
			</tr>
			</s:iterator>
		</table>
	</div>
   </body>
</html>
