class Contenta(contentitudInicial: Int) extends Estado(contentitudInicial) {
 
 override def come(pet: Mascota){
   contentitud += 1;
 }
  
 override def juga(pet: Mascota){
   contentitud += 2;
 }
}