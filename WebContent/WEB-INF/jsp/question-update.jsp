<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="keywords" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="author" content="Sirimongkol Panwa">
<title>หน้าหลัก accoffice</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fileupload/css/jquery.fileupload.css">
<style type="text/css">
.thumbnail img { width:150px; height:200px; }
</style>
</head>
<body>
<div id="wrapper">
<!-- Navigation -->
<jsp:include page="nav.jsp"></jsp:include>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">UPDATE ถาม - ตอบ</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            	Q & A ${error}
	                        </div>
	                        <div class="panel-body">
	                            <div class="row">
	                            <form role="form" action="javascript:void(0)" method="post" id="questionForm">
	                                <input type="hidden" id="id" name="id" value="${question.id }">
	                                <div class="col-lg-10">  
	                                		<div class="form-group">
	                                            <label>ข้อ</label>
	                                            <input class="form-control" id="seq" name="seq" value="${question.seq }">
	                                        </div> 
	                                        <div class="form-group">
	                                            <label>คำถาม</label>
	                                            <textarea class="form-control" rows="5" id="question" name="question">${question.question }</textarea>
	                                            <p class="help-block">สามารถใช้ Code HTML เช่น &#60;a href="#"&#62;link Text&#60;/a&#62;  </p>
	                                        </div>	 
	                                    	<div class="form-group">
	                                            <label>คำตอบ</label>
	                                            <textarea class="form-control" rows="5" id="answer" name="answer">${question.answer }</textarea>
	                                            <p class="help-block">สามารถใช้ Code HTML เช่น &#60;a href="#"&#62;link Text&#60;/a&#62;  </p>
	                                        </div>	                                       	                                    	                                         	                                     
	                               	</div> 
	                               	<div class="col-lg-10">
	                               		<div class="btn-group">
	                      				<button type="submit" class="btn btn-primary" id="submit">Submit</button>
                                        <button type="reset" class="btn btn-danger" id="reset">Reset</button>    
                                        <button type="button" class="btn btn-default" id="back">Back</button> 
										</div>  
	                               	</div>	                               	
	                               	</form>  
	                           	</div> 
	                      	</div> 
	              		</div>  
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fileupload/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fileupload/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fileupload/js/jquery.fileupload.js"></script>

<script type="text/javascript">
$(document).ready(function() {  
	
    $('#back').click(function() {
    	window.history.back();
    })
    
    $('#submit').click(function(){
    	var formData = $('#questionForm').serializeObject();
    	if (validate(formData)) {
    		saveQuestion(JSON.stringify(formData));
    	}
    	return false;
    });
});

function saveQuestion(question) {
	$.ajax({
	    url: '${pageContext.request.contextPath}/question/update.do',
	    data: question,
	    type: "POST",
	    dataType:"json",
	    contentType: "application/json",
	    cache: false,
	    success: function(retQuestion) {
	    	window.scroll(0, 0); 
	    	alert('บันทึกข้อมูลสำเร็จ');
	    	$('.panel-heading').text('Q & A Last Update!!!');
			window.location = '${pageContext.request.contextPath}/question/list';
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
	    	$('.panel-heading').text(this.url + '\njqXHR status : ' + jqXHR.status + '\ntextStatus : ' + textStatus + '\nThrown : ' + errorThrown);
	    }
	});	
	return false;
}

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

function validate(question) {
	if (question.question == '') {
		$('.panel-heading').text('กรุณากรอกคำถาม');
		window.scroll(0, 0); 
		$('#question').select();
		return false;	
	}
	else if (question.answer == '') {
		$('.panel-heading').text('กรุณากรอกคำตอบ');
		window.scroll(0, 0); 
		$('#answer').select();
		return false;	
	}
	return true;
}
</script>
</body>
</html>