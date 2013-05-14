import java.util.Date

object programa {
 def main(args: Array[String]){
   val pepita = new Mascota(new Contenta(1))
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.come()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.come()
   pepita.cuanContentaEstas()
   
   /*val pepita = new Mascota(new Aburrida(0, new Date))
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.come()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.cuanContentaEstas()
   pepita.come()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.cuanContentaEstas()*/
   
   /*val pepita = new Mascota(new Hambrienta(0))
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.come()
   pepita.podesJugar()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.cuanContentaEstas()
   pepita.come()
   pepita.cuanContentaEstas()
   pepita.juga()
   pepita.cuanContentaEstas()*/
 }
}