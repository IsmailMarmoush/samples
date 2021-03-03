<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	version="2.1">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" session="false" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="html" doctype-system="about:legacy-compat" />

	<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>CDATA and JSP:Text</title>
</head>
<body>
	<h1>CDATA and JSP:Text</h1>
	&lt;%= request.getAttribute("item") %&gt;
	<jsp:text>
		<![CDATA[<img src="]]>
	</jsp:text>
	<jsp:expression>"hawk.jpg"</jsp:expression>
	<jsp:text>
		<![CDATA[">]]>
	</jsp:text>
	<br />

	<jsp:text>
		<![CDATA[  &lt;![CDATA[hi]]&gt;]]>
		<![CDATA[ you're logged in  <jsp:expression>request</request> ]]>
	</jsp:text>
	
</body>
	</html>
</jsp:root>