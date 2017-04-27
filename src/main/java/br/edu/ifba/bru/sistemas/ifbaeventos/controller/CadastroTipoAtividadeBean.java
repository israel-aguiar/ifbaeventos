package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;
import br.edu.ifba.bru.sistemas.service.CadastroTipoAtividades;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class CadastroTipoAtividadeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTipoAtividades cadastro;
	
	private TipoAtividade tipoAtividade;
	
	public void prepararCadastro(){
		if (this.tipoAtividade == null){
			this.tipoAtividade = new TipoAtividade();
		}
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.tipoAtividade);
			
			context.addMessage(null, new FacesMessage(
					"Tipo de atividade salva com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

}
