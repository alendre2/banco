package aplicativo;

import java.util.Scanner;

import entidades.Conta;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Insira os dados da conta:");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			sc.nextLine();
			System.out.print("Titula: ");
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limite = sc.nextDouble();
			
			Conta conta = new Conta(numero, titular, saldo, limite);
			
			System.out.println(conta);

			
			System.out.println();
			
			System.out.print("Insira o valor para saque: ");
			double saque = sc.nextDouble();
			conta.saque(saque);
			
			System.out.println(conta);
		
		}
		catch(DomainException e) {
			System.out.println("Erro de saque:" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
