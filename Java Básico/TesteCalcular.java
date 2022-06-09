
public class TesteCalcular
{


	      public static void main(String args[])
	      {
	    	  if (args.length == 1)
	    	  {
	    		  int x;
	    		  x = Integer.parseInt(args[0]);
	    		  switch (x)
	    		  {
	    		  case 0: System.out.println("Adição      " ); break;
	    		  case 1: System.out.println("Subtração   " ); break;
	    		  case 2: System.out.println("Multiplicação"); break;
	    		  case 3: System.out.println("Divisão      "); break;
	    		  case 4: System.out.println("Potenciação  "); break;
	    		  case 5: System.out.println("Tabuada      "); break;
	    		 default: System.out.println("Numero desconhecido");
	    		  }
	     	  }
	    	  else
	    	  {
	    		  System.out.println("Numero de argumentos invalidos.");
	    		  
	    	  }
	      }
		

	}


