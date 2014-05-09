<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>修改商品</title>
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
			<form id="SellerUpdateGoodsForm" action="modifyGoods" method="post">
			<div class="usernameContent">
				<fieldset>
				<legend>修改商品信息</legend>
				<div class="floatBlock">
				<label for="name">商品名称：</label>
				<input id="name" name="name" type="text" size="20" value="${goods.name}"/>
				<div class="validatorTipContainer"><div id="nameTip" ></div></div>
				<label for="quantity_left">剩余数量：</label>
				<input id="quantity_left" name="quantity_left" type="text" size="20" value="${goods.quantityLeft}"/><div class="validatorTipContainer"><div id="quantity_leftTip" ></div></div>
				<label for="price">价格：</label>
				<input id="price" name="price" type="text" size="20" value="${goods.price}" /><div class="validatorTipContainer"><div id="priceTip" ></div></div>
				<label for="send_method">配送方式：</label>
				<s:select id="send_method" list="#{'发送短信':'发送短信','快递运输':'快递运输'}" name="send_method" 
					 value="send_method">				
				</s:select>
				<label for="goods_classification">商品类别：</label>
				<s:select id="goods_classification" list="goodsClassificationList" name="goods_classification" listKey="id" listValue="name"
					value="goods_classification">				
				</s:select>
				<br />
				</div>
				<div class="noneFloatBlock">
				<label for="introduction">商品介绍：</label><div class="validatorTipContainer"><div id="introductionTip" ></div></div>
				<textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;" >
					${goods.introduction}
				</textarea>
				</div>
				<div class="floatBlock">
				<label for="uploadify">商品主图片（用于在商品列表中显示，请务必添加一个图片）：</label>
				<input type="file" name="uploadify" id="uploadify" /> 
				</div>
				<div class="noneFloatBlock">
					<input type="hidden" class="picture_link" name="picture_link" value="${goods.pictureLink}" />
					<input type="hidden" name="id" value="${goods.goodsId}" />
					<input type="submit" value="修改" />
				</div>
				</fieldset>
			</div>
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$.formValidator.initConfig({formID:"SellerUpdateGoodsForm",theme:'Default',debug:false,onSuccess:function(){
				if($(".picture_link").length<1){
				 alert("请插入商品主图片");
				 return false;
				}else{return true;}
				},onError:function(){alert("请正确填写表单信息!");}});
				$("#name").formValidator({onShow:"请输入商品名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:4,max:40,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
				$("#quantity_left").formValidator({onShow:"请输入商品剩余数量",onCorrect:"输入正确"}).regexValidator({regExp:"num1",dataType:"enum",onError:"请输入一个正数或0"});
				$("#price").formValidator({onShow:"输入商品价格",onCorrect:"输入正确"}).regexValidator({regExp:"decmal",dataType:"enum",onError:"请输入一个浮点数，如2.50"});
				$("#introduction").formValidator({onShow:"请输入商品介绍,可在此添加图片",onFocus:"长度在300~5000之间,可在此添加图片",onCorrect:"输入正确"}).inputValidator({min:0,onError:"长度在300~5000之间,输入有误"});
				<%	
					URLHelper.alertMessage(request,out);
				%>
			});
			<%	
				URLHelper.addUploadButton(out, "#uploadify", "商品主图片", "#SellerUpdateGoodsForm", "picture_link",false,URLHelper.PICTURE_TYPE);
				URLHelper.addRichTextArea(out, "introduction",640);
			%>
		</script>
	</body>
</html>
