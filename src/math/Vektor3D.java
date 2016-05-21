package math;

import java.util.Random;
import static java.lang.Math.*;

public class Vektor3D {

    public double x, y, z;

    public Vektor3D() {
        this.x=0.0;
        this.y=0.0;
        this.z=0.0;
    }

    public Vektor3D(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }
    
    public Vektor3D(Vektor3D copy) {
        this.x=copy.x;
        this.y=copy.y;
        this.z=copy.z;
    }

    private void onErrorSetZero() {
        System.err.println("Double overflow");
        setPosition(0.0, 0.0, 0.0);
    }

    public void add(Vektor3D v) {
        if (((Double)(this.x += v.x)).isInfinite() || ((this.x += v.x) == Double.MAX_VALUE) ||
                   ((Double)(this.y += v.y)).isInfinite() || ((this.y += v.y) == Double.MAX_VALUE) ||
                   ((Double)(this.z += v.z)).isInfinite() || ((this.z += v.z) == Double.MAX_VALUE)) {
            onErrorSetZero();
        } else {
            this.x += v.x;
            this.y += v.y;
            this.z += v.z;
        }
    }

    public void sub(Vektor3D v) {
        if (v.x > 0 ? this.x < Double.MIN_VALUE + v.x : this.x > Double.MAX_VALUE + v.x) {
            onErrorSetZero();
        } else if (v.y > 0 ? this.y < Double.MIN_VALUE + v.y : this.y > Double.MAX_VALUE + v.y) {
            onErrorSetZero();
        } else if (v.z > 0 ? this.z < Double.MIN_VALUE + v.z : this.z > Double.MAX_VALUE + v.z) {
            onErrorSetZero();
        } else {
            this.x -= v.x;
            this.y -= v.y;
            this.z -= v.z;
        }
    }

    public void mult(double s) {
        if (s > 0 ? this.x > Double.MAX_VALUE/s || this.x < Double.MIN_VALUE/s : (s < -1 ? this.x > Double.MIN_VALUE/s
                || this.x < Double.MAX_VALUE/s : s == -1 && this.x == Double.MIN_VALUE)) {
            onErrorSetZero();
        } else if (s > 0 ? this.y > Double.MAX_VALUE/s || this.y < Double.MIN_VALUE/s : (s < -1 ? this.y > Double.MIN_VALUE/s
                || this.y < Double.MAX_VALUE/s : s == -1 && this.y == Double.MIN_VALUE)) {
            onErrorSetZero();
        } else if (s > 0 ? this.z > Double.MAX_VALUE/s || this.z < Double.MIN_VALUE/s : (s < -1 ? this.z > Double.MIN_VALUE/s
                || this.z < Double.MAX_VALUE/s : s == -1 && this.z == Double.MIN_VALUE)) {
            onErrorSetZero();
        } else if (((Double)(this.x *= s)).isInfinite() || ((this.x *= s) == Double.MAX_VALUE) ||
                   ((Double)(this.y *= s)).isInfinite() || ((this.y *= s) == Double.MAX_VALUE) ||
                   ((Double)(this.z *= s)).isInfinite() || ((this.z *= s) == Double.MAX_VALUE)) {
            onErrorSetZero();
        } else {
            this.x *= s;
            this.y *= s;
            this.z *= s;
        }
    }

    public void div(double s) {
        if ((this.x == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero();
        } else if ((this.y == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero();
        } else if ((this.z == Double.MIN_VALUE) && (s == -1)) {
            onErrorSetZero();
        } else if (((Double)(this.x /= s)).isInfinite() ||
                   ((Double)(this.y /= s)).isInfinite() ||
                   ((Double)(this.z /= s)).isInfinite()) {
            onErrorSetZero();
        } else if (s == 0) {
            onErrorSetZero();
        } else if ((s >= -0.1 || s <= 0.1) && (((this.x /= s) == Double.MIN_VALUE) || ((this.y /= s) == Double.MIN_VALUE) || ((this.z /= s) == Double.MIN_VALUE))) {
            onErrorSetZero();
        } else if (s == Double.MIN_VALUE && ((this.x >= -0.1 || this.x <= 0.1) || (this.y >= -0.1 || this.y <= 0.1) || (this.z >= -0.1 || this.z <= 0.1))) {
            onErrorSetZero();
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
        double l = (sqrt(pow(this.x, 2) + pow(this.y, 2) + pow(this.z, 2)));
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
            this.z = rdm.nextDouble() * 2 -1;
        } else {
            double l = this.length();
            this.x = (1 / l) * this.x;
            this.y = (1 / l) * this.y;
            this.z = (1 / l) * this.z;
        }
    }
    
    public void truncate(double max) {
    	this.normalize();
    	this.x *= max;
    	this.y *= max;
    	this.z *= max;
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
