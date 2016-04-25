/**
 * Created by samstone on 25.04.2016.
 */

public class LineareAlgebra {

    private LineareAlgebra() {}

    public static void add(double[] a, double[] b) {
        double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] + b[i];
        }
        else
            System.out.println("Fehler add() !");
    }

    public static void sub(double[] a, double[] b) {
        double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] - b[i];
        }
        else
            System.out.println("Fehler sub() !");
    }

    public static void mult(double[] a, double[] b) {
        double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] * b[i];
        }
        else
            System.out.println("Fehler mult() !");
    }

    public static void div(double[] a, double[] b) {
        double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] / b[i];
        }
        else
            System.out.println("Fehler div() !");
    }

    public static void isEqual(double[] a, double[] b) {

    }

    public static void isNotEqual(double[] a, double[] b) {

    }

    public static double length(double[] a) {
        double erg = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2));
        return erg;
    }

    public static double[] normalize(double[] a) {
        double l = length(a);
        double[] erg = new double[3];
        for (int i = 0; i < a.length; i++) {
            erg[i] = (1 / l) * a[i];
        }
        return erg;
    }

    public static void euklDistance(double x1, double x2, double y1, double y2) {
        /* euklDistance 2D */
        double PotX = Math.pow((x1 - x2), 2);   // Potenzieren
        double PotY = Math.pow((y1 - y2), 2);
        double eukl   = Math.sqrt(PotX + PotY);
    }

    public static void manhattanDistance(double x0, double x1, double y0, double y1) {
        double dist = Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    public static double[] crossProduct(double[] a, double[] b) {
        double[] crossP = null;
        crossP[0] = a[1] * b[2] - a[2] * b[1];
        crossP[1] = a[2] * b[0] - a[0] * b[2];
        crossP[2] = a[0] * b[2] - a[1] * b[0];
        return crossP;
    }
    public static double dotProduct(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++)
            sum += a[i] * b[i];
        return sum;
    }

    public static void cosEquation(double[] a, double[] b) {

    }

    public static void sinEquation(double[] a, double[] b) {

    }

    public static void angleRad(double a) {

    }

    public static void angleDegree(double a) {

    }

    public static void radToDegree(double a) {
        Math.toDegrees(a);
    }

    public static void degreeToRad(double a) {
        Math.toRadians(a);
    }

    public static void determinante(double[] a, double[] b) {

    }

    public static void abs(double a) {
        Math.abs(a);
    }

    public static void show(double[] a) {
        System.out.println("[" + a[0] + "]");
        System.out.println("[" + a[1] + "]");
        System.out.println("[" + a[2] + "]");
    }
}
