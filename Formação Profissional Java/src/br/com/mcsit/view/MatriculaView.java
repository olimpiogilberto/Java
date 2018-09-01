package br.com.mcsit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.mcsit.basico.Aluno;
import br.com.mcsit.basico.Curso;
import br.com.mcsit.basico.Disciplina;
import br.com.mcsit.componentes.CustomTextField;
import br.com.mcsit.ensino.Matricula;
import br.com.mcsit.model.AlunoDAO;
import br.com.mcsit.model.CursoDAO;
import br.com.mcsit.model.DisciplinaDAO;
import br.com.mcsit.model.MatriculaDAO;

public class MatriculaView implements ActionListener, ItemListener{
		private JFrame janela = new JFrame("Matricula de Alunos");
		   
		private JLabel label_ra = new JLabel("RA:        ");
		private JLabel label_nome = new JLabel("NOME:  ");
		private JLabel label_nada = new JLabel("                   ");
		private JLabel label_curso = new JLabel("CURSO:");;
		private JLabel label_disciplina = new JLabel("DISCIPLINAS: ");
		
		private CustomTextField text_ra;
		
		
		private JComboBox c1 = new JComboBox();
		private JComboBox c2 = new JComboBox();
		private JButton botao_matricular = new JButton("Matricular");
		private JButton botao_consultar = new JButton("Consultar");
		
		private Color[] cores = {Color.lightGray,Color.BLACK,Color.WHITE,Color.GRAY};

		private JPanel p1, p2, p3, p4, p5, p6;

			
		public MatriculaView(){
			janela.setLayout(new BorderLayout());
			
			janela.add(p1 = new JPanel(new GridLayout(3,1)),
					BorderLayout.NORTH);
			
			FlowLayout layout_esquerda = new FlowLayout(FlowLayout.LEFT); 
						
			p1.add(p2 = new JPanel(layout_esquerda)) ;
			p2.add(label_ra);
			p2.add(text_ra = new CustomTextField(10,cores));
			p2.add(botao_consultar);
			
			
			p1.add(p3 = new JPanel(layout_esquerda));
			p3.add(label_nome);
			p3.add(label_nada);
		
				
			p1.add(p4 = new JPanel(layout_esquerda));
			p4.add(label_curso);
			p4.add(c1);
			
			janela.add(p5 = new JPanel(layout_esquerda),
					BorderLayout.CENTER);
			p5.add(label_disciplina);
			p5.add(c2);
										
			janela.add(p6 = new JPanel(new FlowLayout(FlowLayout.RIGHT)),
					BorderLayout.SOUTH);
			p6.add(botao_matricular);

			this.carregaComboCurso(c1);
			this.carregaComboDisciplina(c2);
			
			botao_matricular.addActionListener(this);
			botao_consultar.addActionListener(this);
			
			c1.addItemListener(this);
					
			//janela.setSize(400, 400);
			janela.pack();
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);
			janela.setVisible(true);
		}
		
	public Aluno recuperaDados(){
			Aluno a = new Aluno();
			a.setRa(Integer.parseInt(text_ra.getText().substring(0, 10)));
			a.setNome(label_nome.getText());
						
			JOptionPane.showMessageDialog(null, "funcionou");
			return a;
			
		}
		
		public void exibeDados(Aluno p){
			if(p!= null){
				text_ra.setText("" + p.getRa());
				label_nada.setText(p.getNome());
					
			
		}else{
			JOptionPane.showMessageDialog(janela, "Aluno Inexistente!");
		}
		}
		
		
		public void carregaComboCurso(JComboBox combo){
			CursoDAO dao = new CursoDAO();
			List<Curso> cursos = dao.listAll(); 
			
			combo.addItem("Selecione o Curso"); 
			
			if(cursos != null){
			  for (Curso c : cursos){
				  combo.addItem(c.getNome()); 
			  }	
				
			}
		}
		
		
		public void carregaComboDisciplina(JComboBox lista){
			DisciplinaDAO dao = new DisciplinaDAO();
			List<Disciplina> disciplinas = dao.listAll(); 
			
			lista.addItem("Selecione a Disciplina"); 
			
			if(disciplinas != null){
			  for (Disciplina d : disciplinas){
				  lista.addItem(d.getNome());
				
				    
			  }	
				
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Object origem = e.getSource();
			AlunoDAO dao = new AlunoDAO();
			
			if(origem == botao_consultar){
				int ra = this.recuperaRA();
				if(ra > 0){
				Aluno a = new Aluno();
				a.setRa(Integer.parseInt(text_ra.getText()));
				a = dao.findByRa(a); 
				exibeDados(a);
				}
			} else {
				Matricula m = this.recuperaMatricula();
				
				if(m.getAluno().getRa() !=0 && m.getCurso().getCodigo() !=0 &&
						m.getDisciplina().getCodigo() != 0){
					MatriculaDAO mdao = new MatriculaDAO();
					int retorno = mdao.cadastrar(m);
					
					if(retorno > 0){
						JOptionPane.showMessageDialog(janela, "Matricula efetuada");  
						
					}
					else{
						JOptionPane.showMessageDialog(janela, "Não Matriculado");  
						}
					}
				  	
			}
			
		}
		
		public Matricula recuperaMatricula(){
			Matricula m = new Matricula();
			m.getAluno().setRa(this.recuperaRA());
			m.getCurso().setCodigo(this.recuperaCurso());
			m.getDisciplina().setCodigo(this.recuperaDisciplina());
			
			return m;
				
}
			
		
		public int recuperaRA(){
			if(!text_ra.getText().trim().equals("")){
				return Integer.parseInt(text_ra.getText());
			} else{
				JOptionPane.showMessageDialog(janela, "Digite o RA");
				return 0;
			}
}
		public int recuperaCurso(){
			if(c1.getSelectedIndex()!=0){
				return c1.getSelectedIndex();
			} else{
				JOptionPane.showMessageDialog(janela, "Escolha um Curso");
				return 0;
			}
}
		public int recuperaDisciplina(){
			if(c2.getSelectedIndex()!=0){
				return c2.getSelectedIndex();
			} else{
				JOptionPane.showMessageDialog(janela, "Escolha uma Disciplina");
				return 0;
			}
}

		@Override
		public void itemStateChanged(ItemEvent e) {
			int codigoCurso = c1.getSelectedIndex();
			DisciplinaDAO dao = new DisciplinaDAO();
			List<Disciplina> disciplinas = dao.listAll(codigoCurso); 
			
			if(disciplinas != null){
				c2.removeAllItems();
				c2.addItem("Selecione a Disciplina"); 
				
				for (Disciplina d : disciplinas){
					  c2.addItem(d.getNome());
				}
			}
			
		}
		
}//final
