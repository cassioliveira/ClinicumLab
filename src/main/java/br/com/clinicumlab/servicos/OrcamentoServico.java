package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.OrcamentoDao;
import br.com.clinicumlab.modelo.Orcamento;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class OrcamentoServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OrcamentoDao orcamentoDao;

    @Transactional
    public void salvar(Orcamento orcamento) {
        this.orcamentoDao.save(orcamento);
    }

    @Transactional
    public void deletar(Orcamento orcamento) {
        orcamentoDao.delete(findById(orcamento.getId()));
    }

    public Orcamento findById(Long id) {
        return orcamentoDao.porId(id);
    }

    public List<Orcamento> todos() {
        return orcamentoDao.todos();
    }

}
