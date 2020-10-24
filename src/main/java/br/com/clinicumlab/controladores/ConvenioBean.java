package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Convenio;
import br.com.clinicumlab.servicos.ConvenioServico;
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
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ConvenioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Convenio convenio;

    @Getter
    @Setter
    @Inject
    private ConvenioServico convenioServico;

    @Getter
    @Setter
    private Convenio convenioSelecionado;

    @Getter
    private List<Convenio> convenios;

    private List<Estados> estados = new ArrayList<>();

    public ConvenioBean() {
        convenio = new Convenio();
        convenioSelecionado = new Convenio();
        estados = Arrays.asList(Estados.values());
    }

    @PostConstruct
    public void init() {
        this.convenios = convenioServico.todos();
    }

    /**
     * Lista os estados da federação previamente cadastrados no banco.
     *
     * @return
     */
    public List<Estados> getEstados() {
        this.estados = convenioServico.getEstados();
        return estados;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Convenio e salvar.
     */
    public void salvar() {
        this.convenioServico.salvar(convenio);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + convenio.getNomeConvenio() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-convenios.xhtml");
        convenio = new Convenio();
    }

    /**
     * Método responsável por excluir um objeto do tipo Convenio e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.convenioServico.deletar(convenioSelecionado);
        this.convenios = convenioServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.convenio.getId() != null;
    }

}
