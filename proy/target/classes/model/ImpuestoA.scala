package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.DiscriminatorValue

@Entity
@DiscriminatorValue("A")
class ImpuestoA extends Impuesto{
	
	
	override def costoImpositivo(costoTareas:java.math.BigDecimal):java.math.BigDecimal = {
	  return costoTareas.multiply(new java.math.BigDecimal(1.03));
	}
}