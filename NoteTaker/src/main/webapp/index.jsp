<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<title>NoteTaker:Home</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@include file="navbar.jsp"%>
		<br>
		<div class="card my-5">
			<img alt="" class="img-fluid mx-auto" style="max-width: 300px;"
				src="img/note.png"/>
			<h1 class="text-primary text-uppercase text-center mt-3">
				<b>Note Taker</b>
			</h1>
			<h6>Note Taker is place where you can write and store your notes ,and whenever you need 
			. you can also retrive your notes very easly.It have feature to delete and update your saved note also. :) </h6>
			<div class="container text-light text-center">
				<button class="btn btn-outline-primary"><a href="http://localhost:8081/NoteTaker/add_note.jsp">Start Here</a></button>
			</div>
		</div>
	</div>
</body>
</html>