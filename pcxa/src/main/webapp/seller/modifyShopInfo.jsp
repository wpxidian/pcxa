<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>企业管理员注册</title>
		<link type="text/css" rel="stylesheet" href="css/common.css" />
		<link type="text/css" rel="stylesheet" href="css/register_3.css" />	
		<link rel="stylesheet" type="text/css" href="js/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" type="text/css" href="js/kindeditor/plugins/code/prettify.css" />
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
	 <div style="clear:both;"></div>
	 <div class="loginContent">
	  <form id="userLogin" name="userLogin" action="modifyShopInfo" method="post" >
	 	<div class="loginTitle"><div>修改信息</div></div>
	 	<div style="clear:both;height:35px;"></div>
	 	
	 	<div class="userInfoContent">
	 		<label for="name">企业名称：</label>
	 		<div class="textContent">
	 			<input name="name" class="text" type="text" id="name" value="${session.shop.name}"/>
	 		</div>
	 		<div class="tipContent">
	 			<div id="nameTip" ></div>
	 		</div>
	 	</div>  
	 	<div style="clear:both;"></div>
	 	
	 	<div class="userInfoContent">
			<label for="introduction">企业介绍：</label>
			<div class="validatorTipContainer">
				<div id="introductionTip" ></div>
			</div>
			<textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"> 
				${session.shop.introduction}
			</textarea>
		</div>
		<div style="clear:both;"></div>
		
		<div class="userInfoContent">
			<label for="mail_box">企业邮箱：</label>
			<div class="textContent">
				<input name="mail_box" class="text" type="text" id="mail_box"  value="${session.shop.mailBox}"/>
			</div>
			<div class="tipContent">
				<div id="mail_boxTip" ></div>
			</div>
		</div>   
	 	<div style="clear:both;"></div>
	 	
		<div class="userInfoContent">
			<label for="phone">企业电话：</label>
			<div class="textContent">
				<input name="phone" class="text" type="text" id="phone" value="${session.shop.phone}" />
			</div>
			<div class="tipContent">
				<div id="phoneTip" ></div>
			</div>
		</div> 
	 	<div style="clear:both;"></div>
	 	
	 	<div class="userInfoContent">
	 		<label for="account">网银账户：</label>
	 		<div class="textContent">
	 			<input name="account" class="text" type="text" id="account"  value="${session.shop.account}" />
	 		</div>
	 		<div class="tipContent">
	 			<div id="accountTip" ></div>
	 		</div>
	 	</div>   
	 	<div style="clear:both;"></div>
	 	<div class="userInfoContent">
			<label for="uploadify">企业图片：</label>
			<div style="clear:both;height:5px;"></div>
			<input type="file" name="uploadify" id="uploadify"  />
		</div>
	 	<div style="clear:both;"></div>
	 	
	    <input type="submit" value="修改"/>
	    <div style="clear:both;height:35px;"></div>
	  	<input type="hidden" class="picture_link" name="picture_link" value="${session.shop.pictureLink}" />
	  </form>
	 </div>
	 <div style="clear:both;"></div>	 
   </div>
   
    <script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
		
			$.formValidator.initConfig({formID:"userLogin",theme:'ArrowSolidBox',debug:false,onSuccess:function(){
				return true;
			},onError:function(){alert("请正确填写表单信息!");},
			  submitAfterAjaxPrompt : '正在验证用户名，请稍等...'});	
			
			$("#username").formValidator({onShowFixText:"6~12个字符，包括字母、数字、下划线，以字母开头，字母或数字结尾",onShowText:"请输入用户名",onShow:"请输入用户名",onCorrect:"该用户名可以注册"}).inputValidator({min:6,max:12,onError:"你输入的用户长度不正确,请确认"}).regexValidator({regExp:"username",dataType:"enum",onError:"用户名格式不正确"})
			    .ajaxValidator({
				dataType : "html",
				async : true,
				url : "SellerSameUsernameServlet.work",
				success : function(data){
		            	if( data == "true" ) return true;
					return "该用户名已存在，请更换用户名";
				},
				error: function(jqXHR, textStatus, errorThrown){alert("服务器没有返回数据，可能服务器忙，请重试"+errorThrown);},
				onError : "该用户名不可用，请更换用户名",
				onWait : "正在验证用户名，请稍等..."
			});
			
			$("#name").formValidator({onShow:"请输入企业名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:2,max:40,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
			$("#introduction").formValidator({onShow:"请输入企业介绍,可在此添加图片",onFocus:"长度在300~5000之间,可在此添加图片",onCorrect:"输入正确"}).inputValidator({min:0,onError:"长度在300~5000之间,输入有误"});
			$("#mail_box").formValidator({onShow:"请输入邮箱",onFocus:"邮箱6-100个字符",onCorrect:"输入正确"}).inputValidator({min:6,max:100,onError:"你输入的邮箱长度非法,请确认"}).regexValidator({regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",onError:"你输入的邮箱格式不正确"});
			$("#phone").formValidator({onShow:"请输入企业咨询电话",onFocus:"长度大于5个字符",onCorrect:"输入正确"}).inputValidator({min:5,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#account").formValidator({onShow:"请输入网银账户",onFocus:"长度大于5个字符",onCorrect:"输入正确"}).inputValidator({min:5,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
		
			$('#submit').click(function(){
				$('#userLogin').submit();
			});					
			centerPageX();
			<% URLHelper.alertMessage(request,out); %>
		});
		<%
			URLHelper.addUploadButton(out, "#uploadify", "企业图片", "#userLogin", "picture_link",false,URLHelper.PICTURE_TYPE);		   
			URLHelper.addRichTextArea(out, "introduction",640);
		%>
	</script>
</body>
</html>
