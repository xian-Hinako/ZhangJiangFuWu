<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Viconfont.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Vmy.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Vanimate.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/syalert/Vsyalert.min.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}//js/Vjquery.min.js"></script>
<script src="${pageContext.request.contextPath}/syalert/Vsyalert.min.js"></script>
</head>
</head>
<body>
<c:if test="${user.identity == 2 || user.identity == 0}">
  <div>
  <div class="top">
		<div class="cen">
		<li class="fir"><a href="${pageContext.request.contextPath}/TooridinaryHome.do">首页</a></li>
		<li>新闻头条</li>
		<li>新闻动态</li>
		<li>团队风采</li>
		<li><a href="${pageContext.request.contextPath}/AllMessage.do">志愿心声</a></li>
	</div>   
	</div>
</div>
</c:if>

    <div class="btns">
	  	<a href="${pageContext.request.contextPath}/ToUpdatePerson.do?uiid=${persondetaild.uiid}">修改资料</a> 
	  	<a href="${pageContext.request.contextPath }/ToUpdatePassword.do">修改密码</a> 
    </div>
       
    <div class="banner">
		<ul><li><span class="iconfont icon-nicheng"></span><h5>序号：${persondetaild.uiid}</h5></li>
		<ul><li><span class="iconfont icon-nicheng"></span><h5>名字：${persondetaild.uiname}</h5></li>
        <li><span class="iconfont icon-dianhuahaoma"></span><h5>性别：${persondetaild.sex==1?'男':'女'}</h5></li>
        <li><span class="iconfont icon-bangdingyouxiang"></span><h5>生日：<fmt:formatDate value="${persondetaild.birthday}" pattern="yyyy-MM-dd" /></h5></li>
        <li><span class="iconfont icon-bangdingqq"></span><h5>常在地：${persondetaild.aladdress}</h5></li>
        <li><span class="iconfont icon-weixin"></span><h5>联系方式：${persondetaild.tel}</h5></li>
        <li><span class="iconfont icon-weixin"></span><h5>头像：${persondetaild.picture}</h5></li>
		</ul>
	</div> 
	<div class="footer">
		<p><span>主办：湛江志愿者平台</span><span>承办：湛江志愿者平台</span><span>运行管理：岭南师范学院17外包2有限公司</span></p>
		<p><span>粤ICP备12783789-1号</span><span>地址：岭南师范学院17外包2</span>
			<span>邮政编码：000000</span>
			<span></span>
		</p>
	</div>
</body>
</html>