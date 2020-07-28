<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		<title>修改志愿者信息</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.mCustomScrollbar.css">
		<script src="${pageContext.request.contextPath}/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/framework/jquery.mousewheel.min.js"></script>
		<script src="${pageContext.request.contextPath}/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-form-label{
				width: 100px;
			}
			.layui-input-block{
				margin-left: 100px;
				margin-right: 100px;
			}
		</style>

	</head>
<body>
<!-- <div class="cBody"> 
            <form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/UpdateUserInfo.do">     -->
            <form id="addForm" class="layui-form" method="get">  						
				<div class="layui-form-item">
					<label class="layui-form-label">用户ID</label>
					<div class="layui-input-block">
						<input type="text" id="uiid" name="uiid" required lay-verify="required" autocomplete="off" class="layui-input" value="${persondetaild.uiid}" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" id="uiname" name="uiname" required lay-verify="required" autocomplete="off" class="layui-input" value="${persondetaild.uiname}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<div class="layui-input-block">
						<input type="radio" id="sex" name="sex" autocomplete="off" class="layui-input" value="1"  ${("1" eq persondetaild.sex)?"checked":"" }/>男
						<input type="radio" id="sex" name="sex" autocomplete="off" class="layui-input" value="2"  ${("2" eq persondetaild.sex)?"checked":"" }/>女
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生日</label>
					<div class="layui-input-block">
						<input type="text" id="birthday" name="birthday" onchange="checkDate(this)" autocomplete="off" class="layui-input" value="<fmt:formatDate value="${persondetaild.birthday}" pattern="yyyy-MM-dd" />">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" id="aladdress" name="aladdress" autocomplete="off" class="layui-input" value="${persondetaild.aladdress}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-block">
						<input type="text" id="tel" name="tel" autocomplete="off" class="layui-input" onblur="checkMobile(this)" value="${persondetaild.tel}"><span id="telTips" style="color:red"></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">头像</label>
					<div class="layui-input-block">
						<input type="text" id="picture" name="picture" autocomplete="off" class="layui-input" value="${persondetaild.picture}" disabled="true">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
					    <!--  <input type="submit" class="layui-btn" value="立即提交 ">    -->
					    <button type="reset" class="layui-btn" onclick="update(${persondetaild.uiid})">立即提交</button> 
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			
			
			<script>
				layui.use(['upload','form'], function() {
					var form = layui.form;
					var upload = layui.upload;
					var layer = layui.layer;
					//监听提交
					//解决了layui.open弹窗从内部关闭这个弹窗的问题
					form.on('submit(submitBut)', function(data) {
						var updateFrame = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(updateFrame);  //再改变当前层的标题
					});
				});				
				
				function update(uiid){
					function userinfo(){
						this.uiid = $("#uiid").val(); 
						this.uiname = $("#uiname").val();
						this.sex = $("#sex").val();
						this.birthday = $("#birthday").val();
						this.aladdress = $("#aladdress").val();
						this.tel = $("#tel").val();
						this.picture = $("#picture").val();
						this.createDAte="";
					}
					var userinfo = new userinfo();
					var tel = $("#tel").val();
					if(tel == ""){
						checkMobile(tel);
					}else{
						$.ajax({
							url:"${pageContext.request.contextPath }/UpdateUserInfo.do",
		        			type:"post",
		        			data:JSON.stringify(userinfo),
		        			dataType:"json",
		        			async:false,
		        			cache:false,
		        			contentType: "application/json",
		        			success:function(data){
		        				/* alert(data); */	
		        				parent.location.href="${pageContext.request.contextPath }/volunteerlist.do";
		        				if(data==true){         					
		        					alert("修改成功!");	        					
		        				}else{
		        					alert("修改失败!");
		        				}	        				
		        			}
						});
					}					
		}
				
				//输入时间格式限定
				function checkDate(dateStr){
					var a = /^(\d{4})-(\d{2})-(\d{2})$/
					if(!a.test(dateStr.value)){
						alert("输入错误!日期格式应为XXXX-XX-XX!");
						dateStr.focus();
						return false;
					}else{
						return true;
					}
				}
				
				//判断手机号码格式
				  function checkMobile(s) {
					  var flag = false;
					  var tel = $("#tel").val();
					  if(tel == ""){
						  flag = true;
						  document.getElementById("telTips").innerHTML='请输入电话号码';
					      document.getElementById("tel").value="";
					      document.getElementById("tel").focus();
					  }else{
						     if (!(/^1[3|4|5|7|8][0-9]\d{8,11}$/.test(tel))) { 				      
							      flag = true;
							      document.getElementById("telTips").innerHTML='输入的格式不对';
							         document.getElementById("tel").value="";
							         document.getElementById("tel").focus();
							      
						      } else { 
							     flag = true;
							     $("#telTips").hide();
						      }
					  }
					  return flag;     
				}
			</script>
</body>
</html>