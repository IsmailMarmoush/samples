<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>SHOUT-OUT!</h1>
	<form method="POST" action="shoutservlet">
		<table>
			<tr>
				<td>Your name:</td>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>Your shout:</td>
				<td><input type="text" id="message" name="message" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SHOUT" /></td>
			</tr>
		</table>
	</form>
	<h2>Current Shouts</h2>
	<div id="content">
		<%
			if (application.getAttribute("messages") != null) {
		%>
		<%=application.getAttribute("messages")%>
		<%
			}
		%>
	</div>
</body>
</html>