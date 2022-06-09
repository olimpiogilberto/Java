import javax.swing.JOptionPane;
    class UsaCaixaDialogo
    {
    	public static void main(String[]args) 
    	{ 
    		String nome; int idade;
    		nome=JOptionPane.showInputDialog("Digite seu nome"); 
    		idade=Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade"));
    		System.out.println("Seu nome é "+ nome +", você tem "+ idade +" anos de idade");
        }
   }
    
   
               
              
               
     
