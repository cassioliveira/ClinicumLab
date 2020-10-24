package br.com.clinicumlab.controladores;

import br.com.clinicumlab.modelo.Hemograma;
import br.com.clinicumlab.servicos.HemogramaServico;
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
public class HemogramaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Hemograma hemograma;

    @Getter
    @Setter
    @Inject
    private HemogramaServico hemogramaServico;

    @Getter
    @Setter
    private Hemograma hemogramaSelecionado;

    @Getter
    private List<Hemograma> hemogramas;

    /**
     * Construtor da classe
     */
    public HemogramaBean() {
        hemograma = new Hemograma();
        hemogramaSelecionado = new Hemograma();
    }

    @PostConstruct
    public void init() {
        this.hemogramas = hemogramaServico.todos();

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Hemograma e salvar.
     *
     */
    public void salvar() {
        hemogramaServico.salvar(hemograma);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + hemograma.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-exames.xhtml");
        hemograma = new Hemograma();
    }

    /**
     * Método responsável por excluir um objeto do tipo Hemograma e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.hemogramaServico.deletar(hemogramaSelecionado);
        this.hemogramas = hemogramaServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.hemograma.getId() != null;
    }
    
    public Double getCalculoHGM(){
        double hgm = 122.0;
        return hgm;
//        return hemogramaServico.calculoHGM(hemograma.getHemoglobina(), hemograma.getEritrocitos());
    }
    
    public Double getCalculoVGM(){
        double hgm = 500.0;
        return hgm;
//        return hemogramaServico.calculoVGM(hemograma.getHematocrito(), hemograma.getEritrocitos());
    }
    
    public Double getCalculoCHGM(){
        double hgm = 90.0;
        return hgm;
//        return hemogramaServico.calculoCHGM(hemograma.getHematocrito(), hemograma.getHemoglobina());
    }

}
