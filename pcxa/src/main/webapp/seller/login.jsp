<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>登陆</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css" />
	
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/formValidator-4.1.3.min.js"></script>
	<script type="text/javascript" src="js/formValidatorRegex.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	</head>
	<body>
	 	<form id="loginForm" action="login" method="post">
		<div class="container">
			<div class="usernameContent">
				<div class="photo"><img src="images/login/user.png" /></div>
				用户名：<input id="username" name="username"  type="text" size="20"/>
				<div class="validatorTipContainer"><div id="usernameTip" ></div></div>
			</div>
			<div class="passwordContent">
				<div class="photo"><img src="images/login/lock.png" /></div>
				密&nbsp;&nbsp;码：<input id="password" name="password"  type="password" size="20"/>
				<div class="validatorTipContainer"><div id="passwordTip" ></div></div>
			</div>
			<div class="submitContent" >
				<a href="#"><img id="submitBt" src="images/login/enter.gif" /></a>
			</div>
		</div>
		</form>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				centerPageXY();
				$("#submitBt").click(function(){
					$("#loginForm").submit();
				});
				$.formValidator.initConfig({formID:"loginForm",theme:'Default',debug:false,onSuccess:function(){return true;},onError:function(){alert("请正确填写账号和密码!");}});
				$("#username").formValidator({onShow:"请输入账号",onFocus:"至少3个长度",onCorrect:"账号合法"}).inputValidator({min:3,empty:{leftEmpty:false,rightEmpty:false,emptyError:"账号两边不能有空符号"},onError:"账号输入有误"});
				$("#password").formValidator({onShow:"请输入密码",onFocus:"至少3个长度",onCorrect:"密码合法"}).inputValidator({min:3,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码输入有误"});
			});
		</script>
	</body>
</html>
