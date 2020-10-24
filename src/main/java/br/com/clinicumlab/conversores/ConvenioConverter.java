package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Convenio;
import br.com.clinicumlab.servicos.ConvenioServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Convenio.class)
public class ConvenioConverter implements Converter {
    
    private final ConvenioServico convenioServico;

    public ConvenioConverter() throws ClinicumLabException {
        this.convenioServico = CDIServiceLocator.getBean(ConvenioServico.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Convenio objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.convenioServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Convenio) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
