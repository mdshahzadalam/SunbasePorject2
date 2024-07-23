
<%@page import="com.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<%@include file="components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background-color: #E3F4F4;
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="addStudent" method="post">
							<div class="mb-3">
								<label class="form-label">Name<span
									style="color: red; font-weight: bold;">*</span></label> <input
									type="text" required name="name" class="form-control">
							</div>


							<div class="mb-3">
								<label class="form-label">Email<span
									style="color: red; font-weight: bold;">*</span></label> <input
									type="text" required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Age<span
									style="color: red; font-weight: bold;">*</span></label> <input
									type="text" required name="age" class="form-control">
							</div>

							
							<div class="d-flex align-items-center justify-content-center">
							<button type="submit" class="btn btn-primary mx-auto" >Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>