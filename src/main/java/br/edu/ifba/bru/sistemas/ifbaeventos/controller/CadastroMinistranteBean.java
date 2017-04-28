package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;
import br.edu.ifba.bru.sistemas.service.CadastroMinistrantes;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class CadastroMinistranteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMinistrantes cadastro;
	
	private Ministrante ministrante;
	
	public void prepararCadastro(){
		if (this.ministrante == null){
			this.ministrante = new Ministrante();
		}
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.ministrante);
	
			context.addMessage(null, new FacesMessage(
					"Ministrante salvo com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Ministrante getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(Ministrante ministrante) {
		this.ministrante = ministrante;
	}
	
	

}
