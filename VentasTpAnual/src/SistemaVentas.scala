object SistemaVentas {
	var noches: List[Noche]
	var entradasVendidas: List[Entrada]
	var diasMinDtoAnticipada: Int
	var porcentajeDtoAnticipada: Double

 def consultarButacasLibres(unaNoche: Noche): List[Butaca] = {
	 return unaNoche.butacasLibres
	}
	
 def pedirEntrada(unCliente: Cliente, unaNoche: Noche, unaButaca: Butaca): Entrada = {
   var ultNroFact = entradasVendidas.last.nroFactura + 1
  
   return new Entrada(unCliente, unaNoche, unaButaca, ultNroFact)
 }
 
 def comprarEntrada(unaEntrada: Entrada) {
   unaEntrada.comprar()
   
 }
 
 def buscarEntradaVendida(unNroFactura: Int): Entrada = {
   var nro= unNroFactura
   return entradasVendidas.filter(e=>(e.nroFactura == nro)).head
 }
 
 def devolverEntrada(unaEntrada: Entrada) = {
   var noche=unaEntrada.noche
   var butaca = unaEntrada.butaca
   
   if ((noche.fecha - today)>10){
     unaEntrada.devolver()
     return true }
    else{ 
     return false
   }
 }

}