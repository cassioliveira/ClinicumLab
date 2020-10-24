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
public class Antibiograma extends Exame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "is_negativo", length = 20)
    private boolean isNegativo;

    @Column(length = 1)
    private String cefadroxil;

    @Column(length = 1)
    private String cefalexina;

    @Column(length = 1)
    private String cefazolina;

    @Column(length = 1)
    private String cefalotina;

    @Column(length = 1)
    private String cefaclor;

    @Column(length = 1)
    private String cefoxitina;

    @Column(length = 1)
    private String cefuroxima;

    @Column(length = 1)
    private String cefotaxima;

    @Column(length = 1)
    private String ceftriaxona;

    @Column(length = 1)
    private String cefaperozana;

    @Column(length = 1)
    private String ceftadizima;

    @Column(length = 1)
    private String imipenen;

    @Column(length = 1)
    private String amoxicilina;

    @Column(length = 1)
    private String ampicilina;

    @Column(length = 1)
    private String carbenicilina;

    @Column(length = 1)
    private String oxacilina;

    @Column(length = 1)
    private String penicilinag;

    @Column(length = 1)
    private String norfloxacina;

    @Column(length = 1)
    private String ciprofloxacina;

    @Column(length = 1)
    private String pefloxacina;

    @Column(length = 1)
    private String ofloxacina;

    @Column(length = 1)
    private String sulfatrimetroprim;

    @Column(length = 1)
    private String nalidixico;

    @Column(length = 1)
    private String pipemidico;

    @Column(length = 1)
    private String nitrofurantoina;

    @Column(length = 1)
    private String amicacina;

    @Column(length = 1)
    private String gentamicina;

    @Column(length = 1)
    private String tobramicina;

    @Column(length = 1)
    private String doxiciclina;

    @Column(length = 1)
    private String tetraciclina;

    @Column(length = 1)
    private String eritromicina;

    @Column(length = 1)
    private String clindamicina;

    @Column(length = 1)
    private String cloranfenicol;

    @Column(length = 1)
    private String lincomicina;

}
