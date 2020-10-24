package br.com.clinicumlab.controladores;

import br.com.clinicumlab.modelo.Urinalise;
import br.com.clinicumlab.servicos.UrinaliseServico;
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
public class UrinaliseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Urinalise urinalise;

    @Getter
    @Setter
    @Inject
    private UrinaliseServico urinaliseServico;

    @Getter
    @Setter
    private Urinalise urinaliseSelecionada;

    @Getter
    private List<Urinalise> urinalises;

    /**
     * Construtor da classe
     */
    public UrinaliseBean() {
        urinalise = new Urinalise();
        urinaliseSelecionada = new Urinalise();
    }

    @PostConstruct
    public void init() {
        this.urinalises = urinaliseServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Urinalise e salvar.
     *
     */
    public void salvar() {
        urinaliseServico.salvar(urinalise);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + urinalise.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-exames.xhtml");
        urinalise = new Urinalise();
    }

    /**
     * Método responsável por excluir um objeto do tipo Urinalise e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.urinaliseServico.deletar(urinaliseSelecionada);
        this.urinalises = urinaliseServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.urinalise.getId() != null;
    }

}
