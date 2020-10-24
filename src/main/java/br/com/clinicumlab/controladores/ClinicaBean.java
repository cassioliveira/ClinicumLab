package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Clinica;
import br.com.clinicumlab.servicos.ClinicaServico;
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
public class ClinicaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Clinica clinica;

    @Inject
    @Getter
    @Setter
    private ClinicaServico clinicaServico;

    @Getter
    @Setter
    private Clinica clinicaSelecionada;
    
    @Getter
    private List<Clinica> clinicas;
    
    private List<Estados> estados = new ArrayList<>();

    /**
     * Construtor da classe
     */
    public ClinicaBean() {
        clinica = new Clinica();
        clinicaSelecionada = new Clinica();
        estados = Arrays.asList(Estados.values());
    }
    
    @PostConstruct
    public void init() {
        this.clinicas = clinicaServico.todos();
    }
    
    /**
     * Lista os estados da federação previamente cadastrados no banco.
     *
     * @return
     */
    public List<Estados> getEstados() {
        this.estados = clinicaServico.getEstados();
        return estados;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Clinica e salvar.
     *
     */
    public void salvar(){
        this.clinicaServico.salvar(clinica);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de'" + clinica.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        clinica = new Clinica();
    }
    
    /**
     * Método responsável por excluir um objeto do tipo Clinica e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir(){
        this.clinicaServico.deletar(clinicaSelecionada);
        this.clinicas = clinicaServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }
    
    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.clinica.getId() != null;
    }

}
