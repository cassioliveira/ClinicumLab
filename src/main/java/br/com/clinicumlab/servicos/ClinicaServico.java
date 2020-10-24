package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.ClinicaDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Clinica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ClinicaServico implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private ClinicaDao clinicaDao;
    
    @Getter
    private List<Estados> estados;

    public ClinicaServico() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }
    
    @Transactional
    public void salvar(Clinica clinica) {
        this.clinicaDao.save(clinica);
    }

    @Transactional
    public void deletar(Clinica clinica) {
        clinicaDao.delete(findById(clinica.getId()));
    }

    public Clinica findById(Long id) {
        return clinicaDao.porId(id);
    }

    public List<Clinica> todos() {
        return clinicaDao.todos();
    }
    
}
