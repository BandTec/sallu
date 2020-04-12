package com.sallu.api.models.dto;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
public class LoginDTO implements Serializable {

    @Id
    @GeneratedValue
    private Integer idTbLogin;
    private String email;
    private String password;
    @OneToOne
    private CadastroDTO fkLogin;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getIdTbLogin() {
        return idTbLogin;
    }

    public void setIdTbLogin(Integer idTbLogin) {
        this.idTbLogin = idTbLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CadastroDTO getFkLogin() {
        return fkLogin;
    }

    public void setFkLogin(CadastroDTO fkLogin) {
        this.fkLogin = fkLogin;
    }
}
