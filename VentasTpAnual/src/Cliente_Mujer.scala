

class Cliente_Mujer(nombre: String, apellido: String, nroTarjeta: String, restoDatosLegales: String) extends Cliente(nombre, apellido, nroTarjeta, restoDatosLegales) {
		
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("mujeres"))
		if ((SistemaVentas.entradasDeMujeresConDescVendidas / SistemaVentas.cantidadEntradas) < 0.20) 
			return (precioBase *0.20);
		else
		  return 0;
   else
     return 0;
} 
  
}