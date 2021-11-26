
package model.bean;

/**
 *
 * @author olive
 */
public class Visita {
    private int codigo;
    private String nome;
    private String cpf;
    private String endereco;
    private String cep;
    private String celular;
    private String codigoGerado;
    private String andar;
    private String sala;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getCelular() {
        return celular;
    }

    public String getCodigoGerado() {
        return codigoGerado;
    }

    public String getAndar() {
        return andar;
    }

    public String getSala() {
        return sala;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCodigoGerado(String codigoGerado) {
        this.codigoGerado = codigoGerado;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
