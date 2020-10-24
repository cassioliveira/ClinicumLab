package br.com.clinicumlab.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class Clinica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "razao", length = 150)
    private String razaoSocial;

//    @Column(name = "cpf", nullable = false, unique = true, length = 11)
//    private String cpf;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 15)
    private String rg;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "facebook", length = 50)
    private String facebook;

    @Column(name = "twitter", length = 20)
    private String twitter;

    @Column(name = "instagram", length = 50)
    private String instagram;

    @Column(name = "skype", length = 50)
    private String skype;

    @Column(name = "telefone1", length = 20)
    private String telefone1;

    @Column(name = "telefone2", length = 20)
    private String telefone2;

    @Column(name = "whatsapp", length = 20)
    private String whatsapp;

    @Column(name = "celular", length = 20)
    private String celular;

    @Valid
    @Embedded
    private ResponsavelClinica responsavelClinica;

    @Column(name = "rua", length = 100)
    private String rua;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "estado", length = 30)
    private String estado;

    @Column(name = "cidade", length = 50)
    private String cidade;

    public Clinica() {
        responsavelClinica = new ResponsavelClinica();
    }
    
}
