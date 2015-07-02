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
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<!-- Optional Bootstrap Theme -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/docs.min.css">
<%-- <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"> --%>
<style type="text/css">
 .carousel-content { 
     color:black; 
     display:flex; 
     align-items:center; 
 } 
</style>
</head>
<body>
 <a id="skippy" class="sr-only sr-only-focusable" href="#content"><div class="container"><span class="skiplink-text">Skip to main content</span></div></a>
     <!-- Docs master nav -->
<header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
<div class="container">
	<div class="navbar-header">
	  <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
	    <span class="sr-only">Toggle navigation</span>
	    <span class="icon-bar"></span>
	    <span class="icon-bar"></span>
	    <span class="icon-bar"></span>
	  </button>
	  <a href="${pageContext.request.contextPath}" class="navbar-brand">Accoffice</a>
	</div>
    <nav id="bs-navbar" class="collapse navbar-collapse">
      	<ul class="nav navbar-nav">
	        <li class="active">
	          	<a href="${pageContext.request.contextPath}">หน้าหลัก</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">Download</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">ราคา</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">ขอใบเสนอราคา</a>
	        </li>		        	
	        <li>
	          	<a href="${pageContext.request.contextPath}">วิดีโอสอนการใช้งาน</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">เทคนิคการใช้งาน</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">ถามตอบ</a>
	        </li>
	        <li>
	          	<a href="${pageContext.request.contextPath}">ติดต่อเรา</a>
	        </li>	        	        		        		        	        	        
		</ul>
		<ul class="nav navbar-nav navbar-right"></ul>		
  	</nav>	    
</div>
</header>

