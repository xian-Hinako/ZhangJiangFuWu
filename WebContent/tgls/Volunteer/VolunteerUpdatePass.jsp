<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-1.11.3.min.js"></script>
</head>
<style>
	body{
		background: #F5F5F5;
	}
	.pass{
		width: 600px;
		height: 300px;
		margin: 50px auto;
		background: transparent;
		font-size: 18px;
	}
	span{
		float: left;
		
	}
	.pass1{
		width: 600px;
		height: 50px;
		background: transparent;
		margin: 10px auto;
	}
	input{
		width: 500px;
		height: 30px;
		float: right;
		margin-right: 10px;
	}
	.submit{
		width: 60px;
		height: 40px;
		background: #39f;
		font-size: 18px;
		margin-left: 20px;
	}
</style>
<body>
<!-- <form action="${pageContext.request.contextPath }/Updatepassend.do" method="post">   -->
<form  method="get">
<div class="pass">
		<div class="pass1">
	<label>用户ID</label><input type="text" name="uid" id="uid" placeholder="请输入账号" value="${uidpass}" readonly="readonly"></div>
	<div class="pass1">
	<label>原始密码</label><input type="password" name="oldpassword" id="oldpassword" onblur="checkoldpassword()"><span id="oldpassword_span"></span></div>
	<div class="pass1">
	<label>新密码</label><input type="password" name="password1" id="password1"><span id="password1_span"></span></div>
	<div class="pass1">
	<label>确认密码</label><input type="password" name="password2" id="password2" onblur="checkpassword2()"><span id="password2_span"></span></div>

    <div class="sub"><button type="button" class="submit" onclick="updatePassword()">提交</button><a href="${pageContext.request.contextPath }/TooridinaryHome.do">返回首页</a></div>
	</div>
</form>	
   
   <!-- 传旧密码 -->
<input type="text" style="display: none;" id="oldpasswordC" name="oldpasswordC" value="${oldpassword }"/>
   
	

	<script type="text/javascript">
	   function checkoldpassword(){
		   var flag = false;
		   var oldpasswordC = document.getElementById('oldpasswordC').value;
		   var oldpassword = document.getElementById('oldpassword').value; 
		   if(oldpassword == ""){
			   flag = true;
			   document.getElementById("oldpassword_span").innerHTML='<font color="red">请输入原密码</font>';
			   document.getElementById("oldpassword").focus();
		   }else{
			   if(oldpasswordC != oldpassword){
				   flag = true;				   
				   document.getElementById("oldpassword_span").innerHTML='<font color="red">原密码不正确</font>';
				   document.getElementById("oldpassword").value="";
				   document.getElementById("oldpassword").focus();
			   }else{
				   flag = true;
				   $("#oldpassword_span").hide();
			   } 
		   }
		   return flag;
	   }
	</script>
			 
	<script>
	/*
        $(function(){
            $("#password2").blur(function(){
	           var flag = false;
	            if($("#password2").val() == ""){
	            	document.getElementById("password2_span").innerHTML='<font color="red">确认密码不能为空</font>';
	            	document.getElementById("password2").focus();
	            }
                if($("#password1").val()!=$("#password2").val()){
                    flag = false;
                    document.getElementById("password2_span").innerHTML='<font color="red">两次输入的密码不一致</font>';
                    document.getElementById("password2").value="";
                    document.getElementById("password2").focus();
                }else{
	                flag = true;
	                $("#password2_span").hide();  
                }
            })             
        })
*/

       function checkpassword2(){
	         var flag = false;
	         if($("#password1").val()!=$("#password2").val()){
	         flag = false;
	         document.getElementById("password2_span").innerHTML='<font color="red">两次输入的密码不一致</font>';
	         document.getElementById("password2").value="";
	         document.getElementById("password2").focus();
	       }else{
		     flag = true;
		     $("#password2_span").hide();  
	     }
         return  flag;
	        
       }
       
       function updatePassword() {
    	   var oldpassword = $("#oldpassword").val();
			var password1 = $("#password1").val();
	    	var uid = $("#uid").val();
			var password2 = $("#password2").val();			
			if(oldpassword ==""){
				document.getElementById("oldpassword_span").innerHTML='<font color="red">请输入原密码</font>';
		        document.getElementById("oldpassword").value="";
		        document.getElementById("oldpassword").focus();
			}else{
				if(password1 == ""){
					document.getElementById("password1_span").innerHTML='<font color="red">两次输入的密码不一致</font>';
			         document.getElementById("password1").value="";
			         document.getElementById("password1").focus();
				}else{
					var flag = checkpassword2();
					if(flag == true){
						$.ajax({
							type:"post",
							data:{"uid":uid,"password2":password2},
							url:"${pageContext.request.contextPath }/Updatepassend.do",
							dataType:"json",
							success:function(data){
								if(data== true){
									alert("修改成功,请重新登录!");
									window.location.href="${pageContext.request.contextPath }/Userlogin.do";
								}
								else{
									location.href="${pageContext.request.contextPath }/ToUpdatePassword.do";
									alert("修改失败!");
								}
							}
						});
						}
						else{
							document.getElementById("password2_span").innerHTML='<font color="red">两次输入的密码不一致</font>';
					        document.getElementById("password2").value="";
					        document.getElementById("password2").focus();
						}
				}
			}			
		}
     
    </script>

</body>
</html>