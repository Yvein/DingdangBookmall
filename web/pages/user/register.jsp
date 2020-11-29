<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
	<title>叮当书城 注册</title>
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
				//创建正则表达式对象
				var usernamePatt = /^\w{3,12}$/;
				//使用test方法验证
				if(!usernamePatt.test(usernameText)){
					//提示结果
					$("span.usernameError").text("请输入合法的用户名！");
					legal = false;
					$("span.registError").text("");
					//return false;
				}
				else $("span.usernameError").text("");

				//验证密码，由字母、数字、下划线组成，长度为6-12位
				//获取密码输入框里的内容
				var pswText = $("#password").val();
				//创建正则表达式对象
				var pswPatt = /^\w{6,12}$/;
				//使用test方法验证
				if(!pswPatt.test(pswText)){
					//提示结果
					$("span.pswError").text("请输入合法的密码！");
					legal = false;
					$("span.registError").text("");
					//return false;
				}
				else $("span.pswError").text("");

				//确认密码：和密码相同
				//获取确认密码输入框里的内容
				var repwdText = $("#repwd").val();
				//判断两次密码是否相同
				if(repwdText != pswText){
					//提示结果
					$("span.repswError").text("两次输入密码不一致！");
					legal = false;
					$("span.registError").text("");
					//return false;
				}
				else $("span.repswError").text("");

				//邮箱验证：xxxxx@xxx.com
				//获取邮箱输入框里的内容
				var emailText = $("#email").val();
				//创建正则表达式对象
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				//使用test方法验证
				if(!emailPatt.test(emailText)){
					//提示结果
					$("span.emailError").text("请输入正确的邮箱！");
					legal = false;
					$("span.registError").text("");
					//return false;
				}
				else $("span.emailError").text("");

				$("span.errorMsg").text("");
				return legal;
			})
		})
	</script>

</head>
<body id="register">
	<!--顶部导航-->
	<div class="nav">
		<ul>
			<li><a href="#">叮当书城</a></li>
			<li><a href="pages/manager/manager.jsp">后台管理</a></li>
			<li><a href="pages/user/login.jsp">购物车</a></li>
			<li><a href="pages/user/login.jsp">立即登录</a></li>
		</ul>
	</div>
	<div class="register">
		<div class="hd2">
			<h1 id="regis">注册</h1>
			<hr />
		</div>

		<div class="register-form">
			<form action="UserServlet" id="register-form" method="post">
				<input type="hidden" name="action" value="regist">
				<div class="txt">
					<p class="register-form">用户名称:
						<span class="usernameError"></span>
					</p>
					<label>
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
					<p class="register-form">用户密码:
						<span class="pswError"></span>
					</p>
					<label>
						<input
								class="input-block"
								id="password"
								name="password"
								type="password"
								placeholder="点此输入密码"
								autocomplete="off"
								tabindex="1"
								<%--value="<%=request.getAttribute("password")==null?"":request.getAttribute("password")%>"--%>
						/>
					</label>
					<br><br>
					<p class="register-form">确认密码:
						<span class="repswError"></span>
					</p>
					<label>
						<input
								class="input-block"
								id="repwd"
								name="repwd"
								type="password"
								placeholder="点此确认密码"
								autocomplete="off"
								tabindex="1"
						/>
					</label>
					<br><br>
					<p class="register-form">电子邮件:
						<span class="emailError"></span>
					</p>
					<label>
						<input
								class="input-block"
								id="email"
								name="email"
								type="text"
								placeholder="点此输入您的邮箱"
								autocomplete="off"
								tabindex="1"
								value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"
						/>
					</label>
					<div class="loginError">
						<span name="registError" class="registError">
							<%=request.getAttribute("registError")==null?"":request.getAttribute("registError")%>
						</span>
					</div>
				</div>
				<br>
				<div class="btn-wr text-primary">
					<input class="btn btn-primary btn-md" id="Submit" type="submit" value="点击注册">
				</div>
			</form>
		</div>
	</div>

	<%--静态包含 页脚--%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>