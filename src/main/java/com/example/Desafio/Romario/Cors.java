package com.example.Desafio.Romario;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)

public class Cors implements Filter{


	private static final String PREFLIGHT_REQUEST_METHOD = "OPTIONS";
	private static final String origin ="*";
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Credentials", "true");

		if (isPreFlightRequestFromAllowedOrigin(request)) {
			// Consider HTTP Status 200 OK for all pre flight requests
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, PATCH, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers", "*");
		//	response.setHeader("Access-Control-Allow-Headers", "Accept, Origin, Content-Type, X-Auth-Token");
//			response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			response.setHeader("Access-Control-Allow-Max-Age", "3600");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// Now let spring security take care of the request
			chain.doFilter(request, response);
		}
	}
	
	private boolean isPreFlightRequestFromAllowedOrigin(HttpServletRequest request) {

		boolean trustedOrigin = origin.equals("*");
		boolean preflightRequest = PREFLIGHT_REQUEST_METHOD.equals(request.getMethod());

		return trustedOrigin && preflightRequest;
	}


}

