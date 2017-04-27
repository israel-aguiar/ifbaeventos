package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.Transactional;
import br.edu.ifba.bru.sistemas.repository.Eventos;

public class CadastroEventoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Eventos eventos;
	
	@Transactional
	public void salvar(Evento evento) {
		this.eventos.guardar(evento);
	}
	
	@Transactional
	public void excluir(Evento evento) {
		this.eventos.remover(evento);
	}
	
	

}
