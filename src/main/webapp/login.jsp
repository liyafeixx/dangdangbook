<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.oracelwpd.ddbookmarket.model.Admin" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link href="bower_components/bootswatch/dist/simplex/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container-fluid" style="width: 70%">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%
							Map<String,String> errors= (Map<String, String>) request.getAttribute("errors");
						%>
						<%
							if (request.getAttribute("sam")!=null){
							    %>
						<h2><%=request.getAttribute("sam")%></h2>
						<%
							}
						%>

						<form method="post" autocomplete="off" action="login" id="loginError">

							<%
								Admin admin = (Admin) request.getAttribute("admin");
								if (admin != null) {
							%>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<%
									   if (errors!=null&&errors.get("name")!=""){
									       %>
									<input type="text" class="form-control is-invalid" id="inputName" placeholder="用户名" name="name"
										   value="<%=admin.getName()%>">
									<div class="invalid-feedback">
										<%=errors.get("name")%>
									</div>
									<%
									   }else{
									       %>
									<input type="text" class="form-control" id="inputName" placeholder="用户名" name="name"
										   value="<%=admin.getName()%>">
									<%
									   }
									%>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<%
										if (errors!=null&&errors.get("pwd")!=""){
									%>
									<input type="password" class="form-control is-invalid" id="inputPwd" placeholder="密码" name="pwd">
									<div class="invalid-feedback">
										<%=errors.get("pwd")%>
									</div>
									<%
									}else{
									%>
									<input type="password" class="form-control" id="inputPwd" placeholder="密码" name="pwd">
									<%
										}
									%>
								</div>
							</div>
                                <%--验证码--%>
							<div class="form-group row">
								<label for="inputVcode" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-5">
									<%
									if (errors!=null&&errors.get("vcode")!=null){
									    %>
									<input type="text" class="form-control is-invalid" id="inputVcode" placeholder="验证码" name="vcode">
									<div class="invalid-feedback">
										<%=errors.get("vcode")%>
									</div>
									<%
									}else{
									    %>
									<input type="text" class="form-control" id="inputVcode" placeholder="验证码" name="vcode">
									<%
									}
									%>

								</div>
								<div class="col-5">
									<img src="/vcode.png" id="vcodeImg" title="看不清点击换一张">
								</div>

							</div>

							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登录</button>
								</div>
							</div>
							<%
								} else {
							%>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">用户名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName" placeholder="用户名" name="name">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="inputPwd" placeholder="密码" name="pwd">
								</div>
							</div>
							<%--验证码--%>
							<div class="form-group row">
								<label for="inputVcode" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="inputVcode" placeholder="验证码" name="vcode">
								</div>
								<div class="col-5">
									<img src="/vcode.png" id="vcodeImg" title="看不清点击换一张">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登录</button>
								</div>
							</div>
							<%
								}
							%>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.slim.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function () {
		$("#vcodeImg").click(function () {
			//点击换图片
			$(this).attr("src","vcode.png?a="+Math.random());
        })
    })
</script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
	<script type="text/javascript">
        $(function () {
            $("#loginError").validate({
                rules:{//限制类型

                    name:{
                        required:true,
                        maxlength:20,
						minlength:2
                    },
                    pwd:{
                        required:true,
                        maxlength:20,
                        minlength:2
                    },
					vcode:{
                        required:true,
						maxlength:4,
						minlength:4
					}
                },
                messages:{//提示输入错误的信息

                },
                errorElement:"div",
                errorClass:"invalid-feedback",
                validClass:"is-valid",
                highlight: function(element, errorClass, validClass) {//高亮显示，填写错误，需要醒目提示
                    $(element).addClass("is-invalid").removeClass(validClass);
                    /* $(element.form).find("label[for=" + element.id + "]")
                         .addClass(errorClass);*/
                },
                unhighlight: function(element, errorClass, validClass) {//取消高亮显示，填写正确取消
                    $(element).removeClass("is-invalid").addClass(validClass);
                    /*$(element.form).find("label[for=" + element.id + "]")
                        .removeClass(errorClass);*/
                },

            });
        });
	</script>
</body>
</html>