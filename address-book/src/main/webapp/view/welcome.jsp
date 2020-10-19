<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" />
<link rel="shortcut icon" href="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/2b14985a-c66e-4dbd-b09c-609fe0678dae/d4jt21r-943ff4da-3cfd-484d-afa7-afb9d631a9aa.png" />
	<script type="text/javascript" src="${path}/webjars/jquery/3.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/jquery.boot.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	
<title>Welcome</title>
<style type="text/css">
.row {
	margin-top: 0px;
	margin-right: 0px;
	margin-left: 0px;
}

.menu {
	height: 100%;
	position: fixed;
	background-color: #f8f8f8f;
	top: 60px;
}
.panel-body{

}

.menu .navbar-nav li {
	width: 100%;
	border-bottom: 1px solid #e7e7e7;
}
.fix{
position: fixed;
width: 100%;
}

</style>
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal.name !=null}">

		<form method="post" id="logoutForm" action="${path}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">

		</form>

		<div class="navbar navbar-default navbar-fixed">
			<div class="container-fluid">

				<div class="navbar-header">

					<a class="navbar-brand text-center" href="javascript:void(0);"> Address
						Book </a>
				</div>
				<div class="collapse navbar-collapse"  style="margin-left: 190px">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${path}"> <span
								class="glyphicon glyphicon-home"></span>Home
						</a></li>
						<li><a href="javascript:void(0);" id=""><span
								class="glyphicon glyphicon-info-sign"></span>About Us</a></li>
						<li><a href="javascript:void(0);"><span
								class="glyphicon glyphicon-phone-alt"></span>Contact Us</a></li>


					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a onclick="document.forms['logoutForm'].submit()">Welcome
								: ${pageContext.request.userPrincipal.name} | <span
								class="glyphicon glyphicon-log-out"></span> Log Out</a></li>

					</ul>
				</div>

			</div>

		</div>

		<div class="row">
			<div class="menu navbar navbar-default">
				<div class="menu-container">
					<ul class="nav navbar-nav">
						<li><a href="javascript:void(0);" id="userList"> <span
								class="glyphicon glyphicon-user"></span>User List
						</a></li>
						<li><a href="javascript:void(0);" id="addressList"><span
								class="glyphicon glyphicon-info-sign"></span>Address List</a></li>

					</ul>
				</div>
			</div>

			<div class="container-fluid">
				<div class="inner-jsp panel-body" style="margin-left: 210px">
					<c:forEach begin="0" end="5" varStatus="loop">

						<div class="cpl-md-12">
							<h2>${heading}</h2>
							<p class="text-justify" >${message}</p>
						</div>

					</c:forEach>
				</div>
			</div>


		</div>

		<div class="nav navbar-default navbar-fixed-bottom">
			<div class="container">
				<div class="col-md-10 navbar-text text-center"> © 2020, All
					Rights Reserved AddressBook Uganda</div>

			</div>

		</div>




	</c:if>


</body>


</html>