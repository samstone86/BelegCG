package math;

import java.util.Random;
import static java.lang.Math.*;

public class LineareAlgebra {

    private LineareAlgebra() {}

    public static Vektor2D add(final Vektor2D v1, final Vektor2D v2) {
        Vektor2D result = v1;
        result.add(v2);
        return result;
    }

    public static Vektor3D add(final Vektor3D v1, final Vektor3D v2) {
        Vektor3D result = v1;
        result.add(v2);
        return result;
    }

    public static Vektor2D sub(final Vektor2D v1, final Vektor2D v2) {
        Vektor2D result = v1;
        result.sub(v2);
        return result;
    }

    public static Vektor3D sub(final Vektor3D v1, final Vektor3D v2) {
        Vektor3D result = v1;
        result.sub(v2);
        return result;
    }

    public static Vektor2D mult(Vektor2D v1, double s) {
    	Vektor2D result = v1;
        result.mult(s);
        return result;
    }

    public static Vektor3D mult(final Vektor3D v1, double s) {
    	Vektor3D result = v1;
        result.mult(s);
        return result;
    }

    public static Vektor2D div(final Vektor2D v1, double s) {
    	Vektor2D result = v1;
        result.div(s);
        return result;
    }

    public static Vektor3D div(final Vektor3D v1, double s) {
    	Vektor3D result = v1;
        result.div(s);
        return result;
    }

    public static boolean isEqual(final Vektor2D v1, final Vektor2D v2) {
    	Vektor2D result = v1;
        return result.isEqual(v2);
    }

    public static boolean isEqual(final Vektor3D v1, final Vektor3D v2) {
    	Vektor3D result = v1;
        return result.isEqual(v2);
    }

    public static boolean isNotEqual(final Vektor2D v1, final Vektor2D v2) {
         return !isEqual(v1,v2);
    }

    public static boolean isNotEqual(final Vektor3D v1, final Vektor3D v2) {
        return !isEqual(v1,v2);
    }

    public static double length(final Vektor2D v1) {
    	return v1.length();
    }

    public static double length(final Vektor3D v1) {
    	return v1.length();
    }

    public static Vektor2D normalize(final Vektor2D v1) {
        if (v1.isNullVector()) {
            Random rdm= new Random();
            v1.x = rdm.nextDouble() * 2 -1;         // random Werte zwischen [-1, 1]
            v1.y = rdm.nextDouble() * 2 -1;
            return new Vektor2D(v1.x, v1.y);
        } else {
            double l = length(v1);
            return new Vektor2D(((1 / l) * v1.x), ((1 / l) * v1.y));
        }
    }

    public static Vektor3D normalize(final Vektor3D v1) {
        if (v1.isNullVector()) {
            Random rdm= new Random();
            v1.x = rdm.nextDouble() * 2 -1;         // random Werte zwischen [-1, 1]
            v1.y = rdm.nextDouble() * 2 -1;
            v1.z = rdm.nextDouble() * 2 -1;
            return new Vektor3D(v1.x, v1.y, v1.z);
        } else {
            double l = length(v1);
            return new Vektor3D(((1 / l)* v1.x), ((1 / l)* v1.y),((1 / l)* v1.z));
        }
    }

