



class Cliente_Mayor(nombre: String, apellido: String, nroTarjeta: String, restoDatosLegales: String) extends Cliente(nombre, apellido, nroTarjeta, restoDatosLegales){

 override def dtoTipoPersona(precioBase:Double):Double = {
  return 0;
	}
}