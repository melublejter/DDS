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

import scala.collection.JavaConversions._
import javax.persistence.FetchType

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity
class Tarea(_tiempo:Integer, _complejidad:ComplejidadMinima, _impuesto:List[Impuesto]) extends PersistentObject{
  //Es una singletable, falta poner con tareacompuesta con id_padre
	var id_tarea: java.lang.Long =null
  	var impuestos: java.util.List[Impuesto] = new java.util.ArrayList[Impuesto]()
  	var complejidad:ComplejidadMinima=null;
	var tiempo: Integer=0;
	
  @Id @GeneratedValue def getId() = id_tarea
  def setId(_id_tarea: Long) = id_tarea = _id_tarea

  @OneToMany(fetch = FetchType.LAZY, cascade = Array(CascadeType.ALL))
	  def getImpuestos() = impuestos
	  def setImpuestos(_impuestos: java.util.List[Impuesto]) = impuestos = _impuestos

  	
	@Column def getComplejidad() = complejidad
  def setId(_complejidad: ComplejidadMinima) = complejidad = _complejidad

	
	@Column def getTiempo() = tiempo
  def setTiempo(_tiempo: Integer) = tiempo = _tiempo


	
	def obtenerCostoSinImpuesto():java.math.BigDecimal = {
	  return complejidad.obtenerCosto(tiempo);
	}

	def obtenerCostoConImpuesto():java.math.BigDecimal = {
	  var _costo:java.math.BigDecimal=obtenerCostoSinImpuesto();
	  impuestos.foreach
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