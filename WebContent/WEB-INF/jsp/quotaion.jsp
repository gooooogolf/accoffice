<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="keywords" content="โปรแกรมพิมพ์บิล, โปรแกรมบัญชีสำเร็จรูป, โปรแกรมขายหน้าร้าน POS, โปรแกรมห้องพัก-คอนโด, โปรแกรมพิมพ์ฟอร์มภาษี">
<meta name="author" content="Sirimongkol Panwa">
<title>ขอใบเสนอราคา accoffice</title>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/redmond/jquery-ui-1.9.2.custom.css"/> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.css"/> --%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ui.jqgrid.css"/> --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shop-homepage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
<style type="text/css">
.thumbnail img { width:50px; height:100px; }
</style>
</head>
<body>
<div id="wrapper">
<!-- Navigation -->
<jsp:include page="nav.jsp"></jsp:include>
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row text-center">
                <br>
                <c:forEach items="${products}" var="product">
		   			<div class="col-md-3 col-sm-6 hero-feature">
		                <div class="thumbnail">
<%-- 		                    <br><img src="${product.imgSrc }" alt="${product.productId }"> --%>
		                    <div class="caption">
		                        <h3>${product.productId }</h3>
		                        <p>${product.productName }</p>
		                    </div>
		                    <div class="ratings">
		                    	<p>
		                            <a href="#" id="choose_${product.id }" class="btn btn-primary" onclick="javascript:chooseProduct('${product.id }', '${product.productName }')">เลือก</a> 
<!-- 		                            <a href="#" class="btn btn-default">รายละเอียด</a> -->
		                        </p>
		                    </div>
		                </div>
		            </div>
		       	</c:forEach>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                	<div class="col-md-12">
			  		<br>
						<div id="alert-success" class="alert alert-success"><strong><span class="glyphicon glyphicon-send"></span> Success! Message sent.</strong></div>	  
					    <div id="alert-danger" class="alert alert-danger"><span class="glyphicon glyphicon-alert"></span><strong> Error! Please check the inputs. (If form error!)</strong></div>
			  		</div>
				<form role="form" action="javascript:void(0)" method="post" id="quotationForm">
				    <div class="col-lg-6">
					      <div class="form-group">
					        <label for="quotationName">ชื่อของคุณ</label>
					        <div class="input-group">
					          <input type="text" class="form-control" name="quotationName" id="quotationName" placeholder="ใส่ชื่อของคุณ" required>
					          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
					      </div>
					   	<div class="form-group">
			        		<label for="contactEmail">อีเมล์ของคุณ</label>
			        		<div class="input-group">
			          		<input type="email" class="form-control" id="quotationEmail" name="quotationEmail" placeholder="ใส่อีเมล์ของคุณ" required  >
			          		<span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
			      		</div>
			      		<div class="form-group">
			      		  	<div class="panel panel-default">
		                        <div class="panel-heading">รายการสินค้า</div>
		                        <div class="panel-body">
		                        	<table id="tblProducts" class="table table-hover">
<!-- 		                        		<thead> -->
<!-- 		                        		<tr> -->
<!-- 		                        		<th>สินค้า</th> -->
<!-- 		                        		<th style="width:5%;">จำนวน</th> -->
<!-- 		                        		</tr> -->
<!-- 		                        		</thead> -->
		                        		<tbody id="tbodyProducts">
		                        		</tbody>
		                        	</table>
		                        </div>
	                        </div>
			      		</div>
			      		<div>
			      		<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info">
			      		</div>
					</div>					
				</form>
				</div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqGrid/i18n/grid.locale-en.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqGrid/jquery.jqGrid.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>
<script type="text/javascript">
var __ids = [], productIds = {};
var trProductTemplate = '<tr id="trProduct{productId}"><td>{productName}</td><td><input type="text" id="txtProduct{productId}" class="form-control" size="2" maxlength="2" value="1"/></td></tr>'
$(document).ready(function(){
	$('#alert-danger, #alert-success').hide();
	$('#quotationForm').submit(function(){
		var quotation = {
				quotationEmail: $('#quotationEmail').val(),
				quotationName: $('#quotationName').val(),
				products: getProductItems(productIds)
		}
		
		$.ajax({
		    url: '${pageContext.request.contextPath}/quotation/contact/send.do',
		    data: JSON.stringify(quotation),
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
		    	
		    },
		    error: function(jqXHR, textStatus, errorThrown) {
		    	alert(this.url + '\njqXHR status : ' + jqXHR.status + '\ntextStatus : ' + textStatus + '\nThrown : ' + errorThrown);
		    }
		});	
	});
	
});

function getProductItems(json) {
	var products = [], product; 
    for(var prop in json) {
    	product = {};
    	product.id = json[prop]
    	product.quantity = $('#txtProduct' + product.id).val();
    	products.push(product);
    }
    return products;
}

function chooseProduct(id, productName) {
	if (productIds[id]) {
		delete productIds[id];
		$('#choose_' + id).text('เลือก').removeClass('btn btn-success').addClass('btn btn-primary');
		$('#trProduct' + id).remove();
	}
	else {
		productIds[id] = id;
		$('#choose_' + id).text('เลือกแล้ว').addClass('btn btn-success');
		var productId = new RegExp('{productId}', 'g');
		var trProduct = trProductTemplate; 	
		trProduct = trProduct.replace(productId, id);
		trProduct = trProduct.replace('{productName}', productName);
		$('#tbodyProducts').append(trProduct);
		$('#txtProduct' + id).select();
	}
	
}

</script>
</body>
</html>