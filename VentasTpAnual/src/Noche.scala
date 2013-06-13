import java.util.Date
class Noche(unaFecha:Date,unaHora:Int) {
	var fecha: Date;
	var horaInicio: Int
	var bandas: List[Banda];
	var butacasLibres: List[Butaca] = List.empty[Butaca];
	var butacasOcupadas: List[Butaca] = List.empty[Butaca];
	var id: Int;
	
	
	def valorExtra():Double = {
	  
	  return this.maxCategoria().costoExtra;
	  
	  
	}
	
	def maxCategoria():Categoria = {
			val categorias = bandas.map{unaBanda => unaBanda.categoria};
			return categorias.maxBy{unaCategoria => unaCategoria.nivel};
	}
	

}