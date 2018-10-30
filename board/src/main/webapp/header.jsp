<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/lib/lib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CB 게시판</title>

<link rel="icon" href="/img/favicon.ico">
<link rel="stylesheet" href="/css/default.css">
<!--[if lt IE 9]>
 <script src=”http://html5shim.googlecode.com/svn/trunk/html5.js”></script>
 <![endif]-->
<!--[if (gte IE 6)&(lte IE 8)]>
<script type="text/javascript" src="js/selectivizr.js"></script>
<![endif]-->
<!--[if lt IE 9]>
 <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

<script type="text/javascript">
	
	$(window).scroll(function () {
			var height = $(document).scrollTop();

			if(height > 30) { 
   				$('#head_menu').attr('class','head_menu1')
				$('#class_title').attr('class','class_title1')
			} else {
				$('#head_menu').attr('class','head_menu')
				$('#class_title').attr('class','class_title')
			}
			
	});

	$(function(){
		$('html, body').animate({scrollTop:0});
		$('a.menu1').click(function(){
			$('a').removeClass('select')
			$(this).addClass('select');
			$('html, body').animate({scrollTop:0},1000);
			//scrollTop:스크롤의 위치
			return false;
		});
		$('a.menu2').click(function(){
			$('a').removeClass('select')
			$(this).addClass('select');
			$('html, body').animate({scrollTop:$('#main_con').offset().top},1000);
			//offset:body의 제일 위에서부터의 거리
			return false;
		});
		

	});
	
</script>

</head>

<body>
	<div id="wrap">
		
    	<div class="main_01">
            <div id="head_menu" class="head_menu">
            
                <div class="logo">
                	<a href="/index.jsp">
                    	<img  src="/img/logo.png" class="logo_img" />
                    </a>
                </div>
                
                <ul>
                    <li><a class="menu" href="/index.jsp">HOME</a></li>
                    <li><a class="menu2" href="#main_con">게시판 뷰</a></li>
                    <li><a class="menu1" href="#">TOP</a></li>
                    <li><a href="/logout">LOGOUT</a></li>
                	<li>
                    	<c:if test="${S_USER.name != null}">
							<strong>${S_USER.name}</strong>님 안녕하세요.
						</c:if> 
                    </li>
                </ul>
                
                <div class="tel">
                   	<img src="img/tel.png" /> 
                    <a href="tel:01062166693">010 6216 6693</a>
                </div>
                
                <div class="tel2">
                    <a href="tel:01062166693"><img src="img/tel2.png" /></a>
                </div>
                	
            </div>
            
            <div id="class_title" class="class_title" ><a id="home">CB BOARD</a></div>
        	<div class="class_title_sub">WEB BOARD PAGE</div>
            <div>
       			<img class="main_bg" src="/img/main_bg.jpg"/>
             </div>
            <%@include file="/left.jsp" %>
    	</div>
