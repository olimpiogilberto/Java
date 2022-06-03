package br.com.mcsit.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.com.mcsit.basico.Disciplina;
import br.com.mcsit.basico.Disciplina;
import br.com.mcsit.basico.Disciplina;
import br.com.mcsit.componentes.CustomTextField;
import br.com.mcsit.model.DisciplinaDAO;


public class DisciplinaView implements ActionListener{
	
	private JFrame janela = new JFrame("CADASTRO DE DISCIPLINAS");
	private JLabel label_codigo =    new JLabel("Código.......: ");
	private JLabel label_nome =      new JLabel("Nome.........: ");
	private JLabel label_descricao = new JLabel("Descrição: ");
	
	private CustomTextField text_codigo, text_nome;
	private JTextArea text_descricao = new JTextArea(6, 25);
	
	private JButton botao_cadastrar = new JButton("Cadastrar");
	private JButton botao_consultar = new JButton("Consultar");
	private JButton botao_alterar = new JButton("Alterar");
	private JButton botao_excluir = new JButton("Excluir");
	private Color[] cores = {Color.lightGray,Color.BLACK,Color.WHITE,Color.GRAY};
	
	public DisciplinaView(){
		janela.setLayout(new GridLayout(4, 1));
		
		FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);
		FlowLayout layout_centro = new FlowLayout(FlowLayout.CENTER);
		JPanel painel_1 = new JPanel(layout_esquerda); 
		painel_1.add(label_codigo);
		painel_1.add(text_codigo = new CustomTextField(10,cores));
		int novo = carregaCodigo();
		text_codigo.setText("" + novo);
		painel_1.add(botao_consultar);
		janela.add(painel_1);
		
		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(label_nome);
		painel_2.add(text_nome = new CustomTextField(25,cores));
		text_nome.setText("");
		janela.add(painel_2);
		
		JPanel painel_3 = new JPanel(layout_esquerda);
		painel_3.add(label_descricao);
		painel_3.add(text_descricao);
		text_descricao.setText("");
		janela.add(painel_3);
		
		JPanel painel_4 = new JPanel(layout_centro);
		painel_4.add(botao_cadastrar);
		painel_4.add(botao_alterar);
		painel_4.add(botao_excluir);
		janela.add(painel_4);
		
		botao_cadastrar.addActionListener(this);
		botao_consultar.addActionListener(this);
		botao_alterar.addActionListener(this);
		botao_excluir.addActionListener(this);
				
		//janela.setSize(700, 800);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(true);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
	}
	//-------------------------------
	public Disciplina gravar(){
		Disciplina d = new Disciplina();
		d.setCodigo(Integer.parseInt(text_codigo.getText()));
		d.setNome(text_nome.getText());
		d.setDescricao(text_descricao.getText());
		return d;
	}
	//limpar dados apos exibir
	public void limpaDados(){
		text_codigo.setText("");
		text_nome.setText("");
		text_descricao.setText("");
		}
	//-------------------------------
	public void exibeDados(Disciplina d){
		if(d!= null){
			text_codigo.setText("" + d.getCodigo());
			text_nome.setText("" + d.getNome());
			text_descricao.setText("" + d.getDescricao());
		
	}else{
		 limpaDadosInexistentes();
		JOptionPane.showMessageDialog(janela, "Disciplina não cadastrada!!" );
	
	}
	}
//------------------------------------
	public boolean validaCampos(){
		
		if(text_codigo.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o codigo:");
			return false;
		}

		return true;
	}
//------------------------------------	
	private void limpaDadosInexistentes() {
		text_codigo.setText("");
		text_nome.setText("");
		text_descricao.setText("");
	}

	public int carregaCodigo(){
		DisciplinaDAO dao = new DisciplinaDAO();
		int maximo = dao.consultarMax();
		return maximo+1;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton origem = (JButton)e.getSource();
		DisciplinaDAO dao = new DisciplinaDAO();
		
		if(origem == botao_consultar){
			
			Disciplina d = new Disciplina();
			d.setCodigo(Integer.parseInt(text_codigo.getText()));
			d = dao.consultar(d); 
					
			exibeDados(d);
			
			}
		
		else if(validaCampos()){
		boolean sucesso = false;
		
		if(origem == botao_cadastrar) sucesso = dao.cadastrar(gravar());
		else if(origem == botao_alterar) sucesso = dao.alterar(gravar());
		else if(origem == botao_excluir) sucesso = dao.excluir(gravar());
		if(sucesso){
			JOptionPane.showMessageDialog(janela, "Operação realizada com Sucesso");
			limpaDados();
			text_codigo.setText("" + carregaCodigo());
		}
		else JOptionPane.showMessageDialog(janela, "Erro na Operação" );	
				
	}
	}

	
//---------------------------------	


}