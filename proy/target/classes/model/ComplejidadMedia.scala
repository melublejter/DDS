package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Column


@Entity
class ComplejidadMedia extends ComplejidadMinima {
  	
  	nombre="Media";
   override def obtenerCosto(tiempo:Integer):Double ={
    return (tiempo * 25)*1.05;
  }
  override def diasMaximoAtraso(tiempo:Integer):Double ={
    return tiempo*0.1;
  }
  
}
  