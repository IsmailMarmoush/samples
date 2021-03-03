<%@page import="java.util.HashSet, java.util.*"%>
<%@page import="java.util.Set"%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="hello.txt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Tutorial: Hello Dojo!</title>
</head>
<body>
	${pageContext.request.remoteAddr}
	<h1 id="greeting">Hello ${"hello" }</h1>
	<!-- <a> -- hello</a>-->
	\${pageContext.request.remoteAddr} = ${pageContext.request.remoteAddr}
	<br /> \${request.remoteAddr} = ${request.remoteAddr}
	<%-- <%=session.getAttribute("userid")%> --%>
	 <jsp:scriptlet>ArrayList cities = new ArrayList();
	    cities.add("NYC");
	    cities.add("SFO");
	    pageContext.setAttribute("cities", cities, PageContext.PAGE_SCOPE);</jsp:scriptlet>
	<select name="cities">             
		<c:forEach var="city" items="${cities}">
			<option>${city}</option>
		</c:forEach>         
	</select>
	<table>
		<%
		    Set aSet = new HashSet();
		    aSet.add("hello1");
		    aSet.add("hello2");
		    aSet.add("hello3");
		    Iterator it = aSet.iterator();
		    int i = 0;
		    while (it.hasNext()) {
				out.println("<tr><td>" + (++i) + "</td>");
				out.println("<td>" + it.next() + "</td></tr>");

		    }
		%>
		  
	</table>

	<%!int num;
    boolean state = true;

    public void jspInit() {
	num = 20;

    }

    public void hi() {
	log("hi function");
    }%>
	<%
	    pageContext.setAttribute("myXMLVariable", "<img src=\"hawk.jpg\" ");
	%>
	<br /> ${myXMLVariable }
	<br />
	<c:out value="${myXMLVariable }" />
	<%
	    this.hi();
	    if (state) {
	%>
	<%
	    } else {
			//pageContext.include(...)
	%>
	no
	<%
	    }
	%>
	<table border="1">
		<tr>
			<%=""%>
			<%=num + 6 + "<h1> hello from expression</h1>"%>

			<td>d</td>
		</tr>
	</table>
</body>
</html>
