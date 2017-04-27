package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.TipoAtividades;

public class CadastroTipoAtividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoAtividades tipoAtividades;
	
	@Transactional
	public void salvar(TipoAtividade tipoAtividade) throws NegocioException{
		//Regras de negócio
		this.tipoAtividades.guardar(tipoAtividade);
	}
	
	@Transactional
	public void excluir(TipoAtividade tipoAtividade) throws NegocioException{
		tipoAtividade = this.tipoAtividades.porId(tipoAtividade.getId());
		
		this.tipoAtividades.remover(tipoAtividade);
	}
	
}
