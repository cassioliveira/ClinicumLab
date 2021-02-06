package br.com.clinicumlab.excecoes;

import java.io.Serializable;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ExameJaCadastradoException extends RuntimeException implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ExameJaCadastradoException(String message) {
        super(message);
    }
    
}
