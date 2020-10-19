<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
 

<div class="panel panel-default">
	<div class="panel-heading">
	<strong><span class="glyphicon glyphicon-th-list"></span>  User List</strong>
	<div class="pull-right">
	<a href="javascript:void(0);" onclick="addForm('user')"><span class="glyphicon glyphicon-plus-sign"></span> Add User</a>
	</div>
	</div>
	
	
	<div class="panel-body">
	
	<table class="table table-bordered table-condensed table-hover table-striped">
		<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Role</th>
				<th>edit</th>
				<th>delete</th>
			</tr>


		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userid}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td><a href="javascript:void(0);" onclick="editForm('user','${user.userid}')"><span class="glyphicon glyphicon-edit"></span></a></td>
					<td><a href="javascript:void(0);" onclick="deleteData('user','${user.userid}')"><span class="glyphicon glyphicon-trash"></span></a></td>
					

					
				</tr>
			</c:forEach>


		</tbody>
	</table>
	
	
	</div>
</div>
	
