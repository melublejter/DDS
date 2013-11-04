package model;

import persistence.PersistentObject
import javax.persistence.Entity

@Entity
class ImpuestoB(_porcentaje:Double) extends Impuesto{
	porcentaje=_porcentaje;
	
	def costoImpositivo(costoTareas:Double):Double = {
	  return costoTareas*1.05;
	}
}