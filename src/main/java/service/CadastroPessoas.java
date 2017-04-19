package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Pessoa;
import repository.Pessoas;
import util.Transactional;

public class CadastroPessoas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoas pessoas;
	
	/*public CadastroPessoas(Pessoas pessoas){
		this.pessoas = pessoas;
	}*/
	
	@Transactional
	public void salvar(Pessoa pessoa) throws NegocioException {
		//regras de negócio ao adicioar pessoa (se houver)
		this.pessoas.guardar(pessoa);
	}
	
	@Transactional
	public void excluir(Pessoa pessoa) throws NegocioException{
		pessoa = this.pessoas.porId(pessoa.getId());
		
		this.pessoas.remover(pessoa);
	}
}
