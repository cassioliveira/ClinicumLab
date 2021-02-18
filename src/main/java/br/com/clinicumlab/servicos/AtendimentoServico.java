package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.AtendimentoDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.enumeracao.StatusAtendimento;
import br.com.clinicumlab.modelo.Atendimento;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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

    @Transactional
    public void salvar(Atendimento atendimento) {
        if (atendimento.getId() == null) { 
            atendimento.setDataAtendimento(new Date());
            atendimento.setProtocolo(geraProtocolo());
        }
        this.atendimentoDao.save(atendimento);
    }

    @Transactional
    public void deletar(Atendimento atendimento) {
        atendimentoDao.delete(findById(atendimento.getId()));
    }

    public Atendimento findById(Long id) {
        return atendimentoDao.porId(id);
    }

    public List<Atendimento> todos() {
        return atendimentoDao.todos();
    }

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
     * Gera um número de protocolo para o atendimento. Esse número é composto pela
     * data de cadastro do atendimento seguido de um número aleatório de 5 dígitos.
     * 
     * @return 
     */
    private String geraProtocolo() {
        String protocolo;
        Random aleatorio = new Random();
        String mesAno = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE); //Gera a data de hoje formatada somente com números
        protocolo = mesAno + (aleatorio.nextInt(99000) + 10000); //Última parte gera um número a partir de 10000 e menor que 99999
        return protocolo;
    }

}
