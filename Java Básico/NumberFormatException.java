import java.io.*;
class TesteImputStream
{
   public static void main (String args[])
   {
	   try
	   {
		   byte mbyte[] = new byte[100];
		   PrintStream saida=System.out;
		   saida.println("Digite a sua idade");
		   System.in.read(mbyte);
		   String mString = new String(mbyte).trim();
		   int idade = Integer.parseInt(mString);
		   saida.println("Idade convertida em int " + idade);
	   }
	   		catch (IOException e)
	   		{
	   			System.out.println("Erro de entrada");
	   		}
       			catch(NumberFormatException e)
       			{
       				System.out.println("Erro na conversão. Digite somente números...");
       			}
   }
}