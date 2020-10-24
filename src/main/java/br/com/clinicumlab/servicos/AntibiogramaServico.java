package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.AntibiogramaDao;
import br.com.clinicumlab.excecoes.NegocioException;
import br.com.clinicumlab.modelo.Antibiograma;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class AntibiogramaServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AntibiogramaDao antibiogramaDao;

    @Inject
    private ExameServico exameServico;

    @Transactional
    public void salvar(Antibiograma antibiograma) {
        if (!exameServico.jaCadastrado("Antibiograma")) {
            antibiograma.setCodigo("ANTIBIO01");
            antibiograma.setDescricao("Antibiograma");
            this.antibiogramaDao.save(antibiograma);
        } else {
            throw new NegocioException("Exame já cadastrado!");
        }
    }

    @Transactional
    public void deletar(Antibiograma antibiograma) {
        antibiogramaDao.delete(findById(antibiograma.getId()));
    }

    public Antibiograma findById(Long id) {
        return antibiogramaDao.porId(id);
    }

    public List<Antibiograma> todos() {
        return antibiogramaDao.todos();
    }

}
