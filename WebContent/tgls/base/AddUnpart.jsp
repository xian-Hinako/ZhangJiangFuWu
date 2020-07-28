<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<title>增加报名信息</title>

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
				margin-left: 130px;
				margin-right: 90px;
			}
		</style>
		
		<script type="text/javascript">
		//检查活动是否存在
		 function checkaid(){
	        	var f= true;       	
	        	var actid= $("#actid").val();      	
	        	//	document.getElementById("actid_span").innerHTML="";
	        		$.ajax({
	        			url:"${pageContext.request.contextPath }/CheckActivity.do",
	        			type:"post",
	        			data:{"actid":actid},
	        			dataType:"json",
	        			async:false,
	        			success:function(data){
	        				/* alert(data); */
	        				if(data==false){   
	        					$("#actid").val("");
	        					alert("该活动不存在,请填写正确的活动ID");
	        				}
	        			}
	        		});
	        	return f;
	         }
		 
		 function submitAdd(){
			 var uid = $("uid").val;
			 var actid = $("actid").val;
			 var satus = $("status").val;
			 $.ajax({
				 url:"${pageContext.request.contextPath}/AddUnpart.do",
				 type:"post",
				 data:{"uid":uid,"actid":actid,"status":status},
				 dataType:"json",
				 async:false,
				 success:function(data){
					 parent.location.href="${pageContext.request.contextPath}/FindAllUnpart.do";
					 if(data == true){
						 alert("新增成功!");
					 }else{
						 alert("新增失败!");
					 }					 
				 }
			 });
		 }
		</script>

	</head>
<body>
<!-- <div class="cBody">  -->
		<!-- <form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/AddUnpart.do">   -->	
		     <form id="addForm" class="layui-form" method="post"> 
				<div class="layui-form-item">
					<label class="layui-form-label">用户账号</label>
					<div class="layui-input-block">
						<input type="text" id="uid" name="uid" required lay-verify="required" autocomplete="off" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">活动ID</label>
					<div class="layui-input-block">
						<input type="text" id="actid" name="actid" onchange="checkaid()" required lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">活动状态</label>
					<div class="layui-input-block">
					    <input type="text" id="status" name="status" autocomplete="off" class="layui-input" value="0"/>
						<!-- <input type="radio"  name="status" autocomplete="off" class="layui-input" value="0"/>报名中
						<input type="radio"  name="status" autocomplete="off" class="layui-input" value="2"/>已取消
						<input type="radio"  name="status" autocomplete="off" class="layui-input" value="1"/>已完成  -->
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
					<!-- 	<button class="layui-btn" lay-submit lay-filter="submitBut">立即提交</button>   -->
					    <button class="layui-btn" onclick="submitAdd()">立即提交</button>
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
			</script>
</body>
</html>