package br.com.mcs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mcs.beans.Funcionario;
import br.com.mcs.beans.Pessoa;

public class FuncionarioDAO {
	private Connection conexao;
	public FuncionarioDAO() {
		this.conexao = FabricaConexao.abreConexao();
	}
	

	public Integer cadastrar(Funcionario func) {
		try {
			String sql = "INSERT INTO tbfuncionario (registro, nome, depto, cargo) "
					+ "VALUES (?, ?, ?, ?)";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, func.getRegistro());
			stm.setString(2, func.getNome());
			stm.setInt(3, func.getDepartamento());
			stm.setInt(4, func.getFuncao());

			Integer erro = stm.executeUpdate();

			return erro;

		} catch (SQLException erro) {
			if(erro.getErrorCode() == 1049){
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return null;	
			}else if(erro.getErrorCode() == 1146){
				
				System.out.println("ERRO: " + erro +
								   "\nTABELA NÃO EXISTE: ");
				return null;	
			}else if(erro.getErrorCode() == 1062){
				System.out.println("ERRO NA CLASSE:" + this
						+"\nSQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\n REGISTRO JÁ CADASTRADO" 
						+"\nMENSAGEM: " +erro.getMessage());
				return 100;
			}else{
				System.out.println("ERRO NA CLASSE:" + this
						+"\nSQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return null;
			}
		}
	}
	
	public Integer alterar(Funcionario func) {
		try {
			String sql = "UPDATE tbfuncionario Set Nome = ?, Depto = ?, cargo = ? WHERE registro = ? ";
					

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, func.getNome());
			stm.setInt(2, func.getDepartamento());
			stm.setInt(3, func.getFuncao());
			stm.setInt(4, func.getRegistro());

			Integer erro = stm.executeUpdate();

			return erro;

		} catch (SQLException erro) {
			if(erro.getErrorCode() == 1049){
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return null;	
			}else if(erro.getErrorCode() == 1146){
				
				System.out.println("ERRO: " + erro +
								   "\nTABELA NÃO EXISTE: ");
				return null;	
			}else{
				System.out.println("ERRO NA CLASSE:" + this
						+"\nSQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return null;
			}
	}
	}
	
	public Integer excluir(Funcionario func) {
		try {
			String sql = "DELETE FROM tbfuncionario WHERE registro = ?";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, func.getRegistro());

			Integer erro = stm.executeUpdate();

			return erro;

		} catch (SQLException erro) {
			if(erro.getErrorCode() == 1049){
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return -1;	
			}else if(erro.getErrorCode() == 1146){
				
				System.out.println("ERRO: " + erro +
								   "\nTABELA NÃO EXISTE: ");
				return -1;	
			}else{
				System.out.println("ERRO NA CLASSE:" + this
						+"\nSQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return -1;
			}
		}
	}
	
	public Funcionario consultar(Funcionario func) {
		try {
			String sql = "SELECT * FROM tbfuncionario WHERE registro = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, func.getRegistro());

			ResultSet resultado = stm.executeQuery();

			if (resultado.next()) {
				func.setNome(resultado.getString("Nome"));
				func.setRegistro(resultado.getInt("Registro"));
				func.setDepartamento(resultado.getInt("depto"));
				func.setFuncao(resultado.getInt("cargo"));
				return func;

			} else {
				return null;
			}
		}

		catch (SQLException erro) {
			
			if(erro.getErrorCode() == 1049){
				//Error: 1049 SQLSTATE: 42000 (ER_BAD_DB_ERROR) 
				//Message: Banco de dados '%s' desconhecido 
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return null;
			}else{
				System.out.println("SQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return null;
			}
		}
	}
	

}//Fim da classe
