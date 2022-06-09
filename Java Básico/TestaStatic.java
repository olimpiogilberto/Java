
class TestaStatic {
	public static void main(String args[])
	{
		Carro c1 = new Carro();
		Carro fiat = new Carro();
		Carro fusca = new Carro();
		
		
        System.out.println("Placa d C3         " + c1.placa);
        System.out.println("Placa do Palio     " + fiat.placa);
        //Alterando as placas
        fiat.placa="SCE-2345"; 
        System.out.println("Placa do NewBeattle " + fusca.placa);//ABC-3456
        fusca.placa=" FOD-3456";
        System.out.println("Placa da Ferrari   " + fiat.placa);//ABC-3456
	}
}
 
