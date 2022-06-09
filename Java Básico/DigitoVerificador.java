    /*01*/ import javax.swing.JOptionPane;/*utilização para caixa de dialogo*/
	/*02*/ public class DigitoVerificador //inico do corpo da classe digitoverificador
	/*03*/ {
	/*04*/            public static void main(String args[])//método necessário para que a classe seja executada
	/*05*/            {//inicio método main
	/*06*/    	String strOriginal = JOptionPane.showInputDialog("Digite o número:");//
	/*07*/                  String num = strOriginal;
	/*08*/                  int tamanho = num.length();//o método length retorna o número de caracters da string
	/*09*/                  int soma = 0;//
	/*10*/                  if (tamanho==1) soma = Integer.parseInt(num);//    
	/*11*/                  while (tamanho >1)
	/*12*/                 {
	/*13*/                         soma = 0;
	/*14*/                         for (int i = 0; i< tamanho; i++)
	/*15*/                        {
	/*16*/                              soma+= Integer.parseInt(num.substring(i,i+1));//o método substring retorna o caracter na posição indicada ou os caracteres na proxima ou do inicio até seu final
	/*17*/                        }
	/*18*/                        num = Integer.toString(soma);//conversão de inteiro para string
	/*19*/                        tamanho = num.length();
	/*20*/                 }	  
	/*21*/                 String resultado = strOriginal+ "-" + soma;
	/*22*/                 JOptionPane.showMessageDialog(null,"O número com seu dígito "+
	/*23*/                           "verificador é: "+ resultado);
	/*24*/            }
	/*25*/ }
	
