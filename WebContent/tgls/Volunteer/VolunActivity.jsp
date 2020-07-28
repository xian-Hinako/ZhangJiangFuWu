<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.VolunServices.pojo.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Vactivity.css">
   <style>
            .message_alert {
                position:absolute;
                top: 30%;
                left: 50%;
                width: 20%;
                text-align: center;
                background: #3bb4f2;
                opacity: 1;
                z-index: 999;
                padding: 5px 0;
                color: white;
                display: none;
            }       
        </style>
</head>
<body>
	<div class="top">
		<div class="cen">
		<!-- 已经登录的首页 -->
	  <c:if test="${usersession.uid !=null }">
	    <div>
		   <li><a href="${pageContext.request.contextPath}/TooridinaryHome.do">首页</li>
		</div>
	  </c:if>
	  <!-- 未登录的首页 -->
	  <c:if test="${usersession.uid ==null }">
	    <div>
		   <li><a href="${pageContext.request.contextPath}/Text.do">首页</li>
		</div>
	  </c:if>
		<li>志愿活动</li>
		<li><a href="#">新闻动态</a></li>
		<li><a href="#">团队风采</a></li>
		<li><a href="${pageContext.request.contextPath}/AllMessage.do">志愿心声</a></li>
	</div>   
	</div>
	<div class="photo">
		<img src="${pageContext.request.contextPath}/images/1.jpg">
	</div>	
	<div class="banner">	
	   <!-- 分页start -->   
		<ul>		
		<c:forEach  items="${cs}" var="cs" >
		<form method="get">
	 	<li><img src="${pageContext.request.contextPath}/images/a1.jpg"><h4><a href="" class="a1">${cs.aid}. ${cs.aname}</a></h4><p>${cs.introduce}</p><span>地点：${cs.actaddress}</span><span class="right">名额余量:${cs.number}时间：<fmt:formatDate value="${cs.day}" pattern="yyyy-MM-dd HH:mm:ss" type="both"/><div class="baoming">            
	  <!--  <div> <a href="${pageContext.request.contextPath }/CheckJoinTime2.do?aid=${cs.aid}">报名</a> </div> --> <button type="button" onclick="checkJoin(${cs.aid})">报名</button> 
	    </div></span>
        </li>          
        </form>
        </c:forEach>        
        </ul>               
	</div>
	  <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div> 
	
	<input type="text" style="display: none" id="uid" name="uid" value="${usersession.uid}">
	
	<div class="footer">
		<p><span>主办：湛江志愿者平台</span><span>承办：湛江志愿者平台</span><span>运行管理：岭南师范学院17外包2有限公司</span></p>
		<p><span>粤ICP备12783789-1号</span><span>地址：岭南师范学院17外包2</span>
			<span>邮政编码：000000</span>
			<span></span>
		</p>
	</div>
	
	<script type="text/javascript">
    $(function(){
        $('.message_alert').show(300).delay(2500).hide(300);
    })
	
	   //判断是否允许报名该活动
	   function checkJoin(aid){
    	 //  alert('进入js');
    	   var uid = document.getElementById('uid').value;
    	   if(uid ==""){
    		   location.href="${pageContext.request.contextPath }/Userlogin.do";
    		   alert("请先登录!");
    	   }else{
		   $.ajax({
			   url:"${pageContext.request.contextPath }/CheckJoinTime.do",
   			   type:"post",
   			   data:{aid:aid},
   			   dataType:"json",
   			   async:true,
   			   success:function(data){
   				   /* alert(data); */
   				  location.href="${pageContext.request.contextPath }/listActivity.do";
   				  if(data == 0){
   					alert("你已报名的某活动的时间与该活动的时间有冲突!");
   				  }
   				  if(data == 1){
   					  alert("报名成功!");
   				  }
   				  if(data == 2){
   					  alert("报名失败!");
   				  }
   				  if(data == 3){
   					  alert("活动已经失效!");
   				  }
   				  if(data == 4){
   					  alert("你已报名该活动!");
   				  }
   				  if(data == 5){
   					  alert("错误!");
   				  }
   				  if(data == 6){
 					  alert("名额已满!");
 				  }
   			}
		   });
    	   }
	   }
	   	   	
	</script>
	

</body>
</html>