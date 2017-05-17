package br.edu.ifba.bru.sistemas.ifbaeventos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifba.bru.sistemas.ifbaeventos.controller.ParticipanteAutenticacao;

//@WebFilter("/ext/*")
public class AltenticacaoParticipanteFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
		HttpSession httpSession 				= ((HttpServletRequest) request).getSession(); 
 
		HttpServletRequest httpServletRequest   = (HttpServletRequest) request;
 
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
 
//		if(httpServletRequest.getRequestURI().indexOf("index.xhtml") <= -1){
		if(httpServletRequest.getRequestURI().indexOf("/ext/login.xhtml") <= -1){
 
			ParticipanteAutenticacao usuarioModel =(ParticipanteAutenticacao) httpSession.getAttribute("participanteAutenticado");
 
			if(usuarioModel == null){
				
				System.out.println("usuario não autenticado");
 
//				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/index.xhtml");
//				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/ext/login.xhtml");

 
			}
			else{
 
				chain.doFilter(request, response);
			}
		}		
		else{
 
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
