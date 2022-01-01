<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<br>
		<h3>Add Your Note Here</h3>
		<br>
		
		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Title</label> <input name="title" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter Here"/> 
			</div>
			<div class="form-group">
				<label for="content">Note</label> 
				<textarea name="content" required="required" id="note" placeholder="Write Note" class="form-control"style="hight:600px"></textarea>
				
			</div>
			<div class="container text-center">
			<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
	</div>
</body>
</html>