import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Date
import java.util.Calendar
import org.junit.Assert._
import java.lang.Object
import sun.util.calendar.Gregorian


class FestivalTests {
  	
	
 	@Before
 	var sectorA = new Sector(80.0,'A');
 	var sectorB = new Sector(60.0,'B');
 	var sectorC= new Sector(40.0,'C');
 	
 	var fila1 = new Fila(1,50.0);
 	var fila2 = new Fila(2,40.0);
 	var fila3 = new Fila(3,30.0);
 	
 	var butaca1_1A = new Butaca(sectorA,fila1,1);
 	var butaca2_2A = new Butaca(sectorA,fila2,2);
 	var butaca3_3A = new Butaca(sectorA,fila3,3);
 	var butaca4_1B = new Butaca(sectorB,fila1,4);
 	var butaca5_2B = new Butaca(sectorB,fila2,5);
 	var butaca6_3B = new Butaca(sectorB,fila3,6);
 	var butaca7_1C = new Butaca(sectorC,fila1,7);
 	var butaca8_2C = new Butaca(sectorC,fila2,8);
 	var butaca9_3C = new Butaca(sectorC,fila3,9);
 	
 	var todasLasButacas = List[Butaca](butaca1_1A,butaca2_2A, 
 	    butaca3_3A, butaca4_1B,butaca5_2B, butaca6_3B, butaca7_1C, 
 	    butaca8_2C, butaca9_3C );
 	
 	
 	var categoria1 = new Categoria(1,00.0);
 	var categoria2 = new Categoria(2,50.0);
 	var categoria3 = new Categoria(3,100.0);
 	var categoria4 = new Categoria(4,200.0);
 	
 	var losPiojos = new Banda(categoria3,"Los Piojos");
 	var arbol = new Banda(categoria2,"Arbol");
 	var laVelaPuerca = new Banda(categoria2,"La Vela Puerca");
 	var NTVG = new Banda(categoria1,"NTVG");
 	var callejeros = new Banda(categoria2,"Callejeros");
 	var losAutentiosDecadentes = new Banda(categoria3,"Los Autenticos Decadentes");
 	var rollingStone = new Banda(categoria4,"Los Rolling Stone");
 	
 	var noche1 = new Noche(new Date(2013,7,20),20,1,List[Banda](losPiojos),todasLasButacas);
 	var noche2 = new Noche(new Date(2013,7,21),20,2,List[Banda](arbol),todasLasButacas);
 	var noche3 = new Noche(new Date(2013,7,22),19,3,List[Banda](laVelaPuerca,NTVG),todasLasButacas);
 	var noche4 = new Noche(new Date(2013,7,23),19,4,List[Banda](callejeros,rollingStone),todasLasButacas);
 	var noche5 = new Noche(new Date(2013,7,24),21,5,List[Banda](losAutentiosDecadentes),todasLasButacas);
 		
 	
 	var carlos = new Cliente_Mayor("Nombre = Carlos Fernandez|40 años|DNI = 17.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var jose = new Cliente_Jubilado("Nombre = Josa Gomez|60 años|DNI = 8.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var facundo = new Cliente_Menor("Nombre = Facundo Hernandez|15 años|DNI = 42.897.364|Nacionalidad = Argentino|Sexo = Masculino");
 	var pablo = new Cliente_Menor("Nombre = Pablo Gimenez|20 años|DNI = 37.897.364|Nacionalidad = Argentino|Sexo = Masculino");

  @Test
  def cantidadDeButacasLibresTodasLasNoches() {
    assertEquals(noche1.butacasLibres.size, 9);
    assertEquals(noche2.butacasLibres.size, 9);
    assertEquals(noche3.butacasLibres.size, 9);
    assertEquals(noche4.butacasLibres.size, 9);
    assertEquals(noche5.butacasLibres.size, 9);
  }

  @Test
  def cantidadDeBandasPorNoche() {
    assertEquals(noche1.bandas.size, 1);
    assertEquals(noche2.bandas.size, 1);
    assertEquals(noche3.bandas.size, 2);
    assertEquals(noche4.bandas.size, 2);
    assertEquals(noche5.bandas.size, 1);
  }

  @Test
  def maximasCategoriasPorNoche() {
    assertEquals(noche1.maxCategoria.nivel, 3);
    assertEquals(noche2.maxCategoria.nivel, 2);
    assertEquals(noche3.maxCategoria.nivel, 2);
    assertEquals(noche4.maxCategoria.nivel, 4);
    assertEquals(noche5.maxCategoria.nivel, 3);
  }

  @Test
  def valorExtraPorNoche() {
    assertEquals(100.0, noche1.maxCategoria.costoExtra, 0.0);
    assertEquals(50.0, noche2.maxCategoria.costoExtra, 0.0);
    assertEquals(50.0, noche3.maxCategoria.costoExtra, 0.0);
    assertEquals(200.0, noche4.maxCategoria.costoExtra, 0.0);
    assertEquals(100.0, noche5.maxCategoria.costoExtra, 0.0);
  }

  @Test
  def valorEntradaBase() {
    assertEquals(130.0, butaca1_1A.precioBase, 0.0);
    assertEquals(110.0, butaca4_1B.precioBase, 0.0);
    assertEquals(80.0, butaca8_2C.precioBase, 0.0);
    assertEquals(90.0, butaca6_3B.precioBase, 0.0);
    assertEquals(110.0, butaca3_3A.precioBase, 0.0);
    assertEquals(90.0, butaca7_1C.precioBase, 0.0);
  }

  @Test
  def compraDeEntradaClienteMayorNoche1Butaca1() {
    var entrada = SistemaVentas.crearEntrada(carlos, noche1, butaca1_1A);
    entrada.comprar();

    assertEquals(230.0, entrada.precioDeVenta, 0.0);
  }

  @Test
  def compraDeEntradaClienteJubiladoNoche2Butaca6() {
    var entrada = SistemaVentas.crearEntrada(jose, noche2, butaca6_3B);
    entrada.comprar();

    assertEquals(90.0 * 0.85 + 50.0, entrada.precioDeVenta, 0.0);
  }

  @Test
  def compraDeEntrada_Mayor100_ClienteMenor18Noche3Butaca4() {
    var entrada = SistemaVentas.crearEntrada(facundo, noche3, butaca4_1B);
    entrada.comprar();

    assertEquals(110.0 - 22.0 + 50.0, entrada.precioDeVenta, 0.0);
  }

  @Test
  def compraDeEntrada_Menor100_ClienteMenor18Noche4Butaca9() {
    var entrada = SistemaVentas.crearEntrada(pablo, noche4, butaca9_3C);
    entrada.comprar();

    assertEquals(70.0 - 10.0 + 200.0, entrada.precioDeVenta, 0.0);
  }

  //EN los siguientes Tests, hay problemas con las diferencias de fechas,
  //No lo pude arreglar. El segundo da VERDE, pero el primero no pasa

  @Test
  def compraDeEntradaAnticipada_ClienteMayorNoche5Butaca5() {
    var entrada = SistemaVentas.crearEntrada(carlos, noche5, butaca5_2B);
    entrada.comprar();

    assertEquals(100.0 - 10.0 + 100.0, entrada.precioDeVenta, 0.0);
  }

  @Test
  def comprarYDevolverEntrada() {
    var entrada = SistemaVentas.crearEntrada(carlos, noche1, butaca3_3A);
    entrada.comprar();
    assertEquals(210.0, entrada.precioDeVenta, 0.0);
    var precioDevuelto = entrada.devolver
    assertEquals(105.0, precioDevuelto, 0.0);

  }
	
	
}


