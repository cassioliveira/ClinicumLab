package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Exame;
import br.com.clinicumlab.servicos.ExameServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Exame.class)
public class ExameConverter implements Converter {
    
    private final ExameServico exameServico;
    
    public ExameConverter() throws ClinicumLabException {
        this.exameServico = CDIServiceLocator.getBean(ExameServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Exame objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.exameServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Exame) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
