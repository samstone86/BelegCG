package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;
    private double sx, sy;

    public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }
    
    public void saveState() {
        sx = this.x;
        sy = this.y;
    }

    public void restoreState(String err) {
        this.x = sx;
        this.y = sy;
        System.err.println(err);
    }
    
    public void checkMaxValue () {
		if(this.x > Double.MAX_VALUE || this.x > Double.MAX_VALUE) {
			restoreState("Speicherueberlauf Double.MAX_VALUE");
		}
    }

    public void add(Vektor2D v) {
    	saveState();
    	if(this.x == Double.MAX_VALUE || this.y == Double.MAX_VALUE || v.x == Double.MAX_VALUE || v.y == Double.MAX_VALUE) {
    		restoreState("ERROR: Double.MAX_VALUE !");
    	} else {
    		this.x += v.x;
        	this.y += v.y;
    	}
    }

    public void sub(Vektor2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public void mult(double s) {
    	saveState();
    	//if ((s > 1 || s < -1) && !(this.x == Double.MAX_VALUE || this.y == Double.MAX_VALUE)) {
    	if (s >= -1) {
    		this.x *= s;
    		this.y *= s;
    		checkMaxValue();
    	} else {
            restoreState("Speicherueberlauf Double.MIN_VALUE");
        }
    }

    public void div(double s) {
        saveState();
        if (s != 0) {
            this.x /= s;
            this.y /= s;
            checkMaxValue();
        } else {
            restoreState("Division duch 0 !!!");
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
