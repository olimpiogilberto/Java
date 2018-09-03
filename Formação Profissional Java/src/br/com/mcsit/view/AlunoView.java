package br.com.mcsit.view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import br.com.mcsit.basico.Aluno;
import br.com.mcsit.componentes.CustomTextField;
import br.com.mcsit.model.AlunoDAO;

public class AlunoView implements ActionListener{
	private Integer novo = 0;
	private Aluno aluno = new Aluno();
	private JFrame janela = new JFrame("CADASTRO ALUNO");
	   
	private JLabel label_ra = new JLabel("RA:        ");
	private JLabel label_nome = new JLabel("NOME:  ");
	
	private JLabel label_cpf = new JLabel("CPF:      ");
	private JLabel label_curso = new JLabel("CURSO:");;
	
	private JLabel label_cep = new JLabel("CEP:   ");
	private JLabel label_rua = new JLabel("RUA:      ");
	private JLabel label_numero = new JLabel("Nº:      ");
	private JLabel label_complemento = new JLabel("COMPLEMENTO:      ");
	private JLabel label_bairro = new JLabel("BAIRRO:");
	private JLabel label_cidade = new JLabel("CIDADE:      ");
	
	private CustomTextField text_ra, text_nome, text_cep, text_rua, text_numero, text_complemento, text_bairro, text_cidade ;
	
	MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
	private JFormattedTextField text_cpf = new JFormattedTextField(mascaraCpf);
	
