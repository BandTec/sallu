public class FichaMedica {

  private Integer id;
  private Double peso;
  private Double altura;
  private Double pressaoArterial;
  private Double temperaturaCorporal;
  private String sexo;
  private String nome;
  private String dataCiclo;
  private String dataFicha;
  private boolean gestante;

    public FichaMedica(int id, Double peso, Double altura, Double pressaoArterial, Double pressaoCorporal, String sexo, String nome, String dataCiclo, String dataUltFicha) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.temperaturaCorporal = pressaoCorporal;
        this.sexo = sexo;
        this.nome = nome;
        this.dataCiclo = dataCiclo;
        this.dataFicha = dataUltFicha;
        this.gestante = gestante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Double getPressaoCorporal() {
        return temperaturaCorporal;
    }

    public void setPressaoCorporal(Double pressaoCorporal) {
        this.temperaturaCorporal = pressaoCorporal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlergia() {
        return nome;
    }

    public void setAlergia(String alergia) {
        this.nome = alergia;
    }

    public String getDataCiclo() {
        return dataCiclo;
    }

    public void setDataCiclo(String dataCiclo) {
        this.dataCiclo = dataCiclo;
    }

    public String getDataUltFicha() {
        return dataFicha;
    }

    public void setDataUltFicha(String dataUltFicha) {
        this.dataFicha = dataUltFicha;
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
                ", pressaoCorporal=" + temperaturaCorporal +
                ", sexo='" + sexo + '\'' +
                ", alergia='" + nome + '\'' +
                ", dataCiclo='" + dataCiclo + '\'' +
                ", dataUltFicha='" + dataFicha + '\'' +
                ", gestante='" + gestante + '\''+
                '}';
    }
}
