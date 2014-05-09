package com.pcxa.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.pcxa.model.Shop;
import com.pcxa.model.User;

/**
 * Title: URLHelper 0.1 Description:用于一些JQuery控件的集成以及Servlet和JSP中简单交互封装 JDK
 * version used:<JDK1.7>
 * 
 * @author JiLu
 * @version 0.1
 */

public class URLHelper {

	public static final Type stringType = String.class;
	public static final Type integerType = int.class;
	public static final Type doubleType = double.class;
	public static final Type floatType = float.class;
	public static final Type dateType = Date.class;
	public static final Type booleanType = boolean.class;
	
	//private static final String keys = "0123456789";
	
	public static String webIP = "127.0.0.1";
	public static String imgFolder = "attached/";
	public static String uploadFolder = "/" + imgFolder;
	public static String imgFolderForSellerAndAdmin = ".." + uploadFolder;

	public static String videoFolder = "E:\\Red5\\webapps\\chapter4\\streams\\";
	public static String videoURL = "http://"+ webIP+ ":5080/chapter4/streams/";
	
	
	static {	
		
		uploadFolder = "/" + imgFolder;
		
		imgFolderForSellerAndAdmin = ".." + uploadFolder;
	
	}

	public static final byte PICTURE_TYPE = 0;
	public static final byte VIDEO_TYPE = 1;
	public static final byte AUDIO_TYPE = 2;
	
	/*************************************Jquery部分封装代码Start*****************************************/
	
	/**
	 * addWeightFunction用来实现更改权重的Jquery部分代码，
	 * 该方法只给admin使用，注意该方法没有返回值,
	 * 请将代码放置于<script></script>中,需要jquery包,使用<%URLHelper.addWeightFunction(out) %>调用
	 * 
	 * @param out
	 *            该参数为jsp中的out对象
	 */
	public static void addWeightFunction(JspWriter out) throws IOException {
		out.print("$(document).ready(function() {\n"
				+ "$('.weightSubmit').click(function(){"
				+ "$('#addWeightForm').append('<input type=\"hidden\" name=\"id\" value=\"'+$(this).attr(\"id\")+'\" />');"
				+ "$('#addWeightForm').append('<input type=\"hidden\" name=\"weight\" value=\"'+$(\"#\"+$(this).attr(\"id\")+\"w\").attr(\"value\")+'\" />');"
				+ "$('#addWeightForm').submit();" + "});});");
	}
	
	/**
	 * addVideoPlayFunction用来弹窗视频播放功能的Jquery部分代码，
	 * 请将代码放置于<script></script>中,需要jquery包,fancybox包,使用<%URLHelper.addVideoPlayFunction(out) %>调用
	 * 
	 * @param out
	 *            该参数为jsp中的out对象
	 */
	public static void addVideoPlayFunction(JspWriter out) throws IOException {
		out.print("$(document).ready(function() {$(\".video\").fancybox({"+
			"maxWidth : 667,"+
			"maxHeight : 520,"+
			"fitToView : false,"+
			"width : '100%',"+
			"height : '100%',"+
			"autoSize : false,"+
			"closeClick : false,"+
			"openEffect : 'elastic',"+
			"closeEffect : 'elastic',"+
			"beforeShow   : function() {"+
						"$('.fancybox-skin').css({backgroundImage:'url(\"images/common/videoBack.gif\")'});"+
				   "}"+ 
		"});});");
	}

	
	/**
	 * alertMessage方法用于在本页面显示sendMessage方法传递来的信息
	 * 该方法使用接收在request对象中传递来的httpMessage参数，并使用javascript将该信息显示与页面中
	 * 一般该方法与sendMessage一同使用
	 * 请将代码放置于document.ready(function(){});中,使用<%URLHelper.alertMessage(request,out) %>调用
	 * 
	 * @param request
	 *            request是本页面的一个HttpServletRequest的实例，用于获取httpMessage参数
	 * @param out
	 *            out是本页面的输出流
	 * @throws IOException
	 *             if an error occurred
	 * 
	 */
	public static void alertMessage(HttpServletRequest request, JspWriter out)
			throws IOException {
		if (request.getParameter("httpMessage") != null
				&& !"".equals(request.getParameter("httpMessage"))) {
			out.print("	alert('" + request.getParameter("httpMessage") + "');");
		}
	}

