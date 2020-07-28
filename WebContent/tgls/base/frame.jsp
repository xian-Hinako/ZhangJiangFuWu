<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="穷在闹市" />
		<!-- 作者 -->
		<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>湛江志愿服务</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Viconfont.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Vmy.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Vanimate.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/syalert/Vsyalert.min.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}//js/Vjquery.min.js"></script>
<script src="${pageContext.request.contextPath}/syalert/Vsyalert.min.js"></script>


		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
		<script type="text/javascript" src="framework/frame.js" ></script>
		
<title>Insert title here</title>
</head>
<body>
<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="images/logo1.png"/>
		        <div class="logoText">
		            <h1>湛江志愿服务</h1>
		            <p>zhanjiangzhiyuan</p>
		        </div>
		    </div>
		    <div class="menu">
		        <ul>
		        	<!-- <li>
		                <a class="menuFA" href="javascript:void(0)" onclick="menuCAClick('tgls/qdAPI.html',this)"><i class="iconfont icon-zhishi left"></i>前端API</a>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)" onclick="menuCAClick('tgls/iconfont.html',this)"><i class="iconfont icon-huojian left"></i>iconfont字体库</a>
		           	</li> -->
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>管理员管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                  <c:if test="${findUserByName.identity == 3 }">
		                   <div>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/NoAuditUser.do',this)">审核管理员</a></dt>
		                   </div>
		                 </c:if>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/managerlist.do',this)">管理员列表</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>志愿者管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/volunteerlist.do',this)">所有志愿者</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>活动管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/AllActivity.do',this)">所有活动</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/AllRecord.do',this)">服务记录</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/FindAllUnpart.do',this)">活动报名表</a></dt>
		                </dl>
		           	</li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left"></i>打印表单<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/base/maintain.html',this)">活动名单打印</a></dt>
		                </dl>
		           	</li>
		           	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left"></i>评论<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/FindAllMessage.do',this)">全部评论</a></dt>
		                </dl>
		           	</li>
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/ToUpdatePerson.do',this)"><i class="iconfont icon-yonghu1"></i>管理员</a></li>
						<li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath }/ToUpdatePassword.do',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="${pageContext.request.contextPath }/logout.do"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
					
				
			<!-- 头部栏 - 结束 -->			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="tgls/base/agent_add.html" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
</body>
</html>