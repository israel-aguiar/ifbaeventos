package br.edu.ifba.bru.sistemas.ifbaeventos.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter {
	
	@Inject
	private EntityManager entityManager;

	public JPAFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setAttribute("entityManager", entityManager);

		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
