package math;

//import org.junit.Test;

public class Tests{

    //Speicherüberlauf
    //@Test(expected=java.lang.ArithmeticException.class) // FÜR CROSSPRODUCT, DOTPRODUCT, LENGTH, DETERMINANTE
    public void testSpeicherueberlauf(){

    	Vektor2D v0 = new Vektor2D(0.0, 0.0);
        Vektor2D v1 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D v2 = new Vektor2D(1.0, 1.0);
        Vektor3D v3 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor3D v4 = new Vektor3D(1.0, 1.0, 1.0);
        Vektor2D v5 = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
        Vektor2D v6 = new Vektor2D(-1.0, -1.0);
        Vektor3D v7 = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        Vektor3D v8 = new Vektor3D(-1.0, -1.0, -1.0);
        
        Vektor3D v9 = new Vektor3D(Double.MAX_VALUE, 0.0, 0.0);
        Vektor3D v10 = new Vektor3D(0.0, Double.MAX_VALUE, Double.MAX_VALUE);
        
        Vektor2D v11 = new Vektor2D(Double.MAX_VALUE, 0.0);
        Vektor2D v12 = new Vektor2D(0.0, Double.MAX_VALUE);
        
        double s1 = 2.0;
        double s2 = 0.5;
        double s3 = Double.MIN_VALUE;
        double s4 = Double.MIN_VALUE;
        double s5 = Double.MAX_VALUE;
        double s6 = 0.0;

        //Addition: -> assertNull Success, if Double Overflow
        	//Überlauf
        		//LineareAlgebra.show(LineareAlgebra.add(v7, v8));
        		//assertNull(LineareAlgebra.add(v1, v2)); // okay: Max Value + 1.0
        		//assertNull(LineareAlgebra.add(v2, v1)); // okay: 1.0 + Max Value
        		//assertNull(LineareAlgebra.add(v3, v4)); // okay: Max Value + 1.0
				//assertNull(LineareAlgebra.add(v4, v3)); // okay 1.0 + Max Value

        	//Unterlauf
        		//assertNull(LineareAlgebra.add(v5, v6)); // okay: Min Value + (-1.0)
        		//assertNull(LineareAlgebra.add(v6, v5)); // -> JUnit failed -> bei (-1.0) + Min Value
        		//assertNull(LineareAlgebra.add(v7, v8)); // okay: Min Value + (-1.0)
        		//assertNull(LineareAlgebra.add(v8, v7)); // -> JUnit failed -> bei (-1.0) + Min Value
		
        //Subtraktion:
        	//Überlauf
        		//assertNull(LineareAlgebra.sub(v1, v6)); // okay: Max Value - (-1.0)
        		//assertNull(LineareAlgebra.sub(v3, v8)); // okay: Max Value - (-1.0)
        		//assertNull(LineareAlgebra.sub(v2, v5)); // okay: 1.0 - Min Value
        		//assertNull(LineareAlgebra.sub(v4, v8)); // okay: 1.0 - Min Value
        		
        	//Unterlauf
        		//assertNull(LineareAlgebra.sub(v5, v2)); // -> JUnit failed -> bei Min Value - (+1.0) 
        		//assertNull(LineareAlgebra.sub(v7, v4)); // -> JUnit failed -> bei Min Value - (+1.0) 
        		//assertNull(LineareAlgebra.sub(v6, v1)); // -> JUnit failed -> bei (-1.0) - (Max Value)
        		//assertNull(LineareAlgebra.sub(v8, v3)); // -> JUnit failed -> bei (-1.0) - (Max Value)
        
        //Multiplikation
        	//Überlauf
        		//assertNull(LineareAlgebra.mult(v1, s1)); // okay: Max Value * 2.0
        		//assertNull(LineareAlgebra.mult(v3, s1)); // okay: Max Value * 2.0
        	//Unterlauf
        		//assertNull(LineareAlgebra.mult(v5, s1)); // -> JUnit failed -> bei Min Value * 2.0
        		//assertNull(LineareAlgebra.mult(v7, s1)); // -> JUnit failed -> bei Min Value * 2.0
        
        //Division
        	//Überlauf
        		//assertNull(LineareAlgebra.div(v1, 0.1)); // okay: Max Value / 0.1
        		//assertNull(LineareAlgebra.div(v3, 0.1)); // okay: Max Value / 0.1
        		//assertNull(LineareAlgebra.div(v5, -0.1)); // -> JUnit failed -> bei Min Value / -0.1
				//assertNull(LineareAlgebra.div(v7, -0.1)); // -> JUnit failed -> Bei Min Value / -0.1
        	//Unterlauf
        		//assertNull(LineareAlgebra.div(v5, 0.1)); // -> JUnit failed -> bei Min Value / 0.1
        		//assertNull(LineareAlgebra.div(v7, 0.1)); // -> JUnit failed -> bei Min Value / 0.1
        		//assertNull(LineareAlgebra.div(v1, -0.1)); // okay: Max Value / -1.0
        		//assertNull(LineareAlgebra.div(v3, -0.1)); // okay: Max Value / -1.0
        		
        
        //Crossproduct
        //LineareAlgebra.crossProduct(v9, v10); // okay: für Overflow
        
        //Dotproduct
        //LineareAlgebra.dotProduct(v1, v1); // okay: für Overflow
        //LineareAlgebra.dotProduct(v3, v3); // okay: für Overflow

        //length
        //LineareAlgebra.length(v1); // okay
        //LineareAlgebra.length(v3); // okay

        //Determinante
        //LineareAlgebra.determinante(v1, v1); // für NaN
        //LineareAlgebra.determinante(v11, v12); // für Overflow
        //LineareAlgebra.determinante(v3, v7, v10); // für Overflow
        //LineareAlgebra.determinante(v3, v3, v3); // für Nan
        
        //eukl. Distance
        //LineareAlgebra.euklDistance(v12, v2); // okay: für Overflow
        //LineareAlgebra.euklDistance(v3, v4); // okay: für Overflow
        
        //Manhattan Distance
        //System.out.println(LineareAlgebra.manhattanDistance(v12, v2)); // okay: für Overflow
        //System.out.println(LineareAlgebra.manhattanDistance(v4, v10)); // okay: für Overflow
        
        //radToDegree
        //LineareAlgebra.radToDegree(Double.MAX_VALUE);
    
        //degreeToRad
        //double erg = (2*Math.PI)/360*Double.MAX_VALUE;
        //System.out.println(erg);
        //assertEquals(erg, LineareAlgebra.degreeToRad(Double.MAX_VALUE), 0);
        
        //double erg = (2*Math.PI)/360*Double.MIN_VALUE;
        //System.out.println(erg);
        //assertEquals(erg, LineareAlgebra.degreeToRad(Double.MIN_VALUE), 0);

        // -> Success
		
    }
    /*
    
    //Division durch 0
    @Test
    public void testaufNull(){
    	Vektor2D v0 = new Vektor2D(0.0, 0.0);
        Vektor2D v1 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D v2 = new Vektor2D(1.0, 1.0);
        Vektor3D v3 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vektor2D v5 = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
        Vektor3D v7 = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        
        //LineareAlgebra.show(LineareAlgebra.div(v2, 0.0));
        //assertNull(LineareAlgebra.div(v2, 0.0)); // okay: Max Value / 0.0
        //assertNull(LineareAlgebra.div(v3, 0.0)); // okay: Max Value / 0.0
		//assertNull(LineareAlgebra.div(v5, 0.0)); // okay: Min Value / 0.0
		//assertNull(LineareAlgebra.div(v7, 0.0)); // okay: Min Value / 0.0
		//assertNull(LineareAlgebra.div(v2, 0.0)); // okay: 1.0 / 0.0
        //assertNull(LineareAlgebra.div(v0, 0.0)); // okay: 0.0 / 0.0
    }
    
    
    //auf Gleichheit Ã¼berprÃ¼fen
    @Test
    public void testisEqual(){
        Vektor3D v1 = new Vektor3D(20,3,5);
        Vektor3D v2 = new Vektor3D(20,3,5);

        //assertTrue(LineareAlgebra.isEqual(v1, v2));
        //-> okay

        Vektor3D v3 = new Vektor3D(20,3,5);
        Vektor3D v4 = new Vektor3D(20,3,6);

        assertFalse(LineareAlgebra.isEqual(v3, v4));
        //-> okay

    }

	*/

}
