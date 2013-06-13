class Decorator_Cte_Mayor(unDecorado:TipoCliente) extends TipoCliente {
		var decorado:TipoCliente= unDecorado
  
		def dtoTipoPersona(precioBase:Double):Double = decorado.dtoTipoPers(precioBase) + 0
		def datosLegales()= decorado.datosLegales;
}