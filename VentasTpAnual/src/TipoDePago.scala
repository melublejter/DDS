import scala.collection.immutable.Nil
import java.sql.Struct
//import java.util.Conversion

abstract class TipoDePago {

	def comprar(unaEntrada:Entrada,cod:String);
}

class PagoEnEfectivo extends TipoDePago(){
  
	def comprar(unaEntrada:Entrada,cod: String) {
	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return
	      }
	    unaEntrada.realizarCompra(cod);
	    
	    
  }
	
}


class PagoConTarjeta() extends TipoDePago(){
  var _sisCobro: SistemaDeCobro = null
  
 def comprar(unaEntrada:Entrada,cod:String) {
	//usa la api
	  
		if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return;	//NO encuentra la estrada en la lista de vendidas 
	    }
	     print("Ingrese el apellido y nombre del comprador : " )
	     val nombreCliente = Console.readLine
	     print("Ingrese el numero de tarjeta del comprador : " )
	     val numeroTarjeta =  Console.readLine
	     
	    unaEntrada.realizarCompra(cod:String);
	     
	     try {
	    	 _sisCobro.cobrar(unaEntrada.precioDeVenta, nombreCliente, numeroTarjeta);
		   } catch {	
				case e: DesconexionException => SistemaVentas.agregarPagoPendiente(new Pago(unaEntrada,nombreCliente,numeroTarjeta))
				case e: ValidacionException =>  unaEntrada.anular()
				  		//loguear venta no realizada o informar por pantalla
			}
	    
  }
  
  
  
	
} 

