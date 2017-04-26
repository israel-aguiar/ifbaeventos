package br.edu.ifba.bru.sistemas.ifbaeventos.controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.repository.Participantes;
import br.edu.ifba.bru.sistemas.service.CadastroParticipantes;
import br.edu.ifba.bru.sistemas.service.NegocioException;

//@ManagedBean
//@ViewScoped
@Named
@javax.faces.view.ViewScoped
public class ConsultaParticipantesBean implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroParticipantes cadastro;
	
	@Inject
	private Participantes participantesRepository;
	
	private List<Participante> participantes;
	private Participante participanteSelecionado;
	
	public void consultar() {
		
		this.participantes = participantesRepository.todos();
		
	}
			
	public List<Participante> getParticipantes() {
		return participantes;
	}
	
	
	public void setParticipanteSelecionado(Participante pessoaSelecionada) {
		this.participanteSelecionado = pessoaSelecionada;
	}

	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.participanteSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
		}
	}


}
