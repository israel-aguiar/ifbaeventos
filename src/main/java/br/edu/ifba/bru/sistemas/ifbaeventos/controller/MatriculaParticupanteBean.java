package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.repository.Participantes;

@Named
@ViewScoped
public class MatriculaParticupanteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Participantes participantes;
	
	private Participante participante;
		
	private List<Atividade> atividades;
	
	private List<Atividade> atividadesSelecionadas;
	
	@PostConstruct
	public void init() {
		atividadesSelecionadas = new ArrayList<>();
		atividades = new ArrayList<>();
		
		Atividade atividade1 = new Atividade();
		atividade1.setTitulo("Redes");
		atividade1.setCodigo("R1");
		atividade1.setId(1l);

		Atividade atividade2 = new Atividade();
		atividade2.setTitulo("Redes");
		atividade2.setCodigo("R2");
		atividade2.setId(2l);

		Atividade atividade3 = new Atividade();
		atividade3.setTitulo("Programação");
		atividade3.setCodigo("P1");
		atividade3.setId(3l);

		Atividade atividade4 = new Atividade();
		atividade4.setTitulo("Banco de Dados");
		atividade4.setCodigo("B1");
		atividade4.setId(4l);
		
		atividades.add(atividade1);
		atividades.add(atividade2);
		atividades.add(atividade3);
		atividades.add(atividade4);
	}
	
	public String salvar() {
		System.out.println(atividadesSelecionadas.size());
		
		atividadesSelecionadas.stream().forEach(atv -> System.out.printf("%s - %s\n", atv.getId(), atv.getTitulo()));
//		return "matricula_atividades";
		return null;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Atividade> getAtividadesSelecionadas() {
		return atividadesSelecionadas;
	}

	public void setAtividadesSelecionadas(List<Atividade> atividadesSelecionadas) {
		this.atividadesSelecionadas = atividadesSelecionadas;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}


}
