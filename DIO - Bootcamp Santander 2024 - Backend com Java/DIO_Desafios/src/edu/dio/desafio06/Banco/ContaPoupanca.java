package edu.dio.desafio06.Banco;

public class ContaPoupanca extends Conta
{
	public void extrato()
	{
		System.out.println("Extrato da Conta Poupança\n" 
				+ "Agência: " + super.agencia + "\n"
				+ "Conta: " + super.numero + "\n"
				+ "Saldo: " + super.saldo + "\n");
	}
}
