package br.com.clinicumlab.excecoes;

import java.io.Serializable;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class NegocioException extends RuntimeException implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }
    
}
