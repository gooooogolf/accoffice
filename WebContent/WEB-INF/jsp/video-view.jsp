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
<title>Video : ${video.videoSeq }. ${video.videoName }</title>
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
                    <div class="col-lg-12"><br>
                       <div class="col-sm-12 col-lg-12 col-md-12">
                        	<div class="col-sm-2 col-lg-2 col-md-2"><br>
                        		<img class="thumbnail" style="width:150px; height:200px;" src="${product.imgSrc }" alt="${product.productId }">
                        	</div>
                        	<div class="col-sm-10 col-lg-10 col-md-10"><br>
	                        	<div class="caption-full">
	                                <h3><a href="#">${product.productId }</a></h3> 
	                                <h4>${video.videoSeq }. ${video.videoName }</h4>          
	                            </div>
                        	</div>
                        	<div class="col-sm-12 col-lg-12 col-md-12">
                        		<div class="panel panel-default">
			                        <div class="panel-heading">
			                            	${video.videoTitle }
			                        </div>
			                        <div class="panel-body">
			                        <p>${video.videoDesc }</p> 			                      
			                        </div>
		                		</div>
                        	</div>	
                        	<div class="col-sm-12 col-lg-12 col-md-12">
                        	<button type="button" class="btn btn-default" id="back">Back</button>
                        	</div>                          
	                    </div> 
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
});


</script>
</body>
</html>