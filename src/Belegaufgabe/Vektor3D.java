package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor3D {

    public double x, y, z;
    private double sx, sy , sz;

    public Vektor3D(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public void saveState() {
        sx = this.x;
        sy = this.y;
        sz = this.z;
    }

    public void restoreState() {
        this.x = sx;
        this.y = sy;
        this.z = sz;
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
        saveState();
        if (s != 0) {
            this.x *= s;
            this.y *= s;
            this.z *= s;
        } else {
            restoreState();
        }
    }

    public void div(double s) {
        saveState();
        if (s != 0) {
            this.x /= s;
            this.y /= s;
            this.z /= s;
        } else {
            restoreState();
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
