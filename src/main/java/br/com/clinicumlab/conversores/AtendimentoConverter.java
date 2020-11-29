package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Atendimento;
import br.com.clinicumlab.servicos.AtendimentoServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Atendimento.class)
public class AtendimentoConverter implements Converter {

    private final AtendimentoServico atendimentoServico;

    public AtendimentoConverter() throws ClinicumLabException {
        this.atendimentoServico = CDIServiceLocator.getBean(AtendimentoServico.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Atendimento objectToReturn = null;

        if (value != null) {
            objectToReturn = this.atendimentoServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Long code = ((Atendimento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }

}
