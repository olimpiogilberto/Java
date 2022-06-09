class Pessoa
 {
	  private String nome,telefone;
	  int Sexo;	
	  private static int masculino= 1 ;
	  private static int feminino= 2; 
	  public void setSexo(int s )
	  {	
 
 Sexo=s;
	  } 
	  public String lerSexo()
	  {
		  if(Sexo == 1)
		  {
			  return "Masculino";
	      }
		  
	  else{
		  return "Feminino";
	  }
			  
	  }
 }
