package br.com.mcsit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.mcsit.basico.Professor;

public class ProfessorDAO {
	private Connection conexao;
	
	public ProfessorDAO(){
		this.conexao = FabricaConexao.abreConexao();
	}

	public boolean cadastrar(Professor dados){
		
		try{
			String sql = "INSERT TBProfessor (cpf, nome, rgf, co_disciplina, cep, rua, bairro)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
			stm.setString(2, dados.getNome());
			stm.setLong(3, dados.getRgf());
			stm.setInt(4, dados.getDisciplina().getCodigo());
			stm.setLong(5, dados.getEndereco().getCep());
			stm.setString(6, dados.getEndereco().getRua());
			stm.setString(7, dados.getEndereco().getBairro());
			
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			if(erro.getErrorCode() == 1146) {
				System.out.println("Erro na classe ProfessorDAO.cadastrar()\n" 
						+"MENSAGEM: " +erro.getMessage());
				return false;
				} else {
					System.out.println("Erro na classe ProfessorDAO.cadastrar()\n" 
							+"SQLCODE : " + erro.getErrorCode()
							+"\nERRO: " +erro
							+"\nESTADO: " +erro.getSQLState()
							+"\nMENSAGEM: " +erro.getMessage());
				return false;
				}
		}
	}

	public boolean alterar(Professor dados){
		
		try{
			String sql = "UPDATE TBProfessor SET Nome = ?, RGF = ?, "+
					"Co_Disciplina = ?, CEP = ?, Rua = ?, Bairro = ?" +
					"WHERE CPF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(7, dados.getCpf());
			stm.setString(1, dados.getNome());
			stm.setLong(2, dados.getRgf());
			stm.setInt(3, dados.getDisciplina().getCodigo());
			stm.setLong(4, dados.getEndereco().getCep());
			stm.setString(5, dados.getEndereco().getRua());
			stm.setString(6, dados.getEndereco().getBairro());
			
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			System.out.println("Erro: " + erro);
			return false;
		}
	}

	public boolean excluir(Professor dados){
	
		try{
			String sql = "DELETE FROM TBProfessor WHERE CPF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
						
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			System.out.println("Erro: " + erro);
		    return false;
			
		}
	}	
	
	public Professor consultarRGF(Professor dados){
		
		try{
			String sql = "SELECT * FROM TBProfessor WHERE RGF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, dados.getRgf());
						
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				dados.setCpf(resultado.getLong("CPF"));
				dados.setNome(resultado.getString("Nome"));
				dados.getDisciplina().setCodigo(resultado.getInt("Co_Disciplina"));
				dados.getEndereco().setCep(resultado.getLong("CEP"));
				dados.getEndereco().setRua(resultado.getString("Rua"));
				dados.getEndereco().setBairro(resultado.getString("Bairro"));
				
				return dados;
				
			}else{
				return null;
				
			
			}
			
		}
		catch(SQLException erro){
			System.out.println("Erro ProfessorDAO.consultarRGF: " + erro);
			return null; 
			
		}
		
	}
	

	public Professor consultarCPF(Professor dados){
		
		try{
			String sql = "SELECT * FROM TBProfessor WHERE CPF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
						
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				dados.setNome(resultado.getString("Nome"));
				dados.setRgf(resultado.getInt("RGF"));
				dados.getDisciplina().setCodigo(resultado.getInt("Co_Disciplina"));
				dados.getEndereco().setCep(resultado.getLong("CEP"));
				dados.getEndereco().setRua(resultado.getString("Rua"));
				dados.getEndereco().setBairro(resultado.getString("Bairro"));
				
				return dados;
				
			}else{
				return null;
				
			
			}
			
		}
		catch(SQLException erro){
			System.out.println("Erro ProfessorDAO.consultarCPF: " + erro);
			return null; 
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}







