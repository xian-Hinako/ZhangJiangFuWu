
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--启用el表达式--%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>找回密码</title>
<style type="text/css">
   .part1{
       margin-top:100px;
	   margin-bottom:100px;
	   margin-right:40%;
	   margin-left:40%;
   }
   
   .part2 input{
       width:300px;
       height:30px;
       line-height:30px;
   }
</style>
</head>
<body style="background-color:#F5F5F5 ">
  <script>    
	function send(){       
		var uname = document.getElementById("uiname");        
		var phone= document.getElementById("tel");        
		var str = uname.value;        
		var number= phone.value;        
		window.location.href="${pageContext.request.contextPath}/sendme.do?uiname="+str+"&tel="+number;    
		}
	</script>
      <div class="part1">
        <h2>找回密码</h2>
		<form action="${pageContext.request.contextPath}/comparecode.do" method="get" id="addForm" class="layui-form">
	   <div class="part2">
		用户名:<input type="text" name="uiname" id="uiname" value="${uiname}"><br>    
		手机号:<input type="text" name="tel"  id ="tel" value="${tel}"><br>   
	    </div> 
		<input type="button" value="发送验证码" id="button" onclick="send()" ><br>    
		${flag}${flag1}<br> 
		<div class="part2">   
		验证码:<input type="text" name="code"><br>    
		新的密码:<input type="password" name="upassword"><br>   
	    </div>
		<input type="submit" value="修改">

		</form>
		<a
			style="text-decoration: underline; padding: 0px 5px;"
			href="${pageContext.request.contextPath}/tgls/index.jsp"> <img style="width: 18px;"
			src="https://zu.xitek.com/static/res/www/houh/img/back.png">返回
		</a>
	</div>
</body>
</html>