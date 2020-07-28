<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
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
		<title>所有活动</title>

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
		
		<!-- 弹窗 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/syalert/syalert.min.css" />

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/syalert/syalert.min.js"></script>

        <style type="text/css">
         *{ margin:0px; padding:0px; box-sizing:border-box; }
         *:focus{ outline:none;}
         .tsm{ background:#333; font-size:13px; color:#fff; margin:20px; margin-top:0px; padding:12px; line-height:25px;}
         .tsm .p2{ margin-top:12px;}
         .btns{ padding:20px;}
         .btns div{ display:block; text-align:center; cursor:pointer; padding:10px; border-radius:5px; background:#0CC; color:#fff; margin-bottom:12px; width:100%;}
        </style>
        <!-- 弹窗end -->

		<style>
			.layui-table img {
			    max-width: none;
			}	    
		</style>

	</head>
<body>
<div class="cBody">
			<div class="console">
				
					<div class="layui-form-item">
					<form class="layui-form" action="${pageContext.request.contextPath}/FindActivityByActName.do">
						<div class="layui-input-inline">
						    <input type="text" name="actname" required lay-verify="required" placeholder="输入活动名称" autocomplete="off" class="layui-input">
						</div>
						 <input type="submit" class="layui-btn" value="检索"/>
				   </form>
						 
					<form class="layui-form" action="${pageContext.request.contextPath}/AllActivity.do">
				       <input type="submit" value="所有记录" class="layui-btn"/>
				    </form>						 
				</div>

				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>

        <!-- 新增的弹窗end -->
						
			<table class="layui-table">
				<thead>
					<tr>
					        <th><input type="button" class="cb" value="全选" onclick="checkedAll()"/> <input type="button" class="cb" value="反选" onclick="reverseAll()"/></th>
							<th>活动ID</th>
							<th>活动名称</th>
						<!-- 	<th>活动介绍</th>   -->
							<th>活动地址</th>
							<th>活动日期</th>
							<th>活动时长</th>
							<th>活动人数</th>
							<th>活动状态</th>
							<th>备注</th>
							<th>操作<button class="layui-btn layui-btn-xs" id="deleteAllUn">批量删除</button></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach  items="${allActivity}" var="allActivity" >
					<tr>
					   <td><input type="checkbox"  class="cb"  value="${allActivity.aid}" /></td>
						<td>${allActivity.aid}</td>
						<td>${allActivity.aname}</td>
				<!-- 	<td>${allActivity.introduce}</td>   -->	
						<td>${allActivity.actaddress}</td>
						<td><fmt:formatDate value="${allActivity.day}" pattern="yyyy-MM-dd HH:mm:ss" type="both"/></td>
						<td>${allActivity.duration}</td>
						<td>${allActivity.number}</td>
						<td><c:choose>
						    <c:when test = "${allActivity.status == 0}">报名中</c:when>
						    <c:when test = "${allActivity.status == 1}">已完成</c:when>
						    <c:when test = "${allActivity.status == 2}">已取消</c:when>
						</c:choose></td>
						<td>${allActivity.remark}</td>
						<td>
							<button class="layui-btn layui-btn-xs" onclick="updateBut(${allActivity.aid})">修改</button>
						  	<a href="javascript:if(confirm('删除该信息也会删除相关报名名单,确定要删么？'))location='${pageContext.request.contextPath}/DeleteActivity.do?aid=${allActivity.aid}'" class="layui-btn layui-btn-xs">删除</a> 
						<!-- <a class="layui-btn layui-btn-xs" onclick="delCustomList(${allActivity.aid})">删除</a>   -->
						</td>
					</tr>
				</c:forEach>					
				</tbody>
			</table>
			
			<button class="layui-btn layui-btn-xs" onclick="AddBut()">发布新活动</button>
			
			<!-- 传记录总数值 -->
			<input type="text" style="display: none" id="allActivitysize" name="allActivitysize" value="${allActivitysize }">
			
			<!-- layUI 分页模块 -->
		  <div id="pages"></div>  			 
    </div> 
			
			<script>
				layui.use('laypage', function() {
					var laypage = layui.laypage;
					
					var allActivitysize = $("#allActivitysize").val();
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: allActivitysize
					    ,limit:10
					    ,curr:1
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
	//				      console.log(obj)
					    }
					});
				});
								
				
				//修改按钮
				var updateFrame = null;
				function updateBut(aid){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "活动信息修改",
							type: 2,
							area: ['50%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
						    content: '${pageContext.request.contextPath}/FindActByAid.do?aid=' +aid
						});
					});
					
				}  
				
				//增加按钮
				var AddFrame = null;
				function AddBut(){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "活动报名信息",
							type: 2,
							area: ['50%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
						    content: 'tgls/base/AddActivity.jsp' 
						});
					});
					
				} 
				
				//删除
				function delCustomList(aid){
					layui.use(['form','laydate'], function() {
						layer.confirm('删除该信息也会删除相关报名名单,确定要删么？', {
							btn: ['确定', '取消'] //按钮
						}, function() {
							//$(_this).parent().parent().remove();
							$.ajax({
								url:"${pageContext.request.contextPath}/DeleteActivity.do",
								type:"post",
								data:{"aid":aid},
								dataType:"json",
								success:function(obj){
									if(obj){
										location.href="${pageContext.request.contextPath}/AllActivity.do";
										layer.msg('删除成功', {
											icon: 1
										});
									}else{
										alert("删除失败!");
									}
								}
							});
						}, function() {
							layer.msg('取消删除', {
								time: 2000 //20s后自动关闭
							});
						});
					});
				}  
				
				//批量删除的全选
				function checkedAll(){
					var cbArr = $(".cb");
					for (var x = 0; x < cbArr.length;x++)
						cbArr[x].checked = true;
				}
				
				//批量删除的反选
				function reverseAll(){
					var cbArr = $(".cb");
					for (var x = 0;x <cbArr.length; x++)
						cbArr[x].checked = !cbArr[x].checked;
				}
				
				//批量删除
				$(function(){
					$("#deleteAllUn").click(function(){
						var ids="";
						$(".cb:checked").each(function(){
							ids +=","+$(this).val();
						});
						ids = ids.substring(1);
						if(ids!=""){
							if(confirm("你确定要删除ID为"+ids+"的信息吗?")){
								$.ajax({
									url:"${pageContext.request.contextPath}/DeleteSelectActivity.do",
									type:"post",
									data:{ids:ids},
									dataType:"json",
									success:function(data){
										if(data == true){
											alert("删除成功!");
											location.href="${pageContext.request.contextPath}/AllActivity.do";
										}else{
											alert("删除失败!");
										}
									}
								});
							}
						}else{
							alert("请选择要删除的用户!");
						}
					});
				})
				
			</script>
		</div>
</body>
</html>