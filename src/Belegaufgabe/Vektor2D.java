package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;

    public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public void add(Vektor2D v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void sub(Vektor2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public void mult(double s) {
    	this.x *= s;
        this.y *= s;
    }

    public void div(double s) {
    	//Experiment
    	try{
    	this.x /= s;
    	this.y /= s;
    	} catch(ArithmeticException e){
    	      System.out.print("error " + "Divided by 0");
    	      e.printStackTrace();
        }
    }

    public boolean isEqual(Vektor2D v) {      
        return ((this.x == v.x) && (this.y == v.y));
    }

    public boolean isNotEqual(Vektor2D v) {
        return !isEqual(v);
    }

    public double length() {
        return (sqrt(pow(this.x, 2) + pow(this.y, 2)));
    }

    public void normalize() {
        if (this.isNullVector()) {
            Random rdm= new Random();
            this.x = rdm.nextDouble() * 2 -1;
            this.y = rdm.nextDouble() * 2 -1;
        } else {
            double l = this.length();
            this.x = (1 / l) * this.x;
            this.y = (1 / l) * this.y;
        }
    }

    public void setPosition(double new_x, double new_y) {
            this.x = new_x;
            this.y = new_y;
    }

    public boolean isNullVector() {
        return (this.x == 0 && this.y == 0);
    }
}
