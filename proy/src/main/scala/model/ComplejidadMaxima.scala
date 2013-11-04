package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Column


@Entity
class ComplejidadMaxima extends ComplejidadMinima{
  	
  	nombre="Maxima"
  override def obtenerCosto(tiempo:Integer):Double ={
    if(tiempo<=10)
    	return (tiempo * 25)*1.07;
    else
      return (tiempo * 25)*1.07 + 10 *(tiempo-10);
  }  
  override def diasMaximoAtraso(tiempo:Integer):Double ={
    return 8+(tiempo*0.2);
  }

}