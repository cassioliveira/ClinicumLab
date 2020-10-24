package br.com.clinicumlab.modelo;

import br.com.clinicumlab.enumeracao.ExameCategoria;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 20)
    private String codigo;

    @Column(name = "material", length = 50)
    private String material;

    @Column(name = "metodologia", length = 50)
    private String metodologia;

    @Column(name = "resultado", length = 50)
    private String resultado;

    @Column(name = "valor")
    private BigDecimal valor;

    @NotNull(message = "Informe o nome do exame")
    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ExameCategoria categoria;

    @Lob
    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "valores", length = 200)
    private String valoresDeReferencia;

}
