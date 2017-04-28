package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;
import br.edu.ifba.bru.sistemas.repository.Ministrantes;
import br.edu.ifba.bru.sistemas.service.CadastroMinistrantes;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class ConsultaMinistrantesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMinistrantes cadastro;
	
	@Inject
	private Ministrantes ministrantesRepository;
	
	private List<Ministrante> ministrantes;
	private Ministrante ministranteSelecionado;
	
	public void consultar() {
		this.ministrantes = ministrantesRepository.todos();
	}
			
		
	public List<Ministrante> getMinistrantes() {
		return ministrantes;
	}


	public void setMinistranteSelecionado(Ministrante ministranteSelecionado) {
		this.ministranteSelecionado = ministranteSelecionado;
	}

	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.ministranteSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Ministrante excluído com sucesso!"));
		} catch (NegocioException e) {
		}
	}


}
