class ExemploConversao
{
	public static void main(String a[])
	{
		byte b=5;short s=125;int i=400;		
		long l =500; float f=14.5f;
		double d=14.554433;
		//Casting implicito ou automático
		System.out.println("s=" + (s+=b));
		System.out.println("d=" + (d+=f));
		//Casting explícito ou declarado
		System.out.println("f="+(f=(float)d));
		System.out.println("i="+(i=(int)f));
		System.out.println("l="+(l=(long)d));
		System.out.println("b="+(b=(byte)s));
		
	}
	
	
}
