package persistence

import ModelManager.getManager
import java.util.List
import javax.persistence.Query
import model.Proyecto
import scala.collection.JavaConversions._



class HomeProyecto {

	def save(unProyecto:Proyecto) {
		getManager().persist(unProyecto);
	}

	def all():List[Proyecto] = {
	 /* var unaQuery:Query=null;
		unaQuery = getManager().createQuery("from " + classOf[Proyecto]/*.getSimpleName()*/);
		return unaQuery.getResultList();*/
	  getManager().createQuery("From Proyectos", classOf[Proyecto]).getResultList.toList
	}

}
