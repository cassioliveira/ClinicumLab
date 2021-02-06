package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.ExameDao;
import br.com.clinicumlab.excecoes.ExameJaCadastradoException;
import br.com.clinicumlab.modelo.Exame;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ExameServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ExameDao exameDao;

    @Transactional
    public void salvar(Exame exame) throws ExameJaCadastradoException{
        if (exame.getId() == null && jaCadastrado(exame.getDescricao())) {
            throw new ExameJaCadastradoException("Já existe um exame com essa descrição!");
        } else {
            this.exameDao.save(exame);
        }
    }

    @Transactional
    public void deletar(Exame exame
    ) {
        exameDao.delete(findById(exame.getId()));
    }

    public Exame findById(Long id) {
        return exameDao.porId(id);
    }

    public List<Exame> todos() {
        return exameDao.todos();
    }

    /**
     * Verifica se há algum exame cadastrado no banco com a descrição igual à
     * passada como parâmetro.
     *
     * @param examePrincipal
     * @return
     */
    public boolean jaCadastrado(String examePrincipal) {
        for (Exame exame : todos()) {
            if (examePrincipal.equals(exame.getDescricao())) {
                return true;
            }
        }
        return false;
    }

}
