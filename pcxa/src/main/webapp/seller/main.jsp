<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>品城西安企业管理员管理中心</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.23.custom.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />


<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#accordion").accordion();
		$(window).resize(
			function() {
				$(".content").width($(window).width()-200);
				$(".content").height($(window).height()-75);
				$(".content iframe").width($(window).width()-200);
				$(".content iframe").height($(window).height()-75);
			});
		$(window).resize();	
		
	});
</script>
</head>
<body>
	<div class="top">
		<div class="top_up">
			<div class="top_down_left"></div>
			<div class="top_up_center">
				<a href="index.jsp" target="_top"><img
					src="images/main/main_06.gif" /> </a>&nbsp;&nbsp;<a href="#" onclick="back()"><img
					src="images/main/main_08.gif" /> </a>&nbsp;&nbsp;<a href="#" onclick="forward()"><img
					src="images/main/main_10.gif" /> </a>&nbsp;&nbsp;<a href="#" onclick="refresh()"><img
					src="images/main/main_12.gif" /> </a>&nbsp;&nbsp;<a href="#" onclick="window.parent.close();"><img
					src="images/main/main_14.gif" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="top_down">
			<div class="top_down_center"></div>
			<div class="top_down_right">
				店铺名称：${session.shop.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统时间：AM10:20
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="help.htm" target="content" class="toplink1">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>


	<div class="TreeWrap">
		<div id="accordion">
			
			<h3>
				<a href="#">企业信息管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="displayShopInfo.jsp" target="content">查看企业信息</a>
					</li>
					<li><a href="modifyPassword.jsp" target="content">修改密码</a>
					</li>
					<li><a href="modifyShopInfo.jsp" target="content">修改企业信息</a>
					</li>
				</ul>
			</div>
			
			<%--<h3>
				<a href="#">陕西文化管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="geographyInfo.jsp" target="content">地理信息管理</a>
					</li>
					<li><a href="historyInfo.jsp" target="content">历史信息管理</a>
					</li>
					<li><a href="folkwaysInfo.jsp" target="content">民俗信息管理</a>
					</li>
					<li><a href="regionInfo.jsp" target="content">宗教信息管理</a>
					</li>
					<li><a href="literatureInfo.jsp" target="content">文学信息管理</a>
					</li>
					<li><a href="artInfo.jsp" target="content">艺术信息管理</a>
					</li>
				</ul>
			</div>
			
			
			<h3>
				<a href="#">资源索引管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="pictureInfo.jsp" target="content">图片资源索引</a>
					</li>
					<li><a href="manageArticle_index.jsp" target="content">文章资源索引</a>
					</li>
					<li><a href="manageVideoIndex.jsp" target="content">视频资源索引</a>
					</li>
					<li><a href="manageAudio_index.jsp" target="content">音频资源索引</a>
					</li>
				</ul>
			</div>
			
			--%><h3>
				<a href="#">信息管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="displayNews" target="content">新闻管理</a>
					</li>
				</ul>
			</div>
		
			<h3>
				<a href="#">商品信息管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="displayGoods" target="content">管理商品信息</a>
					</li>
				</ul>
			</div>
			<h3>
				<a href="#">订单管理</a>
			</h3>
			<div>
				<ul>
				
					<%--<li><a href="manageGoodReserve.jsp" target="content">查询预定信息</a>
					</li>
					--%>
					<li><a href="displayIndent" target="content">查询订单信息</a>
					</li>
					<li><a href="displayMoneySum.jsp" target="content">查询销售情况</a>
					</li>
				</ul>
			</div>
			<h3>
				<a href="#">展示信息管理</a>
			</h3>
			<div>
				<ul>
					<li><a href="displayTouristSpot" target="content">管理景区信息</a>
					</li>
					<li><a href="displayTourRoute" target="content">精品线路管理</a>
					</li>
					<li><a href="displayFood" target="content">特色美食管理</a>
					</li>
					<li><a href="displayHotel" target="content">住宿酒店管理</a>
					</li>
					<li><a href="displayEntertainment" target="content">休闲娱乐管理</a>
					</li>
					<li><a href="displayTrade" target="content">购物商圈管理</a>
					</li>
					<li><a href="displayCarRenting" target="content">交通服务管理</a>
					</li>
				</ul>
			</div>
			<h3>
				<a href="#">产品推广</a>
			</h3>
			<div>
				<ul>
					<li><a href="hotelTourists_spots.jsp" target="content">酒店住宿推广</a>
					</li>
					<li><a href="foodTourists_spots.jsp" target="content">特色餐饮推广</a>
					</li>
					<li><a href="goodsExtend.jsp" target="content">商品推广</a>
					</li>
				</ul>
			</div>
			
		</div>
	</div>
	
	<div class="content">
		<iframe src="welcome.html" name="content" marginwidth="0" marginheight="0" scrolling="no" ></iframe>
	</div>
</body>
</html>