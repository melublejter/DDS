import java.util.Date
import scala.collection.immutable.Nil
import scala.util.control.Exception

abstract class Entrada() {

	var cliente: Cliente=_;
	var noche: Noche=_;
	var butaca: Butaca=_;
	var nroFactura : Int=_;
	var precioDeVenta: Double=_;
	var fechaCompra: Date = new Date();
	var devuelta: Boolean = false;
	var tipoDePago: TipoDePago;
	/*
tipoDePago que tenga un objeto de una clase pagoEnEfectivos o de una clase pagoConTarjeta. 
Que en el metodo comprar de la entrada llame a tipoDePago.comprar()
*/

def comprar(cod: String = "");
  
  def precioFinal(): Double; 
  
  def imprimir(){
  	  printf("imprimo\n");
	  /*envia imprimir a la impresora fiscal*/
  }
  	
  def realizarCompra(cod: String);
  	
  def devolver(): Double;
}