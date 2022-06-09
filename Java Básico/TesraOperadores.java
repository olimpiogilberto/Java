
public class TesraOperadores 
	{ public static void main(String args[])
	{String a1="Teste";String a2="Concatenação";String a3=a1+a2;
	System.out.println("a3 = "+a3);
	int a = 5; int b = ++a;
	System.out.println(a);
	System.out.println(b);
	System.out.println(a+=b);
	System.out.println(b-=a);
	System.out.println(b=4);
	System.out.println(b++);
	System.out.println(++b);
	System.out.println(b*=a);
	System.out.println(a%=2);
	int resultado = a+b;
	System.out.println("resultado = " + resultado);
	System.out.println("resultado = " + (a+b));
	}
	}