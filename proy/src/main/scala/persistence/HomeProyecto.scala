package main.scala.persistence

import ModelManager.getManager
import java.util.List
import javax.persistence.Query
import model.Proyecto
import scala.collection.JavaConversions.asScalaBuffer


class HomeProyecto {

	def save(unProyecto:Proyecto) {
		getManager().persist(unProyecto);
	}

	def all():List[Proyecto]= {
	  var unaQuery:Query =_;
		unaQuery = getManager().createQuery("from " + Proyecto.class.getSimpleName());
		return query.getResultList();
	}

}
