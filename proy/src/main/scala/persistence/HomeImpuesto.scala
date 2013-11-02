package main.scala.persistence

import ModelManager.getManager
import javax.persistence.Query
import model.Impuesto


class HomeImpuesto {
	def save(unImpuesto:Impuesto) {
		getManager().persist(unImpuesto);
	}
	
	def all():List[Impuesto] = {
	 /* var unaQuery:Query=null;
		unaQuery = getManager().createQuery("from " + classOf[Impuesto]/*.getSimpleName()*/);
		return unaQuery.getResultList();*/
	  getManager().createQuery("From Impuestos", classOf[Impuesto]).getResultList.toList
	}
}