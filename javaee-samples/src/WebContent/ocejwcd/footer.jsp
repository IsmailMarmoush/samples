<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"
		session="false" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" />
	<c:forEach var="counter" begin="1" end="5">
		${counter }
		<jsp:scriptlet>out.println("hello footer&lt;br/&gt;");</jsp:scriptlet>
	</c:forEach>
	<c:out value="hello"></c:out>
	${hi}
	${firstName}
	aa
</jsp:root>