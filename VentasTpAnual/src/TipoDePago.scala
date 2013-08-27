import scala.collection.immutable.Nil
import java.sql.Struct
//import java.util.Conversion

abstract class TipoDePago {

	def comprar(unaEntrada:Entrada):Boolean;
}

class PagoEnEfectivo extends TipoDePago(){
  
	def comprar(unaEntrada:Entrada) {
	    if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return
	      }
	    unaEntrada.realizarCompra();
	    
	    
  }
	
}


class PagoConTarjeta() extends TipoDePago(){
  var _sisCobro: SistemaDeCobro
  
 def comprar(unaEntrada:Entrada) {
	//usa la api
	  
		if  (SistemaVentas.entradasVendidas.==(unaEntrada)){
	      return;	//NO encuentra la estrada en la lista de vendidas 
	    }
	     print("Ingrese el apellido y nombre del comprador : " )
	     val nombreCliente = Console.readLine
	     print("Ingrese el numero de tarjeta del comprador : " )
	     val numeroTarjeta =  Console.readLine
	     
	    
	     try {
	    	 _sisCobro.cobrar(unaEntrada.precioDeVenta, nombreCliente, numeroTarjeta)
		   } catch {	
				case e: DesconexionException => SistemaVentas.agregarPagoPendiente(unaEntrada,nombreCliente,numeroTarjeta)
				case e: ValidacionException =>  
				  		return
				  		//loguear venta no realizada o informar por pantalla
			}
	    
	    finally{
  		unaEntrada.realizarCompra();
	    }
  }
  
  
  
	
} 

