<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" />

	<jsp:output doctype-root-element="html" doctype-system="" omit-xml-declaration="true" />
	<html>
<head>
<title>Insert title here</title>
</head>
<body>
	hello world
	<jsp:include page="footer.jsp" />

	<br />\${requestScope[null] } =>> { ${requestScope[null] } } gives null >> then empty string
	<br />\${requestScope.hello} =>> { ${requestScope.hello} } gives null >> then empty string
	<br />\${sessionScopeBla.hello} =>> { ${sessionScopeBla.hello} } gives error

</body>
	</html>
</jsp:root>