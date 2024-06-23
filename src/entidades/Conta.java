package entidades;

import model.exceptions.DomainException;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}


	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public void deposito(Double deposito) {
		this.saldo += deposito;
		
	}
	
	public void saque(Double saque) {
		if(saque > limiteDeSaque) {
			throw new DomainException(" O valor excede o limite de saque;");
		}
		if(saque > saldo) {
			throw new DomainException(" Saldo insuficiente");
		}
		this.saldo -= saque;
	}

	@Override
	public String toString() {
		return "Novo saldo:" 
				+ "R$ "
				+ String.format("%.2f", saldo);
	}
	
	
	
	

}
