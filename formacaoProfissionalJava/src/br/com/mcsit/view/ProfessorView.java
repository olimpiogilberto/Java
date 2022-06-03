package br.com.mcsit.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.List;
import br.com.mcsit.basico.*;
import br.com.mcsit.model.DisciplinaDAO;
import br.com.mcsit.model.ProfessorDAO;

public class ProfessorView implements ActionListener, FocusListener, KeyListener{
	private JFrame janela = new JFrame("Cadastro de Professores");
	   
	private JLabel label_rgf = new JLabel("RGF:   ");
	private JLabel label_cpf = new JLabel("CPF:   ");
	private JLabel label_nome = new JLabel("NOME:");
	private JLabel label_disciplina = new JLabel("DISCIPLINA:");;
	private JLabel label_cep = new JLabel("CEP:   ");
	private JLabel label_bairro = new JLabel("BAIRRO:");
	private JLabel label_rua = new JLabel("RUA:   ");
	
	private JTextField text_rgf = new JTextField(10);
	private JTextField text_cpf = new JTextField(11);
	private JTextField text_nome = new JTextField(25);
	private JComboBox combo_disciplinas = new JComboBox();
	
	private JTextField text_cep = new JTextField(8);
	private JTextField text_bairro = new JTextField(12);
	private JTextField text_rua = new JTextField(25);
	
	private JButton botao_cadastrar = new JButton("Cadastrar");
	private JButton botao_consultar = new JButton("Consultar");
	private JButton botao_alterar = new JButton("Alterar");
	private JButton botao_excluir = new JButton("Excluir");
	
	public ProfessorView(){
		janela.setLayout(new GridLayout(6, 1));
		
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> disciplinas = dao.listAll(); 
		
		if(disciplinas != null){
		  for (Disciplina d : disciplinas){
			  combo_disciplinas.addItem(d.getCodigo() + "-" + d.getNome()); 
		  }	
			
		}
		
		FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);
		JPanel painel_1 = new JPanel(layout_esquerda); 
		painel_1.add(label_rgf);
		painel_1.add(text_rgf);
		painel_1.add(label_cpf);
		painel_1.add(text_cpf);
		janela.add(painel_1);
		
		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(label_nome);
		painel_2.add(text_nome);
		janela.add(painel_2);
		
		JPanel painel_3 = new JPanel(layout_esquerda);
		painel_3.add(label_disciplina);
		painel_3.add(combo_disciplinas);
		janela.add(painel_3);
		
		JPanel painel_4 = new JPanel(layout_esquerda);
		painel_4.add(label_cep);
		painel_4.add(text_cep);
		painel_4.add(label_bairro);
		painel_4.add(text_bairro);
		janela.add(painel_4);
		
		JPanel painel_5 = new JPanel(layout_esquerda);
		painel_5.add(label_rua);
		painel_5.add(text_rua);
		janela.add(painel_5);
		
		JPanel painel_6 = new JPanel(layout_esquerda);
		painel_6.add(botao_cadastrar);
		painel_6.add(botao_consultar);
		painel_6.add(botao_alterar);
		painel_6.add(botao_excluir);
		janela.add(painel_6);
		
		
		botao_cadastrar.addActionListener(this);
		botao_consultar.addActionListener(this);
		botao_alterar.addActionListener(this);
		botao_excluir.addActionListener(this);
		
		text_rgf.addFocusListener(this);
		text_cpf.addFocusListener(this);
		text_nome.addFocusListener(this);
		text_cep.addFocusListener(this);
		text_rua.addFocusListener(this);
		text_bairro.addFocusListener(this);
		combo_disciplinas.addFocusListener(this);
		
		text_rgf.addKeyListener(this);
		text_cpf.addKeyListener(this);
		text_nome.addKeyListener(this);
		text_cep.addKeyListener(this);
		text_rua.addKeyListener(this);
		text_bairro.addKeyListener(this);
		
		
		//janela.setSize(400, 400);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public Professor recuperaDados(){
		Professor p = new Professor();
		p.setRgf(Integer.parseInt(text_rgf.getText()));
		p.setCpf(Long.parseLong(text_cpf.getText()));
		p.setNome(text_nome.getText());
		int item = Integer.parseInt(String.valueOf(combo_disciplinas.getSelectedItem()).toString().substring(0,2).trim());
		p.getDisciplina().setCodigo(item);
		p.getEndereco().setCep(Long.parseLong(text_cep.getText()));
		p.getEndereco().setRua(text_rua.getText());
		p.getEndereco().setBairro(text_bairro.getText());
		
		return p;
	}
	
	public void exibeDados(Professor p){
		if(p!= null){
		text_cpf.setText("" + p.getCpf());
		text_nome.setText(p.getNome());
		text_rgf.setText("" + p.getRgf());
		combo_disciplinas.setSelectedItem(p.getDisciplina());
		text_cep.setText("" + p.getEndereco().getCep());
		text_rua.setText(p.getEndereco().getRua());
		text_bairro.setText(p.getEndereco().getBairro());
		
	}else{
		JOptionPane.showMessageDialog(janela, "Professor Inexistente!");
	}
	}
	
	public void limpaDados(){
		text_cpf.setText("");
		text_nome.setText("");
		text_rgf.setText("");
		combo_disciplinas.setSelectedItem("");
		text_cep.setText("" );
		text_rua.setText("");
		text_bairro.setText("");
		}
	
	public boolean validaCampos(){
		
		if(text_cpf.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o CPF:");
			return false;
		}
		
		if(text_rgf.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o RGF:");
			return false;
		}
		
		if(text_cep.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o CEP:");
			return false;
		}
		
		
		return true;
	}
	
	public Integer validaCamposConsulta(){
		
		if(text_cpf.getText().trim().equals("") && text_rgf.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o Registro do Professor ou CPF:");
			return 0;
		} else {
			if(text_rgf.getText().trim().equals("")) {
				return 2;
			} 

				return 1;
			
	}}
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton origem = (JButton)e.getSource();
		ProfessorDAO dao = new ProfessorDAO();
		
		if(origem == botao_consultar){
			Professor p = new Professor();
				if(validaCamposConsulta() != 0){
					if(validaCamposConsulta() == 2){
						p.setCpf(Long.parseLong(text_cpf.getText()));
						p = dao.consultarCPF(p); 
						exibeDados(p);
					}else {
					p.setRgf(Integer.parseInt(text_rgf.getText()));
					p = dao.consultarRGF(p); 
					exibeDados(p);
					}
					
				}
			
		} else if(validaCampos()){
		boolean sucesso = false;
		
		if(origem == botao_cadastrar) sucesso = dao.cadastrar(recuperaDados());
			else if(origem == botao_alterar) sucesso = dao.alterar(recuperaDados()); 
				else if(origem == botao_excluir) sucesso = dao.excluir(recuperaDados()); 
					
			if(sucesso){
				JOptionPane.showMessageDialog(janela, "Operação realizada com Sucesso");
				limpaDados();
			}
			else JOptionPane.showMessageDialog(janela, "Erro na Operação");	
					
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		JComponent origem = (JComponent)e.getSource();
			
		origem.setBackground(Color.lightGray);
		origem.setForeground(Color.BLACK);
		}

	@Override
	public void focusLost(FocusEvent e) {
		JComponent origem = (JComponent)e.getSource();
	
		origem.setBackground(Color.WHITE);
		origem.setForeground(Color.GRAY);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField origem = (JTextField)e.getSource();
		origem.setText(origem.getText().toUpperCase());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	


}
