package br.com.clinicumlab.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Classe com dados do responsável da clínica.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Embeddable
public class ResponsavelClinica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "responsavel_nome", nullable = false, length = 150)
    @NotNull(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "responsavel_crbm", length = 20)
    @NotNull(message = "O CRBM deve ser informado")
    private String crbm;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "responsavel_email", length = 100)
    private String email;

    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "responsavel_telefone", length = 20)
    private String telefone;

    @Column(name = "responsavel_celular", length = 20)
    private String celular;
}
