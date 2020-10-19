<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">
		<c:choose>
			<c:when test="${isNew}">
				<span class="glyphicon glyphicon-plus-sign"> </span>
			</c:when>
			<c:otherwise>
				<span class="glyphicon glyphicon-edit"> </span>
			</c:otherwise>


		</c:choose>
		<strong> User </strong>

	</div>
	<sf:form action="${path}/user/add" modelAttribute="user"
		class="form-horizontal" id="submitUserForm" method="POST">
		<sf:hidden path="userid" />
		<div class="panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label"> Full Name: </label>

				<div class="col-md-4">
					<sf:input class="form-control" path="name" placeholder="Enter Name"
						required="true" />
				</div>
				<label class="col-md-2 control-label">Email: </label>

				<div class="col-md-4">
					<sf:input class="form-control" path="email"
						placeholder="Enter Email" required="true" />
				</div>

			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Password: </label>

				<div class="col-md-4">
					<sf:password class="form-control" path="password"
						placeholder="Enter Password" required="true" />
				</div>
				<label class="col-md-2 control-label"> Select Role:</label>

				<div class="col-md-4">
					<sf:select path="role" class="form-control" required="true">

						<sf:option value="ROLE_USER">USER</sf:option>
						<sf:option value="ROLE_ADMIN">ADMIN</sf:option>

					</sf:select>
				</div>

			</div>


		</div>
		<div class="panel-footer">
			<div class="form-group pull-left">
				<sf:button class="btn btn-xs btn-default" value="save">
					<span class="glyphicon glyphicon-floppy-disk"></span>

					<c:choose>
						<c:when test="${isNew}">
							Save
						</c:when>
						<c:otherwise>
							Update
						</c:otherwise>


					</c:choose>
					</sf:button>
			</div>
		</div>
	</sf:form>
</div>

