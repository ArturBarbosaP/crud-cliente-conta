package com.company;

public class Cliente
{
    private String nome;
    private String cpf;
    private int idade;
    private String endereco;
    private Conta conta;

    public Cliente(String nome, String cpf, int idade, String endereco)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public Conta getConta()
    {
        return conta;
    }
}