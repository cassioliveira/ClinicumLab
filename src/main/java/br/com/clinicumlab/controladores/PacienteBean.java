package br.com.clinicumlab.controladores;

import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Paciente;
import br.com.clinicumlab.servicos.PacienteServico;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
import java.time.Month;
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
public class PacienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Paciente paciente;

    @Getter
    @Setter
    @Inject
    private PacienteServico pacienteServico;

    @Getter
    @Setter
    private Paciente pacienteSelecionado;

    @Getter
    private List<Paciente> pacientes;

    private List<Estados> estados = new ArrayList<>();

    /**
     * Construtor da classe
     */
    public PacienteBean() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
        estados = Arrays.asList(Estados.values());
    }

    @PostConstruct
    public void init() {
        this.pacientes = pacienteServico.todos();

    }

    /**
     * Lista os estados da federação previamente cadastrados no banco.
     *
     * @return
     */
    public List<Estados> getEstados() {
        this.estados = pacienteServico.getEstados();
        return estados;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Paciente e salvar.
     *
     */
    public void salvar() {
        pacienteServico.salvar(paciente);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + paciente.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-pacientes.xhtml");
        paciente = new Paciente();
    }

    /**
     * Método responsável por excluir um paciente cadastrado.
     *
     */
    public void excluir() {
        this.pacienteServico.deletar(pacienteSelecionado);
        this.pacientes = pacienteServico.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.paciente.getId() != null;
    }
    
//    public long getIdade(){
//        return pacienteServico.idade(paciente);
//    }
}
