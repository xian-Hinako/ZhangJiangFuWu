<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Vindex.css">
	
	<script src="js/jquery-3.0.0"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery-3.0.0">
</head>
<body>
<div class="top">
		<div class="right">
			<span><a href="${pageContext.request.contextPath}/Userlogin.do">登录</a></span>
			<span> | </span>
			<span><a href="${pageContext.request.contextPath}/ToRegisterAndGetAddress.do">注册</a></span>
		</div>
		<div class="cen">
		<li>首页</li>
		<li class="fir"><a href="${pageContext.request.contextPath}/listActivity.do">志愿活动</a></li>
		<li><a href="#">新闻动态</a></li>
		<li><a href="#">团队风采</a></li>
		<li><a href="${pageContext.request.contextPath}/AllMessage.do">志愿心声</a></li>
	</div>   
	</div>
	<div class="photo">
		<img src="${pageContext.request.contextPath}/images/1.jpg">
	</div>

	<div class="munu1">
		<div class="left">活动风采</div>
	</div>

	<div class="act">
		<div class="action">
			<ol id="nav">
				<li class="current" ></li>
				<li></li>
				<li></li>
				<li></li>
			</ol>

			<span class="iconfont icon-left" id="right"></span>
			<span class="iconfont icon-right" id="left"></span>

			<ul id="box">
				<li><img src="${pageContext.request.contextPath}/images/act1.jpg"></li>
				<li><img src="${pageContext.request.contextPath}/images/new2.jpg"></li>
				<li><img src="${pageContext.request.contextPath}/images/new3.jpg"></li>
				<li><img src="${pageContext.request.contextPath}/images/new4.jpg"></li>	
			</ul>
		</div>
		<script>
		</script>
	</div>
	<div class="tea">
		<div class="left">团队风采</div>
	</div>
	<div class="team">
		<ul><li><img src="${pageContext.request.contextPath}/images/team1.jpg"><span>抗疫一线，心港社工是这样一只队伍</span></li>
		    <li><img src="${pageContext.request.contextPath}/images/team2.jpg"><span>2020年湛江市“情暖留守儿童，筑梦蓝色湛江”</span></li>
	        <li><img src="${pageContext.request.contextPath}/images/team4.jpg"><span>2020年湛江市“情暖留守儿童，筑梦蓝色湛江”</span></li>
            <li><img src="${pageContext.request.contextPath}/images/team5.jpg"><span>病毒无爱人有爱，情暖湛江在行动</span></li>
            <li><img src="${pageContext.request.contextPath}/images/team6.jpg"><span>携手慰问克疫情，情暖湛江在行动</span></li>
            <li><img src="${pageContext.request.contextPath}/images/team7.jpg"><span>水到·心到，1000箱纯悦水派送全市抗疫一线慰问行动</span></li>
	        <li><img src="${pageContext.request.contextPath}/images/team8.jpg"><span>天德志愿者“共战役，我助力”</span></li>
            <li><img src="${pageContext.request.contextPath}/images/team9.jpg"><span>众志成城————湛江志愿者协助企业复产复工</span></li>
            <li><img src="${pageContext.request.contextPath}/images/team10.jpg"><span>携手慰问克疫情，情暖湛江在行动</span></li>
            <li><a href="Volunteer/team.html"><img src="images/more.png"></a></li>
        </ul>
	</div>

	<div class="cenphoto"><img src="${pageContext.request.contextPath}/images/湛江志愿.gif"></div>
	<div class="vol"><div class="volu">志愿风采</div></div>

	<div class="voluteer">
		<ul><li><img src="${pageContext.request.contextPath}/images/vol1.jpg"><span>雷州爱心协会合力捐赠100吨瓜菜驰援武汉</span></li>
		    <li><img src="${pageContext.request.contextPath}/images/vol2.jpg"><span>湛江志愿者协会协助机场到湛旅客进行“湛康码”防疫登记</span></li>
	        <li><img src="${pageContext.request.contextPath}/images/vol3.jpg"><span>霞山区举行文化志愿服务队授旗仪式</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol4.jpg"><span>徐闻再捐爱心蔬菜驰援荆州</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol5.jpg"><span>市民无偿献血助力抗疫</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol6.jpg"><span>我市小学开展“情景式”疫情防控应急演练</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol7.jpg"><span>麻章开展疫情应急处置演练</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol8.jpg"><span>两台机组首次实现满负荷运行</span></li>
            <li><img src="${pageContext.request.contextPath}/images/vol9.jpg"><span>廉江市青平圣女果果丰价高</span></li>
            <li><img src="${pageContext.request.contextPath}/images/more.png"></li>
        </ul>
	</div>
	<div class="footer">
		<p><span>主办：湛江志愿者平台</span><span>承办：湛江志愿者平台</span><span>运行管理：岭南师范学院17外包2有限公司</span></p>
		<p><span>粤ICP备12783789-1号</span><span>地址：岭南师范学院17外包2</span>
			<span>邮政编码：000000</span>
			<span></span>
		</p>
	</div>

	<script src="${pageContext.request.contextPath}/js/Vindex.js"></script>
</body>
</html>