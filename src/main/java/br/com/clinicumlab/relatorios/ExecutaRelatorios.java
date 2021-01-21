package br.com.clinicumlab.relatorios;

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
    
    @Getter
    @Setter
    private Paciente pacienteSelecionado;

    public ExecutaRelatorios() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
    }

    /**
     * Emite carteirinha de tipo sanguíneo do paciente.
     *
     * @throws java.io.IOException
     * @throws net.sf.jasperreports.engine.JRException
     */
    public void emitirCarteirinha() throws IOException, JRException {
//        pacienteServico.salvar(paciente);
        geraRelatorios.gerarPdf("/carteirinha.jasper", "Carteirinha tipo sanguíneo.pdf", paciente);
    }

}
