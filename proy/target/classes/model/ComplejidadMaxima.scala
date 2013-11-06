package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.DiscriminatorValue

@Entity
@DiscriminatorValue("MAXIMA")
class ComplejidadMaxima extends ComplejidadMinima{
  	

  override def obtenerCosto(tiempo:Integer):java.math.BigDecimal ={
    if(tiempo<=10)
    	return costoMenosDeDiezDias(tiempo);
    else
      return costoMenosDeDiezDias(tiempo);
  }  
  def costoMenosDeDiezDias(tiempo:Integer):java.math.BigDecimal ={
    return (new java.math.BigDecimal(tiempo * 25)).multiply(new java.math.BigDecimal (1.07));
  }
 
  def costoMasDeDiezDias(tiempo:Integer):java.math.BigDecimal ={
    
    var unTiempo:java.math.BigDecimal=null;
    unTiempo= new java.math.BigDecimal(tiempo-10); 
    var tiempo2:java.math.BigDecimal=null;
    tiempo2=unTiempo.multiply(new java.math.BigDecimal(10));
    //corroborar que add sea una suma
    return  (new java.math.BigDecimal(tiempo * 25)).multiply(new java.math.BigDecimal (1.07)).add(tiempo2);
  }
 
  
  override def diasMaximoAtraso(tiempo:Integer):java.math.BigDecimal ={
    return new java.math.BigDecimal(8+(tiempo*0.2));
  }
  
  
}