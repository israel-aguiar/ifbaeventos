package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Participante;
import br.edu.ifba.bru.sistemas.repository.Participantes;

@FacesConverter(forClass = Participante.class)
public class ParticipanteConverter implements Converter{

	@Inject
	private Participantes participantes;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Participante retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.participantes.porId(new Long(value));  //participantes.porId(new Long(value));
		}
		
		return retorno;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Participante p = (Participante) value;
		if (p != null && p.getId() != null) {
			return p.getId().toString();
		}
		return null;
	}

}
