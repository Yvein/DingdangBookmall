<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>叮当书城 登录</title>
	<%--静态包含 base--%>
	<%@include file="/pages/common/base.jsp"%>
	<link rel="stylesheet" type="text/css" href="static/css/styles.css">
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function (){

			//给注册绑定单击事件
			$("#Submit").click(function (){
				var legal = true;
				//验证用户名，由字母、数字、下划线组成，长度为3-12位
				//获取用户名输入框里的内容
				var usernameText = $("#username").val();
				//去掉前后空格
				usernameText = $.trim(usernameText);
				if(usernameText == "" || usernameText == null){
					//提示结果
					$("span.usernameError").text("请输入用户名！");
					legal = false;
					$("span.loginError").text("");
					//return false;
				}
				else $("span.usernameError").text("");

				//验证密码，由字母、数字、下划线组成，长度为6-12位
				//获取密码输入框里的内容
				var pswText = $("#password").val();
				//去掉前后空格
				pswText = $.trim(pswText);
				if(pswText == "" || pswText == null){
					//提示结果
					$("span.pswError").text("请输入密码！");
					legal = false;
					$("span.loginError").text("");
					//return false;
				}
				else $("span.pswError").text("");

				return legal;
			})
		})
	</script>
</head>
<body id="login">
	<!--顶部导航-->
	<div class="nav">
		<ul>
			<li><a href="#">叮当书城</a></li>
			<li><a href="pages/manager/manager.jsp">后台管理</a></li>
			<li><a href="pages/user/login.jsp">购物车</a></li>
			<li><a href="pages/user/register.jsp">立即注册</a></li>
		</ul>
	</div>
	<div id="content">
		<div id="l_content">
			<h1 class="h_content">总有一本好书<br>适合你</h1>
			<p class="p_content">
				【叮当】网上购物商城，千万商品，品质保证，
				涵盖图书、童书、电子书、听书、服装、百货等品类，全场2.9折起！
				提供货到付款和多种线上支付方式，上门退货、当面退款，100%正品保障，专业配送及售后服务！
				为顾客提供网上购物的高品质体验！
			</p>
		</div>
		<div id="r_content">
			<div class="login">
				<div class="hd">
					<h2 id="login-hd">账户登录</h2>
					<hr />
				</div>
				<br>
				<div class="login-form">
					<form action="UserServlet" id="login-form" method="post">
						<input type="hidden" name="action" value="login">
						<div class="txt">
							<span class="usernameError"></span>
							<label class="userName">
								<input
										class="input-block"
										id="username"
										name="username"
										type="text"
										placeholder="点此输入用户名"
										autocomplete="off"
										tabindex="1"
										value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"
								/>
							</label>
							<br><br>
							<span class="pswError"></span>
							<label class="passWord">
								<input
										class="input-block"
										id="password"
										name="password"
										type="password"
										placeholder="输入您的密码"
										autocomplete="off"
										tabindex="1"
								/>
							</label>
							<div class="loginError">
								<span name="loginError" class="loginError">
									<%=request.getAttribute("loginError")==null?"":request.getAttribute("loginError")%>
								</span>
							</div>
						</div>

						<div class="btn-wr text-primary">
							<input class="btn btn-primary btn-md" id="Submit" type="submit" value="立即登录">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%--静态包含 页脚--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>