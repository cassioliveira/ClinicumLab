package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.HemogramaDao;
import br.com.clinicumlab.excecoes.NegocioException;
import br.com.clinicumlab.modelo.Hemograma;
import java.io.Serializable;
import javax.transaction.Transactional;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
public class HemogramaServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private HemogramaDao hemogramaDao;

    @Inject
    private ExameServico exameServico;

    @Transactional
    public void salvar(Hemograma hemograma) {
        if (!exameServico.jaCadastrado("Hemograma")) {
            hemograma.setCodigo("HEMOGRA01");
            hemograma.setDescricao("Hemograma");
            this.hemogramaDao.save(hemograma);
        } else {
            throw new NegocioException("Exame já cadastrado!");
        }
    }

    @Transactional
    public void deletar(Hemograma hemograma) {
        hemogramaDao.delete(findById(hemograma.getId()));
    }

    public Hemograma findById(Long id) {
        return hemogramaDao.porId(id);
    }

    public List<Hemograma> todos() {
        return hemogramaDao.todos();
    }

    /**
     * Responsável pelo calculo do HGM baseado na formula informada pelo
     * biomédico.
     *
     * @param hemoglobina
     * @param eritrocitos
     * @return
     */
    public Double calculoHGM(Double hemoglobina, Double eritrocitos) {
        return (hemoglobina / eritrocitos) * 10;
    }

    /**
     * Responsável pelo calculo do VGM baseado na formula informada pelo
     * biomédico. 
     * @param hematocrito
     * @param eritrocitos
     * @return 
     */
    public Double calculoVGM(Double hematocrito, Double eritrocitos) {
        return (hematocrito / eritrocitos) * 10;
    }

    /**
     * Responsável pelo calculo do CHGM baseado na formula informada pelo
     * biomédico.
     * @param hematocrito
     * @param hemoglobina
     * @return 
     */
    public Double calculoCHGM(Double hematocrito, Double hemoglobina) {
        return (hemoglobina / hematocrito) * 100;
    }

}
