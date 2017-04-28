package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.Organizadores;

public class CadastroOrganizadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Organizadores organizadores;
	
	@Transactional
	public void salvar(Organizador organizador) throws NegocioException {
		this.organizadores.guardar(organizador);
	}
	
	@Transactional
	public void excluir(Organizador organizador) throws NegocioException{
		organizador = this.organizadores.porId(organizador.getId());
		this.organizadores.remover(organizador);
	}


}
