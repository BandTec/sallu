package com.sallu.api.models;
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
public class PacienteModel implements Serializable {
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
    @Column(name = "data_nascimento")
    private Date dtNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hospital", referencedColumnName = "pk_hospital")
    private HospitalModel fkHospital;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_login", referencedColumnName = "pk_login")
//    private LoginModel fkLogin;

}