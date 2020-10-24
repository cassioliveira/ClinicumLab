package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Antibiograma;
import br.com.clinicumlab.servicos.AntibiogramaServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Antibiograma.class)
public class AntibiogramaConverter implements Converter {
    
    private final AntibiogramaServico antibiogramaServico;
    
    public AntibiogramaConverter() throws ClinicumLabException {
        this.antibiogramaServico = CDIServiceLocator.getBean(AntibiogramaServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Antibiograma objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.antibiogramaServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Antibiograma) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
