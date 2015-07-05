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
<title>หน้าหลัก accoffice</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/shop-homepage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css">
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
                    <br>
<!--                         <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> -->
<!--                             <ol class="carousel-indicators"> -->
<!--                                 <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li> -->
<!--                                 <li data-target="#carousel-example-generic" data-slide-to="1"></li> -->
<!--                                 <li data-target="#carousel-example-generic" data-slide-to="2"></li> -->
<!--                             </ol> -->
<!--                             <div class="carousel-inner"> -->
<!--                                 <div class="item active"> -->
<!--                                     <img class="slide-image" src="http://placehold.it/800x300" alt=""> -->
<!--                                 </div> -->
<!--                                 <div class="item"> -->
<!--                                     <img class="slide-image" src="http://placehold.it/800x300" alt=""> -->
<!--                                 </div> -->
<!--                                 <div class="item"> -->
<!--                                     <img class="slide-image" src="http://placehold.it/800x300" alt=""> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> -->
<!--                                 <span class="glyphicon glyphicon-chevron-left"></span> -->
<!--                             </a> -->
<!--                             <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> -->
<!--                                 <span class="glyphicon glyphicon-chevron-right"></span> -->
<!--                             </a> -->
<!--                         </div> -->
                    </div>
                    <div class="col-lg-12">      
                    <br>          
                    <c:forEach items="${products}" var="product">
	               		<div class="col-sm-4 col-lg-4 col-md-4">
	                        <div class="thumbnail">
	                            <img class="thumbnail" src="${product.imgSrc }" alt="${product.productId }">
	                            <div class="caption">
<%-- 	                                <h4 class="pull-right">&#3647;${product.productPrice }</h4> --%>
	                                <h4><a href="#">${product.productId }</a>
	                                </h4>
	                                <p>${product.productName } <br> ${product.productTitle}</p>
	                            </div>
	                            <div class="ratings">
	                                <p class="pull-right">${product.effectiveDateTime }</p>
	                                <p>
<!-- 	                                <button>Download</button> -->
	                                    <span class="glyphicon glyphicon-star"></span>
	                                    <span class="glyphicon glyphicon-star"></span>
	                                    <span class="glyphicon glyphicon-star"></span>
	                                    <span class="glyphicon glyphicon-star"></span>
	                                    <span class="glyphicon glyphicon-star"></span>
	                                </p>
	                            </div>
	                        </div>
	                    </div>  
	                </c:forEach>
                    </div>
                    <!-- /.col-lg-12 -->
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>
</body>
</html>