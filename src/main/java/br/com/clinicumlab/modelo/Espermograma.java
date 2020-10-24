package br.com.clinicumlab.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Cássio Oliveira<cassio@cassioliveira.com.br>
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Espermograma extends Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 100)
    private String volume;
    
    @Column(length = 100)
    private String aspecto;
    
    @Column(length = 100)
    private String cor;
    
    @Column(length = 100)
    private String viscosidade;
    
    @Column(length = 100)
    private String liquefacao;
    
    @Column(length = 100)
    private String ph;
    
    @Column(length = 100)
    private String numeroEspermatozoides;
    
    @Column(length = 100)
    private String leucocitos;
    
    @Column(length = 100)
    private String hemacias;
    
    @Column(length = 100)
    private String formasNormais;
    
    @Column(length = 100)
    private String bicefalicos;
    
    @Column(length = 100)
    private String bicaudais;
    
    @Column(length = 100)
    private String microcefalicos;
    
    @Column(length = 100)
    private String macrocefalicos;
    
    @Column(length = 100)
    private String motilidadeImediata;
    
    @Column(length = 100)
    private String motilidade6Hora;
    
    @Column(length = 100)
    private String volumeReferencia;
    
    @Column(length = 100)
    private String aspectoReferencia;
    
    @Column(length = 100)
    private String corReferencia;
    
    @Column(length = 100)
    private String viscosidadeReferencia;
    
    @Column(length = 100)
    private String liquefacaoReferencia;
    
    @Column(length = 100)
    private String phReferencia;
    
    @Column(length = 100)
    private String numeroEspermatozoidesReferencia;
    
    @Column(length = 100)
    private String leucocitosReferencia;
    
    @Column(length = 100)
    private String hemaciasReferencia;
    
    @Column(length = 100)
    private String formasNormaisReferencia;
    
    @Column(length = 100)
    private String bicefalicosReferencia;
    
    @Column(length = 100)
    private String bicaudaisReferencia;
    
    @Column(length = 100)
    private String microcefalicosReferencia;
    
    @Column(length = 100)
    private String macrocefalicosReferencia;
    
    @Column(length = 100)
    private String motilidadeImediataReferencia;
    
    @Column(length = 100)
    private String motilidade6HoraReferencia;
}