	/**
	 * addUploadButton用于在form表单中添加一个可显示进度条，支持多文件上传的上传按钮
	 * 该方法封装的Uploadify这一JQuery插件有效实现了对文件的上传功能
	 * 请将代码放置于<script></script>中,需要jquery包,uploadify包,使用<%URLHelper.addUploadButton(out，"","","","",true,URLHelper.PICTURE_TYPE) %>调用
	 * 
	 * @param out
	 *            out是本页面的输出流
	 * @param fileUploadButtonId
	 *            fileUploadButtonId是form表单中的一个type为file的input标签的id属性(字符串)，例如
	 *            "#picture_link"，注意有#或.
	 * @param buttonName
	 *            buttonName用于指定该上传按钮的名字(字符串)
	 * @param addFormId
	 *            addFormId用于指定在文件上传成功后，在哪个form中添加hidden标签(字符串)，例如"#testForm"，
	 *            注意有#或.
	 * @param hiddenName
	 *            hiddenName用于指定在文件上传成功后，添加的hidden标签的name属性和class属性(字符串)，例如
	 *            "picture_link"，注意没有#或.
	 * @param isMulti
	 *            isMulti用于指定在文件该按钮是否支持多文件上传(Boolean)，true为支持多文件上传
	 * @param uploadFileType
	 *            uploadFileType用于指定允许上传的文件类型,目前这里可填写URLHelper.
	 *            PICTURE_TYPE或URLHelper.VIDEO_TYPE
	 * @throws IOException
	 *             if an error occurred
	 * 
	 */
	public static void addUploadButton(JspWriter out,
			String fileUploadButtonId, String buttonName, String addFormId,
			String hiddenName, Boolean isMulti, byte uploadFileType)
			throws IOException {

		switch (uploadFileType) {
		case PICTURE_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'fileUpload',\n"
					+ "'fileObjName':'uploadify',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '图片文件',\n"
					+ "'fileTypeExts' : '*.gif; *.jpg; *.png',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		case VIDEO_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'../FileUploadVideoServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '视频文件',\n"
					+ "'fileTypeExts' : '*.flv',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		case AUDIO_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'../FileUploadVideoServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '音频文件',\n"
					+ "'fileTypeExts' : '*.mp3',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		default:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'../FileUploadServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '图片文件',\n"
					+ "'fileTypeExts' : '*.gif; *.jpg; *.png',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
		}

	}
	
	

	public static void addUploadButtonForUser(JspWriter out,
			String fileUploadButtonId, String buttonName, String addFormId,
			String hiddenName, Boolean isMulti, byte uploadFileType)
			throws IOException {

		switch (uploadFileType) {
		case PICTURE_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'FileUploadServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '图片文件',\n"
					+ "'fileTypeExts' : '*.gif; *.jpg; *.png',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		case VIDEO_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'FileUploadVideoServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '视频文件',\n"
					+ "'fileTypeExts' : '*.flv',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		case AUDIO_TYPE:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'FileUploadVideoServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '音频文件',\n"
					+ "'fileTypeExts' : '*.mp3',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input class='" + hiddenName
					+ "' type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
			break;
		default:
			out.print("$(document).ready(function() {\n" + " $('"
					+ fileUploadButtonId + "').uploadify( {\n"
					+ "'uploader':'FileUploadServlet.work',\n"
					+ "'swf':'js/uploadify/uploadify.swf',\n"
					+ "'auto' :true,\n" + "'multi' :" + isMulti.toString()
					+ ",\n" + "'removeCompleted' : false,\n"
					+ "'buttonText' :'" + buttonName + "',\n"
					+ "'fileTypeDesc' : '图片文件',\n"
					+ "'fileTypeExts' : '*.gif; *.jpg; *.png',\n"
					+ "'onUploadSuccess' : function(file, data, response) {\n"
					+ isMulti(isMulti, hiddenName) + "$('" + addFormId
					+ "').append(\"<input type='hidden' name='" + hiddenName
					+ "' value='\"+data+\"' />\");\n" + "$('"
					+ fileUploadButtonId + "').uploadify('disable',"
					+ (!isMulti) + ");\n" + "}\n});\n});\n");
		}

	}

