<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>This is a JSP Page</title>
</head>
<body>
Hello!
<p>
   Today's date: <%= (new java.util.Date()).toString()%>
</p>
</body>
</html>