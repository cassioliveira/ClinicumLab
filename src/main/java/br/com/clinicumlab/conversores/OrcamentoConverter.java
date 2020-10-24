package br.com.clinicumlab.conversores;

import br.com.clinicumlab.excecoes.ClinicumLabException;
import br.com.clinicumlab.modelo.Orcamento;
import br.com.clinicumlab.servicos.OrcamentoServico;
import br.com.clinicumlab.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Esta classe representa o conversor de Orcamento, cujo objetivo é converter
 * um valor enviando pela View em objeto ou retornar o ID do objeto. 
 * Ao implementar a interface Converter dois métodos são implementados, 
 * getAsObject e getAsString.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@FacesConverter(forClass = Orcamento.class)
public class OrcamentoConverter implements Converter {
    
    private final OrcamentoServico orcamentoServico;

    /**
     * Enquanto a versão atual do JSF (2.2) não suporta injeção com dentro de
     * conversores, essa classe utilitária CDIServiceLocator, faz esse papel.
     * 
     * @throws br.com.clinicumlab.excecoes.ClinicumLabException
     */
    public OrcamentoConverter() throws ClinicumLabException {
        this.orcamentoServico = CDIServiceLocator.getBean(OrcamentoServico.class);
    }
    
    /**
     * Este método recebe a String e devolve o Object. Quando uma Orçamento
     * for mostrado na tela será seu ID que estará sendo exibido.
     * 
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Orcamento objectToReturn = null;
        
        if(value != null) {
            objectToReturn = this.orcamentoServico.findById(new Long(value));
        }
        return objectToReturn;
    }

    /**
     * Este método recebe o Object e devolve a String. Apartir dessa String 
     * recuperamos o Object que esta ligado ao modelo.
     * 
     * @param context
     * @param component
     * @param value
     * @return 
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            Long code = ((Orcamento) value).getId();
            return code == null ? null : code.toString();
        }
        return "";
    }
    
}
