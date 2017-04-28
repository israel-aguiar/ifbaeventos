package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;
import br.edu.ifba.bru.sistemas.repository.Organizadores;
import br.edu.ifba.bru.sistemas.service.CadastroOrganizadores;
import br.edu.ifba.bru.sistemas.service.NegocioException;

@Named
@ViewScoped
public class ConsultaOrganizadoresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroOrganizadores cadastro;
	
	@Inject
	private Organizadores organizadoresRepository;
	
	private Organizador organizador;
	
	private List<Organizador> organizadores;
	
	private Organizador organizadorSelecionado;
	
	
	
	public void consultar() {
		this.organizadores = organizadoresRepository.todos();
	}
	
	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();

		try{
			this.cadastro.excluir(this.organizadorSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Organizador excluído com sucesso!"));
		} catch (NegocioException e) {
		}
	}

	public Organizador getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}

	public List<Organizador> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(List<Organizador> organizadores) {
		this.organizadores = organizadores;
	}

	public Organizador getOrganizadorSelecionado() {
		return organizadorSelecionado;
	}

	public void setOrganizadorSelecionado(Organizador organizadorSelecionado) {
		this.organizadorSelecionado = organizadorSelecionado;
	}
}
