package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Clinica;
import br.com.clinicumlab.servicos.ClinicaServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Clinica.class)
public class ClinicaConverter implements Converter {

    private final ClinicaServico clinicaServico;

    public ClinicaConverter() throws ClinicumLabException {
        this.clinicaServico = CDIServiceLocator.getBean(ClinicaServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Clinica objectToReturn = null;

        if (value != null) {
            objectToReturn = this.clinicaServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Clinica) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
