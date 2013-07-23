import java.util.Date
import scala.collection.immutable.Nil

class Entrada() {

	var cliente: Cliente=_;
	var noche: Noche=_;
	var butaca: Butaca=_;
	var nroFactura : Int=_;
	var precioDeVenta: Double=_;
	var fechaCompra: Date = new Date();
	var devuelta: Boolean = false;
	
	

  
  def comprar() : Boolean = {
    //No tendria que ser un lista contiene entrada? en vez de un "=="?
    //O tendria que sacarlo si lo verifico antes
    if  (SistemaVentas.entradasVendidas.==(this)){
      return false;
      }
    noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
    SistemaVentas.entradasVendidas=SistemaVentas.entradasVendidas.+:(this);
    this.imprimir();
    
    return true;
  }
  
  def imprimir(){
  	  printf("imprimo\n");
	  /*envia imprimir a la impresora fiscal*/
  }
  	
  	
  	def devolver(): Double ={
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
		  
}