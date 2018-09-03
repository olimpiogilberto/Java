package br.com.mcsit.model;

import java.sql.*;

import br.com.mcsit.basico.*;

public class AlunoDAO {

	private Connection conexao;
	//---------------------------	
	public AlunoDAO(){
		this.conexao = FabricaConexao.abreConexao();
	}
	//---------------------------
	public boolean cadastrar(Aluno dados){
		
		try{
			String sql = "INSERT TBAluno (cpf, ra, nome, curso, cep, rua, numero, complemento, bairro, cidade)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
			stm.setLong(2, dados.getRa());
			stm.setString(3, dados.getNome());
			stm.setInt(4, dados.getCurso().getCodigo());
			stm.setLong(5, dados.getEndereco().getCep());
			stm.setString(6, dados.getEndereco().getRua());
			stm.setLong(7, dados.getEndereco().getNumero());
			stm.setString(8, dados.getEndereco().getComplemento());
			stm.setString(9, dados.getEndereco().getBairro());
			stm.setString(10, dados.getEndereco().getCidade());
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			if(erro.getErrorCode()== 1054){
			System.out.println("AlunoDAO.SQLCODE : " + erro.getErrorCode()
					+"\nERRO1 : " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage()
			        +"\nCOLUNA DESCONHECIDA");
			return false;
			}else{
			System.out.println("AlunoDAO.SQLCODE : " + erro.getErrorCode()
					+"\nERRO2 : " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return false;
		         }
		}
	}
	//---------------------------
	public boolean alterar(Aluno dados){
		
		try{
			String sql = "UPDATE TBAluno SET Nome = ?, CPF = ?, curso = ?"
					                     + ", CEP = ?, Rua = ?, Numero = ?"
					                     + ", Complemento = ?, Bairro = ?, Cidade = ?" +
					      "WHERE RA = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(10, dados.getRa());
			stm.setString(1, dados.getNome());
			stm.setLong(2, dados.getCpf());
			stm.setInt(3, dados.getCurso().getCodigo());
			stm.setLong(4, dados.getEndereco().getCep());
			stm.setString(5, dados.getEndereco().getRua());
			stm.setInt(6, dados.getEndereco().getNumero());
			stm.setString(7, dados.getEndereco().getComplemento());
			stm.setString(8, dados.getEndereco().getBairro());
			stm.setString(9, dados.getEndereco().getCidade());
			
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			System.out.println("SQLCODE : " + erro.getErrorCode()
					+"\nERRO3 : " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return false;
		}
	}
	//---------------------------
	public boolean excluir(Aluno dados){
	
		try{
			String sql = "DELETE FROM TBAluno WHERE CPF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
						
			boolean erro = stm.execute();
			
			return !erro;
			
		}
		catch(SQLException erro){
			System.out.println("Erro4: " + erro);
		    return false;
			
		}
	}	

	public Aluno consultar(Aluno dados){
		try{
			String sql = "SELECT * FROM TBAluno WHERE RA = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getRa());
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				dados.setCpf(resultado.getLong("CPF"));
				dados.setNome(resultado.getString("Nome"));
				dados.getCurso().setCodigo(resultado.getInt("CURSO"));
				dados.getEndereco().setCep(resultado.getLong("CEP"));
				dados.getEndereco().setRua(resultado.getString("Rua"));
				dados.getEndereco().setNumero(resultado.getInt("Numero"));
				dados.getEndereco().setComplemento(resultado.getString("Complemento"));
				dados.getEndereco().setBairro(resultado.getString("Bairro"));
				dados.getEndereco().setCidade(resultado.getString("Cidade"));
				return dados;
				
			}else{
				return null;
			}
		}
		catch(SQLException erro){
			if(erro.getErrorCode()== 1146){
			dados.getControle().setRetorno(erro.getErrorCode());
			System.out.println("ERRO5.1 - AlunoDAO.consultar()"
					+"\nMENSAGEM: " +erro.getMessage()
					+"\nRETORNO: " +dados.getControle().getRetorno()
			        +"\nA TABELA NÃO EXISTE!");
			return null;
			}else{
			System.out.println("ERRO5.2 - AlunoDAO.consultarMax()"
						+"\nMENSAGEM: " +erro.getMessage()
				        +"\nCOLOCAR A MENSAGEM AQUI!");
			return null;
		         } 
		}
	}

	public Aluno findByRa(Aluno dados){
	
	try{
		String sql = "SELECT nome FROM TBAluno WHERE RA = ?";
				
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setInt(1, dados.getRa());
					
		ResultSet resultado = stm.executeQuery();
		
		if(resultado.next()){
			dados.setRa(dados.getRa());
			dados.setNome(resultado.getString("Nome"));
			
			return dados;
			
		}else{
			return null;
			
		
		}
		
	}
	catch(SQLException erro){
		System.out.println("SQLCODE : " + erro.getErrorCode()
		+"\nERRO6: " +erro
		+"\nESTADO: " +erro.getSQLState()
		+"\nMENSAGEM: " +erro.getMessage());
return null; 
		
	}
	
}
	public int consultarMax() {
		
		try{
			String sql = "SELECT MAX(RA) as codigo FROM TBAluno";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				return resultado.getInt("CODIGO");
			}else{ return 0; }
		}
		catch(SQLException erro){
			if(erro.getErrorCode()== 1146){
			System.out.println("ERRO7.1 - AlunoDAO.consultarMax()"
					+"\nMENSAGEM: " +erro.getMessage()
			        +"\nA TABELA NÃO EXISTE!");
			return 0;
			}else{
			System.out.println("ERRO7.2 - AlunoDAO.consultarMax()"
						+"\nMENSAGEM: " +erro.getMessage()
				        +"\nCOLOCAR A MENSAGEM AQUI!");
			return 0;
		         }
		}
	}


	public int consultarMin() {
		
		
		try{
			String sql = "SELECT MIN(RA) as codigo FROM TBAluno";
				
			PreparedStatement stm = conexao.prepareStatement(sql);
								
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				return resultado.getInt("CODIGO");
							
			}else{
				return 0;
						
			}
			
		}
		catch(SQLException erro){
			System.out.println("SQLCODE : " + erro.getErrorCode()
					+"\nERRO8: " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return 0; 
			
		}
		
	}
	
	public Aluno consultarCpf(Aluno dados) {
		try{
			String sql = "SELECT * FROM TBAluno WHERE CPF = ?";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setLong(1, dados.getCpf());
						
			ResultSet resultado = stm.executeQuery();
			
			if(resultado.next()){
				dados.setRa(resultado.getInt("RA"));
				dados.setNome(resultado.getString("Nome"));
				dados.getCurso().setCodigo(resultado.getInt("CURSO"));
				dados.getEndereco().setCep(resultado.getLong("CEP"));
				dados.getEndereco().setRua(resultado.getString("Rua"));
				dados.getEndereco().setBairro(resultado.getString("Bairro"));
				dados.getEndereco().setNumero(resultado.getInt("Numero"));
				
				return dados;
				
			}else{
				return null;
			
			}
			
		}
		catch(SQLException erro){
			System.out.println("SQLCODE : " + erro.getErrorCode()
					+"\nERRO9: " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return null; 
			
		}	

}
}






