package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column

@Entity
trait Impuesto extends PersistentObject{
  //es una single table tambien porque seguardan todos los tipos de impuestos en una tabla el A y el B
  	@Id 
	@GeneratedValue
    @Column(name = "id_impuesto")
    var id_impuesto:Long=_;
  
	 var porcentaje:Double =_;
	 def costoImpositivo(costoTareas:Double):Double;

}