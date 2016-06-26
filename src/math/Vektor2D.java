package math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;
    Random rand = ThreadLocalRandom.current();
    
    public Vektor2D() {
        this.x=0.0;
        this.y=0.0;
    }

    public Vektor2D(double x, double y) {
        this.x=x;
        this.y=y;
    }
    
    public Vektor2D(Vektor2D copy) {
        this.x=copy.x;
        this.y=copy.y;
    }
    
    private void onErrorSetZero(int err) {
        //System.err.println("Double overflow" + err);
        //System.out.println("x" + " " + this.x);
        //System.out.println("y" + " " + this.y);
        setPosition(0.0, 0.0);
    }
    
    public void differenz(Vektor2D a , Vektor2D b) {
    	this.x = Math.abs(a.x - b.x);
    	this.y = Math.abs(a.y - b.y);
    }

    public void add(Vektor2D v) {
        if (((Double)(this.x += v.x)).isInfinite() || ((this.x += v.x) == Double.MAX_VALUE) ||
                   ((Double)(this.y += v.x)).isInfinite() || ((this.y += v.y) == Double.MAX_VALUE)) {
            onErrorSetZero(1);
        } else  {
            this.x += v.x;
            this.y += v.y;
        }
    }

    public void sub(Vektor2D v) {
      if (this.x > 0 ? v.x < Double.MIN_VALUE + this.x : v.x > Double.MAX_VALUE + this.x) {
            onErrorSetZero(2);
        } else if (this.y > 0 ? v.y < Double.MIN_VALUE + this.y : v.y > Double.MAX_VALUE + this.y) {
            onErrorSetZero(3);
        } else {
            this.x -= v.x;
            this.y -= v.y;
        }
    }

    public void mult(double s) {
    	if (s > 0 ? this.x > Double.MAX_VALUE/s || this.x < Double.MIN_VALUE/s : (s < -1 ? this.x > Double.MIN_VALUE/s
                || this.x < Double.MAX_VALUE/s : s == -1 && this.x == Double.MIN_VALUE)) {
            onErrorSetZero(4);
        } else if (s > 0 ? this.y > Double.MAX_VALUE/s || this.y < Double.MIN_VALUE/s : (s < -1 ? this.y > Double.MIN_VALUE/s
                || this.y < Double.MAX_VALUE/s : s == -1 && this.y == Double.MIN_VALUE)) {
            onErrorSetZero(5);
        } else if (((Double)(this.x *= s)).isInfinite() || ((this.x *= s) == Double.MAX_VALUE) ||
                   ((Double)(this.y *= s)).isInfinite() || ((this.y *= s) == Double.MAX_VALUE)) {
            onErrorSetZero(6);
        } else {
            this.x *= s;
            this.y *= s;
        }
    }

    public void div(double s) {
        if ((this.x == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero(7);
        } else if ((this.y == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero(8);
        } else if (((Double)(this.x /= s)).isInfinite() ||
                   ((Double)(this.y /= s)).isInfinite()) {
            onErrorSetZero(9);
        } else if (s == 0) {
            onErrorSetZero(10);
        } else if ((s >= -0.1 || s <= 0.1) && (((this.x /= s) == Double.MIN_VALUE) || ((this.y /= s) == Double.MIN_VALUE))) {
            onErrorSetZero(11);
        } else if (s == Double.MIN_VALUE && ((this.x >= -0.1 || this.x <= 0.1) || (this.y >= -0.1 || this.y <= 0.1))) {
            onErrorSetZero(12);
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

            this.x = rand.nextDouble() * 2 -1;
            this.y = rand.nextDouble() * 2 -1;
        } else {
            double l = this.length();
            this.x = (1 / l) * this.x;
            this.y = (1 / l) * this.y;
        }
    }
    
    public void truncate(double max) {
    	this.normalize();
    	this.x *= max;
    	this.y *= max;
    }
    
    public Vektor2D Round() {

		this.x = LineareAlgebra.Round(this.x);
		this.y = LineareAlgebra.Round(this.y);
		return this;
	}

    public void setPosition(double new_x, double new_y) {
        this.x = new_x;
        this.y = new_y;
    }

    public boolean isNullVector() {
        return (this.x == 0 && this.y == 0);
    }
}
