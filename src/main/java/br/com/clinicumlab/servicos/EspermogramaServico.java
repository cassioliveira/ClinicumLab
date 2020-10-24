package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.EspermogramaDao;
import br.com.clinicumlab.excecoes.NegocioException;
import br.com.clinicumlab.modelo.Espermograma;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class EspermogramaServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EspermogramaDao espermogramaDao;

    @Inject
    private ExameServico exameServico;

    @Transactional
    public void salvar(Espermograma espermograma) {
        if (!exameServico.jaCadastrado("Espermograma")) {
            espermograma.setCodigo("ESPERMO01");
            espermograma.setDescricao("Espermograma");
            this.espermogramaDao.save(espermograma);
        } else {
            throw new NegocioException("Exame já cadastrado!");
        }
    }

    @Transactional
    public void deletar(Espermograma espermograma) {
        espermogramaDao.delete(porId(espermograma.getId()));
    }

    public Espermograma porId(Long id) {
        return espermogramaDao.porId(id);
    }

    public List<Espermograma> todos() {
        return espermogramaDao.todos();
    }

}
