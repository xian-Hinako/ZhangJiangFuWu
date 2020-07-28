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
		<title>审核管理员</title>

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
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="输入分管名称" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" lay-submit lay-filter="formDemo">检索</button>
					</div>
				</form>

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
					 	<th><input type="button" class="cb" value="全选" onclick="checkedAll()"/> <input type="button" class="cb" value="反选" onclick="reverseAll()"/></th>
						<th>用户ID</th>
						<th>用户名</th>
						<th>用户身份</th>
						<th>地址</th>
						<th>操作<button class="layui-btn layui-btn-xs" id="deleteAllUserInfo">批量删除</button></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${NoAuditU}" var="users">
					<tr>
					    <td><input type="checkbox"  class="cb"  value="${users.uid}" /></td>
						<td>${users.uid}</td>
						<td>${users.uname}</td>
						<td><c:choose>
						<c:when test = "${users.identity ==0 }">普通志愿者</c:when></c:choose></td>
						<td>${users.nowaddress}</td>
						<td> 
						    <a href="javascript:if(confirm('确定要审核该志愿者成为管理员吗?'))location='${pageContext.request.contextPath }/AuditUser.do?uid=${users.uid}'"><button type="button" class="layui-btn layui-btn-xs">审核</button></a>
						    <a href="javascript:if(confirm('确定不通过审核吗?'))location='${pageContext.request.contextPath }/UnpassAuditUser.do?uid=${users.uid}'"><button type="button" class="layui-btn layui-btn-xs">不通过</button></a>
						</td>
					</tr>
				 </c:forEach>
				</tbody>
			</table>
			
			<!-- 传记录条数值 -->
			<input type="text" style="display: none" id ="Ausersize" name="Ausersize" value="${Ausersize }">
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				    var Ausersize = $("#Ausersize").val();
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: Ausersize
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
		</div>
	</body>
</html>




