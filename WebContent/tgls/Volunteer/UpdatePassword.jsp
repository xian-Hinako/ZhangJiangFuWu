<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>

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
		<!-- 	<form action="${pageContext.request.contextPath }/Updatepassend.do" method="post" class="layui-form">   -->
			<form method="get" class="layui-form">
			<div class="layui-form-item">
              <label class="layui-form-label">用户ID</label>
  				<div class="layui-input-inline shortInput">
						<input type="text" name="uid" id="uid" autocomplete="off" class="layui-input" value="${uidpass}" readonly="readonly">
				</div>
             </div>
				<div class="layui-form-item">
					<label class="layui-form-label">原始密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="oldpassword" id="oldpassword" onblur="checkoldpassword()" autocomplete="off" class="layui-input"><span id="oldpassword_span"></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password1" id="password1" autocomplete="off" class="layui-input"><span id="password1_span"></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-inline shortInput">
						<input type="password" name="password2" id="password2" autocomplete="off" class="layui-input" onblur="checkpassword2()"><span id="password2_span"></span>
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="button" class="layui-btn layui-btn-primary" onclick="updatePassword()">确认修改</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			
			<!-- 传旧密码 -->
			<input type="text" style="display: none;" id="oldpasswordC" name="oldpasswordC" value="${oldpassword }"/>
			<!-- 身份值
        	<input type="text" style="display: none;" id="identity" name="identity" value="${identity }"/>  -->
			
			<script>
				layui.use('form', function() {
					var form = layui.form;
					//监听提交
					form.on('submit(submitBut)', function(data) {
						layer.msg(JSON.stringify(data.field));
						return false;
					});
				});
			</script>
			
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
                if($("#password1").val()!=$("#password2").val()){
                    flag = false;
                    document.getElementById("password2_span").innerHTML='<font color="red">两次输入的密码不一致</font>';
                    document.getElementById("password2").value="";
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
     
    </script>
	
			
			
			<script type="text/javascript">                            
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
								//	location.href="${pageContext.request.contextPath }/Userlogin.do";
								    top.location='${pageContext.request.contextPath }/Userlogin.do';
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
		</div>

</body>
</html>