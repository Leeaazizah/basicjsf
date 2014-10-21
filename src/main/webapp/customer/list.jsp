<%@ page import="java.util.List, java.text.SimpleDateFormat, id.co.skyforce.basicjsf.domain.*"%>

<%@ page import ="org.hibernate.Query"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customer</title>
</head>
<body>
	<h3><center>List Customer</center></h3><br>
	<form>
		<table border="1" style="width: 100%">
			<center><tr>
				<th>Id Customer</th>
				<th>Name</th>
				<th>Email</th>
				<th>Birthday Date</th>
				<th>Action</th>
			</tr>
			
			

			<%
			SimpleDateFormat sdf = (SimpleDateFormat) request.getAttribute("formatter");
			List<Customer> customerList = (List<Customer>) request.getAttribute("customer");
			for (Customer cust : customerList){
			%>
			
			
			<tr>
			<td> <% out.print(cust.getId()); %></td>
			<td> <% out.print(cust.getFirstName());%> <% %> 
				 <% out.print(cust.getLastName()); %></td>
			<td> <% out.print(cust.getEmail()); %></td>
			<td> <% out.print(sdf.format(cust.getBirthDate())); %></td>
			<td> <% out.print("<a href=\"http://localhost:8080/basicjsf/customer/list?action=update&user="+cust.getId()+"\">Edit</a>") ;%> <%     %> 
			<% out.print("<a href=\"http://localhost:8080/basicjsf/customer/list?action=delete&user="+cust.getId()+"\">Delete</a>") ;%></td>
			
			 
			</tr>
			
			
			<%
			}
			%>
			

		</table><br>
		<center><a href="formadd.jsp">Add New Customer</a></center>
	</form>

</body>
</html>