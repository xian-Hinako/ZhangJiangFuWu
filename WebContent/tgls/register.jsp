<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>志愿者系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
function userNameCheck(){
	
    /* //取到输入的用户名
    var uname = $("#uname").val();
	$("#nameTips").html("");
	var regm="^[A-z0-9\\u4e00-\\u9fa5]*$";
	
	if(uname.value !=""&&!uname.match(regm))
		{
		var str = "*格式不对";
        $("#nameTips").html(str);
		return false;
		}	 */	
	var uname = $("#uname").val();
   //  var data = {}
   //  data["uname"] = uname;	  		  
	  $.ajax({
		  type:'POST',/* 请求类型为post */
		 url:'${pageContext.request.contextPath}/UserNameAjax.do',
		 contentType: 'application/json;charset=UTF-8',/* 向服务器提出的请求类型 text*/
		 dataType:'json',
	     data:JSON.stringify(data),/* 请求的数据 */
		data:{"uname":uname},
		  success: function(result){/* 回调函数 */
			//把json格式的字符串转换成json对象
      		if(result.flag==1){

      		}
      		else{
      			var str = "*用户名已存在";
      			$("#nameTips").html(str);
		        }
		  }
		  
	  });

}

function userNameCheck2(){	
	var flag = false;
    var uname = document.getElementById('uname').value;
    if(uname == ""){
    	flag = true;
    	document.getElementById("nameTips").innerHTML='请输入账号名';
	    document.getElementById("uname").value="";
	    document.getElementById("uname").focus();
    }else{
    	$.ajax({
    		url:"${pageContext.request.contextPath }/UserNameAjax2.do",
    		type:"post",
    		data:{"uname":uname},
    		dataType:"json",
    		async:false,
    		success: function(data){/* 回调函数 */
    			//把json格式的字符串转换成json对象
          		if(data == false){
          			flag = true;
          			document.getElementById("nameTips").innerHTML='该账户名已存在';
    			    document.getElementById("uname").value="";
    			    document.getElementById("uname").focus();
          		}else{
          			flag = true;
          			$("#nameTips").hide();
          		}
    		  }
    		  
    	  });
    	
    }
    return flag;
}	  		
		
</script>

<link href="https://zu.xitek.com/static/res/www/houh/css/style.css"
	rel="stylesheet" />
<link href="https://zu.xitek.com/static/res/www/houh/css/iconfont.css"
	rel="stylesheet" />
<link href="https://zu.xitek.com/static/res/www/houh/css/animate.css"
	rel="stylesheet" />
<link
	href="https://zu.xitek.com/static/res/www/houh/layui/css/layui.css"
	rel="stylesheet" />
<style type="text/css">
.btn-main {
	background-color: #333;
}

.main-btn {
	cursor: pointer;
	background: #333;
	color: #fff;
	border-radius: 6px;
	padding: 0 30px;
	height: 35px;
	line-height: 35px;
}

.cart_num {
	padding: 0px 7px;
	position: absolute;
	top: 8px;
	display: inline-block;
	height: 20px;
	line-height: 20px;
	text-align: center;
	background: #c00;
	border-radius: 20px;
	vertical-align: bottom;
	font-size: 12px;
}
</style>


<style>

.box {
	width: 440px;
	margin: 0 auto;
	background: white;
}

.box-content {
	padding: 40px 10px;
	border-radius: 5px;
	box-shadow: 0px 0px 11px 5px #d6d6d6;
}

.box-title {
	text-align: center;
	padding-bottom: 10px;
}

.login-title {
	font-size: 20px;
}

body {
	background-color: #f2f2f2;
}
</style>
<script type="text/javascript">
function displayWeiZhi(){
	var weizhi = $("#chuanweizhi").val();
	//alert(weizhi);
	document.getElementById('address').value = weizhi;
}
</script>

</head>

