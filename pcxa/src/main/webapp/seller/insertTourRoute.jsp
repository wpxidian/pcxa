<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.pcxa.util.URLHelper"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>添加精品线路</title>
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
    <div class="content">
       <form id="addRouteForm" action="insertTourRoute" method="post">
        <fieldset>
          <legend>添加精品线路</legend>
          <br /><label id="name" for="name">线路名称</label><div id="nameTip"></div>
          <input id="name" type="text" name="name"/> <br /> <br />   
          <label id="route_classification" for="route_classification">线路分类</label> <br />
          <s:select id="route_classification" list="tourRouteClassificationList" name="route_classification" listKey="tourRouteClassificationId" listValue="name">				
		  </s:select><br /><br />
          <label for="brief_introduction">线路简介</label><div id="brief_introductionTip"></div>
         <textarea name="brief_introduction" id="brief_introduction" rows="4" cols="25"></textarea><br />
          <label for="introduction">线路介绍</label><div id="introductionTip"></div>
          <textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea><br />
          <label for="uploadify">精品线路主图片</label><div class="uploadifyTip"></div><input id="uploadify" name="uploadify" type="file"/>
          <input type="submit" value="提交"/>
        </fieldset>
       </form>
    </div>
    <script type="text/javascript">
         $(document).ready(function(){
	        $.formValidator.initConfig({formID:"addRouteForm",theme:'Default',debug:false,onSuccess:function(){
				if($(".picture_link").length<1){
					 alert("请插入线路主图片");
					 return false;
				}else{return true;}
			},onError:function(){alert("请正确填写表单信息!");}});
			
			$("#name").formValidator({onShow:"请输入线路名称",onFocus:"名称长度在10个字以内",onCorrect:"名字符合要求"}).inputValidator({min:5,max:20,onError:"字数不符合要求"});
			$("#brief_introduction").formValidator({onShow:"请输入路线简介",onFocus:"长度在5到100字之间",onCorrect:"输入正确"}).inputValidator({min:5,max:200,onError:"字数不符合要求，请重新输入"});
			$("#introduction").formValidator({onShow:"请输入旅行线路的详细信息",onFocus:"请输入旅行线路的详细信息，可以插入图片",onCorrect:"输入符合要求"}).inputValidator({min:0,onError:"输入不符合要求"});
			$("#mainPic").formValidator({onShow:"请选择用于列表展示的主图片"});
			
        	<%URLHelper.alertMessage(request, out); %>
         });
         <%
         	URLHelper.addUploadButton(out, "#uploadify", "线路主图片", "#addRouteForm", "picture_link",false,URLHelper.PICTURE_TYPE);
			URLHelper.addRichTextArea(out, "introduction",530);
         %>
   </script>
  </body>
</html>
