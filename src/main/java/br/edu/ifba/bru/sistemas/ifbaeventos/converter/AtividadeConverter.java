package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Atividade;
import br.edu.ifba.bru.sistemas.repository.Atividades;

@FacesConverter(forClass = Atividade.class)
public class AtividadeConverter implements Converter{

	@Inject
	private Atividades atividades;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Atividade retorno = null;
		
		if (value != null && !"".equals(value)){
			retorno = this.atividades.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Atividade a = (Atividade) value;
		if (a != null && a.getId() != null){
			return a.getId().toString();
		}
		return null;
	}

}
