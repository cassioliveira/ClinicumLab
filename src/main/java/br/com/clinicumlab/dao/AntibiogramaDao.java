package br.com.clinicumlab.dao;

import br.com.clinicumlab.modelo.Antibiograma;
import java.io.Serializable;

/**
 * 
 * @author cassio
 */
public class AntibiogramaDao extends DaoAbstrato<Antibiograma> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public AntibiogramaDao() {
        super(Antibiograma.class);
    }
}
