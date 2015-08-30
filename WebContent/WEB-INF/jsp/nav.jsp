<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.js"></script>
<![endif]-->
        <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}">ACC OFFICE</a>

            </div>
          		<ul class="nav navbar-top-links navbar-right">
			        <li class="dropdown">
			            <a href="#" data-toggle="dropdown" class="dropdown-toggle">${pageContext.response.locale}<b class="caret"></b></a>
			            <ul class="dropdown-menu">
			                <li><a href="?lang=th">ภาษาไทย</a></li>
			                <li><a href="?lang=en">English</a></li>
<!-- 			                <li class="divider"></li> -->
<%-- 			                <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">ออกจากระบบ</a></li> --%>
			            </ul>
			        </li>
				</ul>
            <!-- /.navbar-header -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/index"><i class="fa fa-home fa-fw"></i> หน้าหลัก</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/download"><i class="fa fa-download fa-fw"></i> <spring:message code="label.download" /></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> รายการปรับปรุง<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/product/list">สินค้า</a>
                                </li>
<!--                                 <li> -->
<%--                                     <a href="${pageContext.request.contextPath}/product/create">เพิ่มสินค้าใหม่</a> --%>
<!--                                 </li> -->
<!--                                 <li> -->
<%--                                     <a href="${pageContext.request.contextPath}/product/update">แก้ไขสินค้า</a> --%>
<!--                                 </li> -->
                                <li>
                                    <a href="${pageContext.request.contextPath}/question/list">ถามตอบ</a>
                                </li>
                               	<li>
                                    <a href="${pageContext.request.contextPath}/vdo/list">VDO</a>
                                </li>
                              	<li>
                                    <a href="${pageContext.request.contextPath}/tech/list">เทคนิคการใช้งาน</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/price"><i class="fa fa-usd fa-fw"></i> ราคา</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/quotation"><i class="fa fa-edit fa-fw"></i> ขอใบเสนอราคา</a>
                        </li>  
                        <li>
                            <a href="${pageContext.request.contextPath}/video"><i class="fa fa-video-camera fa-fw"></i> วิดีโอสอนการใช้งาน</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/technique"><i class="fa fa-info-circle fa-fw"></i> เทคนิคการใช้งาน</a>
                        </li>  
                        <li>
                            <a href="${pageContext.request.contextPath}/questions"><i class="fa fa-question-circle fa-fw"></i> ถามตอบ</a>
                        </li>  
                        <li>
                            <a href="${pageContext.request.contextPath}/contact"><i class="fa fa-comments fa-fw"></i> ติดต่อเรา</a>
                        </li>                                                                                                                                                                            
                    </ul>
				</div>
			</div>
        </nav>
