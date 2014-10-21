<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
	<form action="delete" method="post">
	<input type="hidden" name="action" value="delete">
	Id Customer		: <input type="text" name="id_customer" ><br>
	<button type="submit">Delete</button>
	</form>

</body>
</html>