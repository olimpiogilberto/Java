package br.com.mcs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mcs.beans.Pessoa;
import br.com.mcs.model.FabricaConexao;


public class PessoaDAO {
	private Connection conexao;

	public PessoaDAO() {
		this.conexao = FabricaConexao.abreConexao();
	}

	public boolean cadastrar(Pessoa dados) {
		try {
			String sql = "INSERT INTO tbpessoa (Cpf, Nome, Sexo,TAR) "
					+ "VALUES (?, ?, ?)";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
			stm.setString(2, dados.getNome());
			stm.setString(3, dados.getSexo());

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			if(erro.getErrorCode() == 1049){
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return false;	
			}else if(erro.getErrorCode() == 1146){
				
				System.out.println("ERRO: " + erro +
								   "\nTABELA NÃO EXISTE: ");
				return false;	
			}else{
				System.out.println("ERRO NA CLASSE:" + this
						+"\nSQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return false;
			}
		}
	}

	public boolean alterar(Pessoa dados) {
		try {
			String sql = "UPDATE tbpessoa Set Nome = ?, Sexo = ? WHERE Cpf = ? ";
					

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, dados.getNome());
			stm.setString(2, dados.getSexo());
			stm.setLong(3, dados.getCpf());

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			if(erro.getErrorCode() == 1049){
				//Error: 1049 SQLSTATE: 42000 (ER_BAD_DB_ERROR) 
				//Message: Banco de dados '%s' desconhecido 
				System.out.println("ERRO: " + erro +
								   "\nBANCO NÃO CADASTRADO: ");
				return false;	
			}else{
				System.out.println("SQLCODE : " + erro.getErrorCode()
						+"\nERRO: " +erro
						+"\nESTADO: " +erro.getSQLState()
						+"\nMENSAGEM: " +erro.getMessage());
				return false;
			}
	}
	}

	public boolean excluir(Pessoa dados) {
		try {
			String sql = "DELETE FROM tbpessoa WHERE Cpf = ?";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			System.out.println("Erro no Método Excluir" + erro );
			return false;
		}
	}

	public Pessoa consultar(Pessoa dados) {
		try {
			String sql = "SELECT * FROM tbpessoa WHERE Cpf = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());

			ResultSet resultado = stm.executeQuery();

			if (resultado.next()) {
				dados.setNome(resultado.getString("Nome"));
				dados.setCpf(resultado.getLong("Cpf"));
				dados.setSexo(resultado.getString("Sexo"));

				return dados;

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

}

	