

class Cliente_Mujer(datosLegales:String, estaAcompaniado: Boolean) extends Cliente {
	var _datosLegales: String = datosLegales;
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
		if (true) 
			return (precioBase *0.20);
		else
		  return 0;			
} 
  
}