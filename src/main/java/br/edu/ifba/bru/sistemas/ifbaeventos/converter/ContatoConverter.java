package br.edu.ifba.bru.sistemas.ifbaeventos.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="contatoConverter")
public class ContatoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String contato = value;
        if (value!= null && !value.equals(""))
             contato = value.replaceAll("\\(", "").replaceAll("\\)", "").
             replaceAll("\\ ", "").replaceAll("\\-", "");
		return contato;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String contato= (String)value;
        if (contato != null && contato.length() == 11)
             contato = '(' + contato.substring(0, 2) + ") " + contato.substring(2, 7) + "-" + contato.substring(7, 11);
        else if (contato != null && contato.length() == 10)
            contato = '(' + contato.substring(0, 2) + ") " + contato.substring(2, 6) + "-" + contato.substring(6, 10);                
        

        return contato;
	}

}
