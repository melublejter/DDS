package model;
import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column

@Entity
class ComplejidadMinima extends PersistentObject{
  	@Id 
	@GeneratedValue
    @Column(name = "id_complejidad")
    var id_complejidad:Long=_;
  	
 
    @Column(name="nombre")
  	var nombre:String  = "Minima";
  	  
  def obtenerCosto(tiempo:Integer):Double ={
    return tiempo * 25;
  }
  
  def diasMaximoAtraso(tiempo:Integer):Double ={
    return 5;
  } 

}
