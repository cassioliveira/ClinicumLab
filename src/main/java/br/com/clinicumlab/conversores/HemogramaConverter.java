package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Hemograma;
import br.com.clinicumlab.servicos.HemogramaServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Hemograma.class)
public class HemogramaConverter implements Converter {
    
    private final HemogramaServico hemogramaServico;
    
    public HemogramaConverter() throws ClinicumLabException {
        this.hemogramaServico = CDIServiceLocator.getBean(HemogramaServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Hemograma objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.hemogramaServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Hemograma) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
