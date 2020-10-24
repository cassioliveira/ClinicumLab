package br.com.clinicumlab.controladores;

import br.com.clinicumlab.modelo.Antibiograma;
import br.com.clinicumlab.servicos.AntibiogramaServico;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
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
public class AntibiogramaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Antibiograma antibiograma;

    @Getter
    @Setter
    @Inject
    private AntibiogramaServico antibiogramaServico;

    @Getter
    @Setter
    private Antibiograma antibiogramaSelecionado;

    @Getter
    private List<Antibiograma> antibiogramas;

    /**
     * Construtor da classe
     */
    public AntibiogramaBean() {
        antibiograma = new Antibiograma();
        antibiogramaSelecionado = new Antibiograma();
    }

    @PostConstruct
    public void init() {
        this.antibiogramas = antibiogramaServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Antibiograma e salvar.
     *
     */
    public void salvar() {
        antibiogramaServico.salvar(antibiograma);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + antibiograma.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-exames.xhtml");
        antibiograma = new Antibiograma();
    }

    /**
     * Método responsável por excluir um objeto do tipo Antibiograma e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.antibiogramaServico.deletar(antibiogramaSelecionado);
        this.antibiogramas = antibiogramaServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.antibiograma.getId() != null;
    }

}
