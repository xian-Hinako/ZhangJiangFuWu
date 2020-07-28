<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息修改</title>
<link rel="stylesheet" type="text/css" href="css/Vmodify.css">
</head>
<body>
<div class="cen">
		<label class="xuhao">序号</label>
		<div class="h1">
			<input type="text" value="${persondetaild.uiid}">
		</div>
		<label class="xuhao">名字</label>
		<div class="h1">
			<input type="text" value="${persondetaild.uiname}">
		</div>

	<div class="h2">
      <legend>请选择您的性别：</legend>
        <label for="male">男性</label>
        <input type="radio" name="sex" id="sex" value="sex">
        <label for="female">女性</label>
        <input type="radio" name="sex" id="sex" value="female"> 
  </div>
  <label>生日</label>
		<div class="h1">
			<input type="text" value="<fmt:formatDate value="${persondetaild.birthday}" pattern="yyyy-MM-dd" />">
		</div>

		<label>常在地</label>
		<div class="h1">
			<input type="text" value="${persondetaild.aladdress}">
		</div>

		<label>联系方式</label>
		<div class="h1">
			<input type="text" value="${persondetaild.tel}">
		</div>

		<label>头像</label>
					<div class="h1">
						<input type="text" id="picture" value="${persondetaild.picture}">
					</div>

        <div class="h3">
        	<button>提交</button>
        </div>

</body>
</html>