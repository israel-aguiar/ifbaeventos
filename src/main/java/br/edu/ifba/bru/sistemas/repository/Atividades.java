package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;

public class Atividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public Atividades(EntityManager manager) {
		this.manager = manager;
	}
	
	public Atividade porId(Long id){
		return this.manager.find(Atividade.class, id);
	}
	
	public List<Atividade> todos(){
		TypedQuery<Atividade> query = this.manager.createQuery(
				"from Atividade", Atividade.class);
		return query.getResultList();
	}
	
	public void guardar(Atividade atividade){
		this.manager.merge(atividade);
	}
	
	public void remover(Atividade atividade){
		this.manager.remove(atividade);
	}

}
