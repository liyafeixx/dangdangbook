<%--
if(session.getAttribute("hasLogined")==null||!(boolean)session.getAttribute("hasLogined")==true){
response.sendRedirect("login.jsp");
return;
}
--%>
<%@page import="com.oracelwpd.ddbookmarket.model.BookType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<link rel="stylesheet" type="text/css" href="bower_components/fontawesome/web-fonts-with-css/css/fontawesome-all.css"/>
<link rel="stylesheet" type="text/css" id="zt" />
<script type="text/javascript" src="bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="bower_components/jquery.cookie/jquery.cookie.js"></script>
<script type="text/javascript">
	if ($.cookie('boos')) {
		$("#zt").attr("href","bower_components/bootswatch/dist/" + $.cookie('boos')+ "/bootstrap.css");
		
	} else {
		$('#zt').attr("href","bower_components/bootswatch/dist/sketchy/bootstrap.css");
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">

					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="#"> Link <span class="sr-only">(current)</span></a></li>
							<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a
										class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="text" />
							<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
						</form>
						<ul class="navbar-nav ml-md-auto">
							<li class="nav-item active"><a class="nav-link" href="javascript:void(0)"> <!-- 去井 --> <select
									id="themeSel" class="custom-select">
										<option>sketchy</option>
										<option>darkly</option>
										<option>lux</option>
										<option>solar</option>
										<option>yeti</option>
								</select>
							</a></li>
							<li class="nav-item dropdown">
								<a class="nav-link fa fa-window-close fa-2x" href="exit.jsp" id="navbarDropdownMenuLink" title="退出"></a>
								</li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card border-dark">
						<div class="card-header">
							<form class="form-inline" action="bookList" method="post" id="formid">
								<label class="sr-only" for="inputName">书名</label> 
								<input type="text" class="form-control mb-2 mr-sm-2" id="inputName" name="name" placeholder="书名" value="<%=request.getParameter("name")==null?"":request.getParameter("name")%>"> 
									<label class="sr-only" for="inlineFormInputGroupUsername2">大类</label>
								<div class="input-group mb-2 mr-sm-2">
									<select class="form-control" id="inputBid" name="bid">
									<option value="-1">--请选择--</option>
									</select>
								</div>
                                 <label class="sr-only" for="inlineFormInputGroupUsername2">小类</label>
								<div class="input-group mb-2 mr-sm-2">
									<select class="form-control" id="inputSid" name="sid">
									<option value="-1">--请选择--</option>
									</select>
								</div>
								<button type="submit" class="btn btn-primary mb-2">搜索</button>
							</form>
						</div>
						<div class="card-body" style="padding: 0px">
							<table class="table table-hover table-bordered" style="margin-bottom: 0px ">
								<thead>
									<tr>
										<th>#</th>
										<th>书名</th>
										<th>价格</th>
										<th>作者</th>
										<th>出版社</th>
										<th>出版日期</th>
										<th>简介</th>
										<th>类别</th>
										<th>封面</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<BookType> ls = (List<BookType>) request.getAttribute("ls");
									if(ls!=null){
										for (BookType bookType : ls) {
									%>
									<tr>
										<td><%=bookType.getId()%></td>
										<td><%=bookType.getName()%></td>
										<td><%=bookType.getPrice()%></td>
										<td><%=bookType.getAuthor()%></td>
										<td><%=bookType.getCbs()%></td>
										<td><%=bookType.getCdDate()%></td>
										<td style="max-width: 200px"><%=bookType.getDescri()%></td>
										<td><%=bookType.getSid()%></td>
										<td><img  src="upload/<%=bookType.getPhoto()%>"></td>
										<td>
										     <a href="#modal-container-461467" data-toggle="modal" onclick="window.delId='<%=bookType.getId()%>'" class="fa fa-trash fa-1x" title="删除"></a>
										     <a class="fa fa-edit" title="修改" href="toBookEdit?id=<%=bookType.getId()%>"></a>
										</td>
									</tr>
									<%
										}
										}else{
										%>
										<tr>
										<td colspan="10">无数据</td>
										</tr>
										<%
										}
									%>
								</tbody>
							</table>
						</div>
						<!--card-footer  -->
						<div class="card-footer">
							<nav>
								<ul class="pagination" style="margin-bottom: 0px">
									<%
										int totalPage = (Integer) request.getAttribute("totalPage");
										//获取当前页数
										int currentPage = (Integer) request.getAttribute("currentPage");

										if (currentPage == 1) {
											//disabled 不能点击
									%>
									<li class="page-item disabled"><a class="page-link" href="#">上一页</a></li>
									<%
										} else {
									%>
									<li class="page-item "><a class="page-link" href="bookList?currentPage=<%=currentPage - 1%>">上一页</a></li>
									<%
										}
									%>
									<%
										//总页数
										if (totalPage <= 5) {
											for (int i = 1; i <= totalPage; i++) {
									%>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=i%>"><%=i%></a></li>

									<%
										}
										} else if (currentPage <= 3) {
									%>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=1">1</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=2">2</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=3">3</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=4">4</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage%>">...<%=totalPage%></a></li>
									<%
										} else if (currentPage <= totalPage - 3) {
									%>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=1">1...</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=currentPage - 1%>"><%=currentPage - 1%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=currentPage%>"><%=currentPage%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=currentPage + 1%>"><%=currentPage + 1%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage%>">...<%=totalPage%></a></li>
									<%
										} else {
									%>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=1">1...</a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage - 3%>"><%=totalPage - 3%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage - 2%>"><%=totalPage - 2%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage - 1%>"><%=totalPage - 1%></a></li>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=totalPage%>"><%=totalPage%></a></li>
									<%
										}
									%>
									<!--下一页  -->
									<%
										if (currentPage == totalPage) {
									%>
									<li class="page-item disabled"><a class="page-link" href="#">下一页</a></li>
									<%
										} else {
									%>
									<li class="page-item"><a class="page-link" href="bookList?currentPage=<%=currentPage + 1%>">下一页</a></li>
									<%
										}
									%>

								</ul>
							</nav>
						</div>
					</div>
				
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<blockquote class="blockquote">
					<p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						Someone famous in <cite>Source Title</cite>
					</footer>
				</blockquote>
			</div>
		</div>
	</div>
<!-- 删除确认提示框 -->
	<div class="modal fade" id="modal-container-461467" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								提示
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							确定要删除？
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" onclick="exeDel(event)">
								确定
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								关闭
							</button>
						</div>
					</div>
				</div>
			</div>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#themeSel").change(
					function(evt) {
						$("#zt").attr("href","bower_components/bootswatch/dist/"+ $(evt.target).val()+ "/bootstrap.css");
						$.cookie('boos', $(evt.target).val(), {
							expires : 30
						});
					});
			$('a[href="bookList?currentPage=<%=currentPage%>"]').parent("li").addClass("active");
			$("#themeSel").val($.cookie('boos'));
		});

		  function fillSel(types){
				for (var i = 0; i < types.length; i++) {
					var op=new Option(types[i].name,types[i].id);
					document.getElementById("inputBid").appendChild(op);
				}
				 $("#inputBid").val('<%=request.getAttribute("bid")%>');
				 $("#inputBid").trigger("change");
				}   
			
		function fillSmallSel(types){
	    	  document.getElementById("inputSid").innerHTML='<option value="-1">--请选择--</option>';
	          for (var i = 0; i < types.length; i++) {
					var op=new Option(types[i].name,types[i].id);
					document.getElementById("inputSid").appendChild(op);
				}
	          $("#inputSid").val('<%=request.getAttribute("sid")%>');
	        }
		 
	      $.ajax({
				url:"findAllBigType",
				dataType: "jsonp",
				jsonpCallback:"fillSel"
				});
	      $("#inputBid").change(function(){
	    	  $.ajax({
	              url:"findAllSmallType",
	              dataType:"jsonp",
	              data:"bid="+$(this).val(),
	              jsonpCallback:"fillSmallSel"
	            });
	          });
         //缺少表单内容，解决表单内容
         $('a[class="page-link"][href^="bookList?currentPage="]').click(function(){
                $(this).attr("href",$(this).attr("href")+"&"+$("#formid").serialize());
             });
         //删除确认
         function exeDel(event){
             window.location.href="bookDel?id="+window.delId;
             }
         
	</script>
</body>
</html>