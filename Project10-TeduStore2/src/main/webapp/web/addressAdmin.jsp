<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--JSTL标签库  -->
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单 - 达内学子商城</title>
<link href="${pageContext.request.contextPath}/css/orders.css"
 rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css"
 rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/footer.css"
 rel="stylesheet" />
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
  <jsp:include page="left.jsp" />
  <!-- 右边栏-->
  <div class="rightsidebar_box rt">
   <!--标题栏-->
   <div class="rs_header">
    <span class="address_title">收获地址管理</span>
   </div>
   <!--收货人信息填写栏-->
   <div class="rs_content">
    <form method="post" action="" id="addressForm">
       <!--  隐藏表单域 -->
       <input type="hidden" name="id" id="id">
     <!--收货人姓名-->
     <div class="recipients">
      <span class="red">*</span><span class="kuan">收货人：</span><input
       type="text" name="receiverName" id="receiverName" />
     </div>
     <!--收货人所在城市等信息-->
     <div class="address_content">
      <span class="red">*</span> <span class="kuan">省&nbsp;&nbsp;份：</span>
      <select data-province="---- 选择省 ----" id="receiverState"
       name="receiverState" onchange="getCityFun(this.value,-1,-1)"></select>
      城市：<select data-city="---- 选择市 ----" id="receiverCity"
       name="receiverCity" onchange="getAreaFun(this.value,-1)"></select>
      区/县：<select data-district="---- 选择区 ----" id="receiverDistrict"
       name="receiverDistrict"></select>
     </div>


     <!--收货人详细地址-->
     <div class="address_particular">
      <span class="red">*</span><span class="kuan">详细地址：</span>
      <textarea name="receiverAddress" id="receiverAddress" cols="60"
       rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
     </div>
     <!--收货人地址-->
     <div class="address_tel">
      <span class="red">*</span><span class="kuan">手机号码：</span><input
       type="tel" id="receiverMobile" name="receiverMobile" />固定电话：<input
       type="text" name="receiverPhone" id="receiverPhone" />
     </div>
     <!--邮政编码-->
     <div class="address_postcode">
      <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input
       type="text" id="receiverZip" name="receiverZip" />
     </div>
     <!--地址名称-->
     <div class="address_name">
      <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input
       type="text" id="addressName" name="addressName" />如：<span
       class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
     </div>
     <!--保存收货人信息-->
     <div class="save_recipient">保存收货人信息</div>

    </form>
    <!--已有地址栏-->
    <div class="address_information_manage" style="width: 790px">


    </div>
   </div>
  </div>
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
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/distpicker.data.js"></script>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/distpicker.js"></script>
<script type="text/javascript"
 src="${pageContext.request.contextPath}/js/personal.js"></script>
<script type="text/javascript">
	/**
	 * 提交表单时，校验必填项是否填写完整
	 */

	$(".save_recipient").click(function() {
		var receiverName = $("#receiverName").val();// 收件人
		var receiverState = $("#receiverState").val();// 省
		var receiverCity = $("#receiverCity").val();// 市
		var receiverDistrict = $("#receiverDistrict").val();// 区/县
		var receiverAddress = $("#receiverAddress").val();// 
		var receiverMobile = $("#receiverMobile").val();
						if (receiverName && receiverState && receiverCity
								&& receiverDistrict && receiverAddress
								&& receiverMobile) {
							if($(".save_recipient").html()=="修改"){
								
								$.ajax({
									"url":"${pageContext.request.contextPath}/updateAddressById.do",
									"data":$("#addressForm").serialize(),
									"type":"POST",
									"dataType":"json",
									"success":function(obj){
										alert(obj.state + "," + obj.message);
										$("#receiverName").val("");
										$("#receiverState").val("");
										$("#receiverCity").val("");
										$("#receiverDistrict").val("");
										$("#receiverAddress").val("");// 
										$("#receiverMobile").val("");
										$("#receiverPhone").val("");
										$("#receiverZip").val("");
										$("#addressName").val("");
										//重新初始化省市区列表
										getProvinces(-1, -1, -1);
										//刷新地址信息页面
										getAllAddress();
										//修改成功后白div标签改变回'保存收货人信息'
										$(".save_recipient").html("保存收货人信息");
									}								
								})
						
							}	else{
								
								$.ajax({
									"url" : "${pageContext.request.contextPath}/addAddress.do",
									"data" : $("#addressForm").serialize(),
									"type" : "POST",
									"dataType" : "json",
									"success" : function(obj) {
										alert(obj.state + "," + obj.message);
										$("#receiverName").val("");
										$("#receiverState").val("");
										$("#receiverCity").val("");
										$("#receiverDistrict").val("");
										$("#receiverAddress").val("");// 
										$("#receiverMobile").val("");
										$("#receiverPhone").val("");
										$("#receiverZip").val("");
										$("#addressName").val("");
										//重新初始化省市区列表
										getProvinces(-1, -1, -1);
										//刷新地址信息页面
										getAllAddress();
									}
								});
							} 					  
					  } else {
						alert("请将必填信息填写完整");
					  }
				  })		   	
							
