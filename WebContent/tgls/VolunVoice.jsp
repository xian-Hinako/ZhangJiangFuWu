<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Vvioce.css">
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
	  <!-- 已经登录的志愿活动 -->
	  <c:if test="${usersession.uid !=null }">
	    <div>
		   <li><a href="${pageContext.request.contextPath}/listActivity.do">志愿活动</a></li>
		</div>
	  </c:if>
	  <!-- 未登录的志愿活动 -->
	  <c:if test="${usersession.uid ==null }">
	    <div>
		   <li><a href="${pageContext.request.contextPath}/listActivity.do">志愿活动</a></li>
		</div>
	  </c:if>
	<li><a href="#">新闻动态</a></li>
	<li><a href="#">团队风采</a></li>
	<li><a href="${pageContext.request.contextPath}/AllMessage.do">志愿心声</a></li>
</div>   
</div>
<div class="photo">
	<img src="${pageContext.request.contextPath}/images/1.jpg">
</div>
   
   <!-- 获取session值查看用户是否登录 -->
   <input type="text" style="display: none" id="uid" name="uid" value="${usersession.uid }">
   
<div class="voice">
    <!--   <form action="${pageContext.request.contextPath}/AddNewMessage.do">   --> 
       <form >
		<textarea id="content" id="content" name="content" placeholder="50字以内"></textarea>
	 <button type="button" id="send">发布</button>	
		<!--  <input type="submit" id="send" value="发布"/>  -->
		</form>
		</div>
		<ul id="box">
		  <c:forEach  items="${AllMessage}" var="AllMessage" >
			<li>
				<p>账号:${AllMessage.uid}: ${AllMessage.content}</p>
				<p>${AllMessage.time}</p>
				<span>
				    <c:if test="${AllMessage.uid == user.uid}">
				       <div>
				        <a href="${pageContext.request.contextPath}/DeleteMessage.do?mid=${AllMessage.mid}">X</a>
				       </div>
				    </c:if>
				</span>
			</li>	
		  </c:forEach>
		</ul>
		<script>
			//绑定删除事件
			var dels=box.getElementsByTagName('span');
			for(var i=0;i<dels.length;i++){
				dels[i].onclick=function(){
                    box.removeChild(this.parentNode)            
				}
	        }

	        function getDate(){
				var date=new Date()
				return date.getFullYear()+'年'+(date.getMonth()+1)+'月'+date.getDate()+'号'
			}
	        
	        //// 绑定点击发布事件
	        send.onclick=function(){
	        	if(document.getElementById('content').value==""){
	        		alert('请输入内容');
	        		document.getElementById('content').focus();
	        	//	return;
	        	}else{
	        		var uid = document.getElementById('uid').value;
	        		if(uid == ""){
	        			location.href="${pageContext.request.contextPath}/Userlogin.do";
	        			alert('请先登录!');
	        		//	$("#content").val("");	        			
	        		}else{
	        			var content = document.getElementById('content').value;
	        			 $.ajax({
	        				 url:"${pageContext.request.contextPath}/AddNewMessage.do",
	        				 type:"post",
	        				 data:{"uid":uid,"content":content},
	        				 dataType:"json",
	        				 async:false,
	        				 success:function(data){
	        					 location.href="${pageContext.request.contextPath}/AllMessage.do";
	        					 if(data == true){
	        						 alert("发布成功!");
	        					 }else{
	        						 alert("发布失败!");
	        					 }					 
	        				 }
	        			 });
	        		}
	        	}
	        }
	        
	        // 绑定点击发布事件
	    /*    send.onclick=function(){
	        	if(document.getElementById('content').value==""){
	        		alert('请输入内容');
	        		return;
	        	}
	        
	        var tag=document.createElement('li');
	        tag.innerHTML='<p>'+txt.value+'</p><p class="date">'+getDate()+'</p><span>   X    </span>';
	        box.insertBefore(tag,box.children[0])

	        for(var i=0;i<dels.length;i++){
	        	dels[i].onclick=function(){
	        		box.removeChild(this.parentNode)
	        	}
	        }
	        txt.value="";
         }
        */
        
		</script>

	
</body>

</body>
</html>