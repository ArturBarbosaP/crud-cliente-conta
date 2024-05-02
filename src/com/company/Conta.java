package com.company;

public class Conta
{
    private int numero_conta;
    private double saldo;

    public Conta(int numero_conta)
    {
        this.numero_conta = numero_conta;
        this.saldo = 0;
    }

    public int getNumero_conta()
    {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta)
    {
        this.numero_conta = numero_conta;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public void Sacar(double valor)
    {
        if (valor > saldo)
        {
            System.out.println("Erro: Saldo insuficiente!");
        }
        else if (valor <= 0)
        {
            System.out.println("Erro: O valor nao pode ser 0 ou negativo!");
        }
        else
        {
            saldo -= valor;
            System.out.println("R$" + valor + " sacado da conta");
        }
    }

    public void Depositar(double valor)
    {
        if (valor > 0)
        {
            saldo += valor;
            System.out.println("R$" + valor + " depositado na conta");
        }
        else
            System.out.println("Erro: O valor nao pode ser 0 ou negativo!");
    }
}