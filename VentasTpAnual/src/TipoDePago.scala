import scala.collection.immutable.Nil
import java.sql.Struct
//import java.util.Conversion

abstract class TipoDePago {

	def comprar(unaEntrada:Entrada):Boolean;
}

class PagoEnEfectivo extends TipoDePago(){
  
	def comprar(unaEntrada:Entrada): Boolean = {
	    //No tendria que ser un lista contiene entrada? en vez de un "=="?
	    //O tendria que sacarlo si lo verifico antes
	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return false;
	      }
	    
	    return true;
  }
	
}


class PagoConTarjeta extends TipoDePago(){
  
  def comprar(unaEntrada:Entrada): Boolean = {
    return true;
  }
  
  
  //usa la api
  
//	def comprar(unaEntrada:Entrada): Boolean = {
//	  //var nombreCliente = new String();
//	  var numeroTarjeta:Int=0;
//	  
//	  
//	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
//	      return false;//lanzar una excepcion 
//	      }
//	     print("Ingrese el apellido y nombre del comprador : " )
//	     val nombreCliente = Console.readLine
//	     print("Ingrese el numero de tarjeta del comprador : " )
//	     numeroTarjeta =  (Console.readLine).toInt
//	    
//	     
//	     //el try catch creo q deberia estar aca
//	     
//	     try {
//	    	 informarAPaymentGateway(unaEntrada.precioDeVenta, nombreCliente, numeroTarjeta);
//	    	 return true;
//		   } catch {	
//				case "Error de conexion": Exception=>
//					println("Error de conexion.")
//					//se deberá registrar un pago pendiente en el sistema
//				case "Fallo en la validación de datos": Exception =>  
//				  	println("Fallo: esto puede deberse a que no tiene suficiente crédito, la tarjeta es inválida, etc.")
//				  	//En este caso, se debe deshacer la venta
//			}
//
//	    return false;
//	}
	
} 