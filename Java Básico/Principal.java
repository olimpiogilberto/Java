public class Principal 
{
	public static void main(String[] args)
	{
		int numero = Integer.parseInt( args[0] );
		Principal nprimo = new Principal();
		boolean resultado = nprimo.isPrimo(numero);
		if (resultado)
			System.out.println( "O numero " + numero + " é primo!");
		else
			System.out.println( "O numero " +numero+ " não é primo!");
	}

	public boolean isPrimo(int n)
	{
		if (n<=1)
			return false;

		for (int i=2; i<n; i++)
			if ((n%i) == 0)
				return false;

		return true;
	}
}
