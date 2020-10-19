<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1" />
<link rel="stylesheet" type="text/css"
	href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
	<link rel="shortcut icon" href="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/2b14985a-c66e-4dbd-b09c-609fe0678dae/d4jt21r-943ff4da-3cfd-484d-afa7-afb9d631a9aa.png" />
	
<style type="text/css">
body {
	background:
		url(https://images.pexels.com/photos/255379/pexels-photo-255379.jpeg?cs=srgb&dl=pexels-miguel-%C3%A1-padri%C3%B1%C3%A1n-255379.jpg&fm=jpg);
	background-size: cover;
	display: flex;
	align-items: center;
	height: 100vh;
}

.input-group {
	padding: 10px;
}

.col-md-4 {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
	background-color: coral;

}
</style>
<title>login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="log">
					<div class="panel panel-default">
						<div class="panel-headiing text-center">
							<strong>Login to your account</strong>
						</div>
						<div class="panel-boday">



							<form action="${path}/user/login" method="post"
								class=" form-horizontal" >
								<c:if test="${error!=null}">
									<div class="alert alert-danger">
										<strong>${error}</strong>
									</div>


								</c:if>
								<c:if test="${message!=null}">
									<div class="alert alert-success">
										<strong>${message}</strong>
									</div>


								</c:if>

								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-user"></span>

											</span> <input type="text" class="form-control" name="username"
												placeholder="Enter your Email" />
										</div>

									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-lock"></span>

											</span> <input type="password" class="form-control" name="password"
												placeholder="Enter your password" />
										</div>

									</div>
								</div>

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<div class="form-group">
									<div class="col-md-12">
										<button type="submit" class="btn btn-default btn-block">
											<span class="glyphicon glyphicon-log-in"></span>Login

										</button>

									</div>
								</div>


							</form>
						</div>


					</div>
				</div>


			</div>


		</div>


	</div>





</body>
</html>