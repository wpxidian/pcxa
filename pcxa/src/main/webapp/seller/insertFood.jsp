<%@page import="com.pcxa.util.URLHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<title>添加特色美食</title>
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
       <form id="addFoodForm" action="SellerAddFoodServlet.work" method="post">
        <fieldset>
          <legend>添加特色美食</legend>
          <br /><label id="name" for="name">美食名称</label><div id="nameTip"></div>
          <input id="name" type="text" name="name"/>
          <br /><br /><label for="brief_introduction">美食简介</label><div id="brief_introductionTip"></div>
         <textarea name="brief_introduction" id="brief_introduction" rows="4" cols="25"></textarea>
          <br /><label for="introduction">美食介绍</label><div id="introductionTip"></div>
          <textarea id="introduction" name="introduction" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
          <br /><label for="uploadify">美食主图片</label><div class="uploadifyTip"></div><input id="uploadify" name="uploadify" type="file"/>
          
          <br /><label for="address">地址</label><div id="addressTip"></div>
                <textarea id="address" name="address" rows="2" cols="15"></textarea>
          <br />
          <br /><label for="phone">电话</label><div id="phoneTip"></div>
          <input id="phone" type="text" name="phone"/>
          <br />
          <br /><label for="bus">公交信息</label><div id="busTip"></div>  
          <textarea id="bus" name="bus" rows="2" cols="15"></textarea>  
          <br /><label for="link">店铺链接</label><div ></div>
           <input name="link" id="link" type="text" value="http://"/>
          <br />
          <input type="submit" value="提交"/>     
        </fieldset>
       </form>
    </div>
    <script type="text/javascript">
         $(document).ready(function(){
	        $.formValidator.initConfig({formID:"addFoodForm",theme:'Default',debug:false,onSuccess:function(){
				if($(".picture_link").length<1){
					 alert("请插入美食主图片");
					 return false;
				}else{return true;}
				},onError:function(){alert("请正确填写表单信息!");}
			});
			
			$("#name").formValidator({onShow:"请输入美食名称"});
			$("#brief_introduction").formValidator({onShow:"请输入美食简介",onFocus:"长度在5到100字之间",onCorrect:"输入正确"}).inputValidator({min:5,max:200,onError:"字数不符合要求，请重新输入"});
			$("#introduction").formValidator({onShow:"请输入详细介绍",onFocus:"请输入请输入详细介绍，可以插入图片",onCorrect:"输入符合要求"}).inputValidator({min:0,onError:"输入不符合要求"});
			$("#mainPic").formValidator({onShow:"请选择用于列表展示的主图片"});
			$("#address").formValidator({onShow:"请填写店铺地址,没有可不填"});
			$("#phone").formValidator({onShow:"请填写店铺电话,没有可不填"});
			$("#bus").formValidator({onShow:"请填写店铺公交信息,没有可不填"});
			$("#link").formValidator({onShow:"请填写店铺连接地址,没有可不填"});
         });
        <%
       		URLHelper.addRichTextArea(out, "introduction",530);
	    	URLHelper.addUploadButton(out, "#uploadify", "美食主图片", "#addFoodForm", "picture_link", false, URLHelper.PICTURE_TYPE);
        %>
    </script>
  </body>
</html>
