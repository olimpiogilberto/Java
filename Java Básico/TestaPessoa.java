class TestaPessoa 
 {	

	public static void main(String args[])
		{
			Pessoa joao = new Pessoa();
			Pessoa maria= new Pessoa();
			
			
			int masculino = 1;
			joao.setSexo(masculino);
			int feminino = 2;
			maria.setSexo(feminino);
	        System.out.println("O sexo de João é " + joao.lerSexo());
	        System.out.println("O sexo de Maria é " + maria.lerSexo());
		}
	
 } 
   
