package br.com.clinicumlab.dao;

import br.com.clinicumlab.modelo.Espermograma;
import java.io.Serializable;

/**
 * 
 * @author cassio
 */
public class EspermogramaDao extends DaoAbstrato<Espermograma> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public EspermogramaDao() {
        super(Espermograma.class);
    }
}