<body>

	<div class="layui-row ">
		<div class="layui-col-md12 " style="margin: 100px 0px 200px 0px;">
			<div class="box">
				<div class='box-content  '>
					<div class="box-title">
						<!-- <img
							src="https://zu.xitek.com/static/res/www/houh/img/logo-index.png"
							style="width: 100px;"> -->
					</div>
         <h2 style="text-align: center;font-size: 20px;">注册页面</h2>
				
					<form action="${pageContext.request.contextPath}/RegisterUser.do" method="post" class="layui-form"
						style="margin-top: 20px;">

						<div class="layui-form-item">
							<label class="layui-form-label">用户名</label>
							<div class="layui-input-inline">
								<input type="text" name="uname" id="uname" onblur="userNameCheck2()" onkeyup="value=value.replace(/[^\w\/]/ig,'')" placeholder="请输入用户名" required
									lay-verify="required|phone"
									autocomplete="off" class="layui-input"><span id="nameTips" style="color: red"></span>
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-inline">
								<input type="password" name="upassword" id="upassword" onchange="checkPassword()" 
								required	lay-verify="required|phone" placeholder="请输入密码"
									autocomplete="off" class="layui-input"><span id="passwordTips" style="color:red"></span>
							</div>
						</div>
						
                         <div class="layui-form-item">
							<label class="layui-form-label">确认密码</label>
							<div class="layui-input-inline">
								<input type="password" name="upassword2" id="upassword2" onblur="checkpassword2()" required
									lay-verify="required|phone" placeholder="请输入密码"
									autocomplete="off" class="layui-input"><span id="passwordTips2" style="color:red"></span>
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">身份</label>
							   <div class="layui-input-inline">
							     <input type="text" name="identity" id="identity" placeholder="2志愿者 or 0管理员" required
									lay-verify="required|phone" autocomplete="off" class="layui-input" onblur="checkidentity()"><span id="identityTips" style="color:red"></span>					
						      </div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">电话</label>
							   <div class="layui-input-inline">
							     <input type="text" name="tel" id="tel" placeholder="请输入电话号码" required
									lay-verify="required|phone" autocomplete="off" class="layui-input" onblur="checkMobile(this)"><span id="telTips" style="color:red"></span>						
						      </div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">地址</label>
							<div class="layui-input-inline">
								<input type="text" name="address" id="address" placeholder="请输入你的地址" required
									lay-verify="required|phone" autocomplete="off" class="layui-input" value=""><button type="button" onclick="displayWeiZhi()">获取位置</button>
							</div>
						</div>

						<div class="layui-form-item">
							<div class="layui-input-block">
								<input type="hidden" name="_config" value='{"reload":1}'>
								<button class="layui-btn btn-main">提交</button>
								&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
								&nbsp;&nbsp; &nbsp;&nbsp; 
							</div>
						</div>
					</form>
					<a
						style="float: right; text-decoration: underline; padding: 0px 5px;"
						href="${picPath}/VolunServices4/Text.do"> <img
						style="width: 18px; margin-right: 4px;"
						src="https://zu.xitek.com/static/res/www/houh/img/back.png">返回
					</a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 传地理位置 -->
	<input type="text" id="chuanweizhi" name="chuanweizhi" style="display: none" value="${getDiliweizhi }">
	
	<script type="text/javascript">	  
	  function checkidentity(){
		  var flag = false;
		  var identity = $("#identity").val();
		//  alert(identity);
		  if(identity == ""){
			  flag = true;
			  document.getElementById("identityTips").innerHTML='请输入身份数字';
		      document.getElementById("identity").value="";
		      document.getElementById("identity").focus();
		  }else{
			  if(identity == 0 || identity == 2){
				  flag = true;
				  $("#identityTips").hide();
				 				  
			  }else{
				  flag = true;
				  document.getElementById("identityTips").innerHTML='请输入正确的身份数字';
			      document.getElementById("identity").value="";
			      document.getElementById("identity").focus();
			  }
		  }
		  return flag;
	  }
	  
	  function checkpassword2(){
	         var flag = false;
	         if($("#upassword").val()!=$("#upassword2").val()){
	         flag = false;
	         document.getElementById("passwordTips2").innerHTML='两次输入的密码不一致';
	         document.getElementById("upassword2").value="";
	         document.getElementById("upassword2").focus();
	       }else{
		     flag = true;
		     $("#passwordTips2").hide();  
	     }
      return  flag;
	        
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
