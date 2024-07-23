
<%@page import="com.dao.StudentDao"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<%@include file="components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

body {
	background-color: black;
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Student List</p>


						<table class="table">
							<thead>
								<tr>
									<th><a href="addStudent.jsp" class="btn btn-sm btn-primary">Add
											Student</a></th>
								</tr>
							</thead>
						</table>



						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Age</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								StudentDao dao = new StudentDao(DBConnect.getConn());
								List<Student> list = dao.getAllStudent();
								for (Student s : list) {
								%>
								<tr>
									<td><%=s.getName()%></td>
									<td><%=s.getEmail()%></td>
									<td><%=s.getAge()%></td>

									<td><a href="deleteStudent?id=<%=s.getId()%>"
										class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i></a>
										<a href="updateStudent.jsp?id=<%=s.getId()%>"
										class="btn btn-sm btn-primary"><i
											class="fa-solid fa-pen-to-square"></i></a></td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>