<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>书籍添加</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link href="bower_components/bootswatch/dist/simplex/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.custom-file-label::after {
	content: "浏览"
}
</style>
</head>
<body>
    <div class="container-fluid" style="width: 70%">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<form method="post" enctype="multipart/form-data" autocomplete="off" action="bookTypeAdd" id="bookAddForm">
							
							<div class="form-group row">
								<label for="inputBid" class="col-sm-2 col-form-label text-right">大类</label>
								<div class="col-sm-10">
									
									<select name="bid" class="form-control" id="inputBid">
									<option>请选择</option>
									</select>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputSid" class="col-sm-2 col-form-label text-right">小类</label>
								<div class="col-sm-10">
									<select name="sid" class="form-control" id="inputSid">
									
									</select>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">书名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName" placeholder="书名" name="name">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputPrice" class="col-sm-2 col-form-label text-right">价格</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPrice" placeholder="价格" name="price">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputAuthor" class="col-sm-2 col-form-label text-right">作者</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputAuthor" placeholder="作者" name="author">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputCbs" class="col-sm-2 col-form-label text-right">出版社</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputCbs" placeholder="出版社" name="cbs">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputCdDate" class="col-sm-2 col-form-label text-right">日期</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="inputCdDate" placeholder="日期" name="cdDate">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputDescri" class="col-sm-2 col-form-label text-right">简介</label>
								<div class="col-sm-10">
									<textarea  class="form-control" id="inputDescri" placeholder="简介" name="descri"></textarea>
								</div>
							</div>
							
							<div class="form-group row">

								<label for="inputPhoto" class="col-sm-2 col-form-label text-right">头像</label>
								<div class="col-sm-10">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="inputPhoto" aria-describedby="inputGroupFileAddon04"
											name="photo"> <label class="custom-file-label" for="inputPhoto">请选择文件</label>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">添加</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    
    <script type="text/javascript" src="bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript">
    /*   var xhr=new XMLHttpRequest();
      xhr.open("GET","findAllBigType");//开启拨号
      xhr.send();//点击拨打
      xhr.onreadystatechange=function(){
          if (xhr.readyState==4) {//请求完全接收到了
			if (xhr.status==200) {//如果是200请求就成功了
				 console.dir(xhr.responseText); 
				eval(xhr.responseText);
			}
		 } 
      } */
      function fillSel(types){
			for (var i = 0; i < types.length; i++) {
				var op=new Option(types[i].name,types[i].id);
				document.getElementById("inputBid").appendChild(op);
			}
			}      
		function fillSmallSel(types){
    	  document.getElementById("inputSid").innerHTML="";
          for (var i = 0; i < types.length; i++) {
				var op=new Option(types[i].name,types[i].id);
				document.getElementById("inputSid").appendChild(op);
			}
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
          })
	</script>
	<script type="text/javascript">
		$('#inputCdDate').datepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			autoclose : true,
			defaultViewDate : {
				year : new Date().getFullYear() - 8
			}
		});
	</script>
	<!-- <script type="text/javascript"src="findAllBigType"></script> -->
<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
<script type="text/javascript" src="bower_components/jquery-validation/dist/additional-methods.js"></script>
<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
<script type="text/javascript">
	$(function () {
		$("#bookAddForm").validate({
			rules:{//限制类型
                price:{
                    required:true,//必填
					number:true
				},
                descri:{
                    required:true,
					maxlength:100
				},
                photo:{
                    required:true,
                    accept:"image/*"//只能是图片，/*是不限制图片类型
                }
			},
            messages:{//提示输入错误的信息
                price:{
                    required:"价格必填",
                    number:"必须是数字"
				},
                photo:{
                    accept:"只能是图片"
                }
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