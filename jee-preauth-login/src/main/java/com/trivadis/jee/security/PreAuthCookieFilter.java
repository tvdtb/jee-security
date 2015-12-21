package com.trivadis.jee.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/index.jsp"} )
public class PreAuthCookieFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)res;
		HttpServletRequest request = (HttpServletRequest) req;
		
		chain.doFilter(req, res);
		
		int status = response.getStatus();
		if ("GET".equals(request.getMethod()) && status==200) {
			Cookie cookie = new Cookie("auth", request.getRemoteUser());
			cookie.setHttpOnly(true); // no script access
			cookie.setPath("/"); // for all apps
			response.addCookie(cookie);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
