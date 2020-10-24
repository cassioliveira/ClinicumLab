package br.com.clinicumlab.modelo;

import br.com.clinicumlab.enumeracao.Estados;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
@Table(name = "convenio")
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome do convênio deve ser informado")
    @Column(name = "nome", nullable = false, length = 100)
    private String nomeConvenio;

    @Column(name = "nome_contato", length = 100)
    private String nomeContato;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estados estado;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "desconto")
    private BigDecimal desconto;

    @Column(name = "desconto2")
    private BigDecimal desconto2;
    
}
