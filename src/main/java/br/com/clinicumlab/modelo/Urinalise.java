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
public class Urinalise extends Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 100)
    private String volume;
    
    @Column(length = 100)
    private String aspecto;
    
    @Column(length = 100)
    private String cor;
    
    @Column(length = 100)
    private String ph;
    
    @Column(length = 100)
    private String densidade;
    
    @Column(length = 100)
    private String volumeReferencia;
    
    @Column(length = 100)
    private String aspectoReferencia;
    
    @Column(length = 100)
    private String corReferencia;
    
    @Column(length = 100)
    private String phReferencia;
    
    @Column(length = 100)
    private String densidadeReferencia;
    
    @Column(length = 100)
    private String proteinas;
    
    @Column(length = 100)
    private String glicose;
    
    @Column(length = 100)
    private String corposCetonicos;
    
    @Column(length = 100)
    private String urobilinogenio;
    
    @Column(length = 100)
    private String bilirrubinas;
    
    @Column(length = 100)
    private String hemoglobinaLivre;
    
    @Column(length = 100)
    private String pigmentosBiliares;
    
        @Column(length = 100)
    private String proteinasReferencia;
    
    @Column(length = 100)
    private String glicoseReferencia;
    
    @Column(length = 100)
    private String corposCetonicosReferencia;
    
    @Column(length = 100)
    private String urobilinogenioReferencia;
    
    @Column(length = 100)
    private String bilirrubinasReferencia;
    
    @Column(length = 100)
    private String hemoglobinaLivreReferencia;
    
    @Column(length = 100)
    private String pigmentosBiliaresReferencia;
    
    @Column(length = 100)
    private String leucocitos;
    
    @Column(length = 100)
    private String hemacias;
    
    @Column(length = 100)
    private String celulasEpiteliais;
    
    @Column(length = 100)
    private String cilindros;
    
    @Column(length = 100)
    private String cristais;
    
    @Column(length = 100)
    private String outrosElementos;
    
    @Column(length = 100)
    private String bacterias;
    
    @Column(length = 100)
    private String leucocitosReferencia;
    
    @Column(length = 100)
    private String hemaciasReferencia;
    
    @Column(length = 100)
    private String celulasEpiteliaisReferencia;
    
    @Column(length = 100)
    private String cilindrosReferencia;
    
    @Column(length = 100)
    private String cristaisReferencia;
    
    @Column(length = 100)
    private String outrosElementosReferencia;
    
    @Column(length = 100)
    private String bacteriasReferencia;
}
