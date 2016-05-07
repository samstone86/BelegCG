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
        if (v.x > 0 ? this.x > Double.MAX_VALUE - v.x : this.x < Double.MIN_VALUE - v.x) {
            throw new ArithmeticException("Integer overflow");
        } else if (v.y > 0 ? this.y > Double.MAX_VALUE - v.y : this.y < Double.MIN_VALUE - v.y) {
            throw new ArithmeticException("Integer overflow");
        } else {
            this.x += v.x;
            this.y += v.y;
        }
    }

    public void sub(Vektor2D v) {
        if (v.x > 0 ? this.x < Double.MIN_VALUE + v.x : this.x > Double.MAX_VALUE + v.x) {
            throw new ArithmeticException("Integer overflow");
        } else if (v.y > 0 ? this.y < Double.MIN_VALUE + v.y : this.y > Double.MAX_VALUE + v.y) {
            throw new ArithmeticException("Integer overflow");
        } else {
            this.x -= v.x;
            this.y -= v.y;
        }
    }

    public void mult(double s) {
        if (s > 0 ? this.x > Double.MAX_VALUE/s || this.x < Double.MIN_VALUE/s : (s < -1 ? this.x > Double.MIN_VALUE/s
                || this.x < Double.MAX_VALUE/s : s == -1 && this.x == Double.MIN_VALUE) ) {
            System.err.println("Integer overflow");
            this.x = 0.0;
            // throw new ArithmeticException("Integer overflow");
        } else if (s > 0 ? this.y > Double.MAX_VALUE/s || this.y < Double.MIN_VALUE/s : (s < -1 ? this.y > Double.MIN_VALUE/s
                || this.y < Double.MAX_VALUE/s : s == -1 && this.y == Double.MIN_VALUE) ) {
            System.err.println("Integer overflow");
            this.y = 0.0;
        } else {
            this.x *= s;
            this.y *= s;
        }
    }

    public void div(double s) {
        if ((this.x == Double.MIN_VALUE) && (s == -1)) {
            throw new ArithmeticException("Integer overflow");
        } else if ((this.y == Double.MIN_VALUE) && (s == -1)) {
            throw new ArithmeticException("Integer overflow");
        } else {
            this.x /= s;
            this.y /= s;
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
