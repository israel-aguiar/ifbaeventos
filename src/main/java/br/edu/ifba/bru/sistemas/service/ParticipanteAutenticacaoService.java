package br.edu.ifba.bru.sistemas.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifba.bru.sistemas.ifbaeventos.controller.ParticipanteAutenticacao;
import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;

public class ParticipanteAutenticacaoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EntityManager entityManager;
	
	public Participante validaUsuario(ParticipanteAutenticacao usuarioModel){
		 
		try {
 
			Query query = entityManager.createNamedQuery("Participante.findParticipante");
 
			query.setParameter("cpf", usuarioModel.getCpf());
			query.setParameter("senha", usuarioModel.getSenha());
 
			return (Participante)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
	
	

}
