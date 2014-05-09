<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title>修改酒店住宿</title>
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
    <div class="content" >
       <form id="SellerUpdateHotelForm" action="modifyHotel" method="post">
        <fieldset>
          <legend>修改酒店住宿信息</legend>
          <br /><label  for="name">酒店名称：</label><input id="name" type="text" name="name"  value="${hotel.name}>" />
          <div class="validatorTipContainer"><div id="nameTip"></div></div>           
          <label for="phone">联系电话：</label><input id="phone" type="text"  value="${hotel.phone}"  name="phone"/>
          <div class="validatorTipContainer"><div id="phoneTip"></div></div>
          <label for="link">相关链接：</label><input id="link" type="text"  value="${hotel.link}"  name="link"/>
          <div class="validatorTipContainer"><div id="linkTip"></div></div>
          <label for="star">酒店星级：</label>
             <s:select id="star" list="#{'1':'一星级','2':'二星级','3':'三星级','4':'四星级','5':'五星级'}" name="star" value="star">				
			 </s:select>
          <br/><label for="address">酒店地址：</label><div class="validatorTipContainer"><div id="addressTip"></div></div>
          <textarea id="address" name="address" rows="2" cols="15" >${hotel.address}</textarea>
          <br /><label for="bus">公交信息：</label><div class="validatorTipContainer"><div id="busTip"></div> </div> 
          <textarea id="bus" name="bus" rows="2" cols="15">${hote.bus}</textarea>           
          <br /><label for="brief_introduction">酒店简介：</label><div class="validatorTipContainer"><div id="brief_introductionTip"></div></div>
          <textarea name="brief_introduction" id="brief_introduction" rows="4" cols="25">${hotel.briefIntroduction}</textarea>
          <br /><label for="introduction">酒店介绍：</label><div class="validatorTipContainer"><div id="introductionTip"></div></div>
          <textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;">${hotel.introduction}</textarea>
          <br /><label for="uploadify">酒店主图片（用于在酒店列表中显示，请务必添加一个图片）：</label>
           <br/><input id="uploadify" name="uploadify" type="file"/>
          <br />
          <input type="hidden" class="picture_link" name="picture_link" value="${hotel.pictureLink}" />
		 <input type="hidden" name="id" value="${hotel.hotelId}" />			
          <input type="submit" value="修改"/>     
        </fieldset>
       </form>
    </div>
    <script type="text/javascript">
		$(document).ready(function(){
			$.formValidator.initConfig({formID:"SellerUpdateHotelForm",theme:'Default',debug:false,onSuccess:function(){
			if($(".picture_link").length<1){
			 alert("请插入酒店主图片");
			 return false;
			}else{return true;}
			},onError:function(){alert("请正确填写表单信息!");}});
			$("#name").formValidator({onShow:"请输入酒店名称",onFocus:"长度在2~20之间",onCorrect:"输入正确"}).inputValidator({min:2,max:20,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在2~20之间,输入有误"});
			$("#brief_introduction").formValidator({onShow:"请输入酒店简介",onFocus:"长度在5~100之间",onCorrect:"输入正确"}).inputValidator({min:5,max:100,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度在50~100之间,输入有误"});
			$("#introduction").formValidator({onShow:"请输入详细介绍",onFocus:"长度在300~1000之间，可以插入图片",onCorrect:"输入正确"}).inputValidator({min:0,max:1000,onError:"长度在300~1000之间,输入有误"});
			$("#link").formValidator({onShow:"请输入酒店链接",onFocus:"没有可不填",onCorrect:"输入正确"});
			$("#address").formValidator({onShow:"请输入酒店地址",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#phone").formValidator({onShow:"请输入酒店联系电话",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
			$("#bus").formValidator({onShow:"请输入公交信息",onFocus:"没有可不填",onCorrect:"输入正确"}).inputValidator({min:0,empty:{leftEmpty:false,rightEmpty:false,emptyError:"两边不能有空符号"},onError:"长度大于5个字符,输入有误"});
		});
		<%
		  URLHelper.addUploadButton(out, "#uploadify", "酒店主图片", "#SellerUpdateHotelForm", "picture_link",false,URLHelper.PICTURE_TYPE);
		  URLHelper.addRichTextArea(out, "introduction",530);
		%>
	</script>
  </body>
</html>
