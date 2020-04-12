package com.sallu.api.models.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="tb_Dados")
public class DadosDTO {
    @Id
    @GeneratedValue
    private Integer idTbDados;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double pressaocorporal;
    private String sexo;
    private String alergia;
    private Date dataUltCiclo;
    @OneToMany(mappedBy = "fkEspecialista")
    private Set<EspecialistaDTO> fkEspecialista = new HashSet<>();
//    Chave estrangeira tbLogin
//    @OneToOne
//    private  fkLogin;


    public Integer getIdTbDados() {
        return idTbDados;
    }

    public void setIdTbDados(Integer idTbDados) {
        this.idTbDados = idTbDados;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public double getPressaocorporal() {
        return pressaocorporal;
    }

    public void setPressaocorporal(double pressaocorporal) {
        this.pressaocorporal = pressaocorporal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public Date getDataUltCiclo() {
        return dataUltCiclo;
    }

    public void setDataUltCiclo(Date dataUltCiclo) {
        this.dataUltCiclo = dataUltCiclo;
    }

    public Set<EspecialistaDTO> getFkEspecialista() {
        return fkEspecialista;
    }

    public void setFkEspecialista(Set<EspecialistaDTO> fkEspecialista) {
        this.fkEspecialista = fkEspecialista;
    }
}