	/**
	 * addRichTextArea用于在form表单中添加一个强大富文本编辑器，并支持页面布局功能
	 * 该方法封装的Kindeditor这一JQuery插件有效实现了强大的富文本编辑器功能
	 * 请将代码放置于<script></script>中,需要jquery包,kindeditor包,使用<%URLHelper.addRichTextArea(out,"",530) %>调用
	 * 
	 * @param out
	 *            out是本页面的输出流
	 * @param textareName
	 *            textareName制定了用于实现富文本编辑器的textarea标签的那么属性
	 * @param width
	 *            width属性为该富文本编辑器的宽度
	 * @throws IOException
	 *             if an error occurred
	 * 
	 */
	public static void addRichTextArea(JspWriter out, String textareName,
			int width) throws IOException {
		out.print("KindEditor.ready(function(K) {"
				+ "K.create('textarea[name=\"" + textareName + "\"]', {"
				+ "cssPath : 'js/kindeditor/plugins/code/prettify.css',"
				+ "uploadJson : '../UploadJSONServlet.work',"
				+ "fileManagerJson : '../FileManagerJSONServlet.work',"
				+ "allowFileManager : true," + "width : '" + width + "px',"
				+ "minWidth : '" + width + "px'," + "resizeType : 1"
				+ "});prettyPrint();});");
	}

	public static void addRichTextAreaForUser(JspWriter out, String textareName,
			int width) throws IOException {
		out.print("KindEditor.ready(function(K) {"
				+ "K.create('textarea[name=\"" + textareName + "\"]', {"
				+ "cssPath : 'js/kindeditor/plugins/code/prettify.css',"
				+ "uploadJson : 'UploadJSONServlet.work',"
				+ "fileManagerJson : 'FileManagerJSONServlet.work',"
				+ "allowFileManager : true," + "width : '" + width + "px',"
				+ "minWidth : '" + width + "px'," + "resizeType : 1"
				+ "});prettyPrint();});");
	}
	
	/*************************************Jquery部分封装代码End*****************************************/
	
	
	/*************************************Html部分封装代码Start*****************************************/
	
