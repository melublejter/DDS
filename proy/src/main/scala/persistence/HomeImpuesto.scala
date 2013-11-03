package persistence

import ModelManager.getManager
import javax.persistence.Query
import model.Impuesto
import scala.collection.JavaConversions._


class HomeImpuesto {
	def save(unImpuesto:Impuesto) {
		getManager().persist(unImpuesto);
	}
	
	def all():List[Impuesto] = {
	  getManager().createQuery("From Impuestos", classOf[Impuesto]).getResultList.toList
	}
}