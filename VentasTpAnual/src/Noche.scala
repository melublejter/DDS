import java.util.Date

class Noche(unaFecha:Date,unaHora:Int, unId :Int,
    lasBandas:List[Banda],lasButacas:List[Butaca]) {
  
	var fecha: Date = unaFecha;
	var horaInicio: Int = unaHora;
	var bandas: List[Banda] = lasBandas;
	var butacasLibres: List[Butaca] = lasButacas;
	var butacasDePromocion: List[Butaca] = List.empty[Butaca];;
	var butacas: List[Butaca] = lasButacas;
	var id: Int  = unId;
	
	def reservarButaca(unaButacaPromocional: Butaca, suCodigo: String): Boolean ={
	  unaButacaPromocional.setCodigo(suCodigo);
	  butacasLibres= butacasLibres.diff(List(unaButacaPromocional));
  	  butacasDePromocion= butacasDePromocion.+:(unaButacaPromocional);
	  return true
	}
	
	
	def valorExtra():Double = {
	  return this.maxCategoria().costoExtra;
	}
	
	def maxCategoria():Categoria = {
			val categorias = bandas.map{unaBanda => unaBanda.categoria};
			return categorias.maxBy{unaCategoria => unaCategoria.nivel};
	}
	
	def cambiarCategoriaBanda(unNombreBanda:String, unId: Int, costoExtra: Int){
	  
	}

}
