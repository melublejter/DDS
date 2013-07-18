class Cliente_Jubilado( datosLegales: String ) extends Cliente {
	var _datosLegales: String = datosLegales;
  
def dtoTipoPersona(precioBase:Double):Double = {
  return precioBase* 0.15;
  
	}
}