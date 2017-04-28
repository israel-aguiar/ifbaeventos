package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;

public class Ministrantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public Ministrantes(EntityManager manager) {
		this.manager = manager;
	}
	
	public Ministrante porId(Long id){
		return this.manager.find(Ministrante.class, id);
	}
	
	public List<Ministrante> todos(){
		TypedQuery<Ministrante> query = this.manager.createQuery(
				"from Ministrante", Ministrante.class);
		return query.getResultList();
	}
	
	public void guardar(Ministrante ministrante){
		this.manager.merge(ministrante);
	}
	
	public void remover(Ministrante ministrante){
		this.manager.remove(ministrante);
	}
}