<!-- Docs page layout -->
<div class="bs-docs-header" id="content" tabindex="-1">
  <div class="container">
    <h1>Total comm.</h1>
    <div id="carousel-example" class="carousel slide" data-ride="carousel">
    <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <div class="carousel-content">
                        <div>
                            <p>บริษัท โทเทิ่ล คอมมิวนิเคชั่น อินเตอร์เนชั่นแนล จำกัด</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="carousel-content">
                        <div>
                            <p>โปรแกรมพิมพ์บิล บริหารงานขาย บัญชีสำเร็จรูป ขาย ซื้อ สต๊อก บัญชี ปรับฟอร์มบิลได้ตามต้องการ</p>
                        </div>
                    </div>
                </div>                
                <div class="item">
                    <div class="carousel-content">
                        <div>
                            <p>บัญชี & แบบฟอร์มภาษี  สมุดรายวัน บัญชีแยกประเภท เงินสดย่อย สินทรัพย์ถาวร พิมพ์ฟอร์มภาษี</p>
                        </div>
                    </div>
                </div>     
                <div class="item">
                    <div class="carousel-content">
                        <div>
                            <p>บริการจัดการหอพัก อพาร์ทเม้นท์ หอพัก คอนโด หมู่บ้านจัดสรร ออฟฟิศให้เช่า ธุรกิจที่เปิดบิลซ้ำทุกเดือน</p>
                        </div>
                    </div>
                </div>                            
        	</div>       	
	</div>
   </div>
  	<a class="left carousel-control" href="#carousel-example" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
 	<a class="right carousel-control" href="#carousel-example" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>

    <div class="container bs-docs-container">
      	<div class="row">
	        <div class="col-md-9" role="main">
	          	<div class="bs-docs-section">
					<h1 id="ACC-BILLING" class="page-header">ACC-BILLING</h1>
					<p class="lead">โปรแกรมพิมพ์บิล บริหารงานขาย บัญชีสำเร็จรูป : เหมาะสำหรับธุรกิจซื้อมาขายไป, บริการ, ผลิตสินค้า และธุรกิจที่ต้องการพิมพ์บิลด้วยคอมพิวเตอร์</p>
					<div class="row bs-downloads">
						<div class="col-sm-4">
							<h3 id="download-bootstrap">ระบบงาน</h3>
							<p>แบ่งเป็น 4 ระบบหลัก ได้แก่ ขาย, ซื้อ, สต๊อก, บัญชี </p>
						</div>
						<div class="col-sm-4">
							<h3 id="download-bootstrap">ธุรกิจเฉพาะ</h3>
							<p>-  POS (Point Of Sale) ขายปลีกหน้าร้าน<br>
							- JOB (ต้นทุน JOB) : ธุรกิจผลิตสินค้า / งานสั่งทำ / รับเหมา / โครงการ / งานติดตั้ง</p>
						</div>
						<div class="col-sm-4">
							<h3 id="download-bootstrap">การใช้งาน </h3>
							<p>พิมพ์บิล (ออกใบกำกับภาษี), ควบคุมค่าใช้จ่าย, สต๊อก, ลูกหนี้-เจ้าหนี้, ลงบัญชีเบื้องต้น </p>
						</div>
					</div>
	  			</div>
	          	<div class="bs-docs-section">
					<h1 id="ACC-ROOM" class="page-header">ACC-ROOM</h1>
					<p class="lead">โปรแกรมบริหารจัดการ ห้องพัก   :   เหมาะสำหรับ คอนโด, อพาร์ทเม้นท์, หอพัก, หมู่บ้านจัดสรร และ ธุรกิจที่ต้องเปิดบิลซ้ำๆ ทุกเดือน</p>
					<div class="row bs-downloads">
						<div class="col-sm-6">
							<h3 id="download-bootstrap">ระบบงาน</h3>
							<p>แบ่งเป็น 5 ระบบหลัก ได้แก่ คอนโด-แมนชั่น, ขาย, ซื้อ, สต๊อก, บัญชี</p>
						</div>
						<div class="col-sm-6">
							<h3 id="download-bootstrap">การใช้งาน </h3>
							<p>เน้นความสะดวกในการเปิดบิลซ้ำๆ ทุกเดือน (โดยคลิกปุ่มเดียว สามารถเปิดใบแจ้งหนี้อัตโนมัติครบทุกห้อง)</p>
						</div>
					</div>
	  			</div>
	          	<div class="bs-docs-section">
					<h1 id="ACC-GL" class="page-header">ACC-GL</h1>
					<p class="lead">โปรแกรมบัญชีสำเร็จรูป & พิมพ์ฟอร์มภาษี   :   เหมาะสำหรับ ฝ่ายบัญชี, สำนักงานบัญชี, ผู้ต้องการข้อมูลทางบัญชีและภาษี </p>
					<div class="row bs-downloads">
						<div class="col-sm-6">
							<h3 id="download-bootstrap">ระบบงาน</h3>
							<p>แบ่งเป็น 2 ระบบหลัก ได้แก่ บัญชี และ ฟอร์มภาษี</p>
						</div>
						<div class="col-sm-6">
							<h3 id="download-bootstrap">การใช้งาน </h3>
							<p>- เน้นการจัดทำบัญชีโดยตรง (เพียงคีย์ ยอดรวม ที่สมุดรายวัน โปรแกรมลง เดบิต-เครดิต ให้อัตโนมัติ)<br>
							- บัญชีแยกประเภท และ งบการเงิน อัตโนมัิติ (รองรับ งบแบบกลุ่ม และ งบเปรียบเทียบ 2 ปี)<br>
							- มีฟังก์ชั่นการรับโอนข้อมูลสมุดรายวันจาก ACC-BILLING และ AccOffice เข้ามาเป็นเดือนๆ ได้ <br>
							- พิมพ์ใบรับรองหัก ณ.ที่จ่าย (50ทวิ), ฟอร์มภาษี ภ.ง.ด. 1, 3, 53, ภ.พ.30 และฟอร์มนำส่งเงินสมทบฯ</p>
						</div>
					</div>
	  			</div>	  				  			
	  		</div>
 			<div class="col-md-3" role="complementary">
          		<nav class="bs-docs-sidebar hidden-print hidden-xs hidden-sm">
            		<ul class="nav bs-docs-sidenav">
	              		<li><a href="#ACC-BILLING">ACC-BILLING</a></li>
	              		<li><a href="#ACC-ROOM">ACC-ROOM</a></li>
	              		<li><a href="#ACC-GL">ACC-GL</a></li>	  
	           		</ul>
	      		</nav>
			</div>         				
  		</div>   				
  </div>
  
    
    <!-- Footer
================================================== -->
<footer class="bs-docs-footer" role="contentinfo">
	<div class="container">
	<p>สงวนลิขสิทธิ์โดย บริษัท โทเทิ่ล คอมมิวนิเคชั่น อินเตอร์เนชั่นแนล จำกัด สอบถามเพิ่มเติม จันทร์-ศุกร์  9.00 น -17.00 น.  Tel : 0-2924-4698 (Auto)  Fax : 0-2924-4699</p>
	<p>e-mail : total@accoffice.com , total_comm@hotmail.com   </p>
	</div>
</footer>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
setCarouselHeight('#carousel-example');

function setCarouselHeight(id)
{
    var slideHeight = [];
    $(id+' .item').each(function()
    {
        // add all slide heights to an array
        slideHeight.push($(this).height());
    });

    // find the tallest item
    max = Math.max.apply(null, slideHeight);

    // set the slide's height
    $(id+' .carousel-content').each(function()
    {
        $(this).css('height',max+'px');
    });
}
</script>
</body>
</html>