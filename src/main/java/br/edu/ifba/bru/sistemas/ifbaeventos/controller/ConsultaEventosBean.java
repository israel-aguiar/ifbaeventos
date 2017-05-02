package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;
import br.edu.ifba.bru.sistemas.repository.Eventos;
import br.edu.ifba.bru.sistemas.service.CadastroEventos;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@ViewScoped
public class ConsultaEventosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroEventos cadastro;
	
	@Inject
	private Eventos eventosRepository;
	
	private Evento evento;
	
	private List<Evento> eventos;
	
	private Evento eventoSelecionado;
	
	
	
	public void consultar() {
		this.eventos = eventosRepository.todos();
	}
	
	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.eventoSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Evento excluído com sucesso!"));
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEventoSelecionado() {
		return eventoSelecionado;
	}

	public void setEventoSelecionado(Evento eventoSelecionado) {
		this.eventoSelecionado = eventoSelecionado;
	}


}
