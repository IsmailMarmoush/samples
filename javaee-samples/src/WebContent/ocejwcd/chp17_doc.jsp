<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">
	
	
	
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"
		session="false" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" />
		
		
	<html  xmlns:c="http://java.sun.com/jsp/jstl/core" >
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Chapter 17</title>
</head>
<body>

	<jsp:text>
		<![CDATA[img src=><>.,</.>\][]]]>
	</jsp:text>
	<jsp:expression>"hawk.jpg"</jsp:expression>
	<c:out escapeXml="true" value="welcome xml  saf> "> default value c:out</c:out>
	<br />
	<c:out value="${counter}"> default value c:out</c:out>
	<c:url value="/chp16 .jsp">
		<c:param name="paramname" value="paramvalue"></c:param>
	</c:url>
</body>
	</html>
</jsp:root>