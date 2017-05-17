package br.edu.ifba.bru.sistemas.ifbaeventos.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void mensagem(String mensagem) {
		mensagem(null, mensagem);
	}

	public static void mensagem(String idCliente, String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(idCliente, new FacesMessage("Alerta", mensagem));
	}

	public static void mensagemAtencao(String mensagem) {
		mensagemAtencao(null, mensagem);
	}

	public static void mensagemAtencao(String idCliente, String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(idCliente, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}

	public static void mensagemInfo(String mensagem) {
		mensagemInfo(null, mensagem);
	}
	
	public static void mensagemInfo(String idCliente, String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação: ", mensagem));
	}
}
