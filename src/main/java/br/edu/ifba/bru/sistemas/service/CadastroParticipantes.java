package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.Participantes;

public class CadastroParticipantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Participantes participantes;
	
	/*public CadastroParticipantes(Participantes participantes){
		this.pessoas = participantes;
	}*/
	
	@Transactional
	public void salvar(Participante participante) throws NegocioException {
		//regras de negócio ao adicioar pessoa (se houver)
		this.participantes.guardar(participante);
	}
	
	@Transactional
	public void excluir(Participante participante) throws NegocioException{
		participante = this.participantes.porId(participante.getId());
		
		this.participantes.remover(participante);
	}
}
