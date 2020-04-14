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
@Table(name = "tb_cadastro")
public class CadastroModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_cadastro")
    private Integer idTbCadastro;

    @JsonProperty
    @Column(name = "cad_nome")
    private String nome;

    @JsonProperty
    @Column(name = "cad_email")
    private String email;

    @JsonProperty
    @Column(name = "cad_telefone")
    private String telefone;

    @JsonProperty
    @Column(name = "cad_nassc")
    private Date dtNascimento;

    @JsonProperty
    @Column(name = "cad_ide")
    private Integer identificacao;

    @JsonProperty
    @Column(name = "cad_crm")
    private String crm;
//    @OneToOne(mappedBy = "fkLogin")
//    private Set<LoginDTO> fkLogin = new HashSet<>();
//    Chave estrangeira TbLogin e TbEnfermeiro
//    OneToOne(mappedBy = "fkEnferemeiro")
//    private Set<> fkEnfermeiro = new HashSet<>();

}
