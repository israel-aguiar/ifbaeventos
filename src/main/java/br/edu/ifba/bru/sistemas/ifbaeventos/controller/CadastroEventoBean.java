package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;
import br.edu.ifba.bru.sistemas.repository.Organizadores;
import br.edu.ifba.bru.sistemas.service.CadastroEventos;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@ViewScoped
public class CadastroEventoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroEventos cadastro;
	
	@Inject
	private Organizadores organizadoresRepository;
	
	private Evento evento;
	
	private List<Organizador> organizadores; 
	
	public void prepararCadastro(){
		if (this.evento == null){
			this.evento = new Evento();
		}
		
		organizadores = organizadoresRepository.todos();
		
		System.out.println(organizadores.size());
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.evento);
			
			//this.pessoa = new Participante();
			context.addMessage(null, new FacesMessage(
					"Evento salvo com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Organizador> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(List<Organizador> organizadores) {
		this.organizadores = organizadores;
	}


}
