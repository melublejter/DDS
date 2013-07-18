import java.util.Date

object SistemaVentas {
	var noches: List[Noche] = List.empty[Noche];
	var entradasVendidas: List[Entrada] = List.empty[Entrada];
	var diasMinDescuentoAnticipada = 0;
	var porcentajeDescuentoAnticipada = 0;

	
	
 def crearEntrada(unCliente: Cliente, unaNoche: Noche, unaButaca: Butaca): Entrada = {
   var ultNroFact = entradasVendidas.last.nroFactura + 1
   var ent= new Entrada();
   ent.butaca=unaButaca;
   ent.noche = unaNoche;
   ent.cliente = unCliente;
   ent.nroFactura = ultNroFact;
   ent.precioDeVenta = this.precioFinal(ent);
   
   return ent;
 }
 	
	
 def buscarEntradaVendida(unNroFactura: Int): Entrada = {
   var nro= unNroFactura
   return entradasVendidas.filter(e=>(e.nroFactura == nro)).head
 }
 
  
 def calcularDescuentoAnticipa(precio: Double, noche: Noche): Double = {
   var hoy = new Date();
		 if (noche.fecha.getDate().-(hoy.getDate()) > diasMinDescuentoAnticipada) {
		   return precio.*(porcentajeDescuentoAnticipada);
		 }
		 else{
		   return 0;
		 } 
  }
 
 def precioFinal(entrada: Entrada): Double = {
   var valorEntradaBase = entrada.butaca.precioBase();
   var valorExtraPorNoche = entrada.noche.valorExtra();
   var descuentoTipoPersona = entrada.cliente.dtoTipoPers(valorEntradaBase);
   var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
   var dtoAnticipada = this.calcularDescuentoAnticipa(precio, entrada.noche);
   
   return  precio - dtoAnticipada;
    
  }

}