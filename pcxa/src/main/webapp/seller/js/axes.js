	var x = null ;
	var x = null ;
	function show_coords(event)
		{ 	x=event.clientX + document.body.scrollLeft - document.body.clientLeft-10;
			y=event.clientY + document.body.scrollTop - document.body.clientTop-30;
			
			$.fancybox.open(
			             	{	
			             		href :'addSpotsMapFancybox.jsp',
			             		title : '添加景点',
			    				maxWidth : 620,
			    				maxHeight : 620,
			    				fitToView : true,
			    				width : 500,
			    				height : 350,
			    				autoSize : false,
			    				autoCenter: true,
			    				closeClick : true,
			    				openEffect : 'elastic',
			    				closeEffect : 'elastic',
			    				type:'iframe',
			    				}
			            	).update()
		}
	
	