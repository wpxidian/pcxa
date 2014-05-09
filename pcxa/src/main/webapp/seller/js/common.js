// 页面左边空隙
var containerLeft = 0;
// 页面上边空隙
var containerTop = 0;

//class属性为container的div标签左右居中且上下居中
function centerPageXY() {
	$(window).resize(
			function() {
				containerLeft = ($(window).width() - $('.container')
						.outerWidth()) / 2;
				containerTop = ($(window).height() - $('.container')
						.outerHeight()) / 2;

				$('.container').css({
					position : 'absolute',
					left : containerLeft,
					top : containerTop
				});
			});
	// To initially run the function:
	$(window).resize();
}

//class属性为container的div标签左右居中
function centerPageX() {
	$(window).resize(function() {
		containerLeft = ($(window).width() - $('.container').outerWidth()) / 2;
		$('.container').css({
			position : 'absolute',
			left : containerLeft,
			top : '0px'
		});
	});
	// To initially run the function:
	$(window).resize();
}
