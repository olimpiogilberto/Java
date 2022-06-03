package br.com.mcs.view;
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

import br.com.mcs.beans.Pessoa;
import br.com.mcs.model.EnderecoDAO;
import br.com.mcs.model.PessoaDAO;
import br.com.mcs.componentes.CustomTextField;
/**
 * @autor Gilberto
 * @data 15/11/2015
 * PessoaView.java
 */

public class PessoaView implements ActionListener {
	
		private JFrame janela;
		private JPanel p1, p2, p3, p4, p5, p6, p7;
		private JLabel l1, l2, l3, l4, l5, l6, l7;
		private CustomTextField t1, t2, t3, t4, t5, t6, t7;
		private JButton b1, b2, b3, b4;
	 
		
	    public  PessoaView() {
			janela = new JFrame("Cadastro de Pessoas");
			janela.setLayout(new GridLayout(7, 1));

			FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);

			janela.add(p1 = new JPanel(layout_esquerda));
			p1.add(l1 = new JLabel("CPF"));
			p1.add(t1 = new CustomTextField(11));
			p1.add(b1 = new JButton("Consultar"));

			janela.add(p2 = new JPanel(layout_esquerda));
			p2.add(l2 = new JLabel("NOME"));
			p2.add(t2 = new CustomTextField(22));

			janela.add(p3 = new JPanel(layout_esquerda));
			p3.add(l3 = new JLabel("SEXO"));
			p3.add(t3 = new CustomTextField(11));
			p3.add(l4 = new JLabel("CEP"));
			p3.add(t4 = new CustomTextField(8));

			janela.add(p4 = new JPanel(layout_esquerda));
			p4.add(l5 = new JLabel("RUA"));
			p4.add(t5 = new CustomTextField(23));
			
			janela.add(p6 = new JPanel(layout_esquerda));
			p6.add(l6 = new JLabel("BAIRRO"));
			p6.add(t6 = new CustomTextField(10));
			p6.add(l7 = new JLabel("NUMERO"));
			p6.add(t7 = new CustomTextField(5));

			janela.add(p7 = new JPanel());
			p7.add(b2 = new JButton("Cadastrar"));
			p7.add(b3 = new JButton("Alterar"));
			p7.add(b4 = new JButton("Excluir"));
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			
	        janela.pack();
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);
			janela.setVisible(true);

	    }
		public Pessoa recuperaDados() {
			Pessoa a = new Pessoa();
			a.setCpf(Long.parseLong(t1.getText()));
			a.setNome(t2.getText());		
			a.setSexo(t3.getText());
			
			//a.setLogradouro(new Endereco());
			
			a.getLogradouro().setCep(Integer.parseInt(t4.getText()));
			a.getLogradouro().setRua(t5.getText());
			a.getLogradouro().setBairro(t6.getText());
			a.getLogradouro().setNumero(Integer.parseInt(t7.getText()));
			
			return a;

		}
		
		public boolean validaCampos() {
			if (t1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(janela, "Digite o CPF");
				return false;
			}

			return true;
		}

		public void exibeDados(Pessoa a){
			if (a !=null){
			
			t1.setText("" + a.getCpf());  //tudo que se concatena com "" vira String
			t2.setText(a.getNome());
			t3.setText(a.getSexo());
			t4.setText("" + a.getLogradouro().getCep());
			t5.setText(a.getLogradouro().getRua());
			t6.setText(a.getLogradouro().getBairro());
			t7.setText("" + a.getLogradouro().getNumero());

			}else {
				JOptionPane.showMessageDialog(janela, "Pessoa Inexistente!");
			}
		}
		
		public void limpaDados(){
			t1.setText("");  //tudo que se concatena com "" vira String
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");

			}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object origem = e.getSource();
			PessoaDAO daoPessoa = new PessoaDAO();
			EnderecoDAO daoEndereco = new EnderecoDAO(); 
			
			
			if (origem == b1){
				Pessoa a = new Pessoa();
				a.setCpf(Long.parseLong(t1.getText()));
				a = daoPessoa.consultar (a);
				if(a !=null){
					a.setLogradouro(daoEndereco.consultar(a.getCpf()));
					
					/*
					Endereco enderecoTeste = new Endereco();
					enderecoTeste = daoEndereco.consultar(a.getCpf());
					a.setLogradouro(enderecoTeste);
					*/
			
				}
				exibeDados(a);
			}
			
			else if (validaCampos()){
				boolean sucesso = false;
			
	
			if (origem == b2){
				Pessoa pessoa = recuperaDados();
				sucesso = daoPessoa.cadastrar(pessoa);
				
				if (sucesso){
					
					sucesso = daoEndereco.cadastrar(pessoa.getLogradouro(), pessoa.getCpf());
				}
			}
			else if (origem == b3){
				Pessoa pessoa = recuperaDados();
				sucesso = daoPessoa.alterar(pessoa);
				Long cpf = recuperaDados().getCpf();
				sucesso = daoEndereco.alterar(pessoa.getLogradouro(), cpf);
			}
			else if (origem == b4){
				sucesso = daoPessoa.excluir(recuperaDados());
			   	Long cpf = recuperaDados().getCpf();
				sucesso = daoEndereco.excluir(cpf);
			}
			if (sucesso){
				JOptionPane.showMessageDialog(janela, "Operação realizada com Sucesso!");
				limpaDados();
				}
				
			else JOptionPane.showMessageDialog(janela, "Erro na operação");
			}
		
		}

}
