package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.AtendimentoDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.enumeracao.StatusAtendimento;
import br.com.clinicumlab.modelo.Atendimento;
import br.com.clinicumlab.modelo.Exame;
import br.com.clinicumlab.util.jsf.FacesUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.Random;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class AtendimentoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AtendimentoDao atendimentoDao;

    @Getter
    private List<Estados> estados;

    public AtendimentoServico() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }

    /**
     * Salva o atendimento no  banco de dados, armazenando a data do cadastro e
     * o protocolo, caso seja um novo atendimento.
     * 
     * @param atendimento 
     */
    @Transactional
    public void salvar(Atendimento atendimento) {
        if (atendimento.getId() == null) {
            atendimento.setDataAtendimento(new Date());
            atendimento.setProtocolo(geraProtocolo(atendimento));
        }
        this.atendimentoDao.save(atendimento);
    }

    @Transactional
    public void excluir(Atendimento atendimento) {
        atendimentoDao.delete(findById(atendimento.getId()));
    }

    /**
     * Faz a busca no banco de dados por um atendimento através do ID.
     * 
     * @param id
     * @return 
     */
    public Atendimento findById(Long id) {
        return atendimentoDao.porId(id);
    }

    public List<Atendimento> todos() {
        return atendimentoDao.todos();
    }

    /**
     * Retorna uma lista de atendimentos em que o status esteja definido como
     * ABERTO.
     *
     * @return
     */
    public List<Atendimento> atendimentosAbertos() {
        List<Atendimento> atendimentosAbertos = new ArrayList<>();
        for (Atendimento atendimento : atendimentoDao.todos()) {
            if (atendimento.getStatusAtendimento().equals(StatusAtendimento.ABERTO)) {
                atendimentosAbertos.add(atendimento);
            }
        }
        return atendimentosAbertos;
    }

    /**
     * Retorna uma lista de atendimentos em que o status dos atendimentos esteja
     * definido como CANCELADO ou CONCLUIDO.
     *
     * @return
     */
    public List<Atendimento> atendimentosFinalizados() {
        List<Atendimento> atendimentosAbertos = new ArrayList<>();
        for (Atendimento atendimento : atendimentoDao.todos()) {
            if (atendimento.getStatusAtendimento().equals(StatusAtendimento.CANCELADO)
                    || atendimento.getStatusAtendimento().equals(StatusAtendimento.CONCLUIDO)) {
                atendimentosAbertos.add(atendimento);
            }
        }
        return atendimentosAbertos;
    }

    /**
     * Gera um número de protocolo para o atendimento. Esse número é composto
     * pela data de cadastro do atendimento seguido de um número aleatório de 4
     * dígitos e pelo ID do paciente associado ao atendimento.
     *
     * @return
     */
    private String geraProtocolo(Atendimento atendimento) {
        String protocolo;
        Random aleatorio = new Random();
        String mesAno = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")); //Gera a data de hoje formatada somente com números
        protocolo = mesAno + (aleatorio.nextInt(9900) + 1000) + atendimento.getPaciente().getId();
        return protocolo;
    }

    /**
     * Verifica se o exame já está adicionado no atendimento e identifica se o
     * usuário está clicando no botão de adicionar exame sem selecionar um. Caso
     * o exame não esteja no atendimento e seja um valor válido, é adicionado ao
     * atendimento.
     *
     * @param atendimento
     * @param exameSelecionado
     */
    public void adicionarExameAoAtendimento(Atendimento atendimento, Exame exameSelecionado) {
        if (!atendimento.getExames().contains(exameSelecionado)
                && exameSelecionado != null) {
            atendimento.getExames().add(exameSelecionado);
        } else if (atendimento.getExames().contains(exameSelecionado)) {
            FacesUtil.mensagemAviso("Exame já adicionado!");
        } else {
            System.out.println("Clicou no botão adicionar sem selecionar exame");
        }
    }

    public void removerExameDoAtendimento(Atendimento atendimento, Exame exameSelecionado) {
        atendimento.getExames().remove(exameSelecionado);
    }

    /**
     * Verifica se a lista de exames está vazia para não permitir que seja salvo
     * um atendimento sem exames adicionados. Esta condição deve ser definida no
     * botão de adicionar exame ao atendimento, desabilitando ou não
     * renderizando o mesmo na tela.
     *
     * @param atendimento
     * @return
     */
    public boolean podeSalvarAtendimento(Atendimento atendimento) {
        return atendimento.getExames().size() < 1;
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado.
     *
     * @param atendimento
     * @return
     */
    public boolean atendimentoExistente(Atendimento atendimento) {
        return atendimento.getId() != null;
    }

    @Transactional
    public void concluirAtendimento(Atendimento atendimento) {
        atendimento.setStatusAtendimento(StatusAtendimento.CONCLUIDO);
        this.atendimentoDao.save(atendimento);
    }
    
    public void cancelarAtendimento(Atendimento atendimento) {
        atendimento.setStatusAtendimento(StatusAtendimento.CANCELADO);
        salvar(atendimento);
    }

//    public void finalizarAtendimento(Atendimento atendimento, StatusAtendimento status) {
//        if (status.equals(StatusAtendimento.CONCLUIDO)) {
//            atendimento.setStatusAtendimento(StatusAtendimento.CONCLUIDO);
//        } else if (status.equals(StatusAtendimento.CANCELADO)) {
//            atendimento.setStatusAtendimento(StatusAtendimento.CANCELADO);
//        }
//        salvar(atendimento);
//    }
}
