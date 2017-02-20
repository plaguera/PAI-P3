package fecha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFecha {
	
	private Fecha fecha1, fecha2, fecha3;
	
	@Before
	public void setUp() {
		fecha1 = new Fecha (28, 2, 2012);
		fecha2 = new Fecha (2, 1, 2012);
		fecha3 = new Fecha (29, 2, 2012);
	}
	
	@Test
	public void testFecha1() {
		assertEquals(fecha1.toString(), 				"Martes, 28 de Febrero de 2012");
		assertEquals(fecha1.siguienteDia().toString(), 	"Miércoles, 29 de Febrero de 2012");
		assertEquals(fecha1.siguienteDia().toString(), 	"Jueves, 1 de Marzo de 2012");
		assertEquals(fecha1.siguienteMes().toString(), 	"Domingo, 1 de Abril de 2012");
		assertEquals(fecha1.siguienteAnio().toString(), "Lunes, 1 de Abril de 2013");
	}
	
	@Test
	public void testFecha2() {
		assertEquals(fecha2.toString(), 				"Lunes, 2 de Enero de 2012");
		assertEquals(fecha2.anteriorDia().toString(), 	"Domingo, 1 de Enero de 2012");
		assertEquals(fecha2.anteriorDia().toString(), 	"Sábado, 31 de Diciembre de 2011");
		assertEquals(fecha2.anteriorMes().toString(), 	"Miércoles, 30 de Noviembre de 2011");
		assertEquals(fecha2.anteriorAnio().toString(),	"Martes, 30 de Noviembre de 2010");
		
	}
	
	@Test
	public void testFecha3() {
		assertEquals(fecha3.anteriorAnio().toString(),	"Lunes, 28 de Febrero de 2011");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecha4() {
		Fecha fecha4 = new Fecha(31, 11, 2099);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecha5() {
		Fecha fecha5 = new Fecha(29, 2, 2011);
	}
	
	@Test
	public void testBisiesto() {
		assertTrue(Fecha.esBisiesto(2000));
		assertFalse(Fecha.esBisiesto(1945));
		assertTrue(Fecha.esBisiesto(1600));
		assertFalse(Fecha.esBisiesto(2));
	}
	
	@Test
	public void testFechaValida() {
		assertTrue(fecha1.esFechaValida(29, 2, 2000));
		assertFalse(fecha1.esFechaValida(29, 2, 2001));
		assertTrue(fecha1.esFechaValida(31, 12, 1945));
		assertFalse(fecha1.esFechaValida(31, 11, 1812));
	}
	
	@Test
	public void testDiaSemana() {
		assertEquals(fecha1.getDiaSemana(), 2);
		assertEquals(fecha2.getDiaSemana(), 1);
		assertEquals(fecha3.getDiaSemana(), 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetFecha() {
		fecha1.setFecha(29, 12, 2018);
		assertEquals(fecha1.toString(), "Sábado, 29 de Diciembre de 2018");
		
		fecha1.setFecha(1, 7, 3092);
		assertEquals(fecha1.toString(), "Viernes, 1 de Julio de 3092");
		
		fecha1.setFecha(29, 2, 1978);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetDia() {
		fecha2.setDia(29);
		//System.out.println(fecha2);
		assertEquals(fecha2.toString(), "Domingo, 29 de Enero de 2012");
		
		fecha2.setDia(13);
		assertEquals(fecha2.toString(), "Viernes, 13 de Enero de 2012");
		
		fecha2.setDia(32);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMes() {
		fecha3.setMes(12);
		assertEquals(fecha3.toString(), "Sábado, 29 de Diciembre de 2012");
		
		fecha3.setMes(2);
		assertEquals(fecha3.toString(), "Miércoles, 29 de Febrero de 2012");
		
		fecha3.setMes(13);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetAnio() {
		fecha3.setAnio(2000);
		assertEquals(fecha3.toString(), "Martes, 29 de Febrero de 2000");
		
		fecha3.setAnio(1600);
		assertEquals(fecha3.toString(), "Martes, 29 de Febrero de 1600");
		
		fecha3.setAnio(2001);
	}

}
