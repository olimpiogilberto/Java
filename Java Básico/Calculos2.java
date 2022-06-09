import javax.swing.*;
 class Calculos2 
	 {
		 public static void main (String a[])
		 {
			 float num1, num2;
			 num1 = Float.parseFloat(JOptionPane.showInputDialog("Digite um numero"));
			 num2 = Float.parseFloat(JOptionPane.showInputDialog("Digite um outro"));
			 JOptionPane.showMessageDialog(null, "O numero" + num1 +"ao somado" + num2 +"=" + calcularSoma(num1 + num2));
			 JOptionPane.showMessageDialog(null, "O numero" + num1 + "ao subtraido" + num2 +"=" +calcularSubtrai(num1-num2));
			 JOptionPane.showMessageDialog(null, "O numero" + num1 +"ao multiplicado" + num2 +"=" +calcularMultiplica(num1*num2));
			 JOptionPane.showMessageDialog(null, "O numero" + num1 +"ao divido" + num2 +"=" + calcularDivide(num1/num2));
			 //fim do main
		 
		       public static float calcularSoma(float n1,float n2 ) 
		                          
		       {
		        return (n1 + n2);

	           }
		       public static float calcularSubtrai(float n1,float n2 ) 
		       {
	       		return ( n1 - n2);

	       	           }public static float calcularMultiplica(float n1,float n2 ) 
	    		       {
	       	    		return ( n1 * n2);

	       	    	           }
	       	           public static float calcularDivide(float n1,float n2 ) 
	       	 		       {
	       	    	    		return ( n1 / n2);

	       	    	    }
	       	        public static float calcularPotencia(byte b ,byte e ) 
    	 		       {
    	    	    	 	
	       	        	return ( n1 / n2);

    	    	       }
	 }

