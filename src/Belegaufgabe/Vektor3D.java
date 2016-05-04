package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor3D {

    public double x, y, z;

    public Vektor3D(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void errorSetZero(String err) {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        System.err.println(err);
    }
    
    private void checkMaxValue () {
		if(this.x == Double.MAX_VALUE || this.x == Double.MAX_VALUE || this.z == Double.MAX_VALUE)
			errorSetZero("ERROR: Speicherueberlauf Double.MAX_VALUE !\nStelle Vektor wird wiederhergestellt !");
    }
    
    private void checkMinValue () {
		if(this.x == Double.MIN_VALUE || this.x == Double.MIN_VALUE || this.z == Double.MIN_VALUE)
			errorSetZero("ERROR: Speicherueberlauf Double.MIN_VALUE !\nStelle Vektor wird wiederhergestellt !");
    }

    public void add(Vektor3D v) {
    	this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        checkMaxValue();
    }

    public void sub(Vektor3D v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        checkMinValue();
    }

    public void mult(double s) {
    	if (s >= -1) {
    		this.x *= s;
    		this.y *= s;
    		this.z *= s;
    		checkMaxValue();
    	} else {
    		errorSetZero("ERROR: Speicherueberlauf Double.MIN_VALUE !\nStelle Vektor wird wiederhergestellt !");
        }
    }

    public void div(double s) {
        if (s != 0) {
            this.x /= s;
            this.y /= s;
            this.z /= s;
            checkMaxValue();
        } else {
        	errorSetZero("ERROR: Division durch 0 !\nStelle Vektor wird wiederhergestellt !");
        }
    }

    public boolean isEqual(Vektor3D v) {      
        return ((this.x == v.x) && (this.y == v.y) && (this.z == v.z));
    }

    public boolean isNotEqual(Vektor3D v) {
        return !isEqual(v);
    }

    public double length() {
        return (sqrt(pow(this.x, 2) + pow(this.y, 2) + pow(this.z, 2)));
    }

    public void normalize() {
        if (this.isNullVector()) {
            Random rdm= new Random();
            this.x = rdm.nextDouble() * 2 -1;
            this.y = rdm.nextDouble() * 2 -1;
            this.z = rdm.nextDouble() * 2 -1;
        } else {
            double l = this.length();
            this.x = (1 / l) * this.x;
            this.y = (1 / l) * this.y;
            this.z = (1 / l) * this.z;
        }
    }

    public void setPosition(double new_x, double new_y, double new_z) {
        this.x = new_x;
        this.y = new_y;
        this.z = new_z;
    }

    public boolean isNullVector() {
        return (this.x == 0 && this.y == 0 && this.z == 0);
    }
}
