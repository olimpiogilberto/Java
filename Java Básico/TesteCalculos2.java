import javax.swing.*;
class TesteCalculos2
{
	 public static void main(String args[])
     {
     System.out.println("\n\n(1)Adição\n(2)Subtração\n(3)Multiplicação\n(4)Divisão\n(5)Potenciação\n(6)Tabuada\n(7)sair");

	     
	    	  int opcao = 0;
	    		while (opcao != 6)
	    		{
	    		opcao = Integer.parseInt(JOptionPane.showInputDialog(" Qual operação vc quer fazer? "));
	    		if ((opcao > 6)||(opcao <1)) continue;  /* Opcao invalida: volta ao inicio do loop */ 
	    		{
	    		  switch (opcao)
	    		 
	    		  
	    		  {
	    		  case 1: System.out.println("Adição      " ); break;
	    		
	    		  case 2: System.out.println("Subtração   " ); break;
	    		  
	    		  case 3: System.out.println("Multiplicação"); break;
	    		
	    		  case 4: System.out.println("Divisão      "); break;
	    	
	    		  case 5: System.out.println("Potenciação  "); break;
	    		
	    		  case 6: System.out.println("Tabuada      "); break;
	    	
	    		 default: System.out.println("Sair");
	    		  }
	     	  }
	    		return;
	    		}
	      }
}
	    	
	     
		




