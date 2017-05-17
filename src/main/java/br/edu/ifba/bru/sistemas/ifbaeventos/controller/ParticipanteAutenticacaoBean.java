package br.edu.ifba.bru.sistemas.ifbaeventos.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.ifbaeventos.util.JSFUtil;
import br.edu.ifba.bru.sistemas.service.ParticipanteAutenticacaoService;


@Named
@SessionScoped
public class ParticipanteAutenticacaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Usuário para autenticação
	 */
	@Inject
	private ParticipanteAutenticacao participanteAutenticacao;
 
	@Inject
	private ParticipanteAutenticacaoService participanteAutenticacaoService;
 
	@Inject
	private Participante participante;
 
	public ParticipanteAutenticacao getParticipanteAutenticacao() {
		return participanteAutenticacao;
	}
	public void setParticipanteAutenticacao(ParticipanteAutenticacao usuarioModel) {
		this.participanteAutenticacao = usuarioModel;
	}
 
	public ParticipanteAutenticacao getParticipanteSession(){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		return (ParticipanteAutenticacao)facesContext.getExternalContext().getSessionMap().get("participanteAutenticado");
	}
 
	public String logout(){
 
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
 
		return "/index.xhtml?faces-redirect=true";
	}
	public String efetuarLogin(String formLoginId){
 
		if(StringUtils.isEmpty(participanteAutenticacao.getCpf()) || StringUtils.isBlank(participanteAutenticacao.getCpf())){
 
			JSFUtil.mensagem("Favor informar o login!");
			return null;
		}
		else if(StringUtils.isEmpty(participanteAutenticacao.getSenha()) || StringUtils.isBlank(participanteAutenticacao.getSenha())){
 
			JSFUtil.mensagem("Favor informara senha!");
			return null;
		}
		else{	
 
			participante = participanteAutenticacaoService.validaUsuario(participanteAutenticacao);
 
			if(participante!= null){
 
				participanteAutenticacao.setSenha(null);
				participanteAutenticacao.setId(participante.getId());
				participanteAutenticacao.setNome(participante.getNome());
 
 
				FacesContext facesContext = FacesContext.getCurrentInstance();
 
				facesContext.getExternalContext().getSessionMap().put("participanteAutenticado", participanteAutenticacao);
				RequestContext.getCurrentInstance().execute(String.format("PF('%s').hide()", formLoginId) );
 
				return "sistema/home?faces-redirect=true";
			}
			else{
				JSFUtil.mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}
 
 
	}

}
