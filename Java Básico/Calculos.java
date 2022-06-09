
class Calculos 
{		
	public static float soma(float n1, float n2)
	{
		return(n1 + n2);
		
	}
	public static float subtração(float n1, float n2)
	{
		return(n1 - n2);
		
	}
	public static float multiplicação(float n1, float n2)
	{
		return(n1 * n2);
		
	}
	public static float divisão(float n1, float n2)
	{
		return(n1 / n2);
		
	}
	public static float potencia(byte b, byte e)
	{
		long res=1;
		for(int i=1; i <= e; i++)
		{	
			res=res*b;
		}
		return res;
		
		
	}
	public static float tabuada(int num, int k)
	{
				return(num * k);
		
	}
	public static float primo(float n1, float n2)
	{
				return(n1 * n2);
		
	}
	public static float fatorial(short num)
	{
		long res=1;
		for(int i=1;i <= num;i++)
		{
			res*=1;
		}
		return res;
		
	}
	public static void perfeito(int num)
	{
		int res=0;
		for(int i=(num-1);i>=1;i--)
		{
			if(num%i==0)
				res+=1;
		}
		if(num==res)
			System.out.println("O numero" + num + "e" + "perfeito");
		
	}
	
	
}
