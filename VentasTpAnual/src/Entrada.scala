import java.util.Date
import scala.collection.immutable.Nil
import scala.util.control.Exception

abstract class Entrada( uncliente: Cliente, unTipoCliente: TipoCliente, unaNoche: Noche, unaButaca: Butaca) {

	var cliente: Cliente= uncliente;
	var tipoCliente: TipoCliente= unTipoCliente;
	var noche: Noche= unaNoche;
	var butaca: Butaca= unaButaca;
	var nroFactura : Int=_;
	var precioDeVenta: Double=_;
	var fechaCompra: Date = new Date();
	var devuelta: Boolean = false;


	/*
tipoDePago que tenga un objeto de una clase pagoEnEfectivos o de una clase pagoConTarjeta. 
Que en el metodo comprar de la entrada llame a tipoDePago.comprar()
*/


def comprar(cod: String = "");
  
def anular();

  def precioFinal(): Double; 
  
  def imprimir(){
	  /*envia imprimir a la impresora fiscal*/
  }
  	
  def realizarCompra(cod: String );
  	
  def devolver(): Double;
}