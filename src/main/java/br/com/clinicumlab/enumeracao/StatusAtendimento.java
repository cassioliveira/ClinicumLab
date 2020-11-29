package br.com.clinicumlab.enumeracao;

import java.io.Serializable;
import lombok.Getter;

/**
 * Enumeração que retorna os estados brasileiros e suas siglas para as telas de
 * cadastro.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum StatusAtendimento implements Serializable {

    ORCAMENTO("Orçamento"),
    ABERTO("Aberto"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluído");

    @Getter
    private final String descricao;

    StatusAtendimento(String descricao) {
        this.descricao = descricao;
    }

}
