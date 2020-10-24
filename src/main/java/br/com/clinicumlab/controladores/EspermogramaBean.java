package br.com.clinicumlab.controladores;

import br.com.clinicumlab.modelo.Espermograma;
import br.com.clinicumlab.servicos.EspermogramaServico;
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
public class EspermogramaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Espermograma espermograma;

    @Getter
    @Setter
    @Inject
    private EspermogramaServico espermogramaServico;

    @Getter
    @Setter
    private Espermograma espermogramaSelecionado;

    @Getter
    private List<Espermograma> espermogramas;

    /**
     * Construtor da classe
     */
    public EspermogramaBean() {
        espermograma = new Espermograma();
        espermogramaSelecionado = new Espermograma();
    }

    @PostConstruct
    public void init() {
        this.espermogramas = espermogramaServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Espermograma e salvar.
     *
     */
    public void salvar() {
        espermogramaServico.salvar(espermograma);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + espermograma.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-exames.xhtml");
        espermograma = new Espermograma();
    }

    /**
     * Método responsável por excluir um objeto do tipo Espermograma e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.espermogramaServico.deletar(espermogramaSelecionado);
        this.espermogramas = espermogramaServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.espermograma.getId() != null;
    }

}