</script>
<script type="text/javascript">
	//直接调用

	$(function() {
		//所有的dd隐藏
		$("#leftsidebar_box dd").hide();
		//让账号管理显示
		$("#leftsidebar_box .count_managment dd").show();
		//所有的自定义列表的标题后边的图片 myOrder2.png
		$("#leftsidebar_box dt img")
				.attr("src",
						"${pageContext.request.contextPath}/images/myOrder/myOrder2.png");
		//设置账号管理的图片和其他的三个不相同
		$("#leftsidebar_box .address")
				.find('img')
				.attr("src",
						"${pageContext.request.contextPath}/images/myOrder/myOrder1.png");

		getProvinces(-1, -1, -1);
		getAllAddress();
	});
	//删除收件人数据
	function goDelete(id){
		$.ajax({
			"url":"${pageContext.request.contextPath}/deleteAddressById.do",
			"data":"id="+id,
			"dataType":"json",
			"type":"GET",
			"success":function (obj){//
				//有漏洞
				confirm(obj.state+","+obj.message);
				getAllAddress();	 
			}	
		})	
	}
	//回显数据
	function goUpdate(id){
		$.ajax({
			"url":"${pageContext.request.contextPath}/getAddressById.do",
			"data":"id="+id,
			"dataType":"json",
			"type":"GET",
			"success":function(obj){
				//给表单隐藏域赋值
				$("#id").val(obj.datap.id)
				$("#receiverName").val(obj.datap.recvName);
				$("#receiverAddress").val(obj.datap.recvAddress);// 
				$("#receiverMobile").val(obj.datap.recvPhone);
				$("#receiverPhone").val(obj.datap.recvTel);
				$("#receiverZip").val(obj.datap.recvZip);
				$("#addressName").val(obj.datap.recvTag);
				//回显省市区
				getProvinces(obj.datap.recvProvince,obj.datap.recvCity,obj.datap.recvArea);
				//设置 div标签 '保存信息' 为 '修改'
				$(".save_recipient").html("修改");
			}
			
		})
		
	}
	//获取全部地址显示出来
	function getAllAddress(){
	$.ajax({
		"url":"${pageContext.request.contextPath}/getAddress.do",
		"data":"",
		"type":"GET",
		"dataType":"json",
		"success":function(obj){
			var headerVal='<div class="aim_title">'+
            '<span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>'+
            '</div>';
			$(".address_information_manage").html(headerVal);
			for(i= 0;i<obj.datap.length;i++){	
				//是默认地址
				if(obj.datap[i].isDefault==1){
					var str1 = '<div class="aim_content_one aim_active">'+
	                 '<span class="dzmc dzmc_active">'+obj.datap[i].recvTag+'</span>'+
	                 '<span class="dzxm dzxm_normal">'+obj.datap[i].recvName+'</span>'+
	                 '<span class="dzxq dzxq_normal">'+obj.datap[i].recvDistrict+obj.datap[i].recvAddress+'</span>'+
	                 '<span class="lxdh lxdh_normal">'+obj.datap[i].recvPhone+'</span>'+
	                 '<span class="operation operation_normal">'+
	                 	'<span class="aco_change" onclick="goUpdate('+obj.datap[i].id+')">修改</span>|<span class="aco_delete" onclick="goDelete('+obj.datap[i].id+')">删除</span>'+
	                 '</span>'+
	                 '<span class="swmr swmr_normal" id="'+obj.datap[i].id+'"></span>'+
	            	 '</div>';
	            	 $(".address_information_manage").append(str1);
				}else{
				//非默认地址
					var str2 = '<div class="aim_content_two">'+
	                 '<span class="dzmc dzmc_normal">'+obj.datap[i].recvTag+'</span>'+
	                 '<span class="dzxm dzxm_normal">'+obj.datap[i].recvName+'</span>'+
	                 '<span class="dzxq dzxq_normal">'+obj.datap[i].recvDistrict+obj.datap[i].recvAddress+'</span>'+
	                 '<span class="lxdh lxdh_normal">'+obj.datap[i].recvPhone+'</span>'+
	                 '<span class="operation operation_normal">'+
	                 	'<span class="aco_change" onclick="goUpdate('+obj.datap[i].id+')">修改</span>|<span class="aco_delete" onclick="goDelete('+obj.datap[i].id+')">删除</span>'+
	                 '</span>'+
	                 '<span class="swmr swmr_normal" id="'+obj.datap[i].id+'">设为默认</span>'+
	             '</div>';
					$(".address_information_manage").append(str2);
				}
			}
			//设置默认
			$(".swmr_normal").click(function(){	
				$.ajax({
					"url":"${pageContext.request.contextPath}/address/setDefault.do",
					"data":"id="+$(this).attr("id"),
					"type":"GET",
					"dataType":"json",
					"success":function(obj){					
					}
				});
				setDefault(this);
			})
			
			
			
		 }
	 });
 }
	function getProvinces(provinceCode, cityCode, areaCode) {

		$.ajax({
			"url" : "${pageContext.request.contextPath}/showProvince.do",
			"data" : "",
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {//receiverState
				$("#receiverState").html("<option>请选择</option>");
				for (i = 0; i < obj.datap.length; i++) {
					$("#receiverState").append(
							"<option value="+obj.datap[i].provinceCode+">"
									+ obj.datap[i].provinceName + "</option>");
				}
				//回显数据
				if(provinceCode !=-1){
					$("#receiverState").val(provinceCode)
				}
			}
		})
		getCityFun(provinceCode, cityCode, areaCode);
	}
	//添加城市
	function getCityFun(provinceCode, cityCode, areaCode) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/showCity.do",
			"data" : "provinceCode=" + provinceCode,
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {
				$("#receiverCity").html("<option>请选择</option>");
				for (i = 0; i < obj.datap.length; i++) {
					$("#receiverCity").append(
							"<option value="+obj.datap[i].cityCode+">"
									+ obj.datap[i].cityName + "</option>");
				}
				//回显数据
				if(cityCode!=-1){
					$("#receiverCity").val(cityCode);
				}
			}
		})
		getAreaFun(cityCode,areaCode);
	}
	function getAreaFun(cityCode,areaCode) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/showArea.do",
			"data" : "cityCode=" + cityCode,
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {
				$("#receiverDistrict").html("<option>请选择</option>");
				for (i = 0; i < obj.datap.length; i++) {
					$("#receiverDistrict").append(
							"<option value="+obj.datap[i].areaCode+">"
									+ obj.datap[i].areaName + "</option>");
				}
				//回显数据
				if(areaCode!=-1){
					$("#receiverDistrict").val(areaCode);
				}
			}
		})
	}

	//
	$(".lxdh_normal").each(function(i, e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
	//加异步提交显示邮编为六位
	
</script>
</html>