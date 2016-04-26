
import static java.lang.Math.*;

public class LineareAlgebra {

    private LineareAlgebra() {}

    public static void add(double[] a, double[] b) {
        double[] erg = new double[3];

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] + b[i];
        }
        else if (a.length > b.length) {
                 for (int i = 0; i < b.length; i++)
                     erg[i] = a[i] + b[i];
                 for (int i=b.length; i< a.length; i++){
                	 erg[i]= a[i];
                 }
             }
        else if (a.length < b.length) {
                 for (int i = 0; i < a.length; i++)
                     erg[i] = a[i] + b[i];
                 for (int i=a.length; i< b.length; i++){
                	 erg[i]= b[i];
                 }
             }
        show(erg);
    }

    public static void sub(double[] a, double[] b) {
    	double[] erg = new double[3];

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] - b[i];
        }
        else if (a.length > b.length) {
            for (int i = 0; i < b.length; i++)
                erg[i] = a[i] - b[i];
            for (int i=b.length; i< a.length; i++){
           	 	erg[i]= a[i] - 0;
            }
        }
        else if (a.length < b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] - b[i];
            for (int i=a.length; i< b.length; i++){
           	 	erg[i]= 0 -b[i];
            }
        }
        show(erg);
    }

    public static void mult(double[] a, double[] b) {
    	double[] erg = new double[3];
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] * b[i];
        }
        else
            System.out.println("Fehler mult() !");
    }

    public static void div(double[] a, double[] b) {
    	double[] erg = new double[3];

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                if (a[i] == 0 || b[i] == 0)
            	erg[i] = a[i] / b[i];
        }
        else
            System.out.println("Fehler div() !");
    }

    public static void isEqual(double[] a, double[] b) {
    	int c = 0;
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                if (a[i] == b[i])
                	c++;                	
        }
        if (c == 3)
        	System.out.println("Vektoren sind gleich!");
        else
        	System.out.println("Vektoren sind nicht gleich!");        
    }

    public static void isNotEqual(double[] a, double[] b) {

    }

    public static double length(double[] a) {
        double len = sqrt(pow(a[0], 2) + pow(a[1], 2) + pow(a[2], 2));
        return len;
    }

    public static double[] normalize(double[] a) {
        double l = length(a);
        double[] norm = new double[3];
        for (int i = 0; i < a.length; i++) {
            norm[i] = (1 / l) * a[i];
        }
        return norm;
    }

    public static double euklDistance(double x1, double x2, double y1, double y2) {
        /* euklDistance 2D pow = Potenzieren*/
        double eukl   = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
        return eukl;
    }

    public static double manhattanDistance(double x0, double x1, double y0, double y1) {
        double dist = Math.abs(x1 - x0) + Math.abs(y1 - y0);
        return dist;
    }

    public static double[] crossProduct(double[] a, double[] b) {
        double[] cross = null;
        cross[0] = a[1] * b[2] - a[2] * b[1];
        cross[1] = a[2] * b[0] - a[0] * b[2];
        cross[2] = a[0] * b[2] - a[1] * b[0];
        return cross;
    }
    public static double dotProduct(double[] a, double[] b) { //Skalarprodukt
        double dot = 0.0;
        for (int i = 0; i < a.length; i++)
            dot += a[i] * b[i];
        return dot;
    }

    public static void cosEquation(double[] a, double[] b) {

    }

    public static void sinEquation(double[] a, double[] b) {

    }

    public static double angleRad(double[] a, double[] b) {
    	double result= (dotProduct(a, b)/ (length (a)* length(b)));
    	return toRadians(acos(result));
    }

    public static double angleDegree(double[] a, double[] b) {
    	double result= (dotProduct(a, b)/ (length (a)* length(b)));
    	return acos(result);
    }

    public static double radToDegree(double a) { //Bogenmaß in Winkelgrad
       
        return toDegrees(a);
    }

    public static double degreeToRad(double a) { // Winkelgrad in Bogenmaß
        return toRadians(a);
    }

    public static double determinante(double[][] matrix, int n) {
    	double det = 0;
        double ergAdd = 0;
        double ergSub = 0;
        double matElem = 1;
        double matElem2 = -1;
        int j = 2;
        int k = 0;
        for (int p = 0; p < n; p++) {
            matElem = 1;
            matElem = -1;
            for (int i = 0; i < n; i++) {
                matElem = matrix[k][i] * matElem; 
                matElem2 = matrix[k][j] * matElem2;
                j--;
                if (j == -1)
                {
                    j = n-1;
                }
                k = (k + 1)%n;
            }
            ergAdd += matElem;
            ergSub -= matElem2;
            det = ergAdd + ergSub;
            k++;
            System.out.println(det);
        }   
        return det;
    }

    public static double abs(double[] a) {
        double ab = length(a);
    	return ab;
    }

    public static void show(double[] a) {
        	System.out.println(a.length);
    	switch (a.length-1){
        case 1:
        	System.out.println("[" + a[0] + "]"); break;
        case 2: 
        	System.out.println("[" + a[0] + "]");
        	System.out.println("[" + a[1] + "]"); break;
        case 3:
        	System.out.println("[" + a[0] + "]");
        	System.out.println("[" + a[1] + "]");
        	System.out.println("[" + a[2] + "]"); break;
        }
    }
    
    public static void main(String args[]){
       
       double vek[]={3,4,9};
       double vek2[]={2,12,50};
       System.out.println(radToDegree(4.1));
       System.out.println(angleDegree(vek,vek2));
       System.out.println(angleRad(vek,vek2));
       
    
    }
    
}
