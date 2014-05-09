<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理景区信息</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />
	</head>
	<body>
		<div class="container">
		<div><a href="insertTouristSpotPage">添加景点</a></div>
		<table style="width:100%" border="1">
		<tr>
			<th>景区名称</th>
			<th>景区简介</th>
			<th>经度</th>
			<th>纬度</th>
			<th>景区地址</th>
			<th>景区主图片</th>
			<th>旅游等级</th>
			<th>景区类别</th>
			<th>交通信息</th>
			<th>联系电话</th>
			<th>审核状态</th>
			<th>景区介绍</th>
			<th>景区图片</th>
			<th>景区视频</th>
			<th>景区子景点</th>
			<th>操作</th> 
		</tr>
			<s:iterator value="touristSpotList" var="touristSpot" >
				<tr>
					<td>${touristSpot.name}</td>
					<td class="brief_introduction">${touristSpot.briefIntroduction}</td>
					<td>${touristSpot.longitude}</td>
					<td>${touristSpot.latitude}</td>
					<td class="address">${touristSpot.address}</td>
					<td><img class="picture_link" src="<%=URLHelper.imgFolderForSellerAndAdmin%>${touristSpot.pictureLink}" /></td>
					<td>${touristSpot.grade}星级</td>
					<td>${touristSpot.touristClassification.name}</td>
					<td class="bus">${touristSpot.bus}</td>
					<td>${touristSpot.phone}</td>
					<td>
						<s:if test="#touristSpot.weight==-1">
							未审核
						</s:if>
						<s:elseif test="#touristSpot.weight==0">
							已审核
						</s:elseif>
						<s:elseif test="#touristSpot.weight>0">
							会员积分${touristSpot.weight}
						</s:elseif>
					</td> 
					<td><%-- ${touristSpot.introduction} --%></td>
					<td>
						<s:property value="#touristSpot.touristPictures.size" />副&nbsp;&nbsp;
						<%-- <%=URLHelper.managePictures(tourists_picture, "tourists_spots", "manageTourists.jsp")%> --%>
					</td>
					<td>
						<s:property value="#touristSpot.touristVideos.size" />部&nbsp;&nbsp;
						<%-- <%=URLHelper.manageVideos(tourists_video, "tourists_spots", "manageTourists.jsp")%> --%>
					</td>
					<td>
						<a href="manageSpots.jsp?tourists_Id=${touristSpot.touristSpotId}">
							<s:property value="#touristSpot.spots.size" />个&nbsp;&nbsp;管理
						</a> 
					</td>
					<td>
						<a href="modifyTouristSpotPage?id=${touristSpot.touristSpotId}">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="deleteTouristSpot?id=${touristSpot.touristSpotId}">删除</a>
					</td>
				</tr>
			 </s:iterator>
		</table>
		</div>
	</body>
</html>
