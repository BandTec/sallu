package com.sallu.api.models.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name= "tb_Especialista")
public class EspecialistaDTO {
    @Id
    @GeneratedValue
    private Integer idTbEspecialista;
    private String tipoEspecialista;
    private String corClassificada;
    @ManyToOne
    private DadosDTO fkEspecialista;
//    Chave estrangeira tbHospital
//    @ManyToOne
//    private  fkHospital;


    public Integer getIdTbEspecialista() {
        return idTbEspecialista;
    }

    public void setIdTbEspecialista(Integer idTbEspecialista) {
        this.idTbEspecialista = idTbEspecialista;
    }

    public String getTipoEspecialista() {
        return tipoEspecialista;
    }

    public void setTipoEspecialista(String tipoEspecialista) {
        this.tipoEspecialista = tipoEspecialista;
    }

    public String getCorClassificada() {
        return corClassificada;
    }

    public void setCorClassificada(String corClassificada) {
        this.corClassificada = corClassificada;
    }

    public DadosDTO getFkEspecialista() {
        return fkEspecialista;
    }

    public void setFkEspecialista(DadosDTO fkEspecialista) {
        this.fkEspecialista = fkEspecialista;
    }
}
