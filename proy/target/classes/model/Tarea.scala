package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.IndexColumn;

/*import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
class Tarea(_tiempo:Integer, _complejidad:ComplejidadMinima, _impuesto:List[Impuesto]) extends PersistentObject{
  //Es una singletable, falta poner con tareacompuesta con id_padre
  
  	@Id 
	@GeneratedValue
    @Column(name = "id_tarea")
    var id_tarea:Long=_;
  	
	@Column//(name = "id_impuesto")
    var impuesto:List[Impuesto] = _impuesto;
	
	@Column//(name = "id_tarea")
    var complejidad:ComplejidadMinima =_complejidad;
	
	@Column
	var tiempo: Integer=_tiempo;

	@ManyToOne
	var id_proyecto:Long=_;
	
	
	def obtenerCostoSinImpuesto():Double = {
	  return complejidad.obtenerCosto(tiempo);
	}

	def obtenerCostoConImpuesto():Double = {
	  var _costo:Double=obtenerCostoSinImpuesto();
	  impuesto.foreach
	  	{ unImpuesto => _costo= unImpuesto.costoImpositivo(_costo) }
	   return _costo;
	}
	def obtenerTiempo():Integer = {
	  return tiempo;
	}
	def tieneConTiempoMenorA(cantDias:Integer):Boolean ={
	  return tiempo<cantDias;
	}
	
}