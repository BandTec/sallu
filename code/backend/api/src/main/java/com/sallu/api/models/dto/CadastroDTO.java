package com.sallu.api.models.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name ="tb_Cadastro")
public class CadastroDTO {
    @Id
    @GeneratedValue
    private Integer idTbCadastro;
    private String nome;
    private String email;
    private String telefone;
    private Date dtNascimento;
    private Integer identificacao;
    private String crm;

//    Chave estrangeira TbLogin e TbEnfermeiro
//    OneToOne(mappedBy = "fkLogin")
//    private Set<> fkLogin = new HashSet<>();
//    OneToOne(mappedBy = "fkEnferemeiro")
//    private Set<> fkEnfermeiro = new HashSet<>();


    public Integer getIdTbCadastro() {
        return idTbCadastro;
    }

    public void setIdTbCadastro(Integer idTbCadastro) {
        this.idTbCadastro = idTbCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Integer identificacao) {
        this.identificacao = identificacao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
