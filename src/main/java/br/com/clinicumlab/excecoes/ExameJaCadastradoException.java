package br.com.clinicumlab.excecoes;

import java.io.Serializable;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ExameJaCadastradoException extends Exception implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public ExameJaCadastradoException(String message) {
        super(message);
    }
    
}
