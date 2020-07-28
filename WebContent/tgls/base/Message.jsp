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
		<title>活动报名表</title>

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
			.layui-table img {
			    max-width: none;
			}	    
		</style>

	</head>
<body>
<div class="cBody">
			<div class="console">
				<form class="layui-form" action="${pageContext.request.contextPath}/FindMessByKey.do">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="key" required lay-verify="required" placeholder="输入关键字" autocomplete="off" class="layui-input">
						</div>
						 <input type="submit" value="检索" class="layui-btn"/>
					</div>
				</form>
				<form class="layui-form" action="${pageContext.request.contextPath}/FindAllMessage.do">
				  <input type="submit" value="所有评论" class="layui-btn"/>
				</form>
				
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
							<th>序号</th>
							<th>用户账号</th>
							<th>评论内容</th>
							<th>发布时间</th>
							<th>操作<button class="layui-btn layui-btn-xs" id="deleteAll">批量删除</button></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach  items="${findAllMessage}" var="findAllMessage" >
					<tr>
					   <td><input type="checkbox"  class="cb"  value="${findAllMessage.mid}" /></td>
						<td>${findAllMessage.mid}</td>
						<td>${findAllMessage.uid}</td>
						<td>${findAllMessage.content}</td>
						<td><fmt:formatDate value="${findAllMessage.time}" pattern="yyyy-MM-dd HH:mm:ss" type="both"/></td>
						<td>
							<a href="javascript:if(confirm('确定要删除该评论么？'))location='${pageContext.request.contextPath}/DeleteMessage.do?mid=${findAllMessage.mid}'" class="layui-btn layui-btn-xs">删除</a>
						</td>
					</tr>
				</c:forEach>					
				</tbody>
			</table>
			
			<!-- 传记录总数值 -->
			<input type="text" style="display: none" id="findAllMessagesize" name="findAllMessagesize" value="${findAllMessagesize }">
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
				layui.use('laypage', function() {
					var laypage = layui.laypage;
				
					var findAllMessagesize = $("#findAllMessagesize").val();
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: findAllMessagesize
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
//					      console.log(obj)
					    }
					});
				});
				//修改按钮
				var updateFrame = null;
				function updateBut(){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "商品信息修改",
							type: 2,
							area: ['70%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
							content: 'goods_update.html'
						});
					});
					
				}
				
				//删除
				function delCustomList(_this){
					layui.use(['form','laydate'], function() {
						layer.confirm('确定要删除么？', {
							btn: ['确定', '取消'] //按钮
						}, function() {
							$(_this).parent().parent().remove();
							layer.msg('删除成功', {
								icon: 1
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
					$("#deleteAll").click(function(){
						var ids="";
						$(".cb:checked").each(function(){
							ids +=","+$(this).val();
						});
						ids = ids.substring(1);
						if(ids!=""){
							if(confirm("你确定要删除ID为"+ids+"的信息吗?")){
								$.ajax({
									url:"${pageContext.request.contextPath}/DeleteSelectMessage.do",
									type:"post",
									data:{ids:ids},
									dataType:"json",
									success:function(data){
										if(data == true){
											alert("删除成功!");
											location.href="${pageContext.request.contextPath}/FindAllMessage.do";
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