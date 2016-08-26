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
		action="https://www.googleapis.com/blogger/v3/blogs/1595984422812577917"
		method="get">
		<p>welcome ${token}</p>
	</form>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>