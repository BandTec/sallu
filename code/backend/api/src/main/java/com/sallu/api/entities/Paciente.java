package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_paciente")
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_paciente")
    private Integer idPaciente;

    @JsonProperty
    @Column(name = "paciente_nome")
    private String nomePaciente;

    @JsonProperty
    @Column(name = "paciente_telefone")
    private String telefonePaciente;

    @JsonProperty
    @Column(name = "email_paciente", length = 45, nullable = false)
    private Date emailPaciente;

    @JsonProperty
    @Column(name = "senha_paciente", length = 45, nullable = false)
    private Date senhaPaciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_classificacoes")
    private Classificacao fkClassificacoes;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_login", referencedColumnName = "pk_login")
//    private LoginModel fkLogin;

}