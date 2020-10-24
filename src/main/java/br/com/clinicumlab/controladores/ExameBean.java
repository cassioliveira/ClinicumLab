package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.ExameCategoria;
import br.com.clinicumlab.modelo.Exame;
import br.com.clinicumlab.servicos.ExameServico;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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
public class ExameBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Getter
    private final Locale locale = new Locale("pt", "BR");

    @Getter
    @Setter
    private Exame exame;

    @Getter
    @Setter
    @Inject
    private ExameServico exameServico;

    @Getter
    @Setter
    private Exame exameSelecionado;

    @Getter
    private List<Exame> exames;

    @Getter
    private List<ExameCategoria> exameCategoria;

    /**
     * Construtor da classe
     */
    public ExameBean() {
        exame = new Exame();
        exameSelecionado = new Exame();
    }

    @PostConstruct
    public void init() {
        this.exameCategoria = Arrays.asList(ExameCategoria.values());
        this.exames = exameServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Exame e salvar.
     *
     */
    public void salvar() {
        exameServico.salvar(exame);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + exame.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-exames.xhtml");
        exame = new Exame();
    }

    /**
     * Método responsável por excluir um objeto do tipo Exame e exibir ao final
     * do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.exameServico.deletar(exameSelecionado);
        this.exames = exameServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Define qual tela de cadastro será aberta para edição ou visualização de
     * acordo com o tipo do exame.
     *
     * @param exame
     * @return
     */
    public String getTelaEdicaoExame(Exame exame) {
        String pagina;
        switch (exame.getDescricao()) {
            case "Antibiograma":
                pagina = "/exame/antibiograma";
                break;
            case "Hemograma":
                pagina = "/exame/hemograma-completo";
                break;
            case "Urinalise":
                pagina = "/exame/urinalise";
                break;
            case "Espermograma":
                pagina = "/exame/espermograma";
                break;
            default:
                pagina = "/exame/cadastro-exame";
                break;
        }
        return pagina;
    }

    public boolean getJaCadastrado(String examePrincipal) {
        return exameServico.jaCadastrado(examePrincipal);
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.exame.getId() != null;
    }

}
