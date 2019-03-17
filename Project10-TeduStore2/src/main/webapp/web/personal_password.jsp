<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单 - 达内学子商城</title>
<link href="${pageContext.request.contextPath}/css/orders.css"
 rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css"
 rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/footer.css"
 rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/personage.css"
 rel="stylesheet" />
</head>
<body>
 <!-- 页面顶部-->
 <jsp:include page="header.jsp" />
 <!-- nav主导航-->
 <nav id="nav">
 <ul>
  <li><a href="index.html" class="acti">首页</a></li>
  <li><a href="index.html#computer">电脑办公</a></li>
  <li><a href="index.html#stationery">办公文具</a></li>
 </ul>
 </nav>
 <!-- 我的订单导航栏-->
 <div id="nav_order">
  <ul>
   <li><a href="">首页<span>&gt;</span>个人中心
   </a></li>
  </ul>
 </div>
 <!--我的订单内容区域 #container-->
 <div id="container" class="clearfix">
  <!-- 左边栏-->
  <jsp:include page="left.jsp"/>
  <!-- 右边栏-->
  <jsp:include page="right.jsp"/>
 </div>

 <!-- 品质保障，私人定制等-->
 <div id="foot_box">
  <div class="icon1 lf">
   <img src="${pageContext.request.contextPath}/images/footer/icon1.png"
    alt="" />

   <h3>品质保障</h3>
  </div>
  <div class="icon2 lf">
   <img src="${pageContext.request.contextPath}/images/footer/icon2.png"
    alt="" />

   <h3>私人定制</h3>
  </div>
  <div class="icon3 lf">
   <img src="${pageContext.request.contextPath}/images/footer/icon3.png"
    alt="" />

   <h3>学员特供</h3>
  </div>
  <div class="icon4 lf">
   <img src="${pageContext.request.contextPath}/images/footer/icon4.png"
    alt="" />

   <h3>专属特权</h3>
  </div>
 </div>
 <!-- 页面底部-->
 <div class="foot_bj">
  <div id="foot">
   <div class="lf">
    <p class="footer1">
     <img
      src="${pageContext.request.contextPath}/images/footer/logo.png"
      alt="" class=" footLogo" />
    </p>
    <p class="footer2">
     <img
      src="${pageContext.request.contextPath}/images/footer/footerFont.png"
      alt="" />
    </p>
   </div>
   <div class="foot_left lf">
    <ul>
     <li><a href="#"><h3>买家帮助</h3></a></li>
     <li><a href="#">新手指南</a></li>
     <li><a href="#">服务保障</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li><a href="#"><h3>商家帮助</h3></a></li>
     <li><a href="#">商家入驻</a></li>
     <li><a href="#">商家后台</a></li>
    </ul>
    <ul>
     <li><a href="#"><h3>关于我们</h3></a></li>
     <li><a href="#">关于达内</a></li>
     <li><a href="#">联系我们</a></li>
     <li><img
      src="${pageContext.request.contextPath}/images/footer/wechat.png"
      alt="" /> <img
      src="${pageContext.request.contextPath}/images/footer/sinablog.png"
      alt="" /></li>
    </ul>
   </div>
   <div class="service">
    <p>学子商城客户端</p>
    <img src="${pageContext.request.contextPath}/images/footer/ios.png"
     class="lf"> <img
     src="${pageContext.request.contextPath}/images/footer/android.png"
     alt="" class="lf" />
   </div>
   <div class="download">
    <img
     src="${pageContext.request.contextPath}/images/footer/erweima.png">
   </div>
   <!-- 页面底部-备案号 #footer -->
   <div class="record">&copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx</div>
  </div>

 </div>
</body>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript">
<!--对安全管理的异步操作 -->
	function changePasswordFun(){
		var oldPwd=$("#oldPwd").val();
		var newPwd=$("#newPwd").val();
		var confirmPwd=$("#confirmPwd").val();
		if(checkPasswordLength(oldPwd)&&
				checkPasswordLength(newPwd)&&
				checkPasswordLength(confirmPwd)&&
				checkPasswordEquals()){
	 		$.ajax({
	 			"url":"${pageContext.request.contextPath}/changePassword.do",
	 			"data":"oldPwd="+oldPwd+"&newPwd="+newPwd,
	 			"type":"POST",
	 			"dataType":"json",
	 			"success":function(obj){
	 				if(obj.state==0){
	 					alert(obj.message);
	 				}else{
	 					//var changeSpan=document.getElementById("changeSpan");
	 					//changeSpan.innerHTML=obj.message;
	 					//$("#oldPwdSpan").remove();
	 					//$("#newPwdSpan").remove();
	 					//$("#confirmPwdSpan").remove();
	 					alert(obj.message);			
	 					//验证正确后清除文本框
						$("#oldPwd").val("");
						$("#newPwd").val("");
						$("#confirmPwd").val("");
	 					//验证确定后同时清除样式信息
	 					$("#oldPwdSpan").html("");
						$("#newPwdSpan").html("");
						$("#confirmPwdSpan").html("");
						 
	 				}
	 			}
 			});	
		} 
	}
	//验证密码长度
	function checkPasswordLength(pwd) {
		return pwd.length >= 6 && pwd.length <= 9
	}
	//验证新密码与旧密码是否一致
	function checkPasswordEquals() {
		var newPwdValue = $("#newPwd").val();
		var confirmPwdValue = $("#confirmPwd").val();
		if (newPwdValue == confirmPwdValue) {
			return true;
		} else {
			return false;
		}
	}
	//验证输入密码长度是否为设定长度
	$("#oldPwd").blur(function() {
		if (checkPasswordLength($("#oldPwd").val())) {
			$("#oldPwdSpan").html("密码格式正确!");
			$("#oldPwdSpan").css("color", "green");
		} else {
			$("#oldPwdSpan").html("密码格式错误!");
			$("#oldPwdSpan").css("color", "red");
		}

	});
	$("#newPwd").blur(function() {
		if (checkPasswordLength($("#newPwd").val())) {
			$("#newPwdSpan").html("密码格式正确!");
			$("#newPwdSpan").css("color", "green");
		} else {
			$("#newPwdSpan").html("密码格式错误!");
			$("#newPwdSpan").css("color", "red");
		}

	});
	$("#confirmPwd").blur(function() {
		if (checkPasswordLength($("#confirmPwd").val())) {
			$("#confirmPwdSpan").html("密码格式正确!");
			$("#confirmPwdSpan").css("color", "green");
			if (checkPasswordEquals) {
				$("#confirmPwdSpan").html("密码输入正确!");
				$("#confirmPwdSpan").css("color", "green");
			} else {
				$("#confirmPwdSpan").html("两次输入密码不一致!");
				$("#confirmPwdSpan").css("color", "red");
			}
		} else {
			$("#confirmPwdSpan").html("密码格式错误!");
			$("#confirmPwdSpan").css("color", "red");
		}
	});
	//
	
	 
	
	
</script>
</html>  