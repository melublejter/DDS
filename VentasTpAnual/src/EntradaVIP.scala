import java.util.Date

class EntradaVIP(tipoPago: TipoDePago) extends Entrada {
  noche = SistemaVentas.noches.head;
  var tipoDePago: TipoDePago=tipoPago;

override def devolver(): Double ={
		//Ver bien los return algo, no le preste atencion
		if (devuelta) {
			return -1;
		}
		if  (!SistemaVentas.entradasVendidas.contains(this)){
			//NO encuentra la estrada en la lista de vendidas
			return -2;
		}
  	  var hoy = new Date();
  	  var noche = SistemaVentas.noches.head;
	  if ((noche.fecha.getDate() -hoy.getDate()) > 10 ){
	    //No se puede devolver porque estamos en los ultimos 10 dias
	    return -3;
	    }
  	  for(noche <- SistemaVentas.noches){
  		  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  }
  	  devuelta=true;
  	  return precioDeVenta*0.5;
  	}
  	
override def comprar() : Boolean = {
    //No tendria que ser un lista contiene entrada? en vez de un "=="?
    //O tendria que sacarlo si lo verifico antes
		if (tipoDePago.comprar(this)){
			if  (SistemaVentas.entradasVendidas.==(this)){
				return false;
			}
			for(noche <- SistemaVentas.noches){
				noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
			}
			SistemaVentas.entradasVendidas=SistemaVentas.entradasVendidas.+:(this);
			this.imprimir(); 
			return true;
		}
		else
		  return false;
  }


override def precioFinal(): Double = {
  
		
	var valorEntradaBase = 0.0; 
	var valorExtraPorNoche = 0.0;
	var descuentoTipoPersona = 0.0; 
	var precio = 0.0; 
	var dtoAnticipada = SistemaVentas.calcularDescuentoAnticipa(precio, noche);
	
  for(noche <- SistemaVentas.noches){
    valorEntradaBase = butaca.precioBase();
    valorExtraPorNoche = noche.valorExtra();
    descuentoTipoPersona = descuentoTipoPersona +cliente.dtoTipoPersona(butaca.precioBase());
    //println("precio de la primer butaca VIP:" + 
    //    (valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona));
    precio = precio + valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
  }
  println("Precio de VIP antes de descuento y recargo: " +
      precio);
  precio = precio - dtoAnticipada;
  precio = precio*1.5
  
   return precio;
}
  	  
}