<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Test Application</title>
<link href="./css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<form
		action="https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/blogger&state=security_token12345678&redirect_uri=http://localhost:8080/test2&response_type=code&client_id=487338188162-86agt5l55fj630qomutjh430b9vjl2ek.apps.googleusercontent.com"
		method="post">
		<div id="container">
			<div id="description" align="left">${testDesc}</div>
			<div align="right">
				<table>
					<tr>
						<td>Username :</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>
					</tr>
					<tr>
						<td><p color="red">${errorMessage}</p></td>

					</tr>
				</table>
			</div>
		</div>
	</form>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>