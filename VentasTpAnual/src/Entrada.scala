import java.util.Date

class Entrada(unCliente: TipoCliente, unaNoche: Noche, unaButaca: Butaca, unNroFactura: Int) {

	var cliente: TipoCliente = unCliente;
	var noche: Noche = unaNoche;
	var butaca: Butaca = unaButaca;
	var nroFactura : Int = unNroFactura
	var porcDtoAnt: Double = 0;
	var fechaCompra: Date = new Date();
	
	
  def precioFinal():Double = {
   var valorEntradaBase = butaca.precioBase();
   var valorExtraPorNoche = noche.valorExtra();
   var descuentoTipoPersona = cliente.dtoTipoPers(valorEntradaBase);
   var dtoAnticipada = this.calcularDescuentoAnticipa();
    return valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona - dtoAnticipada;
    
  }
  
  def comprar():Void = {
    noche.butacasLibres.remove(butaca);
    noche.butacasOcupadas.add(butaca);
    sistema.entradasVendidas.add(this);
    this.imprimir();
  }
  
  def calcularDescuentoAnticipa():Double = {
		 if (SistemaVentas.date.after(fechaCompra)) {
		   porcDtoAnt = SistemaVentas.porcentajeDtoAnticipada;
		   return this.precioFinal() * porcDtoAnt;
		 }
		 else{
		   porcDtoAnt = 0.0;
		   return 0;
		 } 
  }
  
  	def imprimir() = {
	  /*envia imprimir a la impresora fiscal*/
  }
  	def devolver() ={
  	  /*Devolver entrada*/
  	  
  	}
		  
}