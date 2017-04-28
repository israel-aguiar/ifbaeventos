package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;

public class Organizadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	@Inject
	public Organizadores(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Organizador porId(Long id) {
		return entityManager.find(Organizador.class, id);
	}
	
	public List<Organizador> todos(){
		TypedQuery<Organizador> query = entityManager.createQuery(
				"from Organizador", Organizador.class);
		return query.getResultList();
	}
	
	public void guardar(Organizador organizador){
		this.entityManager.merge(organizador);
	}
	
	public void remover(Organizador organizador){
		this.entityManager.remove(organizador);
	}
	
}
