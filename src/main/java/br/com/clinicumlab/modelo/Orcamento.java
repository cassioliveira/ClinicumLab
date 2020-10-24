package br.com.clinicumlab.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Orçamento a ser persistida no
 * banco, com todos os seus atributos.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @Column(name = "desconto")
    private BigDecimal desconto;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "previsao_entrega")
    private Date prevEntrega;
    
    @Column(name = "total_bruto")
    private BigDecimal totalBruto;
    
    @Column(name = "total_desconto")
    private BigDecimal totalDesconto;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exame> itensExames = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name = "convenio_pk")
    private Convenio convenio;

    
}
