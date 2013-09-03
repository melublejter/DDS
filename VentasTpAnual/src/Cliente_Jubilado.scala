



class Cliente_Jubilado(nombre: String, apellido: String, nroTarjeta: String, restoDatosLegales: String) extends Cliente(nombre, apellido, nroTarjeta, restoDatosLegales){
  
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("jubilados"))
   //println("DescuentoCliente=" + precioBase*0.15);
  return (precioBase* 0.15);
   else
	   return 0;
  
	}
}