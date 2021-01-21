package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Paciente;
import br.com.clinicumlab.servicos.PacienteServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter {
    
    private final PacienteServico pacienteServico;
    
    public PacienteConverter() throws ClinicumLabException {
        this.pacienteServico = CDIServiceLocator.getBean(PacienteServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Paciente objectToReturn = null;
        
        if (value != null) {
            objectToReturn = this.pacienteServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Paciente) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
