package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;
import br.edu.ifba.bru.sistemas.repository.Eventos;
import br.edu.ifba.bru.sistemas.repository.Ministrantes;
import br.edu.ifba.bru.sistemas.repository.TipoAtividades;
import br.edu.ifba.bru.sistemas.service.CadastroAtividades;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class CadastroAtividadeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroAtividades cadastro;
	
	@Inject
	private Eventos eventosRepositoy;
	
	@Inject
	private Ministrantes ministrantesRepository;
	
	@Inject
	private TipoAtividades tipoAtividadesRepository;
	
	private Atividade atividade;
	
	private List<Evento> todosEventos;
	private List<Ministrante> todosMinistrantes;
	private List<TipoAtividade> todosTiposAtividades;
	
	
	public void prepararCadastro(){
		
		this.todosEventos = eventosRepositoy.todos(); 
		this.todosMinistrantes = ministrantesRepository.todos();
		this.todosTiposAtividades = tipoAtividadesRepository.todos();
		
		if (this.atividade == null){
			this.atividade = new Atividade();
		}
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			this.cadastro.salvar(this.atividade);
			context.addMessage(null, new FacesMessage(
					"Atividade salva com sucesso!"));
		}catch(NegocioException e){
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<Evento> getTodosEventos() {
		return todosEventos;
	}

	public List<Ministrante> getTodosMinistrantes() {
		return todosMinistrantes;
	}

	public List<TipoAtividade> getTodosTiposAtividades() {
		return todosTiposAtividades;
	}

}