    public static double euklDistance(final Vektor2D v1, final Vektor2D v2) {
        /* euklDistance 2D pow = Potenzieren*/
        double euklDist = sqrt(pow((v1.x - v2.x), 2) + pow((v1.y - v2.y), 2));
        if ((euklDist == Double.MAX_VALUE) || (euklDist == Double.NEGATIVE_INFINITY) || (euklDist == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + euklDist);
        return euklDist;
    }

    public static double euklDistance(final Vektor3D v1, final Vektor3D v2) {
        /* euklDistance 2D pow = Potenzieren*/
        double euklDist = sqrt(pow((v1.x - v2.x), 2) + pow((v1.y - v2.y), 2) + pow((v1.z - v2.z), 2));
        if ((euklDist == Double.MAX_VALUE) || (euklDist == Double.NEGATIVE_INFINITY) || (euklDist == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + euklDist);
        return euklDist;
    }
    public static double manhattanDistance(final Vektor2D v1, final Vektor2D v2) {
        double manhDist = Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
        if ((manhDist == Double.MAX_VALUE) || (manhDist == Double.NEGATIVE_INFINITY) || (manhDist == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + manhDist);
        return manhDist;
    }

    public static double manhattanDistance(final Vektor3D v1, final Vektor3D v2) {
        double manhDist = Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y) + Math.abs(v1.z - v2.z);
        if ((manhDist == Double.MAX_VALUE) || (manhDist == Double.NEGATIVE_INFINITY) || (manhDist == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + manhDist);
        return manhDist;
    }

    public static Vektor3D crossProduct(final Vektor3D v1, final Vektor3D v2) {  
    	Vektor3D erg = new Vektor3D(0,0,0);
    	erg.x = v1.y*v2.z - v1.z*v2.y;
    	erg.y = v1.z*v2.x - v1.x*v2.z; 
    	erg.z = v1.x*v2.y - v1.y*v2.x;
        if ((erg.x == Double.MAX_VALUE) || (erg.x == Double.NEGATIVE_INFINITY) || (erg.x == Double.POSITIVE_INFINITY) ||
            (erg.y == Double.MAX_VALUE) || (erg.y == Double.NEGATIVE_INFINITY) || (erg.y == Double.POSITIVE_INFINITY) ||
            (erg.z == Double.MAX_VALUE) || (erg.z == Double.NEGATIVE_INFINITY) || (erg.z == Double.POSITIVE_INFINITY)) {
            throw new ArithmeticException("Double overflow");
        }
        return erg;
    }
    
    public static double dotProduct(final Vektor2D v1, final Vektor2D v2) { //Skalarprodukt
        double dotP = v1.x*v2.x + v1.y*v2.y;
        if ((dotP == Double.MAX_VALUE) || (dotP == Double.NEGATIVE_INFINITY) || (dotP == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + dotP);
        return dotP;
    }

    public static double dotProduct(final Vektor3D v1, final Vektor3D v2) { //Skalarprodukt
        double dotP = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
        if ((dotP == Double.MAX_VALUE) || (dotP == Double.NEGATIVE_INFINITY) || (dotP == Double.POSITIVE_INFINITY))
            throw new ArithmeticException("Double overflow" + dotP);
        return dotP;
    }

    public static double cosEquation(final Vektor2D v1, final Vektor2D v2) {
        return (dotProduct(v1, v2) /(length(v1)*length(v2)));
    }

    public static double cosEquation(final Vektor3D v1, final Vektor3D v2) {
        return (dotProduct(v1, v2) /(length(v1)*length(v2)));
    }

    public static double sinEquation(final Vektor2D v1, final Vektor2D v2) {  
        return (determinante(v1, v2)/(length(v1)*length(v2)));
    } 
    
    public static double angleRad(final Vektor2D v1, final Vektor2D v2) {
        return degreeToRad(acos(cosEquation(v1, v2)));
    }

    public static double angleRad(final Vektor3D v1, final Vektor3D v2) {
        return degreeToRad(acos(cosEquation(v1, v2)));
    }

    public static double angleDegree(final Vektor2D v1, final Vektor2D v2) {
        return acos(cosEquation(v1, v2));
    }

    public static double angleDegree(final Vektor3D v1, final Vektor3D v2) {
        return acos(cosEquation(v1, v2));
    }

    public static double radToDegree(double rad) { //Bogenmass in Winkelgrad
        if (rad == Double.MAX_VALUE)
            throw new ArithmeticException("Double overflow" + rad);
        return  ((360) / (2 * Math.PI) * rad);
    }

    public static double degreeToRad(double deg) { // Winkelgrad in Bogenmass
        if (deg % 360 == 0) 
        	return  ((2 * Math.PI)); 
        return  ((2 * Math.PI) / 360 * deg);
    }

    public static double determinante(final Vektor2D v1, final Vektor2D v2) {
        double det = (v1.x*v2.y - v2.x*v1.y);
        if ((det == Double.MAX_VALUE) || (det == Double.NEGATIVE_INFINITY) || (det == Double.POSITIVE_INFINITY) || ((Double)det).isNaN())
            throw new ArithmeticException("Double overflow" + det);
    	return det;
    }

    public static double determinante(final Vektor3D v1, final Vektor3D v2, final Vektor3D v3) {   //ist wohl eigentlich unnÃƒÆ’Ã‚Â¶tig
        double det = (v1.x*v2.y*v3.z + v2.x*v3.y*v1.z + v3.x*v1.y*v2.z-
        		      v1.z*v2.y*v3.x - v2.z*v3.y*v1.x - v3.z*v1.y*v2.x);
        if ((det == Double.MAX_VALUE) || (det == Double.NEGATIVE_INFINITY) || (det == Double.POSITIVE_INFINITY) || ((Double)det).isNaN())
            throw new ArithmeticException("Double overflow" + det);
        return det;
    }

    public static double abs(final Vektor2D v1) {
    	return length(v1);
    }

    public static double abs(final Vektor3D v1) {
        return length(v1);
    }
    
    public static double Round(double temp) {

		temp = temp * 1000;
		temp = Math.round(temp);
		temp = temp / 1000.0;
		return temp;
	}
    
    public static void show(final Vektor2D v1) {
       	System.out.println("[" + v1.x + "]");
       	System.out.println("[" + v1.y + "]");
    }

    public static void show(final Vektor3D v1) {
        System.out.println("[" + v1.x + "]");
        System.out.println("[" + v1.y + "]");
        System.out.println("[" + v1.z + "]");
    }
}