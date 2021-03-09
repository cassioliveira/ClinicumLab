package br.com.clinicumlab.relatorios;

import br.com.clinicumlab.modelo.Atendimento;
import br.com.clinicumlab.modelo.Paciente;
import br.com.clinicumlab.servicos.PacienteServico;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ExecutaRelatorios implements Serializable {

    @Inject
    private GeraRelatorios geraRelatorios;

    @Inject
    @Getter
    @Setter
    private PacienteServico pacienteServico;

    @Getter
    @Setter
    private Paciente paciente;
    
//    @Getter
//    @Setter
//    private Paciente pacienteSelecionado;
    
    @Getter
    @Setter
    private Atendimento atendimento;
    
//    @Getter
//    @Setter
//    private Atendimento atendimentoSelecionado;

    public ExecutaRelatorios() {
        paciente = new Paciente();
//        pacienteSelecionado = new Paciente();
        atendimento = new Atendimento();
//        atendimentoSelecionado = new Atendimento();
    }

    /**
     * Emite carteirinha de tipo sanguíneo do paciente.
     *
     * @throws java.io.IOException
     * @throws net.sf.jasperreports.engine.JRException
     */
    public void emitirCarteirinha() throws IOException, JRException {
//        pacienteServico.salvar(paciente);
        geraRelatorios.carteirinhaPaciente("/carteirinha.jasper", "Carteirinha tipo sanguíneo.pdf", paciente);
    }
    
    public void emitirHemograma() throws IOException, JRException {
        geraRelatorios.resultadoExame("/hemograma.jasper", "Exame de Hemograma.pdf", atendimento);
    }

}
