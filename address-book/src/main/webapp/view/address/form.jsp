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
	<span class="glyphicon glyphicon-edit"> </span></c:otherwise>
	
	
	</c:choose>
		<strong> 
			 Address
		</strong>

	</div>
	<sf:form action="${path}/address/add" modelAttribute="address" class="form-horizontal"
		method="POST" id="submitAddressForm">
		<sf:hidden path="addressid" />
	<div class="panel-body">
		<div class="form-group" >
			<label class="col-md-2 control-label">Country: </label>

			<div class="col-md-4">
			<sf:input class="form-control" path="country" placeholder="Enter Country" required="true" />
			</div>
			<label class="col-md-2 control-label"> City:</label>

			<div class="col-md-4">
			<sf:input class="form-control" path="city" placeholder="Enter City" required="true"/></div>

		</div>
		<div class="form-group">
			<label class="col-md-2 control-label">Street: </label>

			<div class="col-md-4">
			<sf:input class="form-control" path="street" placeholder="Enter Street" required="true"/>
			</div>
			<label class="col-md-2 control-label"> Box Number:</label>

			<div class="col-md-4">
			<sf:input class="form-control" path="boxNumber" placeholder="Enter Box Number" required="true" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-md-2 control-label">User: </label>

			<div class="col-md-4">
			<sf:select class="form-control" path="userid">
				<c:forEach items="${users}" var="user">
					<sf:option value="${user.userid}">${user.name}</sf:option>
				</c:forEach>
			</sf:select>
			</div>
			<label class="col-md-2 control-label"> </label>

			<div class="col-md-4">
	
			</div>

		</div>
		
		</div>
	
	<div class="panel-footer">
	<div class="col-md-12">
		<div class="form-group ">
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
	</div>
	</sf:form>
	</div>



	

	