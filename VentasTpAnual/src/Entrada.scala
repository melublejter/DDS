import java.util.Date

class Entrada() {

	var cliente: Cliente;
	var noche: Noche;
	var butaca: Butaca;
	var nroFactura : Int;
	var precioDeVenta: Double;
	var fechaCompra: Date = new Date();
	var devuelta: Boolean = false;
	
	

  
  def comprar() : Boolean = {
    if  (SistemaVentas.entradasVendidas.==(this)){return false;}
    noche.butacasLibres= noche.butacasLibres.diff(List(butaca));
    SistemaVentas.entradasVendidas.+:(this);
    this.imprimir();
    
    return true;
  }
  
  def imprimir(){
  	  printf("imprimo");
	  /*envia imprimir a la impresora fiscal*/
  }
  	
  	
  	def devolver(): Double ={
  	  if (devuelta) {return -1;}
  	  if  (SistemaVentas.entradasVendidas.!=(this)){return -2;}
  	  var hoy = new Date();
  	  if ((noche.fecha.getDate() -hoy.getDate()) > 10 ){return -3;}
  	  
  	  noche.butacasLibres=noche.butacasLibres.+:(butaca);
  	  devuelta=true;
  	  return precioDeVenta.*(0.5);
  	}
		  
}