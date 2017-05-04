package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;
import br.edu.ifba.bru.sistemas.repository.Atividades;
import br.edu.ifba.bru.sistemas.service.CadastroAtividades;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class ConsultaAtividadesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAtividades cadastro;
	
	@Inject
	private Atividades atividadesRepository;
	
	private List<Atividade> atividades;
	private Atividade atividadeSelecionada;
	
	public void consultar(){
		this.atividades = atividadesRepository.todos();
	}
	
	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.atividadeSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Atividade excluída com sucesso!"));
		} catch (NegocioException e) {
		}
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

}
