<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户登录页面</title>
<script type="text/javascript">
$(document.body).ready(function () {
        //首次获取验证码
        $("#imgVerify").attr("src","/user/getVerify?"+Math.random());
    });
    //获取验证码
    function getVerify(){
        var src1=document.getElementById('imgVerify')
        src1.src = "/user/getVerify?"+Math.random();
    }
    //校验验证码
    function checkSum(){
        var html1=document.getElementById('loginingForm');
        var inputStr = $("#checks").val();
        if(inputStr!=null && inputStr!="" && inputStr!="验证码:"){
            inputStr = inputStr.toUpperCase();//将输入的字母全部转换成大写
            html1.action="/user/login?inputStr="+inputStr;//提交表单
        }else{
            alert("验证码不能为空!")
        }
    }
    //登录验证
    function doLogin() {
        var userName=document.getElementById('uName').value;
        var password=document.getElementById('upassword').value;
        if(null==userName||null==password||""==userName||""==password){
            alert('用户名或密码不能为空!');
        }else {
            //校验验证码
            checkSum();
        }
    }
   </script>
</head>
<body>
<div>
    <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">用户名</i></label>
        <div class="formControls col-xs-8">
            <input id="userName" name="uName" type="text" class="input-text size-L" />
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">密码</i></label>
        <div class="formControls col-xs-8">
            <input id="password" name="upassword" type="password" class="input-text size-L" />
        </div>
     </div>
     <div class="row cl">
         <div class="formControls col-xs-8 col-xs-offset-3">
              <input id="checks" class="input-text size-L" type="text" value="验证码:" style="width:150px;" />
              <img id="imgVerify" src="" alt="点击更换验证码" /><a href="" rel="nofollow">看不清，换一张</a>
          </div>
     </div>
     <div class="row cl">
          <div class="formControls col-xs-8 col-xs-offset-3">
              <label><input type="checkbox" name="online" id="online" value="" />使我保持登录状态</label>
           </div>
     </div>
     <div class="row cl">
           <div class="formControls col-xs-8 col-xs-offset-3">
               <input name="" type="submit" class="btn btn-success radius size-L" value=" 登    录 " />
               <input name="" type="reset" class="btn btn-default radius size-L" value=" 取    消 " />
           </div>
      </div>
</div>             

</body>
<%-- <body style="background-image:url(images/admin_login_bg1.png); margin:0 auto; width:500px;">
<div style="background-image:url(images/admin_login1.png); width:500px; height:200px; margin-top:130px;">
   <c:if test="${!empty msg}">
      <span>${msg }</span>
   </c:if>

    <table width="500" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="250">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="40"><div align="right" class="STYLE1">用户名：</div></td>
        <td height="40" colspan="2"><input type="text" name="uname" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
      <tr>
        <td height="40"><div align="right">密&nbsp;&nbsp; 码：</div></td>
        <td height="40" colspan="2"><input type="password" name="upassword" style="height:25px; width:200px; font-size:15pt; font-weight:bold;" /></td>
      </tr>
  <!--     <tr>
        <td height="40"><div align="right" class="STYLE1">&nbsp;<input type="radio" value="2" name="identity" checked="checked">志愿者</div></td>
        <td width="100" height="40">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="identity">管理员</td>
      </tr> -->
     <tr>
        <td height="40"><div align="right"><a id="login">登录</a></div></td>
        </tr>
     </table>

  </div>
</body> --%>
</html>