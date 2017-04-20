package br.edu.ifba.bru.sistemas.ifbaeventos.controller;
import java.io.Serializable;
import java.util.List;

import repository.Pessoas;
import service.CadastroPessoas;
import service.NegocioException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Pessoa;

//@ManagedBean
//@ViewScoped
@Named
@javax.faces.view.ViewScoped
public class ConsultaPessoasBean implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPessoas cadastro;
	
	@Inject
	private Pessoas pessoasRepository;
	
	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	
	public void consultar() {
		
		this.pessoas = pessoasRepository.todos();
		
	}
			
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.pessoaSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
		}
	}


}
