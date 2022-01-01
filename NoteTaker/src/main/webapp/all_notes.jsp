<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.raj.factory.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.raj.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>All Notes</h1>
		<div class="row">
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from NoteModel");
				List<NoteModel> list = q.list();
				for (NoteModel note : list) {
				%>
				<div class="card mt-3">
					<img class="card-img-top" style="max-width:30px" src="img/note.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%= note.getTitle()%></h5>
						<p class="card-text">
						<%= note.getContent()%></p>
						<p><b class="text-primary"><%=note.getAddDate()%></b></p>
						<div class="container text-center mt-2">
						<a href="edit.jsp?note_id=<%=note.getId()%>" class="btn btn-primary">Edit</a>
						<a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>
				<%
				}
				s.close();
				%>
			</div>
		</div>
	</div>

</body>
</html>