<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.raj.factory.*,org.hibernate.*,com.raj.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<h1>Edit Page</h1>
		<br>
		<%
		int noteId= Integer.parseInt(request.getParameter("note_id").trim());
		Session s=FactoryProvider.getFactory().openSession();
		NoteModel note=(NoteModel)s.get(NoteModel.class, noteId);
		
		%>
		<form action="UpdateServlet" method="post">
		<input value="<%=note.getId()%>" name="noteId" type="hidden">
			<div class="form-group">
				<label for="title">Title</label> <input name="title" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter Here"
					value="<%=note.getTitle() %>"
					/> 
			</div>
			<div class="form-group">
				<label for="content">Note</label>
				<textarea name="content" required="required" id="note"
					placeholder="Write Note" class="form-control" style="hight: 600px"><%=note.getContent()%></textarea>

			</div>
			<div class="container text-center">
			<button type="submit" class="btn btn-success">Save</button>
			</div>
		</form>
	</div>
</body>
</html>