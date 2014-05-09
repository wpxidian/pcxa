<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理景区</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/manageTourists.css" />
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
			<form id="SellerAddTradeForm" action="insertTrade" method="post">
			<div class="usernameContent">
			<fieldset>
				<legend>添加商铺信息</legend>
				<div class="floatBlock">
				<label for="name">商铺名称：</label>
				<input id="name" name="name" type="text" size="20"/>
				<div class="validatorTipContainer"><div id="nameTip" ></div></div>
				<label for="address">商铺地址：</label>
				<input id="address" name="address" type="text" size="20"/><div class="validatorTipContainer"><div id="addressTip" ></div></div>
				<label for="bus">公交信息：</label>
				<input id="bus" name="bus" type="text" size="20"/><div class="validatorTipContainer"><div id="busTip" ></div></div>
				<label for="phone">联系电话：</label>
				<input id="phone" name="phone" type="text" size="20"/><div class="validatorTipContainer"><div id="phoneTip" ></div></div>
				<label for="trade_classification">所属商圈：</label>
				<s:select id="trade_classification" list="tradeClassificationList" name="trade_classification" 
						listKey="tradeClassificationId" listValue="name">				
				</s:select><br />
				</div>
				<div style="float:left;margin-left:20px;">
				<label for="brief_introduction">商铺简介：</label><div class="validatorTipContainer"><div id="brief_introductionTip" ></div></div>
				<textarea id="brief_introduction" name="brief_introduction" cols="20" rows="3" ></textarea>
				</div>
				<div class="noneFloatBlock">
				<label for="introduction">商铺介绍：</label><div class="validatorTipContainer"><div id="introductionTip" ></div></div>
				<textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
				</div>
				<div class="floatBlock">
				<label for="uploadify">商铺主图片（用于在景区列表中显示，请务必添加一个图片）：</label>
				<input type="file" name="uploadify" id="uploadify" /> 
				</div>
				<div class="floatBlock">
				<label for="trade_picture">商铺图片（用于展示景区，可添加多张，至少添加三张）：</label>
				<input type="file" name="trade_picture" id="trade_picture" /> 
				</div>
				<div class="noneFloatBlock">
					<input type="submit" value="添加" />
				</div>	
				</fieldset>
			</div>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$.formValidator.initConfig({formID:"SellerAddTouristsForm",theme:'Default',debug:false,onSuccess:function(){
				if($(".picture_link").length<1){
				 alert("请插入商铺主图片");
				 return false;
				}else if($(".tourists_picture").length<3){
				 alert("插入商铺图片小于三张");
				 return false;
				}else{return true;}
				},onError:function(){alert("请正确填写表单信息!");}});
				$("#name").formValidator({onShow:"请输入商铺名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:2,max:20,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
				$("#brief_introduction").formValidator({onShow:"请输入景区简介",onFocus:"长度在5~100之间",onCorrect:"输入正确"}).inputValidator({min:5,max:100,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在50~100之间,输入有误"});
				$("#address").formValidator({onShow:"请输入商铺地址",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#bus").formValidator({onShow:"请输入商铺公交信息",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#phone").formValidator({onShow:"请输入商铺电话",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#introduction").formValidator({onShow:"请输入商铺的介绍,可在此添加图片",onFocus:"长度在300~5000之间,可在此添加图片",onCorrect:"输入正确"}).inputValidator({min:0,onError:"长度在300~5000之间,输入有误"});
			});
			<%	URLHelper.addUploadButton(out, "#uploadify", "商铺主图片", "#SellerAddTradeForm", "picture_link",false,URLHelper.PICTURE_TYPE);
				URLHelper.addUploadButton(out, "#trade_picture", "商铺图片", "#SellerAddTradeForm", "trade_picture",true,URLHelper.PICTURE_TYPE);
				URLHelper.addRichTextArea(out, "introduction",530);%>
		</script>
	</body>
</html>

