<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page
    import="java.util.List, java.text.SimpleDateFormat, id.co.skyforce.basicjsf.domain.*"%>
    
    
<!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<form action="save" method="post">
	<pre>
	<input type="hidden" name="action" value="save">
	Nama Depan		: <input type="text" name="nama_depan" ><br>
	Nama Belakang	: <input type="text" name="nama_belakang" ><br>
	Tanggal Lahir	: <input type="text" name="tanggal_lahir" ><br>
	No. Tlp. Rumah	: <input type="text" name="no_telp_rumah" ><br>
	No. Handphone	: <input type="text" name="no_handphone" ><br>
	Email 			: <input type="text" name="email" ><br>
	password 		: <input type="text" name="password" ><br>
	Alamat			: Jalan.    <input type="text" name="jalan" ><br>
					  Kode Pos. <input type="text" name="kodepos" ><br>
					  Kota.		<input type="text" name="kota" ><br>
					  
	<button type="submit">Save</button>

	</form>

</body>
</html>