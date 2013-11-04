package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
trait Impuesto extends PersistentObject{

  @Id 
	@GeneratedValue
    @Column(name = "id_impuesto")
    var id_impuesto:Long=_;
  
  	@Column
	var porcentaje:Double =_;
	 
  	def costoImpositivo(costoTareas:Double):Double;

}