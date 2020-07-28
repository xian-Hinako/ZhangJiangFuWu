<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
		<meta charset="UTF-8">
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
		<title>志愿者列表</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery.mCustomScrollbar.css">
		<script src="${pageContext.request.contextPath }/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/framework/jquery.mousewheel.min.js"></script>
		<script src="${pageContext.request.contextPath }/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="${pageContext.request.contextPath }/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

</head>
<body>
<div class="cBody">
			<div class="console">

				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户账号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>地址</th>
						<th>联系方式</th>
						<th>头像</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach  items="${volunteerlist}" var="volunteerlist" >
					<tr>
						<td>${volunteerlist.uiid}</td>
						<td>${volunteerlist.uiname}</td>
						<td><c:choose>
						<c:when test = "${volunteerlist.sex ==1 }">男</c:when>
						    <c:when test = "${volunteerlist.sex ==2 }">女</c:when>
						</c:choose></td>
						<td>${volunteerlist.age}</td>
						<td>${volunteerlist.aladdress}</td>
						<td>${volunteerlist.tel}</td>
						<td>${volunteerlist.picture}</td>
						<td>
							<button class="layui-btn layui-btn-xs" onclick="updateBut(${volunteerlist.uiid})">修改</button>
						<!-- 	<button class="layui-btn layui-btn-xs" onclick="delUser(${volunteerlist.uiid})">删除</button>   -->
						</td>
					</tr>
				  </c:forEach>
				</tbody>
			</table>
			
			<!-- 传记录条数值 -->
			<input type="text" style="display: none" id="volunteerlistsize" name="volunteerlistsize" value="${volunteerlistsize }">
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				
					var volunteerlistsize = $("#volunteerlistsize").val();
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: volunteerlistsize
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
				
				
				//修改按钮
				var updateFrame = null;
				function updateBut(uiid){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "志愿者信息修改",
							type: 2,
							area: ['50%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
						    content: '${pageContext.request.contextPath}/FindPersonById.do?uiid=' +uiid
						});
					});
					
				}  
				
				function getDate(){
					var date=new Date()
					return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()
				}
			</script>
		</div>
	</body>
</html>