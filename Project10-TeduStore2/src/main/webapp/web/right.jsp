<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <!--个人信息头部-->
<div class="rightsidebar_box rt">
   <div class="rs_header">
    <span><a href="${pageContext.request.contextPath}/showPersonInfo.do">我的信息</a></span> <span
     class="rs_header_active"><a href="${pageContext.request.contextPath}/showPassword.do">安全管理</a></span>
   </div>

   <!--安全管理 -->
   <div class="rs_content">
    <p class="change_password_title">更改密码</p>
    <span style="color: blue" id="changeSpan"></span>
    <div class="new_password">
     <span class="word">输入旧密码：</span> <input type="password"
      name="oldPwd" id="oldPwd" /><span class="change_hint"
      id="oldPwdSpan"></span>
    </div>
    <div class="new_password">
     <span class="word">输入新密码：</span> <input type="password"
      name="newPwd" id="newPwd" /><span class="change_hint"
      id="newPwdSpan"></span>
    </div>
    <div class="confirm_password">
     <span class="word">确认新密码：</span> <input type="password"
      name="confirmPwd" id="confirmPwd" /><span class="confirm_hint"
      id="confirmPwdSpan"></span>
    </div>
    <div class="save_password">
    <a href="#" style="color:#fff" onclick="changePasswordFun()">保存更改</a></div>
   </div>
  </div>