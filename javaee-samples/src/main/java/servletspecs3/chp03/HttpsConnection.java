package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.cert.X509Certificate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "httpsconnection", urlPatterns = { "/servletspecs3/chp03/httpsconnection" })
public class HttpsConnection extends HttpServlet {

    private static final long serialVersionUID = 642314667003901021L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	PrintWriter out = resp.getWriter();

	if (req.isSecure()) {
	    out.println("is secure");
	    out.println("The SSL attributes");
	    out.println("cipher suite: "
		    + req.getAttribute("javax.servlet.request.cipher_suite"));
	    out.println("key size: "
		    + req.getAttribute("javax.servlet.request.key_size"));
	    out.println("ssl session id:"
		    + req.getAttribute("javax.servlet.request.ssl_session_id"));

	    // certificate from user
	    X509Certificate certChain[] = (X509Certificate[]) req
		    .getAttribute("javax.servlet.request.X509Certificate");
	    if (certChain != null) {
		for (int i = 0; i < certChain.length; i++) {
		    System.out.println("Client Certificate [" + i + "] = "
			    + certChain[i].toString());
		}
	    }
	    out.println("certificate: "
		    + req.getAttribute("javax.servlet.request.X509Certificate"));
	} else {
	    out.println("not secure");
	}

    }

    // public void doFilter(ServletRequest request, ServletResponse response,
    // FilterChain chain) throws IOException, ServletException {
    // HttpServletRequest httpRequest = (HttpServletRequest) request;
    // HttpServletResponse httpResponse = (HttpServletResponse) response;
    // // if the scheme is not https
    // if (!request.isSecure()) {
    // // generate full url to https
    // StringBuilder newUrl = new StringBuilder("https://");
    // newUrl.append(request.getServerName());
    // if (httpRequest.getRequestURI() != null) {
    // newUrl.append(httpRequest.getRequestURI());
    // }
    // if (httpRequest.getQueryString() != null) {
    // newUrl.append("?").append(httpRequest.getQueryString());
    // }
    // httpResponse.sendRedirect(newUrl.toString());
    // } else {
    // // already a secure connection no redirect to https required
    // if (chain != null) {
    // chain.doFilter(request, response);
    // }
    // }
    //
    // }
    //
    // @Override
    // public void init(FilterConfig arg0) throws ServletException {
    //
    //
    // }
}
