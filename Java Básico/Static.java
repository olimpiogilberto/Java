class TestaStatic

{ public static void main(String args[])

 { Carro c1 = new Carro();
   Carro fiat = new Carro();
   Carro fusca = new Carro();

   System.out.println("Placa de c1 "+c1.placa);
   System.out.println("Placa de fiat "+fiat.placa);

//Alterando as placas
 
   fiat.placa="ABC - 2345";
   fusca.placa="BCD - 3456";

   System.out.println("Placa de fusca "+fusca.placa);

   System.out.println("Placa de fiat "+fiat.placa);

 }//finish main

}/*finish class*/

class Carro

 { public static String placa = "ABC - 1234"; }