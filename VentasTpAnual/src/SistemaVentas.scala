import org.joda.time._
import org.joda.convert._
import java.text.DateFormat
import java.util.GregorianCalendar
import java.util.Calendar



object SistemaVentas {
	var noches: List[Noche] = List.empty[Noche];
	var entradasVendidas: List[Entrada] = List.empty[Entrada];
	var diasMinDescuentoAnticipada: Int = 30;
	var porcentajeDescuentoAnticipada:Double = 0.10;
	var bandas: List[Banda] = List.empty[Banda];
	var descuentos: List[String] = List.empty[String];
	var pagosPendientes: List[Pago] = List.empty[Pago];


	def cantidadEntradas():Int ={
		var entradas=0;
		for(unaNoche <- noches){
		    entradas += unaNoche.butacas.length;
		}
		return entradas;
	}
	
	def entradasDeMujeresConDescVendidas(): Int ={
	  entradasVendidas.filter(entrada =>(entrada.tipoCliente.isInstanceOf[TipoCliente_Mujer])).length;
	  return 0;
	}
	
	/*	
	def crearEntrada(unCliente: Cliente, unPedido: Pedido): Entrada = {
	
	   var ultNroFact:Int=0;
	   if(entradasVendidas.size==0)
	   {   ultNroFact=1;}
	   else	
	   { ultNroFact = entradasVendidas.last.nroFactura + 1}

	   var entrada= unPedido.generarEntrada();
	   entrada.butaca=unPedido._butaca;
	   entrada.cliente = unCliente;
	   entrada.nroFactura = ultNroFact;
	   entrada.precioDeVenta = entrada.precioFinal();
	   
	   return entrada;
	}
	*/
	/*
	 * (Confirmen si están de acuerdo)
	 *   Creo que este método no debería ir mas ya que ahora es responsabilidad del pedido
    def crearEntradas(unCliente: Cliente,pedidos: List[Pedido]): List[Entrada] = {
		var entradas:List[Entrada]= List.empty[Entrada];
		var costoTotal:Double =0;
		var ultNroFact:Int=0;
		
	    for(pedido <- pedidos){
	      var unaEntrada = crearEntrada(unCliente, pedido);
	      costoTotal= costoTotal + unaEntrada.precioDeVenta;
	      //println("precio de entrada combo"+ unaEntrada.precioDeVenta);
	      entradas=entradas.+:(unaEntrada);
	    }
	    
	    if(costoTotal > 1000.0){
	    	for(entrada <- entradas){
	    		entrada.precioDeVenta=entrada.precioDeVenta*0.90;
	    	}
	    }
	    
	   return entradas;
	}
	 */
	

	def buscarEntradaVendida(unNroFactura: Int): Entrada = {
	   var nro= unNroFactura
	   return entradasVendidas.filter(e=>(e.nroFactura == nro)).head
	}
	 
	 
	 //entradasVendidas.filter(e=>(e.cliente.isInstanceOf[Cliente_Mujer])
	 
	  
	def calcularDescuentoAnticipa(precio: Double, noche: Noche): Double = {
	   var hoy = DateTime.now();
	   var diffInDays =  diferenciasDeFechas(hoy, noche.fecha);
			 if (diffInDays < diasMinDescuentoAnticipada) {
			   return precio*porcentajeDescuentoAnticipada;
			 }
			 else{
			   return 0.0;
			 }
	   return 0.0; 
	 }
	 
	 def precioFinal(entrada: Entrada): Double = {
	   var valorEntradaBase = entrada.butaca.precioBase();
	   var valorExtraPorNoche = entrada.noche.valorExtra();
	   var descuentoTipoPersona = entrada.tipoCliente.dtoTipoPersona(valorEntradaBase);
	   var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
	   var dtoAnticipada = this.calcularDescuentoAnticipa(precio, entrada.noche);
	   
	   return  precio - dtoAnticipada;
	    
	 }
	 
	 
	 
	 //Esta funcion no funciona bien, busque por internet y no funco ninguna.LUCAS
	 //FIXME
	  def diferenciasDeFechas(fechaInicial:DateTime, fechaFinal:DateTime):Int = Days.daysBetween(fechaInicial, fechaFinal).getDays()
	  
	  //Funcion que realiza el cobro de todas los pagos pendientes
	  //TODO Completar para que se pueda implementar los pagos luego de que queden pendientes
	  def cobrarPagos(){
	    for (unPago<- this.pagosPendientes){
	      unPago.cobrar()
	    }
	    
	  }
	  
	  //Funcion cambia la categoria de una banda de forma din�mica
	  //Por ahora hice el test con un setter nomas, 
	  //porque me daba error en el filter,
	  //Parece que no encontrabaa a ninguno con ese nombre
	  def cambiarCategoriaBanda(nombreBanda: String, id: Int, costoExtra: Double){
		 var bandaBuscada =	((bandas.filter(unaBanda=>unaBanda.nombre == nombreBanda)).head)
		 bandaBuscada.categoria(new Categoria(id,costoExtra))
		 
	  }
	  
	  def agregarPagoPendiente(unPago:Pago) {
	    pagosPendientes = pagosPendientes.+:(unPago);
	    
	  }
	  
	  def agregarBanda(unaBanda:Banda){
	     bandas = bandas.+:(unaBanda);
	  }
	  
	  def agregarDescuento(unDescuento: String ){
	    descuentos = descuentos.+:(unDescuento);
	  }
	  
	  def sacarDescuento(unDescuento: String){
	    var nuevosDescuentos = descuentos.filterNot(elemento => elemento.equals(unDescuento));
	    descuentos = nuevosDescuentos;
	    
	  }
	  
	  
	    
	 
	 
}