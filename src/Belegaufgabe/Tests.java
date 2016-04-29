package Belegaufgabe;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests{
	@Test//(expected=java.lang.ArithmeticException.class)
//	public void testaufNull(){
//	Vektor2D v1= new Vektor2D(23,69);
//	v1.div(0);
//	}
	
	public void testisEqual(){
		Vektor3D v1= new Vektor3D(20,3,5);
		Vektor3D v2= new Vektor3D(20,3,5);
		assertTrue(LineareAlgebra.isEqual(v1, v2));
		
		
		Vektor3D v3= new Vektor3D(20,3,5);
		Vektor3D v4= new Vektor3D(20,3,6);
		assertTrue(LineareAlgebra.isEqual(v3, v4));
	
	}
	
//Speicherüberlauf addieren
// division durch 0
// testen gegen max / min value
//	winkelumrechnungen über 360 grad
//	und umgekehrt bei rad
//	gleiche Länge von Vektoren
//	sehr kleiner wert 1 subtrahieren
	
}
