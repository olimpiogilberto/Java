/*01*/ import javax.swing.JOptionPane;
/*02*/ public class DigitoVerificador 
/*03*/ {
/*04*/            public static void main(String args[])
/*05*/            {
/*06*/    	String strOriginal = JOptionPane.showInputDialog("Digite o número:");
/*07*/                  String num = strOriginal;
/*08*/                  int tamanho = num.length();
/*09*/                  int soma = 0;
/*10*/                  if (tamanho==1) soma = Integer.parseInt(num);	    
/*11*/                  while (tamanho >1)
/*12*/                 {
/*13*/                         soma = 0;
/*14*/                         for (int i = 0; i< tamanho; i++)
/*15*/                        {
/*16*/                              soma+= Integer.parseInt(num.substring(i,i+1));
/*17*/                        }/*finish for*/
/*18*/                        num = Integer.toString(soma);
/*19*/                        tamanho = num.length();
/*20*/                 }/*finish while*/	  
/*21*/                 String resultado = strOriginal+ "-" + soma;
/*22*/                 JOptionPane.showMessageDialog(null,"O número com seu dígito "+
/*23*/                           "verificador é: "+ resultado);
/*24*/            }/*finish public static void main*/
/*25*/ }/*finish public class*/