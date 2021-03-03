<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"
		session="false" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" />
	<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Chapter 16</title>
</head>
<body>
	<h1>Hello chapter 16</h1>
	<jsp:useBean id="chp16Bean" scope="page"
		class="com.marmoush.javaexamples.ocejwcd.chp16.Chp16Bean">
		<jsp:setProperty name="chp16Bean" property="firstName" value="ismail" />
		helloooooooooooo
	</jsp:useBean>
	 
	<jsp:getProperty name="chp16Bean" property="firstName" /><br />
	<jsp:directive.include file="footer.html" />
	<jsp:include page="footer.jsp">
		<jsp:param name="firstName" value="marmoush" />
	</jsp:include>
</body>
	</html>
</jsp:root>