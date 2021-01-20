package br.com.clinicumlab.enumeracao;

import java.io.Serializable;
import lombok.Getter;

public enum ExameCategoria implements Serializable {

    BIOQUIMICA("Bioquímica"),
    ENDOCRINOLOGIA("Endocrinologia"),
    HEMATOLOGIA("Hematologia"),
    MICROBIOLOGIA("Microbiologia"),
    MICOLOGIA("Micologia"),
    PARASITOLOGIA("Parasitologia"),
    SOROLOGIA("Sorologia"),
    URINALISE("Urinálise");

    @Getter
    private final String descricao;

    ExameCategoria(String descricao) {
        this.descricao = descricao;
    }

}
