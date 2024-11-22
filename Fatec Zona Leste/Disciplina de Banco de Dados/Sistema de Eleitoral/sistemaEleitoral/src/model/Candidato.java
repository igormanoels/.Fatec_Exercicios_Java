package model;

import java.sql.Date;

public class Candidato {
    
    private int numero;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String estado;

    public Candidato(Object...obj) {
        this.numero = Integer.parseInt((String) obj[0]);
        this.nome = String.valueOf(obj[1]);
        this.cpf = String.valueOf(obj[2]);
        this.nascimento = (Date) obj[3];
        this.estado = String.valueOf(obj[4]);
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
}
