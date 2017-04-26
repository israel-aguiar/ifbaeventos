package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.service.CadastroParticipantes;
import br.edu.ifba.bru.sistemas.service.NegocioException;


//@ManagedBean
//@ViewScoped
@Named
@javax.faces.view.ViewScoped
public class CadastroParticipanteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroParticipantes cadastro;
	
		
	private Participante participante;// = new Participante();
	
	public void prepararCadastro(){
		if (this.participante == null){
			this.participante = new Participante();
		}
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.participante);
			
			//this.pessoa = new Participante();
			context.addMessage(null, new FacesMessage(
					"Participante salvo com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	
}
