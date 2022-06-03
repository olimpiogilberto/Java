package br.com.mcs.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import br.com.mcs.beans.Aluno;

import br.com.mcs.model.AlunoDAO;

public class AlunoView implements ActionListener{
	//ABRE A CLASSE
	
	private JFrame janela = new JFrame("GERENCIA ALUNO");
	   
	private JLabel lRa = new JLabel("RA:        ");
	private JLabel lNome = new JLabel("NOME:  ");
	private JLabel lCpf = new JLabel("CPF:      ");

	private JLabel lEndereco = new JLabel("ENDERECO:   ");
	private JLabel lCep = new JLabel("CEP:   ");
	private JLabel lRua = new JLabel("RUA:      ");
	private JLabel lNumero = new JLabel("Nº:      ");

	private JButton bCadastrar = new JButton("Cadastrar");
	private JButton bConsultar = new JButton("Consultar");
	private JButton bAlterar = new JButton("Alterar");
	private JButton bExcluir = new JButton("Excluir");

	private JTextField tRa 	= new JTextField(8);
	private JTextField tCpf	= new JTextField(11);
	private JTextField tNome= new JTextField(25);

	private JTextField tRua	= new JTextField(30);
	private JTextField tNumero= new JTextField(5);
	private JTextField tCep	= new JTextField(8);

	public AlunoView(){
		janela.setLayout(new GridLayout(7, 1));
		
		FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);
		FlowLayout layout_centro = new FlowLayout(FlowLayout.CENTER);
		JPanel painel_1 = new JPanel(layout_esquerda); 
		painel_1.add(lRa);
		painel_1.add(tRa);
	
		
		painel_1.add(bConsultar);
		janela.add(painel_1);
		
		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(lCpf);
		painel_2.add(tCpf);
		painel_2.add(lNome);
		painel_2.add(tNome);
		janela.add(painel_2);
		
		JPanel painel_3 = new JPanel(layout_esquerda);
		
		janela.add(painel_3);
		
		JPanel painel_4 = new JPanel(layout_esquerda);
	
		painel_4.add(lCep);
		painel_4.add(tCep);
		janela.add(painel_4);
		
		JPanel painel_5 = new JPanel(layout_esquerda);
		
		painel_5.add(lRua);
		painel_5.add(tRua);
		
		painel_5.add(lNumero);
		painel_5.add(tNumero);
		janela.add(painel_5);
		
		JPanel painel_6 = new JPanel(layout_centro);
		painel_6.add(bCadastrar);
		painel_6.add(bAlterar);
		painel_6.add(bExcluir);
		janela.add(painel_6);
		
		bCadastrar.addActionListener(this);
		bConsultar.addActionListener(this);
		bAlterar.addActionListener(this);
		bExcluir.addActionListener(this);
				
		//janela.setSize(400, 400);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		
	}

/**	public static void main (String args[]){
		AlunoView aluno =  new AlunoView();
	}

**/

	public Aluno recuperaDados(){
		
		Aluno aluno = new Aluno();
		aluno.setRa(Integer.parseInt(tRa.getText()));
		aluno.setCpf(Long.parseLong(tCpf.getText()));
		aluno.setNome(tNome.getText());
		aluno.getLogradouro().setCep(Integer.parseInt(tCep.getText()));
		aluno.getLogradouro().setRua(tRua.getText());
		aluno.getLogradouro().setNumero(Integer.parseInt(tNumero.getText()));
		
		return aluno;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton origem = (JButton)e.getSource();
		AlunoDAO dao = new AlunoDAO();
		
	
		
			Aluno a = new Aluno();
			
			a.setRa(Integer.parseInt(tRa.getText()));
				a = dao.buscaPorRa(a);
		
			
			
	
		

					
		}


}
