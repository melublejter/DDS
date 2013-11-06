package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.DiscriminatorValue


@Entity
@DiscriminatorValue("MEDIA")
class ComplejidadMedia extends ComplejidadMinima {
  	

   override def obtenerCosto(tiempo:Integer):java.math.BigDecimal ={
    return (new java.math.BigDecimal(tiempo * 25)).multiply(new java.math.BigDecimal (1.05));
  }
  override def diasMaximoAtraso(tiempo:Integer):java.math.BigDecimal ={
    return new java.math.BigDecimal(0.1).multiply(new java.math.BigDecimal (tiempo));
  }
  
}
  