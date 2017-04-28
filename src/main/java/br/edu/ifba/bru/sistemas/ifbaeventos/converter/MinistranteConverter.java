package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Ministrante;
import br.edu.ifba.bru.sistemas.repository.Ministrantes;

@FacesConverter(forClass = Ministrante.class)
public class MinistranteConverter implements Converter{
	
	@Inject
	private Ministrantes ministrantes;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Ministrante retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.ministrantes.porId(new Long(value)); 
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Ministrante m = (Ministrante) value;
		if (m != null && m.getId() != null) {
			return m.getId().toString();
		}
		return null;
	}

}
