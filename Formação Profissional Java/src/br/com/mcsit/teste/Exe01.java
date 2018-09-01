package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exe01 {
	
	private String cpf;
	private String message;
	
	public static void main(String args[]) throws Exception{
		
		setMessage("Informe seu CPF: ");
		
		 JOptionPane.showInputDialog(getMessage());
		
		System.out.println("CPF:" + getCpf());
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}