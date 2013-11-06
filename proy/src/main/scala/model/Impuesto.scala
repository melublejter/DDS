package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_IMPUESTO", discriminatorType = DiscriminatorType.STRING)
abstract class Impuesto extends PersistentObject{

    var id_impuesto: java.lang.Long =null
  	var porcentaje:java.math.BigDecimal =null
	

  	@Id	@GeneratedValue def getId() = id_impuesto
	def setId(_id_impuesto:Long) = id_impuesto = _id_impuesto
	
	@Column def getPorcentaje() = porcentaje
	def setPorcentaje(_porcentaje : java.math.BigDecimal) = porcentaje = _porcentaje
	
  	
  	def costoImpositivo(costoTareas:java.math.BigDecimal):java.math.BigDecimal;

}