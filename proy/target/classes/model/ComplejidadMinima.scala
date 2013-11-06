package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.DiscriminatorType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_COMPLEJIDAD", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MINIMA")
class ComplejidadMinima extends PersistentObject{
  	  
  def obtenerCosto(tiempo:Integer):java.math.BigDecimal ={
    return new java.math.BigDecimal(tiempo*25);
  }
  
  def diasMaximoAtraso(tiempo:Integer):java.math.BigDecimal ={
    return new java.math.BigDecimal(5);
  } 
 
}