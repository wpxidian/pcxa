<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper" %>
<!DOCTYPE html>
<html>
	<head>
		<title>管理员信息</title>
		<link type="text/css" rel="stylesheet" href="css/common.css" />
		<link type="text/css" rel="stylesheet" href="css/register_3.css" />
		<link rel="stylesheet" type="text/css" href="js/uploadify/uploadify.css" />
		<style type="text/css">
			.friend_link a:hover {
			    color: rgb(102, 102, 102);
			    text-decoration: underline;
			}
			.friend_link a:link,a:visited {
				color: #464646;
				text-decoration: none;
			}
			.copyright{
				color: #464646;
			}
			div.userInfoContent {
			    float: left;
			    margin-left: 25px;
			    margin-top: 10px;
			}
		</style>
		<script type="text/javascript" charset="utf-8" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/common.js"></script>	 
  </head>
  <body>
   <div class="container">
  	<!-- Logo -->
	<img class="logoContent" src="images/login/logo.png" />
	 <div style="clear:both;"></div>
	 <div class="loginContent">
	  <form id="userLogin" name="userLogin" action="####" method="post" >
	  	<input type="hidden" name="backURL" value="seller/login.jsp" />
	 	<div style="clear:both;height:35px;"></div>
	 	<div class="userInfoContent">用&nbsp;户&nbsp;名：${session.shop.username}</div>   
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent">企业名称：${session.shop.name}</div>  
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent">企业介绍：${session.shop.introduction}</div>
		<div style="clear:both;"></div>
		<div class="userInfoContent">企业邮箱：${session.shop.mailBox}</div>     
	 	<div style="clear:both;"></div>
		<div class="userInfoContent">企业电话：${session.shop.phone}</div>   
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent">网银账户：${session.shop.account}</div>     
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent">
		<label for="picture_link">企业图片：</label>
		<div style="clear:both;height:5px;"></div>
		<div style="margin-left:100px;">
		<img src="<%=URLHelper.imgFolderForSellerAndAdmin%>${session.shop.pictureLink}"/></div>
		</div>
	 	<div style="clear:both;"></div>
	    <div class="registerBottonContent" id="submit" style="margin-left:630px;">
	    	<a href="#">
	   	 		<img class="registerButton" src="images/login_2/registerButton_1.png" />
	    	</a>
	    </div>
	    <div style="clear:both;height:35px;"></div>
	  </form>
	 </div>
	 <div style="clear:both;"></div>
	</div>
	
    <script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			centerPageX();
		});
	</script>
</body>
</html>
