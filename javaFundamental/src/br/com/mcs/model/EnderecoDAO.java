package br.com.mcs.model;

import java.sql.*;

import br.com.mcs.beans.*;

/**
 * @autor Gilberto
 * @data 15/11/2015
 * EnderecoDAO.java
 */
public class EnderecoDAO {
	private Connection conexao;

	public EnderecoDAO() {
		this.conexao = FabricaConexao.abreConexao();
	}

	public boolean cadastrar(Endereco end, Long cpf) {
		try {
			String sql = "INSERT INTO tbendereco (Cep, Rua, Numero, bairro, cpf) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, end.getCep());
			stm.setString(2, end.getRua());
			stm.setInt(3, end.getNumero());
			stm.setString(4, end.getBairro());
			stm.setLong(5, cpf);

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			System.out.println("Erro no Método Cadastrar" + erro );
			return false;
		}
	}

	public boolean alterar(Endereco end, Long cpf) {
		try {
			String sql = "UPDATE tbendereco Set Rua = ?, Numero = ?, Cep = ?, Bairro = ? WHERE Cpf = ? ";
					
			
			PreparedStatement stm = conexao.prepareStatement(sql);
			
			stm.setString(1, end.getRua());
			stm.setInt(2, end.getNumero());
			stm.setInt(3, end.getCep());
			stm.setString(4, end.getBairro());
			stm.setLong(5, cpf);

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			System.out.println("SQLCODE : " + erro.getErrorCode()
					+"\nERRO: " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return false;
		}
	}
/*
	public boolean excluir(Endereco end) {
		try {
			String sql = "DELETE FROM tbEndereco WHERE Cep = ?";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, end.getCep());

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			System.out.println("Erro no Método Excluir" + erro );
			return false;
		}
	}*/

	public boolean excluir(Long cpf) {
		try {
			String sql = "DELETE FROM tbEndereco WHERE Cpf = ?";

			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, cpf);

			boolean erro = stm.execute();

			return !erro;

		} catch (SQLException erro) {
			System.out.println("Erro no Método Excluir" + erro );
			return false;
		}
	}
	public Endereco consultar(Endereco end) {
		try {
			String sql = "SELECT * FROM tbendereco WHERE Cep = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, end.getCep());

			ResultSet resultado = stm.executeQuery();

			if (resultado.next()) {
				end.setCep(resultado.getInt("Cep"));
				end.setRua(resultado.getString("Rua"));
				end.setNumero(resultado.getInt("Numero"));

				return end;

			} else {
				return null;
			}
		}

		catch (SQLException erro) {
			System.out.println("Erro no Método Consulta:" + erro);
			return null;
		}
	}

	public Endereco consultar(long cpf) {   //METODO ACIMA SOBRE CARGA
		try {
			String sql = "SELECT * FROM tbendereco WHERE Cpf = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, cpf);

			ResultSet resultado = stm.executeQuery();

			if (resultado.next()) {
				
				Endereco end =  new Endereco();
				end.setCep(resultado.getInt("Cep"));
				end.setRua(resultado.getString("Rua"));
				end.setNumero(resultado.getInt("Numero"));
				end.setBairro(resultado.getString("Bairro"));
				
				return end;

			} else {
				return null;
			}
		}

		catch (SQLException erro) {
			System.out.println("Erro no Método Consulta:" + erro);
			return null;
		}
	}



}
