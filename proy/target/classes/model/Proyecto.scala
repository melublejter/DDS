package model;

import persistence.PersistentObject
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.Entity;
import javax.persistence.OneToMany;


//import javax.persistence.Inheritance
import scala.collection.JavaConversions._
import javax.persistence.OneToMany
//import javax.persistence.InheritanceType
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.DiscriminatorType


@Entity
class Proyecto extends PersistentObject{
  
     var id_proyecto: java.lang.Long =null
  	 var tareas: java.util.List[Tarea] = new java.util.ArrayList[Tarea]()
  	 
  @Id @GeneratedValue def getId() = id_proyecto
  def setId(_id: Long) = id_proyecto = _id

	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = Array(CascadeType.ALL))
	  def getTareas() = tareas
	  def setTareas(_tareas: java.util.List[Tarea]) = tareas = _tareas

	
	def obtenerTiempoTotal():Integer = {
	  var _tiempo:Integer =0;
	  tareas.foreach
	  	{ tarea => _tiempo=_tiempo + tarea.obtenerTiempo() }
	  return _tiempo;
	}
	
	def obtenerCostoTotal():java.math.BigDecimal = {
	  var _costo:java.math.BigDecimal =null;
	  tareas.foreach
	  	{ tarea => _costo=_costo.add(tarea.obtenerCostoConImpuesto())  }
	  return _costo;
	}
	
	def obtenerTareasConTiempoMenorA(cantDias:Integer):List[Tarea]={
	  var tareasConTiempoMenor:List[Tarea] =List.empty[Tarea];
	  
	  //var _costo:Double =0;
	  tareas.foreach
	  	{ tarea => if(tarea.tieneConTiempoMenorA(cantDias)){tareasConTiempoMenor:+tarea} }
	  return tareasConTiempoMenor;
	  
	}
}