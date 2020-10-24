package br.com.clinicumlab.controladores;

import br.com.clinicumlab.modelo.Orcamento;
import br.com.clinicumlab.servicos.OrcamentoServico;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de orçamento. É responsável por
 * ligar a classe de modelo Orcamento à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class OrcamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Orcamento orcamento;

    @Inject
    @Getter
    @Setter
    private OrcamentoServico orcamentoServico;

    @Getter
    @Setter
    private Orcamento orcamentoSelecionado;

    @Getter
    private transient List<Orcamento> orcamentos;

    public OrcamentoBean() {
        orcamento = new Orcamento();
        orcamentoSelecionado = new Orcamento();
    }

    @PostConstruct
    public void init() {
        this.orcamentos = orcamentoServico.todos();
    }

}
