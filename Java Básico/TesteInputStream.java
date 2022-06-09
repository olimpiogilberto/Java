import java.io.*;//importa classes pacote io.
public class TesteInputStream 
{ 
	public static void main(String args[])
	{
	 try//recebe todo código que pode gerar erro;
	 {
	  byte mbyte[]= new byte[100];//criando vetor de bytes;
	  PrintStream saida=System.out;//cria saida para não ter que escrever sempre system.out
	     saida.println("Digite a sua idade");
	  System.in.read(mbyte);
	  String mString= new String(mbyte).trim();
	  int idade=Integer.parseInt(mString);
	  saida.println("Idade convertida em int " + idade);
	  }
	 catch(IOException e)
	 {
		 System.out.println("Erro de I/O");
	 }
	 catch(NumberFormatException e)
	 {
		 System.out.println("Erro de conversão");
		 
	 }
	}
	

}
