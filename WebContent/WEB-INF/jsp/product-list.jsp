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
<title>หน้าหลัก accoffice</title>
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
                <!-- /.row --> 
               <div class="row">
               <br>
            	<div class="col-lg-12" align="right"> <a href="${pageContext.request.contextPath}/product/update" class="btn btn-primary">เพิ่มสินค้าใหม่</a></div>
               </div> 
                <div class="row">
                    <div class="col-lg-12">
                  		<div class="table-responsive">
							<table class="table table-hover">
								<thead>
								<tr>
									<th>รหัสสินค้า</th>
									<th>ชื่อสินค้า</th>
									<th>ราคา</th>
									<th class="text-center"></th>
								</tr>
								<tbody>
								<c:forEach items="${products}" var="product">
									<tr>
										<td>${product.productId }</td>
										<td>${product.productName }</td>
										<td>${product.productPrice }</td>
										<td class="text-right">
										<div class="btn-group">
											<a href="${pageContext.request.contextPath}/product/update/${product.id }" class="btn btn-primary"><i class="fa fa-shopping-cart fa-fw"></i></a>
											<a href="${pageContext.request.contextPath}/product/download/${product.id }" class="btn btn-success"><i class="fa fa-download fa-fw"></i></a>
											<a href="${pageContext.request.contextPath}/product/price/${product.id }" class="btn btn-info"><i class="fa fa-usd fa-fw"></i></a>
										</div>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
                    </div>
                    <!-- /.col-lg-12 -->
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
</body>
</html>