<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>修改休闲娱乐项目信息</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
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
		<form id="SellerUpdateEntertainmentForm" action="modifyEntertainment" method="post">
		<fieldset>
			<legend>添加娱乐项目信息</legend>
	
			<label for="name">娱乐项目名称：</label><input id="name" name="name" value="${entertainment.name}"  type="text" size="20"/>
			<div class="validatorTipContainer"><div id="nameTip" ></div></div>
			<label for="address">娱乐项目地址：</label><input id="address" name="address"  value="${entertainment.address}"  type="text" size="20"/>
			<div class="validatorTipContainer"><div id="addressTip" ></div></div>
			<label for="bus">公交信息：</label><input id="bus" name="bus"  value="${entertainment.bus}"  type="text" size="20"/>
			<div class="validatorTipContainer"><div id="busTip" ></div></div>
			<label for="phone">联系电话：</label><input id="phone" name="phone"  value="${entertainment.phone}"  type="text" size="20"/>
			<div class="validatorTipContainer"><div id="phoneTip" ></div></div>
			<label for="entertainment_classification">娱乐项目类别：</label>
			<s:select id="entertainment_classification" list="entertainmentClassificationList" name="entertainment_classification" value="entertainment_classification"
						listKey="entertainmentClassificationId" listValue="name">				
			</s:select><br />
			<label for="brief_introduction">娱乐项目简介：</label><div class="validatorTipContainer"><div id="brief_introductionTip" ></div></div>
			<textarea id="brief_introduction" name="brief_introduction" cols="30" rows="6" >${entertainment.briefIntroduction}</textarea>
				
			<br /><label for="introduction">娱乐项目介绍：</label><div class="validatorTipContainer"><div id="introductionTip" ></div></div>
			<textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">${entertainment.introduction}</textarea>
		
			<br /><label for="picture_link">娱乐项目主图片（用于在娱乐项目列表中显示，请务必添加一个图片）：</label>
			<br/><input type="file" name="picture_link" id="picture_link" /> 
			<input type="hidden" class="picture_link" name="picture_link" value="${entertainment.pictureLink}" />
			<input type="hidden" name="id" value="${entertainment.entertainmentId}" />
			<input type="submit" value="修改" />		
			</fieldset>
		</form>		
	</div>    
     <script type="text/javascript">
		$(document).ready(function() {
			$.formValidator.initConfig({formID:"SellerUpdateEntertainmentForm",theme:'Default',debug:false,onSuccess:function(){
			if($(".picture_link").length<1){
			 alert("请插入商铺主图片");
			 return false;
			}else{return true;}
			},onError:function(){alert("请正确填写表单信息!");}});
			$("#name").formValidator({onShow:"请输入娱乐项目名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:2,max:40,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
			$("#brief_introduction").formValidator({onShow:"请输入娱乐项目简介",onFocus:"长度在5~100之间",onCorrect:"输入正确"}).inputValidator({min:5,max:200,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在5~100之间,输入有误"});
			$("#address").formValidator({onShow:"请输入地址",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#bus").formValidator({onShow:"请输入公交信息",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#phone").formValidator({onShow:"请输入联系电话",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#introduction").formValidator({onShow:"请输入娱乐项目介绍",onFocus:"长度在300~5000之间,可在此添加图片",onCorrect:"输入正确"}).inputValidator({min:0,onError:"长度在300~5000之间,输入有误"});
			});
			<%	
				URLHelper.addUploadButton(out, "#picture_link", "娱乐项目主图片", "#SellerUpdateEntertainmentForm", "picture_link",false,URLHelper.PICTURE_TYPE);
				URLHelper.addRichTextArea(out, "introduction",530);
			%>
	</script>
  </body>
</html>
