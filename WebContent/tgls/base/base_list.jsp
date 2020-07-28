<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>服务记录</title>
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
		<title>穷在闹市出品</title>

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
				
					<div class="layui-form-item">
					  <form class="layui-form" action="${pageContext.request.contextPath}/SelectRecordByUid.do">
						<div class="layui-input-inline">
							<input type="text" name="uid" required lay-verify="required" placeholder="输入用户账号" autocomplete="off" class="layui-input">
						</div>
						<input type="submit" value="检索" class="layui-btn"/>
					</form>	
					
					<form class="layui-form" action="${pageContext.request.contextPath}/AllRecord.do">
				      <input type="submit" value="所有记录" class="layui-btn"/>
				    </form>									 
					</div>
				   				
				

				<script>
					layui.use(['form','laydate'], function() {
						var form = layui.form;
						var laydate = layui.laydate;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
						
						var newDate = new Date();
						nowTime = newDate.getFullYear()+"-"+(newDate.getMonth()+1)+"-"+newDate.getDate();
						laydate.render({
						    elem: '#time' 
					    	,range: '~'
//					    	,type: 'datetime'	//开启时分秒
					    	,format: 'yyyy-MM-dd'
					    	,max: nowTime	//min/max - 最小/大范围内的日期时间值
						});
					});
				</script>
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
					    <th><input type="button" class="cb" value="全选" onclick="checkedAll()"/> <input type="button" class="cb" value="反选" onclick="reverseAll()"/></th>
						<th>ID</th>
						<th>用户账号</th>
						<th>活动ID</th>
						<th>服务时长</th>
						<th>操作<button class="layui-btn layui-btn-xs" id="deleteAll">批量删除</button></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach  items="${allRecord}" var="allRecord" >
					<tr>
					    <td><input type="checkbox"  class="cb"  value="${allRecord.reacordid}" /></td>
						<td>${allRecord.reacordid}</td>
						<td>${allRecord.uid}</td>
						<td>${allRecord.actid}</td>
						<td>${allRecord.duration}</td>
						<td>
						<!-- <a class="layui-btn layui-btn-xs" href="${pageContext.request.contextPath}/FindRecordByReid.do?reacordid=${allRecord.reacordid}">修改</a>  --> 
						    <button class="layui-btn layui-btn-xs" onclick="updateBut(${allRecord.reacordid})">修改</button> 
						<!--   <a class="layui-btn layui-btn-xs" href="${pageContext.request.contextPath}/DeleteRecord.do?reacordid=${allRecord.reacordid}">删除</a> -->
						    <button class="layui-btn layui-btn-xs" onclick="delCustomList(${allRecord.reacordid})">删除</button> 						
						</td>
					</tr>
				 </c:forEach>
				</tbody>
			</table>
			
			<button class="layui-btn layui-btn-xs" onclick="AddBut()">增加</button>
			
			<!-- 传记录总数值 -->
			<input type="text" style="display: none" id="allRecordsize" name="allRecordsize" value="${allRecordsize }">

			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>						
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage;	
					
					var allRecordsize = $("#allRecordsize").val();
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: allRecordsize
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
					
				//修改按钮
				var updateFrame = null;
				function updateBut(reacordid){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "服务记录修改",
							type: 2,
							area: ['50%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
						    content: '${pageContext.request.contextPath}/FindRecordByReid.do?reacordid=' +reacordid
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
						    content: 'tgls/base/AddRecord.jsp' 
						});
					});
					
				} 
				
				
				//删除
				function delCustomList(reacordid){
					layui.use(['form','laydate'], function() {
						layer.confirm('确定要删除么？', {
							btn: ['确定', '取消'] //按钮
						}, function() {
							$.ajax({
								type:"post",
								asnyc:true,
								url:"${pageContext.request.contextPath}/DeleteRecord.do",
								data:{"reacordid":reacordid},
								dataType:"json",
								success:function(data){
									if(data==true){
										alert("删除成功!");										
									}else{
										alert("删除失败!");
									}
									location.href="${pageContext.request.contextPath}/AllRecord.do";
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
					$("#deleteAll").click(function(){
						var ids="";
						$(".cb:checked").each(function(){
							ids +=","+$(this).val();
						});
						ids = ids.substring(1);
						if(ids!=""){
							if(confirm("你确定要删除ID为"+ids+"的信息吗?")){
								$.ajax({
									url:"${pageContext.request.contextPath}/DeleteSelectRecord.do",
									type:"post",
									data:{ids:ids},
									dataType:"json",
									success:function(data){
										if(data == true){
											alert("删除成功!");
											location.href="${pageContext.request.contextPath}/AllRecord.do";
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