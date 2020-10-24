package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.ConvenioDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Convenio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ConvenioServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConvenioDao convenioDao;

    @Getter
    private List<Estados> estados;

    public ConvenioServico() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }

    @Transactional
    public void salvar(Convenio convenio) {
        this.convenioDao.save(convenio);
    }

    @Transactional
    public void deletar(Convenio convenio) {
        convenioDao.delete(findById(convenio.getId()));
    }

    public Convenio findById(Long id) {
        return convenioDao.porId(id);
    }

    public List<Convenio> todos() {
        return convenioDao.todos();
    }

}
