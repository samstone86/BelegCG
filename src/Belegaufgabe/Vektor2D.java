package Belegaufgabe;

import java.util.Random;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;

    public Vektor2D() {
        this.x=0.0;
        this.y=0.0;
    }

    public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }
    private void onErrorSetZero() {
        System.err.println("Double overflow");
        setPosition(0.0, 0.0);
    }

    public void add(Vektor2D v) {
        if (v.x > 0 ? this.x > Double.MAX_VALUE - v.x : this.x < Double.MIN_VALUE - v.x) {
            onErrorSetZero();
        } else if (v.y > 0 ? this.y > Double.MAX_VALUE - v.y : this.y < Double.MIN_VALUE - v.y) {
            onErrorSetZero();
        } else if (((Double)(this.x += v.x)).isInfinite() || ((this.x += v.x) == Double.MAX_VALUE) ||
                   ((Double)(this.y += v.x)).isInfinite() || ((this.y += v.y) == Double.MAX_VALUE)) {
            onErrorSetZero();
        } else {
            this.x += v.x;
            this.y += v.y;
        }
    }

    public void sub(Vektor2D v) {
      if (this.x > 0 ? v.x < Double.MIN_VALUE + this.x : v.x > Double.MAX_VALUE + this.x) {
            onErrorSetZero();
        } else if (this.y > 0 ? v.y < Double.MIN_VALUE + this.y : v.y > Double.MAX_VALUE + this.y) {
            onErrorSetZero();
        } else {
            this.x -= v.x;
            this.y -= v.y;
        }
    }

    public void mult(double s) {
        if (s > 0 ? this.x > Double.MAX_VALUE/s || this.x < Double.MIN_VALUE/s : (s < -1 ? this.x > Double.MIN_VALUE/s
                || this.x < Double.MAX_VALUE/s : s == -1 && this.x == Double.MIN_VALUE)) {
            onErrorSetZero();
        } else if (s > 0 ? this.y > Double.MAX_VALUE/s || this.y < Double.MIN_VALUE/s : (s < -1 ? this.y > Double.MIN_VALUE/s
                || this.y < Double.MAX_VALUE/s : s == -1 && this.y == Double.MIN_VALUE)) {
            onErrorSetZero();
        } else if (((Double)(this.x *= s)).isInfinite() || ((this.x *= s) == Double.MAX_VALUE) ||
                   ((Double)(this.y *= s)).isInfinite() || ((this.y *= s) == Double.MAX_VALUE)) {
            onErrorSetZero();
        } else {
            this.x *= s;
            this.y *= s;
        }
    }

    public void div(double s) {
        if ((this.x == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero();
        } else if ((this.y == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero();
        } else if (((Double)(this.x /= s)).isInfinite() ||
                   ((Double)(this.y /= s)).isInfinite()) {
            onErrorSetZero();
        } else if (s == 0) {
            onErrorSetZero();
        } else if ((s >= -0.1 || s <= 0.1) && (((this.x /= s) == Double.MIN_VALUE) || ((this.y /= s) == Double.MIN_VALUE))) {
            onErrorSetZero();
        } else if (s == Double.MIN_VALUE && ((this.x >= -0.1 || this.x <= 0.1) || (this.y >= -0.1 || this.y <= 0.1))) {
            onErrorSetZero();
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
        double l = (sqrt(pow(this.x, 2) + pow(this.y, 2)));
        if ((l == Double.MAX_VALUE) || (l == Double.NEGATIVE_INFINITY) || (l == Double.POSITIVE_INFINITY) || ((Double)l).isNaN()) {
            throw new ArithmeticException("Double overflow" + l);
        }
        return l;
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
