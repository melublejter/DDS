class Decorator_Cte_Menor extends TipoCliente {
		var decorado: TipoCliente;
	
		
		def dtoTipoPersona(precioBase:Float):Double = {
		if (precioBase > 100) return (decorado.dtoTipoPers(precioBase)  + precioBase *0.80)
				else if((precioBase< 100) && (precioBase>50))
					return (decorado.dtoTipoPers(precioBase)  + precioBase -10)
							else return  decorado.dtoTipoPers(precioBase)
		} 

		def datosLegales()= decorado.datosLegales;
  
  
}