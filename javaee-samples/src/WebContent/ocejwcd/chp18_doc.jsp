<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:sm="/WEB-INF/simple.tld" xmlns:cl="/WEB-INF/classic.tld" version="2.0">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
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
	<jsp:include page="hello.txt" flush="false"/> 
	<%! int k;
	
	%>
	<h1>Classic Custom Tags</h1>
	<!--  This has unpredicted output due to jsp:root -->
	<!-- ${cl:hi()} -->
	
	<p>
		The conditional tag:
		<cl:MyConditionalTag test="${200>300 }"> this is the body</cl:MyConditionalTag>
	</p>
	<p>
		The for tag:
		<cl:MyForTag end="5" start="1" var="counter">hello ${counter} </cl:MyForTag>
	</p>
	<p>
		The select country tag:
		<cl:selectCountryTag select="EG" lang="fr" />
	</p>
	<p>
		The Body Tag
		<cl:MyBodyTag>hello this is ismail</cl:MyBodyTag>
	</p>

	<h1>Simple Custom Tags</h1>
	<sm:Hello />
</body>
	</html>
</jsp:root>