	/**
	 * addWeightButton是获得改变权重的输入框和提交按钮，实例admin/auditShop.jsp
	 * 仅供admin使用
	 * 请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.addWeightButton(obj,"") %>调用 
	 * 
	 * @param addWeightDomainObj
	 *            该参数要修改权重的对象的一个实例，注意这个实例具体内容无关，只是想要知道实例的类型
	 * @param backURL
	 *            该参数为删除后应返回的URL地址
	 * @return 删除链接的form标签
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static String addWeightButton(Object addWeightDomainObj, String backURL) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{

		Class<? extends Object> addWeightDomainObjectClass = addWeightDomainObj
				.getClass();

		Method getIdMethod = addWeightDomainObjectClass.getDeclaredMethod("getId");
		
		Method getWeightMethod = addWeightDomainObjectClass.getDeclaredMethod("getWeight");
		
		
		return "<input style=\"width:38px;\" id=\""+getIdMethod.invoke(addWeightDomainObj) +"w\" type=\"text\" value=\""+getWeightMethod.invoke(addWeightDomainObj)+"\" />"+
							"<input class=\"weightSubmit\" id=\""+getIdMethod.invoke(addWeightDomainObj)+"\" type=\"button\" value=\"提交\" />";
	}
	
 
	/**
	 * addWeightForm是获得改变权重的表单内容的方法，注意由于在html中表单不能嵌套，请将表单至于合适的地方，实例admin/auditShop.jsp
	 * 仅供admin使用
	 * 请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.addWeightForm(obj,"") %>调用 
	 * 
	 * @param addWeightDomainObj
	 *            该参数要修改权重的对象的一个实例，注意这个实例具体内容无关，只是想要知道实例的类型
	 * @param backURL
	 *            该参数为删除后应返回的URL地址
	 * @return 删除链接的form标签
	 */
	public static String addWeightForm(Object addWeightDomainObj, String backURL){

		return "<form id=\"addWeightForm\" action=\"AdminAddWeightDomainServlet.work\" method=\"post\" >"+
				"<input type=\"hidden\" name=\"domain\" value=\""+addWeightDomainObj.getClass().getName()+"\"/>"+
				"<input type=\"hidden\" name=\"backURL\" value=\""+backURL+"\"/>"+
				"</form>";
	}
	
	
	/**
	 * getDeleteButton是一个得到删除链接的方法，他返回删除链接的a标签
	 * 请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.getDeleteButton(obj,"") %>调用 
	 * 
	 * @param deleteDomainObj
	 *            该参数为要删除的domain对象实例
	 * @param backURL
	 *            该参数为删除后应返回的URL地址
	 * @return 删除链接的a标签
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static String getDeleteButton(Object deleteDomainObj, String backURL)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		int id = -1;
		Class<? extends Object> deleteDomainObjectClass = deleteDomainObj
				.getClass();

		Method getIdMethod = deleteDomainObjectClass.getDeclaredMethod("getId");

		id = (Integer) getIdMethod.invoke(deleteDomainObj);
		return "<a href='SellerDeleteDomainServlet.work?domain="
				+ deleteDomainObjectClass.getName() + "&id=" + id + "&backURL="
				+ backURL + "'>删除</a>";
	}
	public static String getDeleteButton1(Object deleteDomainObj, String backURL)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		int id = -1;
		Class<? extends Object> deleteDomainObjectClass = deleteDomainObj
				.getClass();

		Method getIdMethod = deleteDomainObjectClass.getDeclaredMethod("getId");

		id = (Integer) getIdMethod.invoke(deleteDomainObj);

		return "<a href='AdminDeleteDomainServlet.work?domain="
				+ deleteDomainObjectClass.getName() + "&id=" + id + "&backURL="
				+ backURL + "'>删除</a>";
	}

	/**
	 * getVideoPlayButton 方法用于返回播放视频img的弹窗标签
	 * 如果要使用该方法请，先加载fancybox和jquery控件,并且调用.video的fancyBox方法
	 * 请将代码放置于<body></body>中的具体位置,需要fancybox和jquery,使用<%=URLHelper.getVideoPlayButton("") %>调用
	 * 
	 * 
	 * @param videoName 是要显示缩略图的视频的在数据库的链接地址
	 * 
	 */
	public static String getVideoPlayButton(String videoName) {
		return "<a class=\"video fancybox.iframe\" "
				+ "data-fancybox-type=\"iframe\""
				+ "href=\"flex/video/playVideo.jsp?fileName="
				+ videoName
				+ "\"><div style=\"position:absolute;width:175px;height:120px;\">"
				+ "<img style=\"position:absolute;width:175px;height:120px;left:0px;top:0px;\" src=\""
				+ videoURL
				+ videoName.replace("flv", "jpg")
				+ "\" /><img style=\"position:absolute;width:64px;height:64px;left:55px;top:28px;\" src=\"images/common/play.png\" />"
				+ "</div></a>";
	}

