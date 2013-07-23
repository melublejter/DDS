class Cliente_Jubilado( datosLegales: String ) extends Cliente {
	var _datosLegales: String = datosLegales;
  
 override def dtoTipoPersona(precioBase:Double):Double = {
   //println("DescuentoCliente=" + precioBase*0.15);
  return (precioBase* 0.15);
  
	}
}