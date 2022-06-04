
package cap1.x;

public class Papi {
	final void setNum() { System.out.println("final");}
/* aqui estou subscrevendo meu método final, isso não é válido para um código que não compila */
	
	class fifi extends Papi{
		public void setNum(){}
	} 

}
