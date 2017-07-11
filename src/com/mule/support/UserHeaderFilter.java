package com.mule.support;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class UserHeaderFilter implements Filter {
  FilterConfig fc;
  public static String USER_NAME = "username";
  public void doFilter(ServletRequest req,
                       ServletResponse res,
                       FilterChain chain)
                       throws IOException,
                              ServletException {
    HttpServletResponse response =
      (HttpServletResponse) res;
    // set the provided HTTP response parameters
    for (@SuppressWarnings("rawtypes")
	Enumeration e=fc.getInitParameterNames();
        e.hasMoreElements();) {
      String headerName = (String)e.nextElement();
      response.addHeader(headerName,
    		  USER_NAME);
    }
    // pass the request/response on
    chain.doFilter(req, response);
  }
  public void init(FilterConfig filterConfig) {
    this.fc = filterConfig;
  }
  public void destroy() {
    this.fc = null;
  }
}
