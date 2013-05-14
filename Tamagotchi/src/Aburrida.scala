import java.util.Date

class Aburrida(contentitudInicial: Int, horaInicial: Date) extends Estado(contentitudInicial) {
  val horaDesdeQueSeAburrio = horaInicial
  
 override def come(pet: Mascota){
    var horaActual = new Date
   
    if ((horaActual.getTime() - horaDesdeQueSeAburrio.getTime()) > 80*60000){
      pet.setEstado(new Contenta(1))
    }
 }
  
 override def juga(pet: Mascota){
   pet.setEstado(new Contenta(1))
 }

}