package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;

public class Eventos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	@Inject
	public Eventos(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Evento porId(Long id) {
		return entityManager.find(Evento.class, id);
	}
	
	public List<Evento> todos() {
		TypedQuery<Evento> query = entityManager.createQuery("from Evento", Evento.class);
		return query.getResultList();
	}
	
	public void guardar(Evento evento) {
		entityManager.merge(evento);
	}
	
	public void remover(Evento evento) {
		entityManager.remove(evento);
	}

}
