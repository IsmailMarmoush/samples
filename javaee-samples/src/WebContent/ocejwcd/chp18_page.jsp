<%@ taglib prefix="cl" uri="/WEB-INF/classic.tld"%>
<%@ taglib prefix='sm' uri='/WEB-INF/simple.tld'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Custom Tags</title>
</head>
<body>
	
	<h1>Classic Custom Tags</h1>
	${cl:hi()}
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
	<p>
		The conditional tag with fragment attribute:
		<sm:MyConditionalTag test="${20<300 }">
			<jsp:attribute name="frag">
				<p>hello from fragment </p>
			</jsp:attribute>
			<jsp:body>
				<p>hello from the body</p>
			</jsp:body>
		</sm:MyConditionalTag>
	</p>
	<h1>Synchronization problem with Scoped variables</h1>
	
	
</body>
</html>