package Belegaufgabe;

import static java.lang.Math.*;

public class Vektor2D {

	public double x, y;

	public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public void add(Vektor2D v) {
    	if (this.length() != v.length())
    		//return null;
    	
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

    		this.x /= s;
    		this.y /= s;

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
        double l = this.length();
        this.x = (1 / l) * this.x;
        this.y = (1 / l) * this.y;
    }

    public void setPosition(double new_x, double new_y) {
            this.x = new_x;
            this.y = new_y;
    }

    public boolean isNullVector(Vektor2D v) {
        if (this.x == 0 && this.y == 0)
            return true;
        else
            return false;
    }
   
}
