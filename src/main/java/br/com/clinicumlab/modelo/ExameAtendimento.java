package br.com.clinicumlab.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Responsável por disponibilizar exames para o atendimento.
 *
 * @author cassio
 */
@Data
@Entity
@Table(name = "exame_atendimento")
public class ExameAtendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;
    
    @Column(name = "urgencia")
    private boolean isUrgencia;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "previsao_entrega")
    private Date previsaoEntrega;
    
//    @ManyToOne
//    @JoinColumn(name = "exame_id", nullable = false)
//    private Exame exame;

}
