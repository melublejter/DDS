class Decorator_Cte_Jubilado(unDecorado:TipoCliente) extends TipoCliente {
		var decorado:TipoCliente= unDecorado
		
		def dtoTipoPersona(precioBase:Double):Double = decorado.dtoTipoPers(precioBase) + precioBase * 0.85

		
		def datosLegales()= decorado.datosLegales;
}