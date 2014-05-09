<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>修改密码</title>
		<link type="text/css" rel="stylesheet" href="css/common.css" />
		<link type="text/css" rel="stylesheet" href="css/register_3.css" />	
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
		<script type="text/javascript" charset="utf-8" src="js/formValidator-4.1.3.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/formValidatorRegex.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/common.js"></script>	 
  </head>
  <body>
   <div class="container">
	 <div style="clear:both;"></div>
	 <div class="loginContent">
	  <form id="userLogin" action="modifyPassword" method="post" >
	 	<div class="loginTitle"><div>修改密码</div></div>
	 	<div style="clear:both;height:35px;"></div>
		<div class="userInfoContent"><label for="password">原&nbsp;密&nbsp;码：</label><div class="textContent"><input name="password" class="text" type="password" id="password" /></div><div class="tipContent"><div id="passwordTip" ></div></div></div>   
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent"><label for="newPassword">新&nbsp;密&nbsp;码：</label><div class="textContent"><input name="newPassword" class="text" type="password" id="newPassword" /></div><div class="tipContent"><div id="newPasswordTip" ></div></div></div>   
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent"><label for="repassword">确认密码：</label><div class="textContent"><input name="repassword" class="text" type="password" id="repassword" /></div><div class="tipContent"><div id="repasswordTip" ></div></div></div>   
	 	<div style="clear:both;"></div>
	   <input type="submit" value="修改"/>
	    <div style="clear:both;height:35px;"></div>
	  </form>
	 </div>
	 <div style="clear:both;"></div>	 
   </div>
    <script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$.formValidator.initConfig({formID:"userLogin",theme:'ArrowSolidBox',debug:false,onSuccess:function(){
				return true;
			},onError:function(){alert("请正确填写表单信息!");}});
			$("#password").formValidator({onShow:"请输入原密码",onFocus:"长度在3~20之间",onCorrect:"输入正确"}).inputValidator({min:3,max:20,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在3~20之间,输入有误"});
			$("#newPassword").formValidator({onShow:"请输入新密码",onFocus:"长度在8~20之间",onCorrect:"输入正确"}).inputValidator({min:8,max:40,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在8~20之间,输入有误"});
			$("#repassword").formValidator({onShow:"输再次输入密码",onFocus:"长度在8~20之间",onCorrect:"密码一致"}).inputValidator({min:8,empty:{leftEmpty:false,rightEmpty:false,emptyError:"重复密码两边不能有空符号"},onError:"重复密码不能为空,请确认"}).compareValidator({desID:"newPassword",operateor:"=",onError:"2次密码不一致,请确认"});
			$('#submit').click(function(){
				$('#userLogin').submit();
			});						
			centerPageX();
		});
	</script>
</body>
</html>
