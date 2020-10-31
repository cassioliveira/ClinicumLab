package br.com.clinicumlab.modelo;

import br.com.clinicumlab.enumeracao.Estados;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cadastro")
    private Date cadastro;

    @Column(name = "nome", nullable = false, length = 150)
    @NotNull(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "nome_social", length = 100)
    private String nomeSocial;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "email", length = 100)
    private String email;

    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "rg", length = 15)
    private String rg;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "celular", length = 20)
    private String celular;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "rua", length = 100)
    private String rua;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estados estado;
    
    @Column(name = "cep", length = 10)
    private String cep;
    
    @Column(name = "tipo_sanguineo", length = 2)
    private String tipoSanguineo;
    
    @Column(name = "fator_rh", length = 15)
    private String fatorRH;
    
}
