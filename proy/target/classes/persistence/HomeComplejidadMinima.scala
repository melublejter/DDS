package main.scala.persistence

import model.ComplejidadMinima
import javax.persistence.Query
import scala.collection.JavaConversions._
import ModelManager.getManager

class HomeComplejidadMinima {
	def save(unaComplejidad:ComplejidadMinima){
	  getManager().persist(unaComplejidad);
	}
	def all():List[ComplejidadMinima] = {
	 /* var unaQuery:Query=null;
		unaQuery = getManager().createQuery("from " + classOf[ComplejidadMinima]/*.getSimpleName()*/);
		return unaQuery.getResultList();*/
	  getManager().createQuery("From Complejidades", classOf[ComplejidadMinima]).getResultList.toList
	}

}