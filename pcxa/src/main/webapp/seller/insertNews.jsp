<%@ page import="com.pcxa.util.URLHelper"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
	<title>添加新闻</title>
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
    <div class="content">
       <form id="addNewsForm" action="insertNews" method="post">
        <fieldset>
          <legend>添加新闻</legend>
          <br />
          
          <label for="title">新闻标题</label>
          <div id="titleTip"></div>
          <input id="title" type="text" name="title"/>
          <br />
          
          <label for="time">新闻时间</label>
          <div id="timeTip"></div>
          <input id="time" type="text" name="time"/>
          <br />
          
          <label for="introduction">新闻介绍</label>
          <div id="introductionTip"></div>
          <textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
          <br />
          
          <label for="uploadify">新闻主图片</label>
          <div class="uploadifyTip"></div>
          <input id="uploadify" name="uploadify" type="file"/>
          <input type="submit" value="提交"/>     
        </fieldset>
       </form>
    </div>
    <script type="text/javascript">
         //文件上传编辑器
         $(document).ready(function(){
	        $.formValidator.initConfig({formID:"addNewsForm",theme:'Default',debug:false,onSuccess:function(){
				return true;},onError:function(){alert("请正确填写表单信息!");}
			});
			$("#title").formValidator({onShow:"填写新闻标题",onCorrect:"输入符合要求"}).inputValidator({min:1,onError:"输入不符合要求"});
			$("#introduction").formValidator({onShow:"请输入详细介绍",onFocus:"请输入请输入详细介绍，可以插入图片",onCorrect:"输入符合要求"}).inputValidator({min:0,onError:"输入不符合要求"});
			$("#time").formValidator({onShow:"填写新闻发布时间",onCorrect:"输入符合要求"}).inputValidator({min:1,onError:"输入不符合要求"});
			 <%
			 	URLHelper.alertMessage(request, out); 
	         %>
         });
        <%
       		URLHelper.addRichTextArea(out, "introduction",530);
	    	URLHelper.addUploadButton(out, "#uploadify", "新闻主图片", "#addNewsForm", "picture_link", false, URLHelper.PICTURE_TYPE);
        %>
   </script>
  </body>
</html>
