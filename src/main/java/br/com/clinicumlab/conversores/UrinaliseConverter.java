package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Urinalise;
import br.com.clinicumlab.servicos.UrinaliseServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Urinalise.class)
public class UrinaliseConverter implements Converter {
    
    private final UrinaliseServico urinaliseServico;
    
    public UrinaliseConverter() throws ClinicumLabException {
        this.urinaliseServico = CDIServiceLocator.getBean(UrinaliseServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Urinalise objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.urinaliseServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Urinalise) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
