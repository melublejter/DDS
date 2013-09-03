



class Cliente_Menor(nombre: String, apellido: String, nroTarjeta: String, restoDatosLegales: String) extends Cliente(nombre, apellido, nroTarjeta, restoDatosLegales) {
  
		
 override def dtoTipoPersona(precioBase:Double):Double = {
   if(SistemaVentas.descuentos.contains("menores de 18")){
		if (precioBase > 100) 
			return (precioBase *0.20);
		if((precioBase <= 100) && (precioBase > 50)){
		   //println("DescuentoClienteMenor=" + (10));
			return (10.0);
			}
		else
		  return 0;	
 }else
   return 0;
   
		//Puse este else porque sino me daba error
		//"type mismatch found unit required double"
} 
  
}