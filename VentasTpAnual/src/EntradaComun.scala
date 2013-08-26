import java.util.Date

class EntradaComun(tipoPago:TipoDePago) extends Entrada {
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
	  if ((noche.fecha.getDate() -hoy.getDate()) > 10 ){
	    //No se puede devolver porque estamos en los ultimos 10 dias
	    return -3;
	    }
  	  
  	  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  devuelta=true;
  	  return precioDeVenta*0.5;
}

  	
override def comprar(cod: String = "") : Boolean = {
    //No tendria que ser un lista contiene entrada? en vez de un "=="?
    //O tendria que sacarlo si lo verifico antes
  		if (butaca.codigo.!=(cod)){return false}
		if (tipoDePago.comprar(this)){
  			if  (SistemaVentas.entradasVendidas.==(this)){
  				return false;
  			}
  			noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
  			SistemaVentas.entradasVendidas=SistemaVentas.entradasVendidas.+:(this);
  			this.imprimir();
  			
  			return true;
  		}
  		else	//PONGO ese else porque tira un error porque puede que no devuelva un booleano sino
  		  return false;
}

 override def precioFinal(): Double = {
   var valorEntradaBase = butaca.precioBase();
   var valorExtraPorNoche = noche.valorExtra();
   var descuentoTipoPersona = cliente.dtoTipoPersona(valorEntradaBase);
   var precio = valorEntradaBase + valorExtraPorNoche - descuentoTipoPersona;
   var dtoAnticipada = SistemaVentas.calcularDescuentoAnticipa(precio, noche);
   
   return  precio - dtoAnticipada;
    
  }
 

  	
		  
}