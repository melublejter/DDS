package main.scala.persistence

import ModelManager.getManager
import model.Tarea
import javax.persistence.Query
import scala.collection.JavaConversions._

class HomeTarea {
	def save(unaTarea:Tarea){
	  getManager().persist(unaTarea);
	}
	def all():List[Tarea] = {
	 /* var unaQuery:Query=null;
		unaQuery = getManager().createQuery("from " + classOf[Tarea]/*.getSimpleName()*/);
		return unaQuery.getResultList();*/
	  getManager().createQuery("From Tareas", classOf[Tarea]).getResultList.toList
	}
}