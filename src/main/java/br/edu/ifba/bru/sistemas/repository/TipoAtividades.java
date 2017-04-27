package br.edu.ifba.bru.sistemas.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;

public class TipoAtividades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	@Inject
	public TipoAtividades(EntityManager manager){
		this.manager = manager;
	}
	
	public TipoAtividade porId(Long id){
		return manager.find(TipoAtividade.class, id);
	}
	
	public List<TipoAtividade> todos(){
		TypedQuery<TipoAtividade> query = manager.createQuery("from TipoAtividade", TipoAtividade.class);
		return query.getResultList();
	}
	
	public void guardar(TipoAtividade tipoAtividade){
		this.manager.merge(tipoAtividade);
	}
	
	public void remover(TipoAtividade tipoAtividade){
		this.manager.remove(tipoAtividade);
	}

}
