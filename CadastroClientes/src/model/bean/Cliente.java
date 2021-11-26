package model.bean;
//Temos aqui os atributos do banco de dados
/**
 *
 * @author Olive */
public class Cliente {
    private int Codigo;
    private String Nome;
    private String Endereco;
    private String Fone;
    private String Celular;
    private String Sexo;
    private String Obs;

    public int getCodigo() {
        return Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getFone() {
        return Fone;
    }

    public String getCelular() {
        return Celular;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getObs() {
        return Obs;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }
}
