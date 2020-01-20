<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h2>Create</h2>
	<form action="CreateServlet" method="post" class="form-group">
		<p>
			<label for="txtProduct">Product:</label>
			<input type="text" name="txtProduct" id="txtProduct" required class="form-control">
		</p>
		<p>
			<label for="txtProductName">Product Name:</label>
			<input type="text" name="txtProductName" id="txtProductName" required class="form-control">
		</p>
		<p>
			<label for="txtProductPrice">Product Price:</label>
			<input type="text" name="txtProductPrice" id="txtProductPrice" required class="form-control">
		</p>
		<p>
			<input type="submit" value="Add" class="btn btn-success">
		</p>
	</form>
	<a href="index.jsp"><input type="button" value="Return" class="btn btn-link"></a>	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>