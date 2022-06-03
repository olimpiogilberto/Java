package br.com.mcs.model;

import java.sql.*;

import br.com.mcs.beans.*;

public class AlunoDAO {

	private Connection conexao;
	//---------------------------	
	public AlunoDAO(){
		this.conexao = FabricaConexao.abreConexao();
	}
	
	//---------------------------
	public Aluno buscaPorRa(Aluno dados){
	
	try{
		String sql = "SELECT nome FROM TB_A2luno WHERE RA = ?";
				
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
		System.out.println("Erro na classe:" + this+
							"\nMétodo buscaPorRa" +
							"\nErro: " + erro +
							"\nSQLCODE: " + erro.getErrorCode());
		//		" método buscaPorRa: " + this);
		return null; 
		
	}
	
}
	

}






