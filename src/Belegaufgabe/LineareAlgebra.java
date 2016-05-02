package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;
import Belegaufgabe.Vektor2D.*;

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

    public static Vektor2D normalize(Vektor2D v1) { //kleine werte nehmen

        if (v1.isNullVector()) {
            Random rdm= new Random();
            v1.x = rdm.nextDouble() * 2 -1;
            v1.y = rdm.nextDouble() * 2 -1;
            return new Vektor2D(v1.x, v1.y);
        }
        else {
            double l = length(v1);
            return new Vektor2D(((1 / l) * v1.x), ((1 / l) * v1.y));
        }
    }

    public static Vektor3D normalize(Vektor3D v1) {
        if (v1.isNullVector()) {
            Random rdm= new Random();
            v1.x = rdm.nextDouble() * 2 -1;
            v1.y = rdm.nextDouble() * 2 -1;
            v1.z = rdm.nextDouble() * 2 -1;
            return new Vektor3D(v1.x, v1.y, v1.z);
        }
        else {
        double l = length(v1);
        return new Vektor3D(((1 / l)* v1.x), ((1 / l)* v1.y),((1 / l)* v1.z));
        }
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

    public static Vektor3D crossProduct(Vektor3D v1, Vektor3D v2) {  
    	Vektor3D erg= new Vektor3D(0,0,0);
        erg.x= v1.y*v2.z-v1.z*v2.y; 
        erg.y= v1.z*v2.x-v1.x*v2.z; 
        erg.z= v1.x*v2.y-v1.y*v2.x;
        return erg;
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

    public static double sinEquation(Vektor2D v1, Vektor2D v2) {  
            return (determinante(v1,v2)/(length(v1)*length(v2)));
    } 
    
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
        if (deg % 360 == 0)
            return  ((2*Math.PI));
        return  ((2*Math.PI)/360*(deg%360));
    }

    public static double determinante(Vektor2D v1, Vektor2D v2) {   
    	return (v1.x*v2.y-v2.x*v1.y);
    }
    public static double determinante(Vektor3D v1, Vektor3D v2, Vektor3D v3) {   //ist wohl eigentlich unnötig
        return (v1.x*v2.y*v3.z + v2.x*v3.y*v1.z + v3.x*v1.y*v2.z-
        		v1.z*v2.y*v3.x - v2.z*v3.y*v1.x - v3.z*v1.y*v2.x);
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
      
        Vektor2D a= new Vektor2D(2,3);
        Vektor3D v0= new Vektor3D(-1,2,3);
        Vektor3D v1= new Vektor3D(4,50,6);
        Vektor3D v2= new Vektor3D(7,8,9);
        Vektor2D v3= new Vektor2D(5,2);
        Vektor2D v4= new Vektor2D(2,3);
        show(a);
        System.out.println(radToDegree(4.1));
      /* System.out.println(angleDegree(vek,vek2));
       System.out.println(angleRad(vek,vek2));
        System.out.println(radToDegree(0.6));
        System.out.println(degreeToRad(23));*/
        show(crossProduct(v1,v2));
        System.out.println(determinante(v3,v4));
        System.out.println(determinante(v0,v1,v2));
        System.out.println(length(v3));
        System.out.println(length(v4));
        System.out.println(sinEquation(v3,v4));
        System.out.println("hasüas");
        System.out.println(degreeToRad(720));
        
    }
}
