class Decorator_Cte_Jubilado extends TipoCliente {
		var decorado:TipoCliente
		
		def dtoTipoPersona(precioBase:Float):Double = decorado.dtoTipoPers(precioBase) + precioBase * 0.85

		
		def datosLegales()= decorado.datosLegales;
}