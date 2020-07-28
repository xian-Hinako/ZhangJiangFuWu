<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人服务记录</title>
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
						<th>服务时长</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach  items="${PersonRecordlist}" var="PersonRecord" >
					<tr>
					    <td>${PersonRecord.reacordid}</td>    	
						<td>${PersonRecord.uid}</td>
						<td>${PersonRecord.actid}</td>
						<td>${PersonRecord.duration}</td>
					</tr>
				 </c:forEach>
				</tbody>
			</table>
	</body>
</html>