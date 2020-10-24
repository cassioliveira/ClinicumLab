package br.com.clinicumlab.dao;

import br.com.clinicumlab.modelo.Urinalise;
import java.io.Serializable;

/**
 * 
}
 * @author cassio
 */
public class UrinaliseDao extends DaoAbstrato<Urinalise> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public UrinaliseDao() {
        super(Urinalise.class);
    }
}
