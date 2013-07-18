class Cliente_Menor(datosLegales:String) extends Cliente {
	var _datosLegales: String = datosLegales;
  
		
def dtoTipoPersona(precioBase:Double):Double = {
		if (precioBase > 100) 
			return (precioBase *0.20);
		if((precioBase <= 100) && (precioBase > 50))
			return (precioBase * -10);
		else
		  return 0;	
		//Puse este else porque sino me daba error
		//"type mismatch found unit required double"
		
} 
  
}