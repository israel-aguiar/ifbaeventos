package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;
import br.edu.ifba.bru.sistemas.repository.TipoAtividades;
import br.edu.ifba.bru.sistemas.service.CadastroTipoAtividades;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@ViewScoped
public class ConsultaTipoAtividadesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTipoAtividades cadastro;
	
	@Inject
	private TipoAtividades tipoAtividadesRepository;
	
	private List<TipoAtividade> tipoAtividades;
	private TipoAtividade tipoAtividadeSelecionada;
	
	public void consultar(){
		this.tipoAtividades = tipoAtividadesRepository.todos();
	}
	
	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			this.cadastro.excluir(this.tipoAtividadeSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Tipo de Atividade excluída com sucesso!"));
		}catch (NegocioException e){
			
		}
	}

	public List<TipoAtividade> getTipoAtividades() {
		return tipoAtividades;
	}

	public void setTipoAtividadeSelecionada(TipoAtividade tipoAtividadeSelecionada) {
		this.tipoAtividadeSelecionada = tipoAtividadeSelecionada;
	}
	
	
}
