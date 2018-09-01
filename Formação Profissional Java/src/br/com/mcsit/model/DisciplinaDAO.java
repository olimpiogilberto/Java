package br.com.mcsit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mcsit.basico.Disciplina;


public class DisciplinaDAO {
	private Connection conexao;
	
	
	public DisciplinaDAO(){
		this.conexao = FabricaConexao.abreConexao();
	}
	public List<Disciplina> listAll(){
		
		try{
			String sql = "SELECT * FROM TBDisciplinas ORDER BY codigo";
			
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			List<Disciplina> lista = new ArrayList<Disciplina>();
			
		while (resultado.next()){
			Disciplina d = new Disciplina();
			d.setCodigo(resultado.getInt("CODIGO"));
			d.setNome(resultado.getString("NOME"));
			lista.add(d);
		}
		return lista;
		
		}catch (SQLException erro){
			System.out.println("Erro método listAll: " + erro);
			return null;
		}
		
	}
	
public List<Disciplina> listAll(int curso){
		
		try{
			String sql = "SELECT * FROM TBDisciplinas WHERE CODIGO = ? ORDER BY codigo ";
			
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, curso);
			
			ResultSet resultado = stm.executeQuery();
			List<Disciplina> lista = new ArrayList<Disciplina>();
			
		while (resultado.next()){
			Disciplina d = new Disciplina();
			d.setCodigo(resultado.getInt("CODIGO"));
			d.setNome(resultado.getString("NOME"));
			d.setDescricao(resultado.getString("DESCRICAO"));
			lista.add(d);
		}
		return lista;
		
		}catch (SQLException erro){
			System.out.println("Erro método listByCourse: " + erro);
			return null;
		}
		
	}
//---------CADASTRAR DISCIPLINAS------------------
public boolean cadastrar(Disciplina dados) {
	try{
		String sql = "INSERT TBDisciplinas (codigo, nome, descricao)" +
				"VALUES (?, ?, ?)";
				
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setLong(1, dados.getCodigo());
		stm.setString(2, dados.getNome());
		stm.setString(3, dados.getDescricao());
		
		boolean erro = stm.execute();
		
		return !erro;
		
	}
	catch(SQLException erro){
		System.out.println("Erro na Classe DisciplinaDAO.cadastrar()\n" + erro.getErrorCode()
				+"\nERRO: " +erro
				+"\nESTADO: " +erro.getSQLState()
				+"\nMENSAGEM: " +erro.getMessage());
		return false;
	}
}
//---------ALTERAÇÃO
public boolean alterar(Disciplina dados){
try{
	String sql = "UPDATE TBDisciplinas SET Nome = ?, Descricao = ?" +
			"WHERE CODIGO = ?";
			
	PreparedStatement stm = conexao.prepareStatement(sql);
	stm.setInt(3, dados.getCodigo());
	stm.setString(1, dados.getNome());
	stm.setString(2, dados.getDescricao());
		
	boolean erro = stm.execute();
	
	return !erro;
	
}
catch(SQLException erro){
	System.out.println("Erro na Classe DisciplinaDAO.alterar()\n" + erro.getErrorCode()
			+"\nERRO: " +erro
			+"\nESTADO: " +erro.getSQLState()
			+"\nMENSAGEM: " +erro.getMessage());
	return false; 
	
}
}
//---------EXCLUSAO
public boolean excluir(Disciplina dados){
	
	try{
		String sql = "DELETE FROM TBDisciplinas WHERE CODIGO = ?";
				
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setInt(1, dados.getCodigo());
					
		boolean erro = stm.execute();
		
		return !erro;
		
	}
	catch(SQLException erro){
		System.out.println("Erro na classe DisciplinaDAO.excluir()\n" 
				+"SQLCODE : " + erro.getErrorCode()
				+"\nERRO: " +erro
				+"\nESTADO: " +erro.getSQLState()
				+"\nMENSAGEM: " +erro.getMessage());
		return false; 
		
	}
		
	}
//---------BUSCAR MAIOR DISCIPLINAS------------------
 public int consultarMax() {
	try{
		String sql = "SELECT MAX(CODIGO) as codigo FROM TBDisciplinas";
			
		PreparedStatement stm = conexao.prepareStatement(sql);
							
		ResultSet resultado = stm.executeQuery();
		
		if(resultado.next()){
			return resultado.getInt("CODIGO");
						
		}else{
			return 0;
					
		}
		
	}
	catch(SQLException erro){
		System.out.println("Erro na Classe DisciplinaDAO.consultarMax()\n" + erro.getErrorCode()
				+"\nERRO: " +erro
				+"\nESTADO: " +erro.getSQLState()
				+"\nMENSAGEM: " +erro.getMessage());
		return 0; 
		
	}
	}
//---------------------------------

 public Disciplina consultar(Disciplina dados) {
	
	try{
		String sql = "SELECT * FROM TBDisciplinas WHERE CODIGO = ? ";
		
		PreparedStatement stm = conexao.prepareStatement(sql);
		stm.setLong(1, dados.getCodigo());
		
		ResultSet resultado = stm.executeQuery();
		
	if (resultado.next()){
		dados.setNome(resultado.getString("nome"));
		dados.setDescricao(resultado.getString("descricao"));
		
		return dados;
		
	}else{	
		
			return null;	
	}
	
}
catch(SQLException erro){
	System.out.println("Erro na classe DisciplinaDAO.consultar()\n" 
			+"SQLCODE : " + erro.getErrorCode()
			+"\nERRO: " +erro
			+"\nESTADO: " +erro.getSQLState()
			+"\nMENSAGEM: " +erro.getMessage());
	return null; 
	
}
	
}



///----------------------------------------
}
