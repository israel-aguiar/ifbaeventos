package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.Ministrantes;


public class CadastroMinistrantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Ministrantes ministrantes;
	
	@Transactional
	public void salvar(Ministrante ministrante) throws NegocioException {
		//regras de negócio ao adicioar ministrante (se houver)
		this.ministrantes.guardar(ministrante);
	}
	
	@Transactional
	public void excluir(Ministrante ministrante) throws NegocioException{
		ministrante = this.ministrantes.porId(ministrante.getId());
		
		this.ministrantes.remover(ministrante);
	}

}
