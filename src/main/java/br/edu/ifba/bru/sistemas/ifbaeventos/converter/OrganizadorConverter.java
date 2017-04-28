package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.bru.sistemas.ifbaeventos.model.Organizador;
import br.edu.ifba.bru.sistemas.repository.Organizadores;

@FacesConverter(forClass = Organizador.class)
public class OrganizadorConverter implements Converter{

	@Inject
	private Organizadores organizadores;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Organizador retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.organizadores.porId(new Long(value));  //organizadores.porId(new Long(value));
		}
		
		return retorno;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Organizador p = (Organizador) value;
		if (p != null && p.getId() != null) {
			return p.getId().toString();
		}
		return null;
	}

}
