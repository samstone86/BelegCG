package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;

    public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }

    private void errorSetZero(String err) {
        this.x = 0.0;
        this.y = 0.0;
        System.err.println(err);
    }
    
    private void checkMaxValue () {
		if(this.x == Double.MAX_VALUE || this.x == Double.MAX_VALUE)
			errorSetZero("ERROR: Speicherueberlauf Double.MAX_VALUE !\nStelle Vektor wird wiederhergestellt !");
    }
    
    private void checkMinValue () {
		if(this.x == Double.MIN_VALUE || this.x == Double.MIN_VALUE)
			errorSetZero("ERROR: Speicherueberlauf Double.MIN_VALUE !\nStelle Vektor wird wiederhergestellt !");
    }

    public void add(Vektor2D v) {
    	this.x += v.x;
        this.y += v.y;
        checkMaxValue();
    }

    public void sub(Vektor2D v) {
        this.x -= v.x;
        this.y -= v.y;
        checkMinValue();
    }

    public void mult(double s) {
    	if (s >= -1) {
    		this.x *= s;
    		this.y *= s;
    		checkMaxValue();
    	} else {
    		errorSetZero("ERROR: Speicherueberlauf Double.MIN_VALUE !\nStelle Vektor wird wiederhergestellt !");
        }
    }

    public void div(double s) {
        if (s != 0) {
            this.x /= s;
            this.y /= s;
            checkMaxValue();
        } else {
        	errorSetZero("ERROR: Division durch 0 !\nStelle Vektor wird wiederhergestellt !");
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
