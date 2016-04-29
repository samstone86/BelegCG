package Belegaufgabe;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Tests{
	@Test
	public void testaufNull(){
	Vektor2D v1= new Vektor2D(23,69);
	assertNull(v1.div(0));
	}
}
