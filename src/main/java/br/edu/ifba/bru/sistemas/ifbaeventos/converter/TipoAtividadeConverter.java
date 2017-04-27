package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.TipoAtividade;
import br.edu.ifba.bru.sistemas.repository.TipoAtividades;

@FacesConverter(forClass = TipoAtividade.class)
public class TipoAtividadeConverter implements Converter{

	@Inject
	private TipoAtividades tipoAtividades;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoAtividade retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.tipoAtividades.porId(new Long(value)); 
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		TipoAtividade p = (TipoAtividade) value;
		if (p != null && p.getId() != null) {
			return p.getId().toString();
		}
		return null;
	}

}
