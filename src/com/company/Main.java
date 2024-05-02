package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Lista de clientes
        List<Cliente> listaClientes = new ArrayList<>();

        while (true) //sempre rodar o menu
        {
            switch (Menu())
            {
                case 1:
                    boolean opcaoCliente = true;

                    while (opcaoCliente)//rodar o menu enquanto o valor 5 for digitado
                    {
                        switch (SubMenuCliente())
                        {
                            case 1:
                                CreateCliente(listaClientes);
                                break;

                            case 2:
                                ReadCliente(listaClientes);
                                break;

                            case 3:
                                DeleteCliente(listaClientes);
                                break;

                            case 4:
                                UpdateCliente(listaClientes);
                                break;

                            case 5:
                                opcaoCliente = false;
                                break;

                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                        }
                    }
                    break;

                case 2:
                    boolean opcaoConta = true;

                    while (opcaoConta)//rodar o menu enquanto o valor 6 for digitado
                    {
                        switch (SubMenuContas())
                        {
                            case 1:
                                CreateConta(listaClientes);
                                break;

                            case 2:
                                SacarContaCliente(listaClientes);
                                break;

                            case 3:
                                DepositarContaCliente(listaClientes);
                                break;

                            case 4:
                                VerificarSaldoContaCliente(listaClientes);
                                break;

                            case 5:
                                TranferenciaClienteConta(listaClientes);
                                break;

                            case 6:
                                opcaoConta = false;
                                break;

                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                        }
                    }
                    break;

                case 3:
                    System.exit(3);//sair da aplicacao
                    break;

                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }
    }


    //Menus
    public static int Menu()
    {
        System.out.println("Menu");
        System.out.println("-----------------------------");
        System.out.println("1 - Gerenciar CLIENTES");
        System.out.println("2 - Gerenciar CONTAS");
        System.out.println("3 - SAIR");
        System.out.println("-----------------------------");
        System.out.print("Opcao: ");
        int opcao = LerValorInt();
        System.out.println("-----------------------------");
        return opcao;
    }

    public static int SubMenuCliente()
    {
        System.out.println("Gerenciar CLIENTES");
        System.out.println("-----------------------------");
        System.out.println("1 - Cadastrar CLIENTE");
        System.out.println("2 - Consultar CLIENTE");
        System.out.println("3 - Remover CLIENTE");
        System.out.println("4 - Atualizar CLIENTE");
        System.out.println("5 - Voltar ao MENU INICIAL");
        System.out.println("-----------------------------");
        System.out.print("Opcao: ");
        int opcao = LerValorInt();
        System.out.println("-----------------------------");
        return opcao;
    }

    public static int SubMenuContas()
    {
        System.out.println("Gerenciar CONTAS");
        System.out.println("-----------------------------");
        System.out.println("1 - Criar CONTA para um CLIENTE");
        System.out.println("2 - Sacar dinheiro de uma CONTA de um CLIENTE");
        System.out.println("3 - Depositar dinheiro para uma CONTA de um CLIENTE");
        System.out.println("4 - Verificar saldo de uma CONTA de um CLIENTE");
        System.out.println("5 - Transferir dinheiro de uma CONTA de um CLIENTE para outro CLIENTE");
        System.out.println("6 - Voltar ao MENU INICIAL");
        System.out.println("-----------------------------");
        System.out.print("Opcao: ");
        int opcao = LerValorInt();
        System.out.println("-----------------------------");
        return opcao;
    }


    //crud Clientes
    public static void CreateCliente(List<Cliente> listaClientes)
    {
        System.out.println("Cadastrar CLIENTES");
        System.out.println("-----------------------------");

        System.out.print("Informe o nome do cliente: ");
        String nome = LerValorString();

        System.out.print("Informe o CPF: ");
        String cpf = LerValorString();

        System.out.print("Informe a idade: ");
        int idade = LerValorInt();

        System.out.print("Informe o endereco: ");
        String endereco = LerValorString();

        Cliente cliente = new Cliente(nome, cpf, idade, endereco);

        listaClientes.add(cliente);

        System.out.println("Cliente Cadastrado!");
        System.out.println("-----------------------------");
    }

    public static void ReadCliente(List<Cliente> listaClientes)
    {
        System.out.println("Consultar CLIENTES");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF desejado: ");
        String cpf = LerValorString();

        System.out.println("-----------------------------");

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Endereco: " + cliente.getEndereco());
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void UpdateCliente(List<Cliente> listaClientes)
    {
        System.out.println("Atualizar CLIENTES");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF desejado: ");
        String cpf = LerValorString();

        System.out.println("-----------------------------");

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            System.out.print("Informe o nome do cliente: ");
            cliente.setNome(LerValorString());

            System.out.print("Informe a idade: ");
            cliente.setIdade(LerValorInt());

            System.out.print("Informe o endereco: ");
            cliente.setEndereco(LerValorString());

            System.out.println("Cliente Atualizado!");
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void DeleteCliente(List<Cliente> listaClientes)
    {
        System.out.println("Remover CLIENTES");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF desejado: ");
        String cpf = LerValorString();

        System.out.println("-----------------------------");

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            listaClientes.remove(cliente);
            System.out.println("Cliente Removido!");
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }


    //crud Contas
    public static void CreateConta(List<Cliente> listaClientes)
    {
        System.out.println("Criar CONTA para um CLIENTE");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF do CLIENTE: ");
        String cpf = LerValorString();

        System.out.println();

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            if (cliente.getConta() == null)
            {
                System.out.print("Informe o numero da conta: ");
                int num = LerValorInt();

                Conta conta = new Conta(num);
                cliente.setConta(conta);

                System.out.println("Conta cadastrada para o cliente " + cliente.getNome());
            }
            else
                System.out.println("O cliente " + cliente.getNome() + " ja possui uma conta.");
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void SacarContaCliente(List<Cliente> listaClientes)
    {
        System.out.println("Sacar dinheiro de uma CONTA de um CLIENTE");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF do CLIENTE: ");
        String cpf = LerValorString();

        System.out.println();

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            System.out.print("Digite o valor que deseja sacar: ");
            double valor = LerValorDouble();

            cliente.getConta().Sacar(valor);
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void DepositarContaCliente(List<Cliente> listaClientes)
    {
        System.out.println("Depositar dinheiro para uma CONTA de um CLIENTE");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF do CLIENTE: ");
        String cpf = LerValorString();

        System.out.println();

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            System.out.print("Digite o valor que deseja depositar: ");
            double valor = LerValorDouble();

            cliente.getConta().Depositar(valor);
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void VerificarSaldoContaCliente(List<Cliente> listaClientes)
    {
        System.out.println("Verificar saldo de uma CONTA de um CLIENTE");
        System.out.println("-----------------------------");

        System.out.print("Informe o CPF do CLIENTE: ");
        String cpf = LerValorString();

        System.out.println();

        Cliente cliente = listaClientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);

        if (cliente != null)
        {
            System.out.println("O saldo da conta de " + cliente.getNome() + " e de R$" + cliente.getConta().getSaldo());
        }
        else
            System.out.println("O cliente nao existe!");

        System.out.println("-----------------------------");
    }

    public static void TranferenciaClienteConta(List<Cliente> listaClientes)
    {
        System.out.println("Transferir dinheiro de uma CONTA de um CLIENTE para outro CLIENTE");
        System.out.println("-----------------------------");
        //codigo
        System.out.println("-----------------------------");
    }


    //Inputs
    public static int LerValorInt()
    {
        Scanner valor = new Scanner(System.in);
        return valor.nextInt();
    }

    public static double LerValorDouble()
    {
        Scanner valor = new Scanner(System.in);
        return valor.nextDouble();
    }

    public static String LerValorString()
    {
        Scanner valor = new Scanner(System.in);
        return valor.nextLine();
    }
}