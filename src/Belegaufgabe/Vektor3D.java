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

    public void add(Vektor3D v) {
        if (v.x > 0 ? this.x > Double.MAX_VALUE - v.x : this.x < Double.MIN_VALUE - v.x) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (v.y > 0 ? this.y > Double.MAX_VALUE - v.y : this.y < Double.MIN_VALUE - v.y) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (v.z > 0 ? this.z > Double.MAX_VALUE - v.z : this.z < Double.MIN_VALUE - v.z) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (((Double)(this.x += v.x)).isInfinite() ||
                   ((Double)(this.y += v.y)).isInfinite() ||
                   ((Double)(this.z += v.z)).isInfinite()) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else {
            this.x += v.x;
            this.y += v.y;
            this.z += v.z;
        }

    }

    public void sub(Vektor3D v) {
        if (v.x > 0 ? this.x < Double.MIN_VALUE + v.x : this.x > Double.MAX_VALUE + v.x) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (v.y > 0 ? this.y < Double.MIN_VALUE + v.y : this.y > Double.MAX_VALUE + v.y) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (v.z > 0 ? this.z < Double.MIN_VALUE + v.z : this.z > Double.MAX_VALUE + v.z) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else {
            this.x -= v.x;
            this.y -= v.y;
            this.z -= v.z;
        }
    }

    public void mult(double s) {
        if (s > 0 ? this.x > Double.MAX_VALUE/s || this.x < Double.MIN_VALUE/s : (s < -1 ? this.x > Double.MIN_VALUE/s
                || this.x < Double.MAX_VALUE/s : s == -1 && this.x == Double.MIN_VALUE)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (s > 0 ? this.y > Double.MAX_VALUE/s || this.y < Double.MIN_VALUE/s : (s < -1 ? this.y > Double.MIN_VALUE/s
                || this.y < Double.MAX_VALUE/s : s == -1 && this.y == Double.MIN_VALUE)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (s > 0 ? this.z > Double.MAX_VALUE/s || this.z < Double.MIN_VALUE/s : (s < -1 ? this.z > Double.MIN_VALUE/s
                || this.z < Double.MAX_VALUE/s : s == -1 && this.z == Double.MIN_VALUE)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (((Double)(this.x *= s)).isInfinite() ||
                   ((Double)(this.y *= s)).isInfinite() ||
                   ((Double)(this.z *= s)).isInfinite()) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else {
            this.x *= s;
            this.y *= s;
            this.z *= s;
        }
    }

    public void div(double s) {
        if ((this.x == Double.MIN_VALUE) && (s == -1)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if ((this.y == Double.MIN_VALUE) && (s == -1)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if ((this.z == Double.MIN_VALUE) && (s == -1)) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0; this.z = 0.0;
        } else if (((Double)(this.x /= s)).isInfinite() ||
                   ((Double)(this.y /= s)).isInfinite() ||
                   ((Double)(this.z /= s)).isInfinite()) {
            System.err.println("Integer overflow");
            this.x = 0.0; this.y = 0.0;
        } else {
            this.x /= s;
            this.y /= s;
            this.z /= s;
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
