package br.com.mcs.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.mcs.beans.Funcionario;
import br.com.mcs.beans.Pessoa;
import br.com.mcs.model.FuncionarioDAO;

public class FuncionarioView implements ActionListener{
	private JFrame janela = new JFrame("CADASTRADO FUNCIONARIO");
	   
	private JLabel lRegistro = new JLabel("Registro:        ");
	private JLabel lNome = new JLabel("Nome:  ");
	private JLabel lDepartamento = new JLabel("Departamento:      ");
	private JLabel lFuncao= new JLabel("Função:   ");
	
	private JButton bConsultar = new JButton("Consultar");
	private JButton bSalvar = new JButton("Salvar");
	private JButton bExcluir = new JButton("Excluir");
	private JButton bSair = new JButton("Sair");

	private JTextField tRegistro 	= new JTextField(8);
	private JTextField tNome= new JTextField(25);
	private JTextField tDepartamento = new JTextField(5);
	private JTextField tFuncao = new JTextField(5);
	
	
	public FuncionarioView() {
		
		janela.setLayout(new GridLayout(5, 1));
		
		FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);
		FlowLayout layout_centro = new FlowLayout(FlowLayout.CENTER);
		JPanel painel_1 = new JPanel(layout_esquerda); 
		painel_1.add(lRegistro);
		painel_1.add(tRegistro);
		painel_1.add(bConsultar);
		janela.add(painel_1);
		
		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(lNome);
		painel_2.add(tNome);
		janela.add(painel_2);
		
		JPanel painel_3 = new JPanel(layout_esquerda);
		painel_3.add(lDepartamento);
		painel_3.add(tDepartamento);
		janela.add(painel_3);
		
		JPanel painel_4 = new JPanel(layout_esquerda);
		painel_4.add(lFuncao);
		painel_4.add(tFuncao);
		janela.add(painel_4);
				
		JPanel painel_5 = new JPanel(layout_centro);
		painel_5.add(bSalvar);
		painel_5.add(bExcluir);
		painel_5.add(bSair);
		janela.add(painel_5);
		
		bConsultar.addActionListener(this);
		bSalvar.addActionListener(this);
		bExcluir.addActionListener(this);
		bSair.addActionListener(this);
		
				
		//janela.setSize(400, 400);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
	}


	public void actionPerformed(ActionEvent e) {
		JButton origem = (JButton) e.getSource();
		FuncionarioDAO DAOfuncionario = new FuncionarioDAO();
		
		if (origem == bConsultar){
			Funcionario func = new Funcionario();
			func.setRegistro(Integer.parseInt(tRegistro.getText()));
			func = DAOfuncionario.consultar (func);
			
     			exibeDados(func);
		}else if (origem == bExcluir){
			Funcionario func = new Funcionario();
			func.setRegistro(Integer.parseInt(tRegistro.getText()));
			Integer total = DAOfuncionario.excluir(func);
			
			if(total > 0){
				JOptionPane.showMessageDialog(janela, "Operação realizada com Sucesso!");
			}else {
				JOptionPane.showMessageDialog(janela, "Não foi possível efetuar a operação!");
			}//fim do segundo if
			
		}else if (origem == bSalvar){
			Funcionario func = new Funcionario();
			func.setRegistro(Integer.parseInt(tRegistro.getText()));
			func = DAOfuncionario.consultar (func);
			
			Integer total = -1;
			
			if(func == null){
				func = recuperaDados();
				total = DAOfuncionario.cadastrar(func);
				//JOptionPane.showMessageDialog(janela, total);
			
			}else{
				func = recuperaDados();
				total = DAOfuncionario.alterar(func);
	
			}
			if(total > 0){
				JOptionPane.showMessageDialog(janela, "Operação realizada com Sucesso!");
			}else {
				JOptionPane.showMessageDialog(janela, "Não foi possível efetuar a operação!");
			}//fim do segundo if
		}else if(origem == bSair) {
			System.exit(0);
		}//fim do primeiro if
		
	}//Fim do ActionPerformed
	
	public boolean validaCampos() {
		if (tRegistro.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(janela, "Para cadastrar digite o Código do Resgistro");
			return false;
		}

		return true;
	}
//Fim ValidaCampos
	
	
	public void exibeDados(Funcionario f){
		if (f !=null){
		
		tRegistro.setText("" + f.getRegistro());  //tudo que se concatena com "" vira String
		tNome.setText(f.getNome());
		tDepartamento.setText("" + f.getDepartamento());
		tFuncao.setText("" + f.getFuncao());
		
		}else {
			JOptionPane.showMessageDialog(janela, "Funcionario Inexistente!");
		}
	}
	//Fim exibeDados
	
	public Funcionario recuperaDados() {
		Funcionario f = new Funcionario();
		
		f.setRegistro(Integer.parseInt(tRegistro.getText()));
		f.setNome(tNome.getText());		
		f.setDepartamento(Integer.parseInt(tDepartamento.getText()));
	    f.setFuncao(Integer.parseInt(tFuncao.getText()));
		
		return f;

	}
}
