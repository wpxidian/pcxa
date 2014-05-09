<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>修改商铺</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/addTourists.css" />
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
			<form id="SellerUpdateTradeForm" action="modifyTrade" method="post">
			<div class="usernameContent">
			<fieldset>
				<legend>添加商铺信息</legend>
				<div class="floatBlock">
				<label for="name">商铺名称：</label>
				<input id="name" name="name" type="text" size="20" value="${trade.name}"/>
				<div class="validatorTipContainer"><div id="nameTip" ></div></div>
				<label for="address">商铺地址：</label>
				<input id="address" name="address" type="text" size="20" value="${trade.address}"/><div class="validatorTipContainer"><div id="addressTip" ></div></div>
				<label for="bus">公交信息：</label>
				<input id="bus" name="bus" type="text" size="20" value="${trade.bus}"/><div class="validatorTipContainer"><div id="busTip" ></div></div>
				<label for="phone">联系电话：</label>
				<input id="phone" name="phone" type="text" size="20" value="${trade.phone}"/><div class="validatorTipContainer"><div id="phoneTip" ></div></div>
				<label for="trade_classification">所属商圈：</label>
				<s:select id="trade_classification" list="tradeClassificationList" name="trade_classification" value="trade_classification"
						listKey="tradeClassificationId" listValue="name">				
				</s:select><br />
				</div>
				<div style="float:left;margin-left:20px;">
				<label for="brief_introduction">商铺简介：</label><div class="validatorTipContainer"><div id="brief_introductionTip" ></div></div>
				<textarea id="brief_introduction" name="brief_introduction" cols="20" rows="3" >${trade.briefIntroduction}</textarea>
				</div>
				<div class="noneFloatBlock">
				<label for="introduction">商铺介绍：</label><div class="validatorTipContainer"><div id="introductionTip" ></div></div>
				<textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">${trade.introduction}</textarea>
				</div>
				<div class="floatBlock">
				<label for="picture_link">商铺主图片（用于在商铺列表中显示，请务必添加一个图片）：</label>
				<input type="file" name="picture_link" id="picture_link" /> 
				</div>
				<div class="noneFloatBlock">
				    <input type="hidden" class="picture_link" name="picture_link" value="${trade.pictureLink}" />
					<input type="hidden" name="id" value="${trade.tradeId}" />
					<input type="submit" value="修改" />
				</div>	
				</fieldset>
			</div>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$.formValidator.initConfig({formID:"SellerUpdateTradeForm",theme:'Default',debug:false,onSuccess:function(){
				if($(".picture_link").length<1){
				 alert("请插入商铺主图片");
				 return false;
				}else{return true;}
				},onError:function(){alert("请正确填写表单信息!");}});
				$("#name").formValidator({onShow:"请输入商铺名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:2,max:40,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
				$("#brief_introduction").formValidator({onShow:"请输入商铺简介",onFocus:"长度在5~100之间",onCorrect:"输入正确"}).inputValidator({min:5,max:200,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在50~100之间,输入有误"});
				$("#address").formValidator({onShow:"请输入商铺地址",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#bus").formValidator({onShow:"请输入商铺公交信息",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#phone").formValidator({onShow:"请输入商铺咨询电话",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
				$("#introduction").formValidator({onShow:"请输入商铺咨询电话,可在此添加图片",onFocus:"长度在300~5000之间,可在此添加图片",onCorrect:"输入正确"}).inputValidator({min:0,onError:"长度在300~5000之间,输入有误"});		
			});
				<%
					URLHelper.addUploadButton(out, "#picture_link", "商铺主图片", "#SellerUpdateTradeForm", "picture_link",false,URLHelper.PICTURE_TYPE);		
					URLHelper.addRichTextArea(out, "introduction",530);
				%>
		</script>
	</body>
</html>
