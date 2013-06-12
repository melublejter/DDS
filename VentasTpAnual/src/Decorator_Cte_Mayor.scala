class Decorator_Cte_Mayor extends TipoCliente {
		var decorado: TipoCliente;
  
		def dtoTipoPersona(precioBase:Float):Double = decorado.dtoTipoPers(precioBase) + 0
		def datosLegales()= decorado.datosLegales;
}