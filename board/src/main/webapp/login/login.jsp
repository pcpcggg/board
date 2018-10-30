<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="/img/favicon.ico">
<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
<script src="/bd/js/jquery-3.3.1.min.js"></script>

<title>로그인 </title>

<style type="text/css">
.login_logo {background: #fff; width: 80px; height: 60px; line-height: 60px; margin: 0 auto 30px; border-radius:8px;
	animation: target_image 3s; 
	animation-iteration-count: infinite;
	transform-origin: 50% 50%;
}
@keyframes target_image {

0% { transform: rotate(0deg); }
100% { transform: rotate(360deg); }

}
.login_logo img { margin-bottom:0 !important;}

.btn-primary {
    color: #fff;
    background-color: #efa943;
    border-color: #b99115;
}

</style>

<script type="text/javascript">

$(document).ready(function(){

	if(getCookie("remember") == "Y"){
		$("#idSaveCheck").attr("checked", true);
		$("#userId").val(getCookie("userId"));
	}else{
		$("#idSaveCheck").attr("checked", flase);
	}
	
});

function getCookie(cookieName){
	var cookies = document.cookie.split("; ");
	
	var cookieValue = "";
	for(var i = 0; i< cookies.length; i++){
		var str = cookies[i];
		if(str.startsWith(cookieName +"="))
			cookieValue = str.substring((cookieName + "=").length);
	}
	return cookieValue;
}

</script>


</head>
<body>
		<form class="form-signin" style="text-align: center;" method="post" action="/loginBoard">
			  <div class="login_logo">
		      	<img class="mb-4 " src="/img/logo.png" alt="" width="66" height="34">
		      </div>
		      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		      <label class="sr-only">아이디</label>
		      <input type="text" name="userId" id="userId" class="form-control" placeholder="아이디를 넣어주세요." required autofocus>
		      <label class="sr-only">암호</label>
		      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="암호를넣어주세요." required>
		      
		      <div class="checkbox" style="text-align: left;">
		         <label>
		           <input type="checkbox" value="remember-me" name="remember-me"  id="idSaveCheck"> 아이디 기억하기
		         </label>
		       </div>
		  
		      <input class="btn btn-lg btn-primary btn-block"  type="submit" value="로그인">
		      <p class="mt-5 mb-3 text-muted">&copy; 2018 packchanbae</p>
    	</form>
</body>
</html>