package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;
import br.edu.ifba.bru.sistemas.service.CadastroOrganizadores;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@ViewScoped
public class CadastroOrganizadorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroOrganizadores cadastro;
	
	private Organizador organizador;
	
	public void prepararCadastro() {
		if(organizador == null)
			organizador = new Organizador();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.organizador);
			
			context.addMessage(null, new FacesMessage(
					"Organizador salvo com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}
}
