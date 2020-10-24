package br.com.clinicumlab.enumeracao;

import java.io.Serializable;
import lombok.Getter;

/**
 * Enumeração que retorna os estados brasileiros e suas siglas para as telas de
 * cadastro.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum ExameCategoria implements Serializable {

    HEMATOLOGIA("Hematologia"),
    URINALISE("Urinálise"),
    PARASITOLOGIA("Parasitologia"),
    BIOQUIMICA("Bioquímica"),
    SOROLOGIA("Sorologia");

    @Getter
    private final String descricao;

    ExameCategoria(String descricao) {
        this.descricao = descricao;
    }

}
