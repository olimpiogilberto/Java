package br.com.mcs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	public static Connection abreConexao(){
		try{
			
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/formacao_java";

			//carrega o driver na memoria
			Class.forName(driver);
			
			//Abre a conexao junto ao banco de dados
			return DriverManager.getConnection(url, "root", "admin");
		}
		catch(ClassNotFoundException erro){
			System.out.println("Erro ao abrir a conexao " + erro);
			return null;
		}
		catch(SQLException erro){
			System.out.println("Erro ao abrir a conexao " + erro);
			return null;
		
		}
	}

}
