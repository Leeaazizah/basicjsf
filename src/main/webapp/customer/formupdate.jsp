<%@ page
    import="java.text.SimpleDateFormat, id.co.skyforce.basicjsf.domain.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<form action="update" method="post">
	
	<%
	Customer c = (Customer) request.getAttribute("customer");
	%>

	
	
					  <input type="hidden" name="id_customer" value=<%=c.getId()%> /><br>
	Nama Depan		: <input type="text" name="nama_depan" value="<% out.print(c.getFirstName()); %>"><br>
	Nama Belakang	: <input type="text" name="nama_belakang" value="<% out.print(c.getLastName()); %>"><br>
	Tanggal Lahir	: <input type="text" name="tanggal_lahir" value="<% out.print(c.getBirthDate()); %>"><br>
	No. Tlp. Rumah	: <input type="text" name="no_telp_rumah" value="<% out.print(c.getHomePhone()); %>"><br>
	No. Handphone	: <input type="text" name="no_handphone" value="<% out.print(c.getMobileNo()); %>" ><br>
	Email 			: <input type="text" name="email" value="<% out.print(c.getEmail()); %>"><br>
	Password 		: <input type="text" name="password" value="<% out.print(c.getPassword()); %> "><br>
	Alamat			: Jalan.    <input type="text" name="jalan" value="<% out.print(c.getAddress().getStreet()); %> "><br>
					  Kode Pos. <input type="text" name="kodepos" value="<% out.print(c.getAddress().getPostalCode()); %> "><br>
					  Kota.		<input type="text" name="kota" value="<% out.print(c.getAddress().getCity()); %> "><br>
		
	
	<button type="submit">Update</button>
	<input type="hidden" name="action" value="update">
	</form>

</body>
</html>