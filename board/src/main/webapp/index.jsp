<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/header.jsp"%>


<style>
	.root_daum_roughmap {
		margin: 0 auto;
	}
</style>

<div class="main_con" id="main_con">
	<!-- * Daum 지도 - 지도퍼가기 -->
	<!-- 1. 지도 노드 -->
	<div id="daumRoughmapContainer1540270179556" class="root_daum_roughmap root_daum_roughmap_landing"></div>
	
	<!--
		2. 설치 스크립트
		* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
	-->
	<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>
	
	<!-- 3. 실행 스크립트 -->
	<script charset="UTF-8">
		new daum.roughmap.Lander({
			"timestamp" : "1540270179556",
			"key" : "qicx",
			"mapWidth" : "900",
			"mapHeight" : "500"
		}).render();
	</script>
	
	<!-- 
	<div>
		<h2><strong>00</strong>최신글</h2>
		<ul>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
 	-->
</div>


<%@include file="/tail.jsp"%>
