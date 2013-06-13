class Decorator_Cte_Menor(unDecorado:TipoCliente) extends TipoCliente {
		var decorado:TipoCliente= unDecorado	
		
		def dtoTipoPersona(precioBase:Double):Double = {
		if (precioBase > 100) return (decorado.dtoTipoPers(precioBase)  + precioBase *0.80)
				else if((precioBase< 100) && (precioBase>50))
					return (decorado.dtoTipoPers(precioBase)  + precioBase -10)
							else return  decorado.dtoTipoPers(precioBase)
		} 

		def datosLegales()= decorado.datosLegales;
  
  
}