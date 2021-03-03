<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chapter 17</title>
</head>
<body>
	<%
		pageContext.setAttribute("myXMLVariable", "<img src=\"hawk.jpg\"> ");
		request.setAttribute("theException", new Exception("mymessage"));
	%>
	<br /> ${myXMLVariable}
	<br />
	<c:catch>
	<%int i =1; %>
	<%= 100/(i-1) %>
	</c:catch>
	${theException}
	<br/>
	<c:forTokens items="hi;hello;cool;blabla" delims=";" var="words"  varStatus="varStatus"> 
		${varStatus.index} ${words} <br/>
		
	</c:forTokens>
	<c:out value="${myXMLVariable}" />
	<br/>
	<c:out value="3 > 2" />
</body>
</html>
