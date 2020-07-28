<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="https://zu.xitek.com/static/res/www/houh/css/style.css"
	rel="stylesheet" />
<link href="https://zu.xitek.com/static/res/www/houh/css/iconfont.css"
	rel="stylesheet" />
<link href="https://zu.xitek.com/static/res/www/houh/css/animate.css"
	rel="stylesheet" />
<link
	href="https://zu.xitek.com/static/res/www/houh/layui/css/layui.css"
	rel="stylesheet" />
<style type="text/css">
.box {
	width: 440px;
	margin: 0 auto;
	background: white;
}

.box-content {
	padding: 40px 10px;
	border-radius: 5px;
	box-shadow: 0px 0px 11px 5px #d6d6d6;
}

.box-title {
	text-align: center;
	padding-bottom: 10px;
}

.login-title {
	font-size: 20px;
}

body {
	background-color: #f2f2f2;
}
.btn-main {
	background-color: #333;
}

.main-btn {
	cursor: pointer;
	background: #333;
	color: #fff;
	border-radius: 6px;
	padding: 0 30px;
	height: 35px;
	line-height: 35px;
}

.cart_num {
	padding: 0px 7px;
	position: absolute;
	top: 8px;
	display: inline-block;
	height: 20px;
	line-height: 20px;
	text-align: center;
	background: #c00;
	border-radius: 20px;
	vertical-align: bottom;
	font-size: 12px;
}
</style>

<script
	src="https://zu.xitek.com/static/res/www/houh/js/jquery-3.4.1.min.js"></script>
<script src="https://zu.xitek.com/static/res/www/houh/layui/layui.js"></script>
<script src="https://zu.xitek.com/static/res/www/houh/js/jquery.form.js"></script>
<script src="https://zu.xitek.com/static/res/www/houh/js/common.js?v=2"></script>
</head>
<body>

	<div class="layui-row ">
		<div class="layui-col-md12 " style="margin: 100px 0px 200px 0px;">
			<div class="box">
				<div class='box-content  '>
					<div class="box-title">
						<!-- <img
							src="https://zu.xitek.com/static/res/www/houh/img/logo-index.png"
							style="width: 100px;"> -->
					</div>
					
					   <c:if test="${!empty msg}">
                       <span>${msg }</span>
                      </c:if>
                      
					<form action="${pageContext.request.contextPath}/Userlogin.do" method="post" class="layui-form" style="margin-top: 20px;">
						<div class="layui-form-item">
							<label class="layui-form-label">账号</label>
							<div class="layui-input-inline">
								<input type="text" id="loginBox_mobile" name="uname" required
									lay-verify="required|uname" placeholder="请输入账号
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-inline">
								<input type="password" id="loginBox_password" name="upassword"
									placeholder="密码"  class="layui-input">
							</div>
						
							&nbsp;&nbsp;
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<input type="hidden" name="_config" value='{"reload":1}'>
								<button class="layui-btn btn-main" >登录</button>
									&nbsp;&nbsp;	&nbsp;&nbsp;	&nbsp;&nbsp;	&nbsp;&nbsp;	&nbsp;&nbsp;
										&nbsp;&nbsp;	&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/ToRegisterAndGetAddress.do">注册</a>
							</div>
						</div>
						
					</form>
					<a style="float: left; text-decoration: underline; padding: 0px 5px;" href="${pageContext.request.contextPath}/tgls/FindPassword.jsp">忘记密码</a>
					<a
						style="float: right; text-decoration: underline; padding: 0px 5px;"
						href="${pageContext.request.contextPath}/tgls/index.jsp"> <img
						style="width: 18px; margin-right: 4px;"
						src="https://zu.xitek.com/static/res/www/houh/img/back.png">返回
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>