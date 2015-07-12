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
			        <label for="contactName">ชื่อของคุณ</label>
			        <div class="input-group">
			          <input type="text" class="form-control" name="contactName" id="contactName" placeholder="ใส่ชื่อของคุณ" required>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="contactEmail">อีเมล์ของคุณ</label>
			        <div class="input-group">
			          <input type="email" class="form-control" id="contactEmail" name="contactEmail" placeholder="ใส่อีเมล์ของคุณ" required  >
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="contactMessage">ข้อความ</label>
			        <div class="input-group">
			          <textarea name="contactMessage" id="contactMessage" class="form-control" rows="5" required></textarea>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <div class="form-group">
			        <label for="real" id="realLabel">What is 4+3?</label>
			        <div class="input-group">
			          <input type="text" class="form-control" name="real" id="real" required>
			          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      </div>
			      <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
			    </div>
			  </form>
			  <hr class="featurette-divider hidden-lg">
			  <div class="col-lg-5 col-md-push-1">
			    <address>
			    <h4>บริษัท โทเทิ่ล คอมมิวนิเคชั่น อินเตอร์เนชั่นแนล จำกัด </h4>
<!-- 			    <p class="lead"> -->
				<p>Phone: +6629244698<br>Fax:  +6629244699<br>E-mail : total@accoffice.com</p>
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
	$('#realLabel').html('What is ' + a + ' + ' + b + '?');
	
	$('#contactForm').submit(function(){
		$real = $('#real');
		if($real.val() != (a + b)) {
			$('#alert-danger, #alert-success').hide();
			$('#alert-danger').text('เกิดข้อผิดพลาด! กรุณาใส่ข้อมูลให้ถูกต้อง').show();
			$real.select();
			return false;
		}
		else {
			$('#alert-danger, #alert-success').hide();
			var formData = $(this).serializeObject();
			$.ajax({
			    url: '${pageContext.request.contextPath}/mail/contact/send.do',
			    data: JSON.stringify(formData),
			    type: "POST",
			    dataType:"json",
			    contentType: "application/json",
			    cache: false,
			    beforeSend: function() {
			    	$('#alert-success').text('กำลังส่งข้อมูล...').show();
			    },
			    success: function(isSend) {
			    	$('#alert-danger, #alert-success').hide();
			    	window.scroll(0, 0); 
			    	if (isSend) {
			    		$('#alert-success').text('คุณส่งข้อมูลเรียบร้อยแล้ว').show();
			    		$(':input').not(':button, :submit, :reset, :hidden, :checkbox, :radio').val('');
			    	}
			    	else {
			    		$('#alert-danger').text('เกิดข้อผิดพลาดในการส่งอีเมล์, กรุณาส่งอีกครั้ง').show();
			    	}
			    	a = Math.floor((Math.random() * 10) + 1);
			    	b = Math.floor((Math.random() * 10) + 1);

			    	$('#realLabel').html('What is ' + a + ' + ' + b + '?');
			    	
			    },
			    error: function(jqXHR, textStatus, errorThrown) {
			    	$('#alert-danger').text(this.url + '\njqXHR status : ' + jqXHR.status + '\ntextStatus : ' + textStatus + '\nThrown : ' + errorThrown).show();
			    }
			});	
			
			return false;
		}
		return;
	});
});

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
</script>
</body>
</html>