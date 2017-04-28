package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Evento;
import br.edu.ifba.bru.sistemas.repository.Eventos;

@FacesConverter(forClass = Evento.class)
public class EventoConverter implements Converter {
	
	@Inject
	private Eventos eventos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Evento retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.eventos.porId(new Long(value));  //organizadores.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Evento p = (Evento) value;
		if (p != null && p.getId() != null) {
			return p.getId().toString();
		}
		return null;
	}

}
