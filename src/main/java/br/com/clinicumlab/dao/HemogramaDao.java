package br.com.clinicumlab.dao;

import br.com.clinicumlab.modelo.Hemograma;
import java.io.Serializable;

/**
 * 
}
 * @author cassio
 */
public class HemogramaDao extends DaoAbstrato<Hemograma> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public HemogramaDao() {
        super(Hemograma.class);
    }
}
