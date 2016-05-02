package Belegaufgabe;


import org.junit.Test;
import static org.junit.Assert.*;
import Belegaufgabe.*;



public class Tests{
    @Test//(expected=java.lang.ArithmeticException.class)
//	public void testaufNull(){
//	Vektor2D v1= new Vektor2D(23,69);
//	v1.div(0);
//	}

    public void testisEqualV1(){
        Vektor3D v1= new Vektor3D(20,3,5);
        Vektor3D v2= new Vektor3D(20,3,5);
        assertTrue(LineareAlgebra.isEqual(v1, v2));


        Vektor3D v3= new Vektor3D(20,3,5);
        Vektor3D v4= new Vektor3D(20,3,6);
        assertTrue(LineareAlgebra.isEqual(v3, v4));

    }

    //@Test //(expected=java.lang.AssertionError.class) //(expected=java.lang.ArithmeticException.class)



    //Speicherüberlauf
    @Test
    public void testSpeicherüberlauf() {



        Vektor2D v1 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);

        Vektor2D v2 = new Vektor2D(1.0, 1.0);

        Vektor3D v3 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

        Vektor3D v4 = new Vektor3D(1.0, 1.0, 1.0);

        Vektor3D v5 = new Vektor3D(2.0, 2.0, 2.0);

        double s1 = Double.MAX_VALUE;

        double s2 = Double.MAX_VALUE;



        //Addition

        assertNull(LineareAlgebra.add(v1, v2));

        assertNull(LineareAlgebra.add(v2, v1));

        assertNull(LineareAlgebra.add(v3, v4));

        assertNull(LineareAlgebra.add(v4, v3));

        // -> Error



        //Multiplikation

        assertNull(LineareAlgebra.mult(v1, s1));

        assertNull(LineareAlgebra.mult(v3, s2));

        // -> Error



        //Crossproduct

        assertNull(LineareAlgebra.crossProduct(v3, v3));

        // -> Error



        //Dotproduct

        assertNull(LineareAlgebra.dotProduct(v1, v1));

        assertNull(LineareAlgebra.dotProduct(v3, v3));

        // -> Error



        //length

        assertNull(LineareAlgebra.length(v1));

        assertNull(LineareAlgebra.length(v3));

        // -> Error



        //euklDistance

        assertNull(LineareAlgebra.euklDistance(v1, v2));

        assertNull(LineareAlgebra.euklDistance(v3, v4));

        // -> Error



        //Determinante

        assertNull(LineareAlgebra.determinante(v1, v2));

        assertNull(LineareAlgebra.determinante(v3, v4, v5));

        // -> Error



        //radToDegree

        assertNull(LineareAlgebra.radToDegree(Double.MAX_VALUE));

        // -> Error



        //degreeToRad

        double erg = (2*Math.PI)/360*Double.MAX_VALUE;

        assertEquals(erg, LineareAlgebra.degreeToRad(Double.MAX_VALUE), 0);

        // -> Success

    }



    //Speicherunterlauf
    @Test
    public void testSpeicherunterlauf() {



        Vektor2D v1 = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);

        Vektor2D v2 = new Vektor2D(-1.0, -1.0);

        Vektor3D v3 = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);

        Vektor3D v4 = new Vektor3D(-1.0, -1.0, -1.0);

        Vektor2D v5 = new Vektor2D(1.0, 1.0);

        Vektor3D v6 = new Vektor3D(1.0, 1.0, 1.0);
        //Addition

        assertNull(LineareAlgebra.add(v1, v2));

        assertNull(LineareAlgebra.add(v3, v4));



        //Subtraktion

        assertNull(LineareAlgebra.sub(v1, v5));

        assertNull(LineareAlgebra.sub(v3, v6));



        //-> führt zu Error -> Code anpassen



    }



    //auf Division durch Null überprüfen
    @Test
    public void testaufNull(){



        Vektor2D v1 = new Vektor2D(23,69);

        Vektor3D v2= new Vektor3D(23,69,80);

        assertNull(LineareAlgebra.div(v1, 0.0));

        assertNull(LineareAlgebra.div(v2,0.0));

        //-> Success nur mit (expected=java.lang.AssertionError.class)

    }



    //auf Gleichheit überprüfen
    @Test
    public void testisEqual(){



        Vektor3D v1 = new Vektor3D(20,3,5);

        Vektor3D v2 = new Vektor3D(20,3,5);

        assertTrue(LineareAlgebra.isEqual(v1, v2));

        //-> Success



        Vektor3D v3 = new Vektor3D(20,3,5);

        Vektor3D v4 = new Vektor3D(20,3,6);

        assertTrue(LineareAlgebra.isEqual(v3, v4));

        //-> Success

    }



    //auf Ungleichheit überprüfen
    @Test
    public void testisNotEqual() {



        Vektor3D v1 = new Vektor3D(20,3,5);

        Vektor3D v2 = new Vektor3D(20,3,6);

        assertTrue(LineareAlgebra.isNotEqual(v1, v2));

        //-> Success



        Vektor3D v3 = new Vektor3D(20,3,5);

        Vektor3D v4 = new Vektor3D(20,3,5);

        assertTrue(LineareAlgebra.isNotEqual(v3, v4));

        //-> Success

    }






    @Test
    public void arrayEqualTest() {
        Vektor3D v1 = new Vektor3D(20,3,5);

        Vektor3D v2 = new Vektor3D(20,3,6);

        int[] v1Array = {(int) v1.x, (int) v1.y};

        int[] expectedErg_v1Array = {20, 69};

        assertArrayEquals(v1Array, expectedErg_v1Array);

    }



//Speicherüberlauf addieren
// division durch 0
// testen gegen max / min value
//	winkelumrechnungen über 360 grad
//	und umgekehrt bei rad
//	gleiche Länge von Vektoren
//	sehr kleiner wert 1 subtrahieren

}
