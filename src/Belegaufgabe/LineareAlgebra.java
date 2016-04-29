package Belegaufgabe;

import static java.lang.Math.*;

public class LineareAlgebra {

    private LineareAlgebra() {}

    public static Vektor2D add(Vektor2D v1, Vektor2D v2) {
        return new Vektor2D(v1.x+v2.x, v1.y+v2.y);
    }

    public static Vektor3D add(Vektor3D v1, Vektor3D v2) {
        return new Vektor3D(v1.x+v2.x, v1.y+v2.y, v1.z+v2.z);
    }

    public static Vektor2D sub(Vektor2D v1, Vektor2D v2) {
        return new Vektor2D(v1.x-v2.x, v1.y-v2.y);
    }

    public static Vektor3D sub(Vektor3D v1, Vektor3D v2) {
        return new Vektor3D(v1.x-v2.x, v1.y-v2.y, v1.z-v2.z);
    }

    public static Vektor2D mult(Vektor2D v1, double s) {
    	return new Vektor2D(v1.x*s, v1.y*s);
    }

    public static Vektor3D mult(Vektor3D v1, double s) {
        return new Vektor3D(v1.x*s, v1.y*s, v1.z*s);
    }

    public static Vektor2D div(Vektor2D v1, double s) {
        return new Vektor2D(v1.x/s, v1.y/s);
    }

    public static Vektor3D div(Vektor3D v1, double s) {
        return new Vektor3D(v1.x/s, v1.y/s, v1.z/s);
    }

    public static boolean isEqual(Vektor2D v1, Vektor2D v2) {
        return (v1.x==v2.x && v1.y==v2.y);
    }

    public static boolean isEqual(Vektor3D v1, Vektor3D v2) {
        return (v1.x==v2.x && v1.y==v2.y && v1.z== v2.z);
    }

    public static boolean isNotEqual(Vektor2D v1, Vektor2D v2) {
         return !isEqual(v1,v2);
    }

    public static boolean isNotEqual(Vektor3D v1, Vektor3D v2) {
        return !isEqual(v1,v2);
    }

    public static double length(Vektor2D v1) {
        return (sqrt(pow(v1.x, 2) + pow(v1.y, 2)));
    }

    public static double length(Vektor3D v1) {
        return (sqrt(pow(v1.x, 2) + pow(v1.y, 2)+ pow(v1.z,2)));
    }

    public static Vektor2D normalize(Vektor2D v1) {
        double l = length(v1);
        return new Vektor2D(((1 / l)* v1.x), ((1 / l)* v1.y));
    }

    public static Vektor3D normalize(Vektor3D v1) {
        double l = length(v1);
        return new Vektor3D(((1 / l)* v1.x), ((1 / l)* v1.y),((1 / l)* v1.z));
    }

    public static double euklDistance(Vektor2D v1, Vektor2D v2) {
        /* euklDistance 2D pow = Potenzieren*/
        return sqrt(pow((v1.x - v2.x), 2) + pow((v1.y - v2.y), 2));
    }

    public static double euklDistance(Vektor3D v1, Vektor3D v2) {
        /* euklDistance 2D pow = Potenzieren*/
        return sqrt(pow((v1.x - v2.x), 2) + pow((v1.y - v2.y),2 )+pow((v1.z - v2.z), 2));
    }
    public static double manhattanDistance(Vektor2D v1, Vektor2D v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    public static double manhattanDistance(Vektor3D v1, Vektor3D v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y)+ Math.abs(v1.z - v2.z);
    }

    public static double[] crossProduct(double[] a, double[] b) {   //neumachen
        double[] cross = new double[3];
        cross[0] = a[1] * b[2] - a[2] * b[1];
        cross[1] = a[2] * b[0] - a[0] * b[2];
        cross[2] = a[0] * b[2] - a[1] * b[0];
        return cross;
    }
    public static double dotProduct(Vektor2D v1, Vektor2D v2) { //Skalarprodukt
        return v1.x*v2.x+v1.y*v2.y;
    }

    public static double dotProduct(Vektor3D v1, Vektor3D v2) { //Skalarprodukt
        return v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
    }

    public static double cosEquation(Vektor2D v1, Vektor2D v2) {
       return (dotProduct(v1,v2) /(length(v1)*length(v2)));
    }

    public static double cosEquation(Vektor3D v1, Vektor3D v2) {
        return (dotProduct(v1,v2) /(length(v1)*length(v2)));
    }

    /*public static double sinEquation(Vektor2D v1, Vektor2D v2) {  //Determinate?
            return (determinante()/(length(v1)*length(v2)));
    } */

    public static double angleRad(Vektor2D v1, Vektor2D v2) {
        return degreeToRad(acos(cosEquation(v1,v2)));
    }

    public static double angleRad(Vektor3D v1, Vektor3D v2) {
        return degreeToRad(acos(cosEquation(v1,v2)));
    }

    public static double angleDegree(Vektor2D v1, Vektor2D v2) {
        return acos(cosEquation(v1,v2));
    }

    public static double angleDegree(Vektor3D v1, Vektor3D v2) {
        return acos(cosEquation(v1,v2));
    }

    public static double radToDegree(double rad) { //Bogenmaß in Winkelgrad
        return  ((360)/(2*Math.PI)*rad);
    }

    public static double degreeToRad(double deg) { // Winkelgrad in Bogenmaß
        return  ((2*Math.PI)/360*deg);
    }

    public static double determinante(double[][] matrix, int n) {   //neu!
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

    public static double abs(Vektor2D v1) {
    	return length(v1);
    }

    public static double abs(Vektor3D v1) {
        return length(v1);
    }

    public static void show(Vektor2D v1) {
       	System.out.println("[" + v1.x + "]");
       	System.out.println("[" + v1.y + "]");
    }

    public static void show(Vektor3D v1) {
        System.out.println("[" + v1.x + "]");
        System.out.println("[" + v1.y + "]");
        System.out.println("[" + v1.z + "]");
    }

    public static void main(String args[]){
        double vek[]={3,4,9};
        double vek2[]={2,12,50};
        Vektor2D a= new Vektor2D(2,3);
        show(a);
        System.out.println(radToDegree(4.1));
      /* System.out.println(angleDegree(vek,vek2));
       System.out.println(angleRad(vek,vek2));
        System.out.println(radToDegree(0.6));
        System.out.println(degreeToRad(23));*/
    }
}