	private String [] cursos  = new String[] {"<Selecione>", "JAVA","BANCO","REDES"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox check_curso = new JComboBox(cursos);
	private JButton botao_cadastrar = new JButton("Cadastrar");
	private JButton botao_consultar = new JButton("Consultar");
	private JButton botao_alterar = new JButton("Alterar");
	private JButton botao_excluir = new JButton("Excluir");
	private Color[] cores = {Color.lightGray,Color.BLACK,Color.WHITE,Color.GRAY};

	public AlunoView() throws Exception{
		janela.setLayout(new GridLayout(8, 1));
		
		FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT);
		FlowLayout layout_centro = new FlowLayout(FlowLayout.CENTER);
		JPanel painel_1 = new JPanel(layout_esquerda); 
		painel_1.add(label_ra);
		painel_1.add(text_ra = new CustomTextField(10,cores));
		novo = ra();
		text_ra.setText("" + novo);
		painel_1.add(botao_consultar);
		janela.add(painel_1);

		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(label_cpf);
		text_cpf.setColumns(9);
		painel_2.add(text_cpf );
		janela.add(painel_2);
		
/*		JPanel painel_2 = new JPanel(layout_esquerda);
		painel_2.add(label_cpf);
		MaskFormatter mascaraCpf = null;
		mascaraCpf = new MaskFormatter("###.###.###-##");
        mascaraCpf.setPlaceholderCharacter('_');
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
        jFormattedTextCpf.setBounds(150,120,100,20);
		painel_2.add(jFormattedTextCpf);
		label_cpf.setBounds(50, 120, 100, 20);
		janela.add(painel_2);*/
		
		JPanel painel_3 = new JPanel(layout_esquerda);
		painel_3.add(label_nome);
		painel_3.add(text_nome = new CustomTextField(25,cores));
		janela.add(painel_3);
		
		JPanel painel_4 = new JPanel(layout_esquerda);
		painel_4.add(label_curso);
		painel_4.add(check_curso);
		painel_4.add(label_cep);
		painel_4.add(text_cep = new CustomTextField(8,cores));
		janela.add(painel_4);
		
		JPanel painel_5 = new JPanel(layout_esquerda);
		painel_5.add(label_rua);
		painel_5.add(text_rua = new CustomTextField(25,cores));
		janela.add(painel_5);

		JPanel painel_6 = new JPanel(layout_esquerda);
		painel_6.add(label_numero);
		painel_6.add(text_numero = new CustomTextField(4,cores));
		painel_6.add(label_complemento);
		painel_6.add(text_complemento = new CustomTextField(12,cores));
		janela.add(painel_6);
		
		
		JPanel painel_7 = new JPanel(layout_esquerda);
		painel_7.add(label_bairro);
		painel_7.add(text_bairro = new CustomTextField(12,cores));
		painel_7.add(label_cidade);
		painel_7.add(text_cidade = new CustomTextField(12,cores));
		janela.add(painel_7);
		
		JPanel painel_8 = new JPanel(layout_centro);
		painel_8.add(botao_cadastrar);
		painel_8.add(botao_alterar);
		painel_8.add(botao_excluir);
		janela.add(painel_8);
		
		botao_cadastrar.addActionListener(this);
		botao_consultar.addActionListener(this);
		botao_alterar.addActionListener(this);
		botao_excluir.addActionListener(this);
				
		//janela.setSize(400, 400);
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public Aluno recuperaDados(){
		Aluno a = new Aluno();
		a.setCpf(Long.parseLong(text_cpf.getText()));
		a.setRa(Integer.parseInt(text_ra.getText()));
		a.setNome(text_nome.getText());
		a.getCurso().setCodigo(Integer.parseInt(check_curso.getSelectedItem().toString()));
		a.getEndereco().setCep(Long.parseLong(text_cep.getText()));
		a.getEndereco().setRua(text_rua.getText());
		a.getEndereco().setNumero(Integer.parseInt(text_numero.getText()));
		a.getEndereco().setComplemento(text_complemento.getText());
		a.getEndereco().setBairro(text_bairro.getText());
		a.getEndereco().setCidade(text_cidade.getText());
		return a;
	}
	
	public void exibeDados(Aluno a){
		if(a!= null){
		text_cpf.setText("" + a.getCpf());
		text_ra.setText("" + a.getRa());
		text_nome.setText(a.getNome());
		check_curso.setSelectedItem(a.getCurso());
		text_cep.setText("" + a.getEndereco().getCep());
		text_rua.setText(a.getEndereco().getRua());
		text_numero.setText("" + a.getEndereco().getNumero());
		text_complemento.setText(a.getEndereco().getComplemento());
		text_bairro.setText(a.getEndereco().getBairro());
		text_cidade.setText(a.getEndereco().getCidade());
		
	}else{
		limpaDadosInexistentes();
		JOptionPane.showMessageDialog(janela, aluno.getControle().getMensagem());
	
	}
	}
	
	public void limpaDados(){
		text_cpf.setText("");
		text_ra.setText("");
		text_nome.setText("");
		check_curso.setSelectedItem(null);
		text_cep.setText("" );
		text_rua.setText("");
		text_numero.setText("");
		text_complemento.setText("");
		text_bairro.setText("");
		text_cidade.setText("");
		}
	public void limpaDadosInexistentes(){
		text_nome.setText("");
		check_curso.setSelectedItem(null);
		text_cep.setText("" );
		text_rua.setText("");
		text_numero.setText("");
		text_complemento.setText("");
		text_bairro.setText("");
		text_cidade.setText("");
		}
	
	public boolean validaCampos(){
		
		if(text_cpf.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o CPF:");
			return false;
		}
		
		if(text_ra.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o RA:");
			return false;
		}
		
		if(text_cep.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Digite o CEP:");
			return false;
		}
		
		
		return true;
	}
	//------------------------------------------
	public boolean validaCamposConsulta(){
		
		if(text_cpf.getText().trim().equals("")&& text_ra.getText().trim().equals("")){
			JOptionPane.showMessageDialog(janela, "Para consultar digite o CPF ou o RA do Aluno:");
			return false;
		}
			
		
		return true;
	}
	public Integer ra(){
		AlunoDAO dao = new AlunoDAO();
		int maximo = dao.consultarMax();
		return maximo+1;
	}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton origem = (JButton)e.getSource();
		AlunoDAO dao = new AlunoDAO();
		
		if(origem == botao_consultar){
			if(validaCamposConsulta()){
			
			if(text_ra.getText().trim().equals("")){
				aluno.setCpf(Long.parseLong(text_cpf.getText()));
				aluno = dao.consultarCpf(aluno);  
			}else{
				aluno.setRa(Integer.parseInt(text_ra.getText()));
				aluno = dao.consultar(aluno);
				if(aluno == null) {
					
				aluno.getControle().setMensagem("Erro de acesso ao Banco de Dados!");	
				}
			}	
		
			
			exibeDados(aluno);
			}
		}
		else if(validaCampos()){
		boolean sucesso = false;
		if(origem == botao_cadastrar) sucesso = dao.cadastrar(recuperaDados());
			else if(origem == botao_alterar) sucesso = dao.alterar(recuperaDados()); 
				else if(origem == botao_excluir) sucesso = dao.excluir(recuperaDados()); 
					
			if(sucesso){
				JOptionPane.showMessageDialog(janela, aluno.getControle().mensagem);
				limpaDados();
				check_curso.setSelectedItem(0);
				novo = ra();
				text_ra.setText("" + novo);
			}
			else JOptionPane.showMessageDialog(janela,aluno.getControle().mensagem );	
					
		}
	}

	public CustomTextField getText_cidade() {
		return text_cidade;
	}

	public void setText_cidade(CustomTextField text_cidade) {
		this.text_cidade = text_cidade;
	}

	public JLabel getLabel_complemento() {
		return label_complemento;
	}

	public void setLabel_complemento(JLabel label_complemento) {
		this.label_complemento = label_complemento;
	}

	public JLabel getLabel_cidade() {
		return label_cidade;
	}

	public void setLabel_cidade(JLabel label_cidade) {
		this.label_cidade = label_cidade;
	}

	public CustomTextField getText_complemento() {
		return text_complemento;
	}

	public void setText_complemento(CustomTextField text_complemento) {
		this.text_complemento = text_complemento;
	}

}
