package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Espermograma;
import br.com.clinicumlab.servicos.EspermogramaServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Espermograma.class)
public class EspermogramaConverter implements Converter {
    
    private final EspermogramaServico espermogramaServico;
    
    public EspermogramaConverter() throws ClinicumLabException {
        this.espermogramaServico = CDIServiceLocator.getBean(EspermogramaServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Espermograma objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.espermogramaServico.porId(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Espermograma) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
