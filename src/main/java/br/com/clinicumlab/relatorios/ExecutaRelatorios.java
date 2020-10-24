package br.com.clinicumlab.relatorios;

import br.com.clinicumlab.modelo.Cliente;
import br.com.clinicumlab.servicos.ClienteServico;
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
    private ClienteServico clienteServico;

    @Getter
    @Setter
    private Cliente cliente;

    public ExecutaRelatorios() {
        this.cliente = new Cliente();
    }

    /**
     * Emite carteirinha de tipo sanguíneo do cliente.
     *
     * @throws java.io.IOException
     * @throws net.sf.jasperreports.engine.JRException
     */
    public void emitirCarteirinha() throws IOException, JRException {
        clienteServico.salvar(cliente);
        geraRelatorios.gerarPdf("/carteirinha.jasper", "Carteirinha tipo sanguíneo.pdf", cliente);
    }

}
