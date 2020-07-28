<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
		<title>个人报名表</title>
		<style>
		*{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		h1{
			margin-top: 20px;
		}
		.return{
			width: 100px;
			line-height: 30px;
			background: #6cf;
			margin-top: 20px;
			border-radius: 50px 15px 15px  50px;
			text-align: center;
		}
		a{
			text-decoration: none;
		}
		table{
			margin-top: 20px;
		}
		th{
			width: 100px;
		}
	</style>
</head>
<body>
<h1>个人服务记录</h1>
 <div class="return"><a href="${pageContext.request.contextPath}/TooridinaryHome.do">返回首页</a></div>
 <table class="tablestyle" border="1">
    <thead>
		<tr>
			<th>ID</th>
			<th>用户账号</th>
			<th>活动ID</th>
			<th>活动状态</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	   <c:forEach  items="${PersonUnpartlist}" var="PersonUnpart" >
		  <tr>
			<td>${PersonUnpart.unpartid}</td>
			<td>${PersonUnpart.uid}</td>
			<td>${PersonUnpart.actid}</td>
			<td><c:choose>
				  <c:when test = "${PersonUnpart.status == 0}">报名中</c:when>
				  <c:when test = "${PersonUnpart.status == 1}">已完成</c:when>
				  <c:when test = "${PersonUnpart.status == 2}">已取消</c:when>
				  </c:choose></td>
			<td>
				 <a href="javascript:if(confirm('确实要取消报名吗?'))location='${pageContext.request.contextPath}/CancelUnpartBySelf.do?unpartid=${PersonUnpart.unpartid}'" class="layui-btn layui-btn-xs">取消报名</a>
			</td>
		</tr>
	 </c:forEach>
  </tbody>
 </table>	
</body>
</html>