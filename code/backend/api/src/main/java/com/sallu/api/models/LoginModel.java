package com.sallu.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_login")
public class LoginModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_login")
    private Integer idLogin;

    @JsonProperty
    @Column(name = "login_usuario")
    private String loginUsuario;

    @JsonProperty
    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @JsonProperty
    @Column(name = "nivel_acesso")
    private Boolean nivelAcesso;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkLogin")
//    private List <PacienteModel> paciente;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fklogin")
//    private List<EnfermeiroModel> enfermeiro;

}
