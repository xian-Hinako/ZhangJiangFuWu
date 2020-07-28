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
		
		<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
		
		<title>修改报名信息</title>

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
		    .sum{
		    display:flex;
		    }
		    .firstbox{
		     width:50%;
		    }
		    .secondbox{
		    width:50%;
		    }
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
<!-- <div class="cBody">  -->
			<form id="addForm" class="layui-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/UpdateUserInfo2.do?uiid=${persondetaild.uiid}"> 
			  <div class="sum">
			   <div class="firstbox">
			    <div class="layui-form-item">
					<label class="layui-form-label">头像</label>
				 	<img class="user-header" src="${pageContext.request.contextPath }/${persondetaild.picture}" width="80" height="80">	 	 								
					<input type="file" id="photo" name="photo" value="${persondetaild.picture}" onchange="imgChange(event)" style="display: none"> 
				<!-- 	<div class="layui-input-block">   -->
						<!-- <input type="text" id="picture" name="picture"  autocomplete="off" class="layui-input" value="${persondetaild.picture}">  -->						
					<!-- 	<input type="file" id="photo" name="photo"  autocomplete="off" class="layui-input" value="${persondetaild.picture}">   -->
				<!-- </div>   -->	
				</div>	
				<div class="layui-form-item">
					<label class="layui-form-label">序号</label>
					<div class="layui-input-block">
						<input type="text" id="uiid" name="uiid" required lay-verify="required" autocomplete="off" class="layui-input" value="${persondetaild.uiid}" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" id="uiname" name="uiname" autocomplete="off" class="layui-input" value="${persondetaild.uiname}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="radio" id="sex" name="sex" autocomplete="off" class="layui-input" value="2"  ${("2" eq persondetaild.sex)?"checked":"" }/>女
						<input type="radio" id="sex" name="sex" autocomplete="off" class="layui-input" value="1"  ${("1" eq persondetaild.sex)?"checked":"" }/>男
					</div>
				</div>
			</div>
			
			<div class="secondbox">
				<div class="layui-form-item">
					<label class="layui-form-label">生日</label>
					<div class="layui-input-block">
						<input type="text" id="birthday" name="birthday" autocomplete="off" class="layui-input" onchange="checkDate(this)" value="<fmt:formatDate value="${persondetaild.birthday}" pattern="yyyy-MM-dd" />"/>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">常在地</label>
					<div class="layui-input-block">
						<input type="text" id="aladdress" name="aladdress" autocomplete="off" class="layui-input" value="${persondetaild.aladdress}"">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-block">
						<input type="text" id="tel" name="tel" required lay-verify="required|number" autocomplete="off" class="layui-input" value="${persondetaild.tel}">
					</div>
				</div>
							
				<div class="layui-form-item">
					<div class="layui-input-block"> 
					 	<input type="submit" class="layui-btn" lay-submit lay-filter="submitBut" value="立即提交">
					<!--    <a class="layui-btn" onclick="submitUpdate()">立即提交</a>     -->
					    <c:if test="${indentity ==2||indentity ==0}">
					      <div>
					         <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath }/ToUpdatePassword.do">修改密码</a>
					       	 <a class="layui-btn layui-btn-primary" href="${pageContext.request.contextPath }/TooridinaryHome.do">返回</a>
					       </div>
					    </c:if>				
					</div>
				</div>
			 </div>
		   </div>	
			</form> 
			
			<!-- 获取后台的身份并隐藏传到js -->
			<input type="text" style="display: none" id="indentity" name="indentity" value="${indentity}"/>
			
			<!-- 图片路径 -->
			<input type="text" style="display: none" id="photourl" name="photourl" value="${persondetaild.picture}"/>
			
			<script type="text/javascript">

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
				
				//图片回显
				function imgChange(e) {
        console.info(e.target.files[0]);//图片文件
        console.log(e.target.value);//这个也是文件的路径和上面的dom.value是一样的
        var reader = new FileReader();
        reader.onload = (function (file) {
            return function (e) {
                $('.user-header').attr('src',this.result);
            };
        })(e.target.files[0]);
        reader.readAsDataURL(e.target.files[0]);
    }
    
    $('.user-header').click(function () {
        $("#photo").click();
    });
				
				//修改
				function update(uiid){
					function Userinfo(){						
						this.uiid = document.getElementById("uiid").value;
						this.uiname = document.getElementById("uiname").value;
						this.sex = document.getElementById("sex").value;
						this.birthday = document.getElementById("birthday").value;
						this.aladdress = document.getElementById("aladdress").value;
						this.tel = document.getElementById("tel").value;
					//	this.picture = document.getElementById('picture').files[0];
					    this.picture = $('#picture')[0].files;
						this.createDate="";
					}
					var indentity = document.getElementById("indentity").value;
					var userinfo = new Userinfo();
				 //  alert(JSON.stringify(userinfo));
					$.ajax({
						url:"${pageContext.request.contextPath }/UpdateUserInfo2.do",
	        			type:"post",
	        		//	data:{"uiid":uiid,"uiname":uiname,"sex":sex,"birthday":birthday,"aladdress":aladdress,"tel":tel,"picture":picture},
	        			data:JSON.stringify(userinfo),
	        			dataType:"json",
	        			async:true,
	        			cache:false,
	        			crossDomain : true,
	        			processData: false,
	        			contentType: "application/json;charset=utf-8",
	        		//	contentType:false,
	        			success:function(data){
	        				/* alert(data); */
	        				if(indentity ==2 || indentity == 0){
	        				//	parent.location.href="${pageContext.request.contextPath}/TooridinaryHome.do";
	        					parent.location.href="${pageContext.request.contextPath}/ToUpdatePerson.do";
	        				}else{
	        					parent.location.href="${pageContext.request.contextPath}/Toframe.do";
	        				}	        				
	        				if(data==true){ 	        					
	        					alert("修改成功!");
	        					
	        				}else{
	        					alert("修改失败!");
	        				}	        				
	        			}
					});
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
			</script>
</body>
</html>