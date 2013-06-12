import java.util.Date
class Entrada {

	var cliente: TipoCliente;
	var noche: Noche;
	var nroFactura : Int;
	var porcDtoAnt: Float;
	var fechaCompra: Date;
	
	
  def precioFinal():Float = {
   var valorEntradaBase = butaca.precioBase();
   var valorExtraPorNoche = noche.valorExtra();
   var descuentoTipoPersona = cliente.dtoTipoPers(valorEntradaBase);
   var dtoAnticipada = this.calcularDescuentoAnticipa();
    return = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona - dtoAnticipada;
    
  }
  
  def comprar():Void = {
    noche.butacasLibres.remove(butaca);
    noche.butacasOcupadas.add(butaca);
    sistema.entradasVendidas.add(this);
    this.imprimir();
  }
  
  def calcularDescuentoAnticipa():Double = {
		  
    
  }
  
}