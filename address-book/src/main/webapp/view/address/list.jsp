<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>


<div class="panel panel-default">
	<div class="panel-heading">
	<strong><span class="glyphicon glyphicon-list-alt"></span>  Address List</strong>
	<div class="pull-right">
	<a href="javascript:void(0);" onclick="addForm('address')"><span class="glyphicon glyphicon-plus-sign"></span> Add Address</a>
	</div> 
	<div class="panel-body">
	</div>
	
	
	<table
	class="table table-bordered table-condensed table-hover table-striped">
	<thead>
		<tr>
			<th>Address ID</th>
			<th>Country</th>
			<th>City</th>
			<th>Street</th>
			<th>boxNumber</th>
			<th>edit</th>
			<th>delete</th>
		</tr>


	</thead>
	<tbody>
		<c:forEach items="${addresses}" var="address">
			<tr>
				<td>${address.addressid}</td>
				<td>${address.country}</td>
				<td>${address.city}</td>
				<td>${address.street}</td>
				<td>${address.boxNumber}</td>
				<td><a href="javascript:void(0);" onclick="editForm('address','${address.addressid}')"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="javascript:void(0);" onclick="deleteData('address','${address.addressid}')"><span class="glyphicon glyphicon-trash"></span></a></td>

			</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
</div>

