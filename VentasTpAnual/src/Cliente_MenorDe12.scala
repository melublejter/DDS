

class Cliente_MenorDe12(datosLegales:String, estaAcompaniado: Boolean) extends Cliente {
	var _datosLegales: String = datosLegales;
	var acompaniado: Boolean = estaAcompaniado; 
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
		if (estaAcompaniado) 
			return (precioBase *0.50);
		else
		  return 0.0;	
} 
  
}