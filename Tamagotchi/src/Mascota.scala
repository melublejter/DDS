class Mascota(estadoInicial: Estado) {
  var miEstado = estadoInicial
  
  def setEstado(unEstado: Estado){
    miEstado = unEstado
  }
  
  def come(){
    miEstado.come(this)   
  }
  
  def juga(){
     miEstado.juga(this)
  }
  
  def podesJugar(){
     miEstado.podesJugar()
  }
  def cuanContentaEstas(){
	 miEstado.cuanContentaEstas()
  } 
}

