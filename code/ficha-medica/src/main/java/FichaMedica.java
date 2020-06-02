import java.time.LocalDate;

public class FichaMedica {

  private Integer id;
  private Double peso;
  private Double altura;
  private Double pressaoArterial;
  private Double temperaturaCorporal;
  private String sexo;
  private String nome;
  private String dataCiclo;
  private LocalDate dataFicha;
  private boolean gestante;

    public FichaMedica(Integer id, Double peso, Double altura, Double pressaoArterial, Double temperaturaCorporal, String sexo, String nome, String dataCiclo, LocalDate dataFicha, boolean gestante) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.temperaturaCorporal = temperaturaCorporal;
        this.sexo = sexo;
        this.nome = nome;
        this.dataCiclo = dataCiclo;
        this.dataFicha = dataFicha;
        this.gestante = gestante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(Double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public Double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(Double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCiclo() {
        return dataCiclo;
    }

    public void setDataCiclo(String dataCiclo) {
        this.dataCiclo = dataCiclo;
    }

    public LocalDate getDataFicha() {
        return dataFicha;
    }

    public void setDataFicha(LocalDate dataFicha) {
        this.dataFicha = dataFicha;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    @Override
    public String toString() {
        return "FichaMedica{" +
                "id=" + id +
                ", peso=" + peso +
                ", altura=" + altura +
                ", pressaoArterial=" + pressaoArterial +
                ", temperaturaCorporal=" + temperaturaCorporal +
                ", sexo='" + sexo + '\'' +
                ", nome='" + nome + '\'' +
                ", dataCiclo='" + dataCiclo + '\'' +
                ", dataFicha=" + dataFicha +
                ", gestante=" + gestante +
                '}';
    }
}