	/**
	 * getVideoThumbnailImageTag 方法用于返回显示视频文件缩略图的img标签
	 * 请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.getVideoThumbnailImageTag("") %>调用
	 * 
	 * @param videoName 是要显示缩略图的视频的在数据库的链接地址
	 * 
	 */
	public static String getVideoThumbnailImageTag(String videoName) {
		return "<img src=\"" + videoURL + videoName.replace("flv", "jpg")
				+ "\" />";
	}
	
	
	
	
	/**
	 * displayPictures 方法用于返回查看数据中某个图片列表信息的a标签
	 * 
	 * @param pictureDomainObject 是要查看的图片列表信息的一个domain对象的实例，其中必须指明外键的id 
	 * @param foreignKeyName 是该domain对象中作为外键的属性的名称 
	 * @param backURL 为返回按钮图片后跳转的地址
	 * 仅amdin使用,请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.managePictures(obj,"","") %>调用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
/*	public static String displayPictures(Object pictureDomainObject,
			String foreignKeyName, String backURL) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		int foreignKey = -1;

		Class<? extends Object> pictureDomainObjectClass = pictureDomainObject
				.getClass();

		Method getForeignKeyMethod = pictureDomainObjectClass
				.getDeclaredMethod("get"
						+ ORMapping.formatString(foreignKeyName));

		foreignKey = (Integer) getForeignKeyMethod.invoke(pictureDomainObject);

		return "<a href='displayPictures.jsp?domain="
				+ pictureDomainObjectClass.getName() + "&foreignKey="
				+ foreignKey + "&foreignKeyName=" + foreignKeyName
				+ "&backURL=" + backURL + "'>查看</a>";
	}*/
	
	

	/**
	 * managePictures 方法用于返回管理数据中某个图片列表信息的a标签
	 * 
	 * @param pictureDomainObject 是要管理的图片列表信息的一个domain对象的实例，其中必须指明外键的id 
	 * @param foreignKeyName 是该domain对象中作为外键的属性的名称 
	 * @param backURL 为增加或删除图片后跳转的地址
	 * 仅shop使用,请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.managePictures(obj,"","") %>调用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
/*	public static String managePictures(Object pictureDomainObject,
			String foreignKeyName, String backURL) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		int foreignKey = -1;

		Class<? extends Object> pictureDomainObjectClass = pictureDomainObject
				.getClass();

		Method getForeignKeyMethod = pictureDomainObjectClass
				.getDeclaredMethod("get"
						+ ORMapping.formatString(foreignKeyName));

		foreignKey = (Integer) getForeignKeyMethod.invoke(pictureDomainObject);

		return "<a href='managePictures.jsp?domain="
				+ pictureDomainObjectClass.getName() + "&foreignKey="
				+ foreignKey + "&foreignKeyName=" + foreignKeyName
				+ "&backURL=" + backURL + "'>管理</a>";
	}*/
	
	
	/**
	 * displayVideos 方法用于返回显示数据中某个视频列表信息的a标签
	 * 
	 * @param videoDomainObject 是要显示的视频列表信息的一个domain对象的实例，其中必须指明外键的id 
	 * @param foreignKeyName 是该domain对象中作为外键的属性的名称 
	 * @param backURL 为返回按钮跳转的地址
	 * 仅admin使用,请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.manageVideos(obj,"","") %>调用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	/*public static String displayVideos(Object videoDomainObject,
			String foreignKeyName, String backURL) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		int foreignKey = -1;

		Class<? extends Object> videoDomainObjectClass = videoDomainObject
				.getClass();

		Method getForeignKeyMethod = videoDomainObjectClass
				.getDeclaredMethod("get"
						+ ORMapping.formatString(foreignKeyName));

		foreignKey = (Integer) getForeignKeyMethod.invoke(videoDomainObject);

		return "<a href='displayVideos.jsp?domain="
				+ videoDomainObjectClass.getName() + "&foreignKey="
				+ foreignKey + "&foreignKeyName=" + foreignKeyName
				+ "&backURL=" + backURL + "'>管理</a>";
	}*/
	

