package model;

import persistence.PersistentObject
import javax.persistence.Entity
import scala.collection.JavaConversions._
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.CascadeType;

@Entity
class TareaCompuesta(_tiempo:Integer, _complejidad:ComplejidadMinima, _impuesto:List[Impuesto]) extends Tarea(_tiempo, _complejidad, _impuesto){
	
  	var subTareas: java.util.List[Tarea] = new java.util.ArrayList[Tarea]()
	

  @OneToMany(fetch = FetchType.LAZY, cascade = Array(CascadeType.ALL))
	  def getSubTareas() = subTareas
	  def setSubTareas(_subTareas: java.util.List[Tarea]) = subTareas = _subTareas

	
	
	override def obtenerCostoConImpuesto():java.math.BigDecimal = {
	  var _costo:java.math.BigDecimal =null;
	  subTareas.foreach
	  	{ tarea => _costo=_costo.add(tarea.obtenerCostoConImpuesto()) }
	  
	  if (tieneOverhead())
	  	return _costo.multiply(new java.math.BigDecimal(1.04));
	  return _costo;
	}
	def agregarTarea(unaTarea:Tarea){
	  subTareas:+unaTarea;
	}
	
	
	def tieneOverhead():Boolean={	
	  return (subTareas.length>3);
	}
	
	override def obtenerTiempo():Integer ={
	  var _tiempo:Integer =0;
	  subTareas.foreach
	  	{ tarea => _tiempo=_tiempo + tarea.obtenerTiempo() }
	  return _tiempo;
	}
	override def tieneConTiempoMenorA(cantDias:Integer):Boolean ={
	  return obtenerTiempo()<cantDias;
	}

}