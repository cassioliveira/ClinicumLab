package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.AtendimentoDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.enumeracao.StatusAtendimento;
import br.com.clinicumlab.modelo.Atendimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

}
