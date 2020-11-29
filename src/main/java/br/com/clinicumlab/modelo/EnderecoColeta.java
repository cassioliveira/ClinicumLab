package br.com.clinicumlab.modelo;

import br.com.clinicumlab.enumeracao.Estados;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Data
public class EnderecoColeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estados estado;

    @Column(name = "cep", length = 10)
    private String cep;

}
