<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="keywords" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="author" content="Sirimongkol Panwa">
<title>ติดต่อเรา</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">

</head>
<body>
<div id="wrapper">
<!-- Navigation -->
<jsp:include page="nav.jsp"></jsp:include>
        <!-- Page Content -->
        <div id="page-wrapper">
			<div class="container-fluid">
			<div class="row">
			  <div class="col-md-12">
			  <br>
				<div id="alert-success" class="alert alert-success"><strong><span class="glyphicon glyphicon-send"></span> Success! Message sent.</strong></div>	  
			    <div id="alert-danger" class="alert alert-danger"><span class="glyphicon glyphicon-alert"></span><strong> Error! Please check the inputs. (If form error!)</strong></div>
			  </div>
			  <form role="form" action="javascript:void(0)" method="post" id="contactForm">
			    <div class="col-lg-6">
<!-- 			      <div class="well well-sm"><strong><i class="glyphicon glyphicon-ok form-control-feedback"></i> Required Field</strong></div> -->
			      <div class="form-group">
			        <label for="InputName">ชื่อของคุณ</label>
			        <div class="input-group">
			          <input type="text" class="form-control" name="InputName" id="InputName" placeholder="ใส่ชื่อของคุณ" required>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="InputEmail">อีเมลล์ของคุณ</label>
			        <div class="input-group">
			          <input type="email" class="form-control" id="InputEmail" name="InputEmail" placeholder="ใส่อีเมลล์ของคุณ" required  >
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="InputMessage">ข้อความ</label>
			        <div class="input-group">
			          <textarea name="InputMessage" id="InputMessage" class="form-control" rows="5" required></textarea>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="InputReal" id="InputRealLabel">What is 4+3?</label>
			        <div class="input-group">
			          <input type="text" class="form-control" name="InputReal" id="InputReal" required>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
			    </div>
			  </form>
			  <hr class="featurette-divider hidden-lg">
			  <div class="col-lg-5 col-md-push-1">
			    <address>
			    <h3>บริษัท โทเทิ่ล คอมมิวนิเคชั่น อินเตอร์เนชั่นแนล จำกัด </h3>
			    <p class="lead">
			    <a href="https://www.google.co.th/maps/place/%E0%B8%9A%E0%B8%A3%E0%B8%B4%E0%B8%A9%E0%B8%B1%E0%B8%97+%E0%B9%82%E0%B8%97%E0%B9%80%E0%B8%97%E0%B8%B4%E0%B9%88%E0%B8%A5+%E0%B8%84%E0%B8%AD%E0%B8%A1%E0%B8%A1%E0%B8%B4%E0%B8%A7%E0%B8%99%E0%B8%B4%E0%B9%80%E0%B8%84%E0%B8%8A%E0%B8%B1%E0%B9%88%E0%B8%99+%E0%B8%AD%E0%B8%B4%E0%B8%99%E0%B9%80%E0%B8%95%E0%B8%AD%E0%B8%A3%E0%B9%8C%E0%B9%80%E0%B8%99%E0%B8%8A%E0%B8%B1%E0%B9%88%E0%B8%99%E0%B9%81%E0%B8%99%E0%B8%A5+%E0%B8%88%E0%B8%B3%E0%B8%81%E0%B8%B1%E0%B8%94/@13.8058255,100.503947,13z/data=!4m5!1m2!2m1!1z4LmC4LiX4LmA4LiX4Li04LmI4LilIOC4hOC4reC4oeC4oeC4tOC4p-C4meC4tOC5gOC4hOC4iuC4seC5iOC4mSDguK3guLTguJnguYDguJXguK3guKPguYzguYDguJnguIrguLHguYjguJnguYHguJnguKU!3m1!1s0x30e29bbf7355698b:0x7c12d260f153c035" target="_blank">
			    137/7 หมู่บ้านภาณุรังษี ซอย 3<br>
			    	ถนนบางกรวย-ไทรน้อย<br>
				ตำบล บางกรวย อำเภอ บางกรวย<br>
				นนทบุรี 11130<br></a><br>
			      Phone: +6629244698<br>
			      Fax:  +6629244699<br>
			      E-mail : total@accoffice.com</p>
			    </address>
			  </div>
			</div>
			
			</div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var a = Math.floor((Math.random() * 10) + 1);
	var b = Math.floor((Math.random() * 10) + 1);

	$('#alert-danger, #alert-success').hide();
	$('#InputRealLabel').html('What is ' + a + ' + ' + b + '?');
	
	$('#contactForm').submit(function(){
		$InputReal = $('#InputReal');
		if($InputReal.val() != (a + b)) {
			$('#alert-danger, #alert-success').hide();
			$('#alert-danger').text('เกิดข้อผิดพลาด! กรุณาใส่ข้อมูลให้ถูกต้อง').show();
			$InputReal.select();
			return false;
		}
		else {
			$('#alert-danger, #alert-success').hide();
			$('#alert-success').text('คุณส่งข้อมูลเรียบร้อยแล้ว').show();
			return false;
		}
		return;
	});
});
</script>
</body>
</html>