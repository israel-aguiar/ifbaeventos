package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.Pessoa;
import service.CadastroPessoas;
import service.NegocioException;


//@ManagedBean
//@ViewScoped
@Named
@javax.faces.view.ViewScoped
public class CadastroPessoaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPessoas cadastro;
	
		
	private Pessoa pessoa;// = new Pessoa();
	
	public void prepararCadastro(){
		if (this.pessoa == null){
			this.pessoa = new Pessoa();
		}
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.pessoa);
			
			//this.pessoa = new Pessoa();
			context.addMessage(null, new FacesMessage(
					"Pessoa salva com sucesso!"));
		
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
}
