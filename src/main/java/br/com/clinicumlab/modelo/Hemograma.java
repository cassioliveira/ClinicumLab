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
public class Hemograma extends Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 100)
    private Double eritrocitos;
    
    @Column(length = 100)
    private Double hemoglobina;
    
    @Column(length = 100)
    private Double hematocrito;
    
    @Column(length = 100)
    private String referenciaVgm;
    
    @Column(length = 100)
    private String referenciaHgm;
    
    @Column(length = 100)
    private String referenciaChgm;
    
    @Column(length = 100)
    private String eritrocitosReferenciaHomem;
    
    @Column(length = 100)
    private String hemoglobinaReferenciaHomem;
    
    @Column(length = 100)
    private String hematocritoReferenciaHomem;
    
    @Column(length = 100)
    private String eritrocitosReferenciaMulher;
    
    @Column(length = 100)
    private String hemoglobinaReferenciaMulher;
    
    @Column(length = 100)
    private String hematocritoReferenciaMulher;
    
    @Column(length = 100)
    private String leucocitos;
    
    @Column(length = 100)
    private String neutrofilos;
    
    @Column(length = 100)
    private String bastonetes;
    
    @Column(length = 100)
    private String segmentados;
    
    @Column(length = 100)
    private String eosinofilos;
    
    @Column(length = 100)
    private String basofilos;
    
    @Column(length = 100)
    private String linfocitos;
    
    @Column(length = 100)
    private String tipicos;
    
    @Column(length = 100)
    private String atipicos;
    
    @Column(length = 100)
    private String monocitos;
    
    @Column(length = 100)
    private String plasmocitos;
    
    @Column(length = 100)
    private String plaquetas;
    
    @Column(length = 100)
    private String leucocitosPercentual;
    
    @Column(length = 100)
    private String neutrofilosPercentual;
    
    @Column(length = 100)
    private String bastonetesPercentual;
    
    @Column(length = 100)
    private String segmentadosPercentual;
    
    @Column(length = 100)
    private String eosinofilosPercentual;
    
    @Column(length = 100)
    private String basofilosPercentual;
    
    @Column(length = 100)
    private String linfocitosPercentual;
    
    @Column(length = 100)
    private String tipicosPercentual;
    
    @Column(length = 100)
    private String atipicosPercentual;
    
    @Column(length = 100)
    private String monocitosPercentual;
    
    @Column(length = 100)
    private String plasmocitosPercentual;
    
    @Column(length = 100)
    private String plaquetasPercentual;
    
    @Column(length = 100)
    private String leucocitosMm3;
    
    @Column(length = 100)
    private String neutrofilosMm3;
    
    @Column(length = 100)
    private String bastonetesMm3;
    
    @Column(length = 100)
    private String segmentadosMm3;
    
    @Column(length = 100)
    private String eosinofilosMm3;
    
    @Column(length = 100)
    private String basofilosMm3;
    
    @Column(length = 100)
    private String linfocitosMm3;
    
    @Column(length = 100)
    private String tipicosMm3;
    
    @Column(length = 100)
    private String atipicosMm3;
    
    @Column(length = 100)
    private String monocitosMm3;
    
    @Column(length = 100)
    private String plasmocitosMm3;
    
    @Column(length = 100)
    private String plaquetasMm3;
    
}
