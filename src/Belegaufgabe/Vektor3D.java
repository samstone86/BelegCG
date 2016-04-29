package Belegaufgabe;

import static java.lang.Math.*;

public class Vektor3D {

    public double x, y, z;

    public Vektor3D(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void add(Vektor3D v) {   // Gleiche länge / double.MAX_LENGTH testen
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public void sub(Vektor3D v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
    }

    public void mult(double s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
    }

    public void div(double s) {
    	this.x /= s;
    	this.y /= s;
    	this.z /= s;
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
        double l = this.length();
        this.x = (1 / l) * this.x;
        this.y = (1 / l) * this.y;
        this.z = (1 / l) * this.z;
    }

    public void setPosition(double new_x, double new_y, double new_z) {
        this.x = new_x;
        this.y = new_y;
        this.z = new_z;
    }

    public boolean isNullVector(Vektor3D v) {
        return (this.x == 0 && this.y == 0 && this.z == 0);
    }
}
