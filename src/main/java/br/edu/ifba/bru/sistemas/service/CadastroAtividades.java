package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.Atividades;

public class CadastroAtividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Atividades atividades;
	
	@Transactional
	public void salvar(Atividade atividade) throws NegocioException{
		//regras de negócio ao adicioar atividade (se houver)
		this.atividades.guardar(atividade);
	}
	
	@Transactional
	public void excluir(Atividade atividade) throws NegocioException{
		atividade = this.atividades.porId(atividade.getId());
		
		this.atividades.remover(atividade);
	}

}
