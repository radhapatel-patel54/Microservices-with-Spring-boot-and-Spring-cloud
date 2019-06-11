package com.learning.microservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFIlter extends ZuulFilter {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		// write logic on which condition filter should be executed
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	HttpServletRequest request =	RequestContext.getCurrentContext().getRequest();
	logger.info("request -> {} request URI-> {}", request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
//		return "pre";
//		return "post";
//		return "error";
		return "pre";
	}

	@Override
	public int filterOrder() {
//		return 2;
//		return 3;
		return 1;
	}

}
