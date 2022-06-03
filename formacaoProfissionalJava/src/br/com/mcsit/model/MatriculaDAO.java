package br.com.mcsit.model;

import java.sql.*;

import br.com.mcsit.ensino.Matricula;


public class MatriculaDAO {
	private Connection conexao;
	
	public MatriculaDAO(){
		this.conexao = FabricaConexao.abreConexao();
	}

	public int cadastrar(Matricula matricula){
		
		try{
			String sql = "INSERT INTO TBMatricula VALUES (?, ?, ?)";
					
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, matricula.getAluno().getRa());
			stm.setInt(2, matricula.getCurso().getCodigo());
			stm.setInt(3, matricula.getDisciplina().getCodigo());
			
			
			return  stm.executeUpdate();
		
		}
		catch(SQLException erro){
			System.out.println("SQLCODE : " + erro.getErrorCode()
					+"\nERRO: " +erro
					+"\nESTADO: " +erro.getSQLState()
					+"\nMENSAGEM: " +erro.getMessage());
			return -1;
		}
	}
}
