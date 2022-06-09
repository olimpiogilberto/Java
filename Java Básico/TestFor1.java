import javax.swing.JOptionPane;

/* Estrutura for Sintaxe: for(declaração;condição;incrementação /decrementação)
 * {
 * Comandos até que condição verdadeira
 * }
 * Exemplos*/
class TestFor1 
{
	public static void main(String ar[])
	  {
		for(int i=0;i<2;i++)
		{
			String nome=JOptionPane.showInputDialog("Digite o nome");
			  int idade=Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
		}
		}

}
