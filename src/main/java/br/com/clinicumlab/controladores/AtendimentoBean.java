package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.FormaPagamento;
import br.com.clinicumlab.modelo.Atendimento;
import br.com.clinicumlab.modelo.Paciente;
import br.com.clinicumlab.modelo.Exame;
import br.com.clinicumlab.servicos.AtendimentoServico;
import br.com.clinicumlab.servicos.PacienteServico;
import br.com.clinicumlab.servicos.ExameServico;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Named
@ViewScoped
public class AtendimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Atendimento atendimento;

    @Getter
    @Setter
    @Inject
    private PacienteServico pacienteServico;

    @Getter
    @Setter
    @Inject
    private AtendimentoServico atendimentoServico;

    @Getter
    @Setter
    private Atendimento atendimentoSelecionado;

    @Getter
    @Setter
    @Inject
    private ExameServico exameServico;

    @Getter
    @Setter
    private Exame exameSelecionado;

    @Getter
    private List<Atendimento> atendimentosAbertos = new ArrayList<>();

    @Getter
    private List<Atendimento> atendimentosFinalizados = new ArrayList<>();

    @Getter
    private List<Paciente> pacientes;

    @Getter
    private List<Exame> exames = new ArrayList<>();

    @Getter
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    public AtendimentoBean() {
        atendimento = new Atendimento();
        atendimentoSelecionado = new Atendimento();
    }

    @PostConstruct
    public void init() {
        this.formasPagamento = Arrays.asList(FormaPagamento.values());
        this.atendimentosAbertos = atendimentoServico.atendimentosAbertos();
        this.atendimentosFinalizados = atendimentoServico.atendimentosFinalizados();
        this.pacientes = pacienteServico.todos();
        this.exames = exameServico.todos();
    }

    public void salvar() {
        atendimentoServico.salvar(atendimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de protocolo '" + atendimento.getPaciente().getNome()+ "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("atendimentos.xhtml");
        atendimento = new Atendimento();
    }

    public void excluir() {
        this.atendimentoServico.excluir(atendimentoSelecionado);
        this.atendimentosAbertos = atendimentoServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    public boolean getEditando() {
        return atendimentoServico.atendimentoExistente(atendimento);
    }

    public void adicionarExameAoAtendimento() {
        atendimentoServico.adicionarExameAoAtendimento(atendimento, exameSelecionado);
    }

    public void removerExameDoAtendimento() {
        atendimentoServico.removerExameDoAtendimento(atendimento, exameSelecionado);
    }

    public boolean getPodeSalvarAtendimento() {
        return atendimentoServico.podeSalvarAtendimento(atendimento);
    }

    public void concluirAtendimento() {
        atendimentoServico.concluirAtendimento(atendimento);
    }

    public void cancelarAtendimento() {
        atendimentoServico.cancelarAtendimento(atendimento);
    }
}
