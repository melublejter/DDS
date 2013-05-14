class Hambrienta(contentitudInicial: Int) extends Estado(contentitudInicial) {
 
 override def come(pet: Mascota){
   pet.setEstado(new Contenta(1))
 }
 
 override def podesJugar(){
   println("NO!");
  }
}