	/**
	 * manageVideos 方法用于返回管理数据中某个视频列表信息的a标签
	 * 
	 * @param videoDomainObject 是要管理的视频列表信息的一个domain对象的实例，其中必须指明外键的id 
	 * @param foreignKeyName 是该domain对象中作为外键的属性的名称 
	 * @param backURL 为增加或删除图片后跳转的地址
	 * 仅shop使用,请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.manageVideos(obj,"","") %>调用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	/*public static String manageVideos(Object videoDomainObject,
			String foreignKeyName, String backURL) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		int foreignKey = -1;

		Class<? extends Object> videoDomainObjectClass = videoDomainObject
				.getClass();

		Method getForeignKeyMethod = videoDomainObjectClass
				.getDeclaredMethod("get"
						+ ORMapping.formatString(foreignKeyName));

		foreignKey = (Integer) getForeignKeyMethod.invoke(videoDomainObject);

		return "<a href='manageVideos.jsp?domain="
				+ videoDomainObjectClass.getName() + "&foreignKey="
				+ foreignKey + "&foreignKeyName=" + foreignKeyName
				+ "&backURL=" + backURL + "'>管理</a>";
	}*/

	/**
	 * displayIntroduction方法用于返回显示数据库中某个富文本信息的a标签
	 * 
	 * @param introductionDomainObject 是要显示的富文本信息的domain对象的实例
	 * 请将代码放置于<body></body>中的具体位置,使用<%=URLHelper.displayIntroduction(obj,"") %>调用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String displayIntroduction(Object introductionDomainObject,
			String backURL) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		int id = -1;

		Class<? extends Object> introductionDomainClass = introductionDomainObject
				.getClass();

		Method getIdMethod = introductionDomainClass.getDeclaredMethod("getId");

		id = (Integer) getIdMethod.invoke(introductionDomainObject);

		return "<a href='displayIntroduction.jsp?domain="
				+ introductionDomainClass.getName() + "&id=" + id + "&backURL="
				+ backURL + "'>查看</a>";
	}
	
	public static String displayContent(Object introductionDomainObject,
			String backURL) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		int id = -1;

		Class<? extends Object> introductionDomainClass = introductionDomainObject
				.getClass();

		Method getIdMethod = introductionDomainClass.getDeclaredMethod("getId");

		id = (Integer) getIdMethod.invoke(introductionDomainObject);

		return "<a href='displayContent.jsp?domain="
				+ introductionDomainClass.getName() + "&id=" + id + "&backURL="
				+ backURL + "'>查看</a>";
	}
	
	
	/*************************************Html部分封装代码End*****************************************/
	

	/*************************************Servlet部分封装代码Start*****************************************/
	
	/**
	 * sendMessage方法用于向指定JSP或Servlet页面传递参数
	 * 该方法使用get方式在request对象中传递httpMessage这一参数， 一般该方法与alertMessage一同使用
	 * 
	 * @param response
	 *            response是本页面的一个HttpServletResponse的实例，用于页面跳转
	 * @param message
	 *            message是本页面要传递给下一个页面的信息（一个字符串）
	 * @param sendURL
	 *            sendURL是本页面要跳转到的目标页面路径，可以是绝对或者相对路径
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 * 
	 */
	public static void sendMessage(HttpServletResponse response,
			String message, String sendURL) throws ServletException,
			IOException {
		if (sendURL.contains("?"))
			response.sendRedirect(sendURL + "&httpMessage="
					+ URLEncoder.encode(message, "UTF-8"));
		else
			response.sendRedirect(sendURL + "?httpMessage="
					+ URLEncoder.encode(message, "UTF-8"));
	}
	

