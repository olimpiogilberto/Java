
class ExemploVetorFor 
	{
		public static void main (String args[])
		{
			String str[] = new String[10];
			String temp="";
			for(int i=0; i< str.length; i++)
			{
				temp +=i;
				str[i] = temp;}
			for(int i=0; i< str.length; i++)
			{
				System.out.println("str[" + i+ "]="+ str[i]);
				
			}
			}
		
	}


