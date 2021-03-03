package com.marmoush.javaexamples.ocejwcd.chp22;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.http.HttpServlet;

@ServletSecurity(
    value = @HttpConstraint(
	value = EmptyRoleSemantic.DENY),
    httpMethodConstraints = { @HttpMethodConstraint(
	value = "GET") })
public class ServletSecurityCheck extends HttpServlet {

    private static final long serialVersionUID = -4565620609335288477L;

}
