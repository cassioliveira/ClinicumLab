package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.UrinaliseDao;
import br.com.clinicumlab.excecoes.NegocioException;
import br.com.clinicumlab.modelo.Urinalise;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class UrinaliseServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UrinaliseDao urinaliseDao;

    @Inject
    private ExameServico exameServico;

    @Transactional
    public void salvar(Urinalise urinalise) {
        if (!exameServico.jaCadastrado("Urinalise")) {
            urinalise.setCodigo("URINALI01");
            urinalise.setDescricao("Urinalise");
            this.urinaliseDao.save(urinalise);
        } else {
            throw new NegocioException("Exame já cadastrado!");
        }
    }

    @Transactional
    public void deletar(Urinalise urinalise) {
        urinaliseDao.delete(findById(urinalise.getId()));
    }

    public Urinalise findById(Long id) {
        return urinaliseDao.porId(id);
    }

    public List<Urinalise> todos() {
        return urinaliseDao.todos();
    }

}
