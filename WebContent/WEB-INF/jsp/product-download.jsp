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
                        <h1 class="page-header">Download ${product.productId }</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            	ข้อมูลสินค้า ${error} Last Update ${product.effectiveDateTime}
	                        </div>
	                        <div class="panel-body">
	                            <div class="row">
	                            <form role="form" action="javascript:void(0)" method="post" id="productForm">                   
	                            	<div class="col-lg-12">
	                                        <div class="form-group">
	                                            <label>รูปภาพ</label>
											    <br>
											    <!-- The container for the uploaded files -->
											    <div id="files" class="files">
											    	<img id="imgSrc" class="img-responsive" src="${product.imgSrc }">
											    </div>
											    <br>
	                                        </div>	
	                                      	<div class="form-group">
	                                            <label>Download URL</label>
	                                            <input class="form-control" id="downloadURL" name="downloadURL" value="${product.downloadURL }">
	                                        </div> 
	                                        <div class="form-group">
	                                            <label>รายละเอียด Download</label>
	                                            <textarea class="form-control" rows="5" id="downloadDesc" name="downloadDesc">${product.downloadDesc }</textarea>
	                                            <p class="help-block">สามารถใช้ Code HTML เช่น &#60;a href="#"&#62;link Text&#60;/a&#62;  </p>
	                                        </div>	
	                               	</div> 
	                               	<div class="col-lg-10">
	                               		<div class="btn-group">
		                      				<button type="submit" class="btn btn-primary" id="submit">Submit</button>
		                      				<button type="reset" class="btn btn-warning" id="reset">Reset</button>    
<!-- 		                      				<button type="button" class="btn btn-danger" id="delete">Delete</button>    -->
											<button type="button" class="btn btn-default" id="back">Back</button>
										</div>  
	                               	</div>
	                               	<input type="hidden" class="form-control" id="productId" name="productId" value="${product.productId }">
	                                <input type="hidden" name="id" id="id" value="${product.id }">
	                                <input type="hidden" class="form-control" id="productName" name="productName" value="${product.productName }">
	                                <input type="hidden" class="form-control" id="productTitle" name="productTitle" value="${product.productTitle }">
	                                <input type="hidden" class="form-control" id="productPrice" name="productPrice" value="${product.productPrice }">	
	                                <input type="hidden" class="form-control" id="status" name="status" value="${product.status }">
	                                <textarea rows="1" cols="1" id="productDesc" name="productDesc" style="visibility: hidden;">${product.productDesc }</textarea>	                      
	                                <textarea rows="1" cols="1" id="priceDesc" name="priceDesc" style="visibility: hidden;">${product.priceDesc }</textarea>	                               	
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
    'use strict';
    $('#fileupload').fileupload({
        url: '${pageContext.request.contextPath}/upload/file',
        dataType: 'json',
        done: function (e, data) {
            $.each(data.result, function (index, file) {
             	$('#files').html('<div id="imgTemp"><a href="${pageContext.request.contextPath}/resources/temp/' + file.url + '" target="_blank">' + file.name + '</a>&nbsp;&nbsp;<a href="javascript:$(\'#imgTemp, #imgSrc\').remove()">[x]</a><br></div>');
             	$('#files').append('<img id="imgSrc" class="img-responsive" src="${pageContext.request.contextPath}/resources/temp/' + file.url + '">');
            });
            $('#progress').hide();
        },
        fail: function (e, data) {
        	 $('#filefaild').html('<p>ไม่สามารถอัพโหลดไฟล์ได้</p>');
        	 $('#progress').hide();
        },
        progressall: function (e, data) {
        	$('#filefaild').html('');
        	$('#progress').show();
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css('width', progress + '%');
        }
    }).prop('disabled', !$.support.fileInput).parent().addClass($.support.fileInput ? undefined : 'disabled');
    
    $('#submit').click(function(){
    	var formData = $('#productForm').serializeObject();
    	formData.imgSrc = $('#imgSrc').attr('src');
    	if (validate(formData)) {
    		saveOrUpdateProduct(JSON.stringify(formData));
    	}
    	return false;
    });
    
    $('#back').click(function() {
    	window.history.back();
    })
    
    $('#delete').click(function() {
    	var formData = $('#productForm').serializeObject();
    	formData.imgSrc = $('#imgSrc').attr('src');
    	if (confirm('คุณต้องการลบ ' + formData.productId + '?')) {
    		deleteProduct(JSON.stringify(formData));
    	}
    	return false;
    })
});

function deleteProduct(product) {
	$.ajax({
	    url: '${pageContext.request.contextPath}/product/delete.do',
	    data: product,
	    type: "DELETE",
	    dataType:"json",
	    contentType: "application/json",
	    cache: false,
	    success: function(retProduct) {
	    	window.scroll(0, 0); 
	    	alert('บันทึกข้อมูลสำเร็จ');
	    	$('.panel-heading').text('ข้อมูลสินค้า Last Update ' + retProduct.effectiveDateTime);
			window.location = '${pageContext.request.contextPath}/product/list';
	    },
	    error: function(jqXHR, textStatus, errorThrown) {
	    	$('.panel-heading').text(this.url + '\njqXHR status : ' + jqXHR.status + '\ntextStatus : ' + textStatus + '\nThrown : ' + errorThrown);
	    }
	});	
	return false;
}

function saveOrUpdateProduct(product) {
	$.ajax({
	    url: '${pageContext.request.contextPath}/product/update.do',
	    data: product,
	    type: "POST",
	    dataType:"json",
	    contentType: "application/json",
	    cache: false,
	    success: function(retProduct) {
	    	window.scroll(0, 0); 
	    	alert('บันทึกข้อมูลสำเร็จ');
	    	$('.panel-heading').text('ข้อมูลสินค้า Last Update ' + retProduct.effectiveDateTime);
			window.location = '${pageContext.request.contextPath}/product/list';
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

function validate(product) {
	if (product.productId == '') {
		$('.panel-heading').text('กรุณากรอกข้อมูลสินค้า');
		window.scroll(0, 0); 
		$('#productId').select();
		return false;	
	}
	return true;
}
</script>
</body>
</html>