package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Cliente;
import br.com.clinicumlab.servicos.ClienteServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {
    
    private final ClienteServico clienteServico;
    
    public ClienteConverter() throws ClinicumLabException {
        this.clienteServico = CDIServiceLocator.getBean(ClienteServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Cliente objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.clienteServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Cliente) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
