package com.hello.mvc03.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr());
		
		String uri = StringUtils.defaultString(req.getRequestURI());
		String url = StringUtils.defaultString(req.getRequestURL().toString());
		String queryString = StringUtils.defaultString(req.getQueryString());
		
		String referer = StringUtils.defaultString(req.getHeader("referer"));
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"));
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr)
		.append("\n")
		.append("uri : "+uri)
		.append("\n")
		.append("url : "+url)
		.append("\n")
		.append("queryString : "+queryString)
		.append("\n")
		.append("referer : "+referer)
		.append("\n")
		.append("agent : "+agent);
		
		logger.info("[LOG FILTER]" + sb.toString());
		
		// 00 뺏어서 조작하고 다시 보내주는 역할(주고받기)
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {

	}

}
