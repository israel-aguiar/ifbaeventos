package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;

public class Participantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public Participantes(EntityManager manager){
		this.manager = manager;
	}
	
	public Participante porId(Long id){
		return manager.find(Participante.class, id);
	}
	
	public List<Participante> todos(){
		TypedQuery<Participante> query = manager.createQuery(
				"from Participante", Participante.class);
		return query.getResultList();
	}
	
	public void guardar(Participante participante){
		this.manager.merge(participante);
	}
	
	public void remover(Participante participante){
		this.manager.remove(participante);
	}

}
