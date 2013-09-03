

class Cliente_MenorDe12(nombre: String, apellido: String, nroTarjeta: String, restoDatosLegales: String, estaAcompaniado: Boolean) extends Cliente(nombre, apellido, nroTarjeta, restoDatosLegales) {
	var acompaniado = estaAcompaniado; 
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("menores de 12"))
		if (estaAcompaniado) 
			return (precioBase *0.50);
		else
		  return 0.0;	
   else
	   return 0;
} 
  
}