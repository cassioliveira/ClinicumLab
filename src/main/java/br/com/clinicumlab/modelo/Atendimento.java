package br.com.clinicumlab.modelo;

import br.com.clinicumlab.enumeracao.FormaPagamento;
import br.com.clinicumlab.enumeracao.StatusAtendimento;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Classe que representa os dados do atendimento do cliente.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Data
@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "protocolo", length = 50)
    private String protocolo;

    @Column(name = "requisitante", length = 150)
    private String requisitante;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atendimento", nullable = false)
    private Date dataAtendimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_coleta")
    private Date dataColeta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Column(name = "local_coleta", length = 20)
    private String localColeta;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false, length = 20)
    private FormaPagamento pagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_atendimento", nullable = false, length = 20)
    private StatusAtendimento statusAtendimento;

    @Column(name = "cliente", length = 100)
    private String cliente;

    @Column(name = "material", length = 100)
    private String material;

    @Column(name = "tipo_coleta", length = 50)
    private String tipoColeta;

//    @OneToOne
    private String convenio;

//    @OneToOne
//    private Cliente cliente;
//    @ManyToOne
//    @JoinColumn(name = "atendente_id", nullable = false)
//    private Usuario atendente;
//    @OneToMany
//    private List<ExameAtendimento> exames;
    public Atendimento() {
        this.setPagamento(pagamento.DINHEIRO);
        this.setStatusAtendimento(statusAtendimento.ABERTO);
    }
}
