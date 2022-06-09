import javax.swing.*;
class VetorNomes 
{
	public static void main(String ar[])
{
	int qtd=Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas a serem cadastradas!"));	
	
		String []nome= new String[qtd];
		byte []idade= new byte[qtd];
		for(int i=0;i<qtd;i++)
		{
		
		nome[i]=JOptionPane.showInputDialog("Digite o " + (i+1) +"° nome");
		idade[i]=Byte.parseByte(JOptionPane.showInputDialog("Digite a idade"));
	}
		for(int i=0;i<qtd;i++)
		{
			System.out.println("Nome:" + nome[i]+ "idade:"+ idade[i]);
		}
		
	}

}
