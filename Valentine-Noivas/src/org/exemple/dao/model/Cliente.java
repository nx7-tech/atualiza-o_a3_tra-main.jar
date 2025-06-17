package org.exemple.dao.model;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String endereco, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() { return telefone; }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }
}
//CLASSE AGENDAMENTO