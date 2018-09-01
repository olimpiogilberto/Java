package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exe01 {
	
	private static String cpf;
	private static String message;
	
	public static void main(String args[]) throws Exception{
		
		setMessage("Informe seu CPF: ");
		
		 JOptionPane.showInputDialog(getMessage());
		
		System.out.println("CPF:" + getCpf());
		
	}

	public static String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		cpf = cpf;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		message = message;
	}
}