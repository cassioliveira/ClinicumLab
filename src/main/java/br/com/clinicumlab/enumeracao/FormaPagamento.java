package br.com.clinicumlab.enumeracao;

import java.io.Serializable;
import lombok.Getter;

public enum FormaPagamento implements Serializable {

    DINHEIRO("Dinheiro"),
    TRANSFERENCIA("Transferência"),
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de débito"),
    BOLETO("Boleto"),
    CHEQUE("Cheque");

    @Getter
    private final String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

}
