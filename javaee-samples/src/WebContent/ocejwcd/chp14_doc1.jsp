<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.1">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"
		session="true" import="java.util.*" />
	<jsp:output omit-xml-declaration="true" />
	<jsp:output doctype-root-element="html"
		doctype-system="about:legacy-compat" />
	<jsp:directive.include file="hello.txt" />
	<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HTML5</title>
</head>
<body>
	<h1>HTML5</h1>
	<h2>${"hi"}${6>3}</h2>
	<br /> ${pageContext.request.requestURL}

	<br /> ${pageContext.request.requestURI}
	<br /> ${pageContext.request.servletPath}
	<br /> ${pageContext.request.queryString}
	<br /> ${pageContext.request.contextPath}
	<br /> Session ID=> ${session}
	<br /> cookie ${cookie.containsKey("hi")}
	<br /> ${ "helloooooooooooooooooooooo"}
	<br /> ${not(requestScope.session)}
	<%-- 	<br /> ${not null} --%>
	<br />
	<jsp:scriptlet>session.getId();</jsp:scriptlet>
	<c:out value=""></c:out>
	<c:import url="http://google.com/k" />
	<jsp:text>
		<table>
			<tr>
				<td>hi</td>
				<td>hi</td>
			</tr>
		</table>
	</jsp:text>
	<input type="range"></input>
	<form>
		<p>
			<label> Customer name: <input type="text"></input>
			</label>
		</p>
		<fieldset>
			<legend> Pizza Size </legend>
			<p>
				<label> <input type="radio" name="size" /> Small
				</label>
			</p>
			<p>
				<label> <input type="radio" name="size" /> Large
				</label>
			</p>
		</fieldset>
	</form>
</body>
	</html>
</jsp:root>