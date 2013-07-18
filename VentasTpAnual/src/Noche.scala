import java.util.Date
class Noche(unaFecha:Date,unaHora:Int, unId :Int) {
	var fecha: Date = unaFecha;
	var horaInicio: Int = unaHora;
	var bandas: List[Banda] = List.empty[Banda];
	var butacasLibres: List[Butaca] = List.empty[Butaca];
	var butacasOcupadas: List[Butaca] = List.empty[Butaca];
	var id: Int  = unId;
	
	
	def valorExtra():Double = {
	  
	  return this.maxCategoria().costoExtra;
	  
	  
	}
	
	def maxCategoria():Categoria = {
			val categorias = bandas.map{unaBanda => unaBanda.categoria};
			return categorias.maxBy{unaCategoria => unaCategoria.nivel};
	}
	

}