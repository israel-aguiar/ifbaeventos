package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Pessoa;
import repository.Pessoas;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter{

	@Inject
	private Pessoas pessoas;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Pessoa retorno = null;
		
		if (value != null && !"".equals(value)){  
			retorno =  this.pessoas.porId(new Long(value));  //pessoas.porId(new Long(value));
		}
		
		return retorno;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Pessoa p = (Pessoa) value;
		if (p != null && p.getId() != null) {
			return p.getId().toString();
		}
		return null;
	}

}
