<myjsp:root xmlns:myjsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt" xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	version="2.1">

	<myjsp:directive.page contentType="text/html" pageEncoding="UTF-8" session="false" />
	
	<myjsp:output omit-xml-declaration="true" />
	<myjsp:output doctype-root-element="html" doctype-system="about:legacy-compat" />
	
	<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>CDATA and JSP:Text</title>
</head>
<body>
	<myjsp:directive.include file="footer.jsp"/>
	<br />
	<p>'\${"hi" } \${"hi" }' == >'${"hi" } ${"hi" }'</p>
	<p>\${"hi" } \${"hi" } == >${"hi" } ${"hi" }</p>
	<br />
	<!-- gives 106 -->
	<br />\${"103"+3 }==> ${"103"+3 }

	<br />\${requestScope[null] } =>> { ${requestScope[null] } } gives null >> then empty string
	<br />\${requestScope.hello} =>> { ${requestScope.hello} } gives null >> then empty string
	<br />\${sessionScopeBla.hello} =>> { ${sessionScopeBla.hello} } gives error
	<br />
	<br />\${paramValues.options[0]} => ${paramValues.options[0]}
	<br />\${paramValues.options["0"]} => ${paramValues.options["0"]}
	<br />\${paramValues.options[1]} => ${paramValues.options[1]}
</body>
	</html>
</myjsp:root>