	/**
	 * fullFields用于接受表单传递的参数，并将它们写入到domain对象中
	 * 该方法使用java反射，根据属性名匹配，将request中得到的参数写入的Object对象
	 * 
	 * @param request
	 *            request是本页面的HttpServletRequest的实例
	 * @param obj
	 *            obj是从request对象中得到属性的Object对象
	 * @return 传入的obj对象填写满数据后返回
	 * @throws IOException
	 *             if an error occurred
	 * 
	 */
	public static Object fullFields(HttpServletRequest request, Object obj)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Class<? extends Object> objClass = obj.getClass();
		Field[] fields = objClass.getDeclaredFields();
		for (Field field : fields) {

			Method method = objClass.getDeclaredMethod("set"
					+ formatString(field.getName()), field.getType());

			if (field.getType() == stringType)
				method.invoke(obj, getString(request, field.getName()));
			else if (field.getType() == integerType)
				method.invoke(obj, getInt(request, field.getName()));
			else if (field.getType() == floatType)
				method.invoke(obj, getFloat(request, field.getName()));
			else if (field.getType() == doubleType)
				method.invoke(obj, getDouble(request, field.getName()));
			else if (field.getType() == dateType)
				method.invoke(obj, getDate(request, field.getName()));
			else if (field.getType() == booleanType)
				method.invoke(obj, getBoolean(request, field.getName()));
		}

		return obj;
	}

	/**
	 * getSessionShop用于得到商铺登陆成功后存在session中的Shop对象
	 * 
	 * @param request
	 *            request是本页面的HttpServletRequest的实例
	 * @return 得到商铺登陆成功后存在session中的Shop对象
	 */
	public static Shop getSessionShop(HttpServletRequest request) {
		return (Shop) request.getSession().getAttribute("shop");
	}

	/**
	 * getSessionAdmin用于得到管理员登陆成功后存在session中的Admin对象
	 * 
	 * @param request
	 *            request是本页面的HttpServletRequest的实例
	 * @return 得到管理员登陆成功后存在session中的Admin对象
	 */
	/*public static Admin getSessionAdmin(HttpServletRequest request) {
		return (Admin) request.getSession().getAttribute("admin");
	}*/
	
	
	/**
	 * getSessionUser用于得到管理员登陆成功后存在session中的User对象
	 * 
	 * @param request
	 *            request是本页面的HttpServletRequest的实例
	 * @return 得到用户登陆成功后存在session中的User对象
	 */
	public static User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	/*************************************Servlet部分封装代码End*****************************************/
	

	/**
	 * 该方法不用于一般调用可以无需了解
	 * 
	 * 
	 */
