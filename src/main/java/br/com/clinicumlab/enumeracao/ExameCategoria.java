package br.com.clinicumlab.enumeracao;

import java.io.Serializable;
import lombok.Getter;

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
