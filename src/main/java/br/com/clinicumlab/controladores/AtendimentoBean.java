package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.FormaPagamento;
import br.com.clinicumlab.modelo.Atendimento;
import br.com.clinicumlab.modelo.Cliente;
import br.com.clinicumlab.servicos.AtendimentoServico;
import br.com.clinicumlab.servicos.ClienteServico;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class AtendimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Atendimento atendimento;

    @Getter
    @Setter
    @Inject
    private ClienteServico clienteServico;

    @Getter
    @Setter
    @Inject
    private AtendimentoServico atendimentoServico;

    @Getter
    @Setter
    private Atendimento atendimentoSelecionado;

    @Getter
    private List<Atendimento> atendimentosAbertos;

    @Getter
    private List<Cliente> clientes;

    @Getter
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    /**
     * Construtor da classe
     */
    public AtendimentoBean() {
        atendimento = new Atendimento();
        atendimentoSelecionado = new Atendimento();
    }

    @PostConstruct
    public void init() {
        this.formasPagamento = Arrays.asList(FormaPagamento.values());
        this.atendimentosAbertos = atendimentoServico.atendimentosAbertos();
        this.clientes = clienteServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Atendimento e salvar.
     *
     */
    public void salvar() {
        atendimentoServico.salvar(atendimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de protocolo'" + atendimento.getProtocolo() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("atendimentos.xhtml");
        atendimento = new Atendimento();
    }

    /**
     * Método responsável por excluir um objeto do tipo Atendimento e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.atendimentoServico.deletar(atendimentoSelecionado);
        this.atendimentosAbertos = atendimentoServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.atendimento.getId() != null;
    }

}
