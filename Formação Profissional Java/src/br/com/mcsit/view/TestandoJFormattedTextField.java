package br.com.mcsit.view;
  
import java.awt.Container;
import java.text.ParseException;
  
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;
  
public class TestandoJFormattedTextField extends JFrame {
  
       private static final long serialVersionUID = 1L;
        
    public static void main(String[] args)  
    {  
       TestandoJFormattedTextField field = new TestandoJFormattedTextField();
       field.testaJFormattedTextField();
    }
  
    private void testaJFormattedTextField() {
             Container janela = getContentPane();
             setLayout(null);
  
             //Define os r�tulos dos bot�es
             JLabel labelCpf = new JLabel("CPF: ");
             labelCpf.setBounds(50,120,100,20);
  
             //Define as m�scaras
             MaskFormatter mascaraCpf = null;
  
             try{
                    mascaraCpf = new MaskFormatter("###.###.###-##");
                    mascaraCpf.setPlaceholderCharacter('_');
             }
             catch(ParseException excp) {
                    System.err.println("Erro na formata��o: " + excp.getMessage());
                    System.exit(-1);
             }
  
             //Seta as m�scaras nos objetos JFormattedTextField
             JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
             jFormattedTextCpf.setBounds(150,120,100,20);
              
             //Adiciona os r�tulos e os campos de textos com m�scaras na tela
             janela.add(labelCpf);
             janela.add(jFormattedTextCpf);
             setSize(400, 250);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setVisible(true);
    }
     
}