/*	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] getIntroduction(HttpServletRequest request)
			throws IOException, ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		String[] returns = new String[2];

		returns[0] = getString(request, "backURL", "");

		String domainClassStr = getString(request, "domain", "");

		int id = getInt(request, "id", -1);

		if (domainClassStr.equals("") || id == -1) {
			returns[1] = "请选择需查看的内容";
			return returns;
		} else {
			Class<? extends Object> domainClass = Class.forName(domainClassStr);
			Constructor<? extends Object> constructor = domainClass
					.getConstructor();
			Object obj = constructor.newInstance();
			Method setIdMethod = domainClass.getDeclaredMethod("setId",
					int.class);
			setIdMethod.invoke(obj, id);
			ORMapping objOrm = new ORMapping(obj);
			obj = objOrm.get("id");
			Method getIntroductionMethod = domainClass
					.getDeclaredMethod("getIntroduction");
			String introduction = (String) getIntroductionMethod.invoke(obj);
			returns[1] = introduction;
			return returns;
		}
	}*/

	public static String getString(HttpServletRequest request, String name) {
		return getString(request, name, "");
	}

	public static String getString(HttpServletRequest request, String name,
			String defaultValue) {
		if (request.getParameter(name) == null
				|| "".equals(request.getParameter(name).trim())) {
			return defaultValue;
		} else {
			return request.getParameter(name);
		}
	}

	public static boolean getBoolean(HttpServletRequest request, String name) {
		return getBoolean(request, name, false);
	}

	public static boolean getBoolean(HttpServletRequest request, String name,
			boolean defaultValue) {
		if (request.getParameter(name) == null
				|| !("true".equals(request.getParameter(name).trim()) || "false"
						.equals(request.getParameter(name).trim()))) {
			return defaultValue;
		} else {
			if ("true".equals(request.getParameter(name).trim()))
				return true;
			else
				return false;
		}
	}

	public static Date getDate(HttpServletRequest request, String name) {
		return getDate(request, name, new Date());
	}

	public static Date getDate(HttpServletRequest request, String name,
			Date defaultDate) {
		if (request.getParameter(name) == null) {
			return defaultDate;
		} else {

			String dateString = request.getParameter(name);

			String[] dateStrings = dateString.split("-");

			if (dateStrings.length < 3)
				return defaultDate;

			int year = 0;
			int month = 0;
			int day = 0;

			try {
				year = Integer.parseInt(dateStrings[0]) - 1900;

				month = Integer.parseInt(dateStrings[1]) - 1;

				day = Integer.parseInt(dateStrings[2]);

			} catch (NumberFormatException e) {
				return defaultDate;
			}

			@SuppressWarnings("deprecation")
			Date date = new Date(year, month, day);

			return date;
		}
	}

	public static float getFloat(HttpServletRequest request, String name) {
		return getFloat(request, name, -1);
	}

	public static float getFloat(HttpServletRequest request, String name,
			float defaultValue) {
		if (request.getParameter(name) == null
				|| "".equals(request.getParameter(name).trim())) {
			return defaultValue;
		} else {
			return Float.parseFloat(request.getParameter(name));
		}
	}

	public static double getDouble(HttpServletRequest request, String name) {
		return getFloat(request, name, -1);
	}

	public static double getDouble(HttpServletRequest request, String name,
			double defaultValue) {
		if (request.getParameter(name) == null
				|| "".equals(request.getParameter(name).trim())) {
			return defaultValue;
		} else {
			return Double.parseDouble(request.getParameter(name));
		}
	}

	public static int getInt(HttpServletRequest request, String name) {
		return getInt(request, name, -1);
	}

	public static int getInt(HttpServletRequest request, String name,
			int defaultValue) {
		if (request.getParameter(name) == null
				|| "".equals(request.getParameter(name).trim())) {
			return defaultValue;
		} else {
			return Integer.parseInt(request.getParameter(name));
		}
	}
	
	
/*	public static String getNewIndentNumber(){
		
		StringBuffer sb = new StringBuffer();
		
		do{
			for(int i=0;i<10;i++){
				sb.append(keys.charAt((int) (Math.random()*10))) ;
			}
			
		}while(hasSameNumber(sb.toString()));
		
		return sb.toString();
		
	}*/
	
	public static BufferedImage zoomImage(BufferedImage im, int toWidth,int toHeight) {
	       /*新生成结果图片*/
		 BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);
		 result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
	     return result;
	}
	
	public static String formatDate(Date date){
		
		DateFormat df =DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.CHINA);
		
		return df.format(date);
		
	}

	private static String formatString(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private static String isMulti(boolean isMulti, String hiddenName) {
		if (!isMulti)
			return "$('." + hiddenName + "').remove();";
		return "";
	}
	
/*	private static boolean hasSameNumber(String str){
		boolean isSameNumber = true;
		
		Connection conn = null;

		PreparedStatement ps = null;

		ResultSet rs = null;
		

		try {
			
			conn = DataSourceFactory.getInstance().getConection();
			
			ps = conn.prepareStatement("SELECT * FROM Indent WHERE number=?");

			ps.setString(1, str);
			
			rs = ps.executeQuery();

			
			if(!rs.next()){
				isSameNumber = false;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			return isSameNumber;
		} finally {
			try {
				DataSourceFactory.getInstance().free(conn, ps, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return isSameNumber;
	}*/	
}
