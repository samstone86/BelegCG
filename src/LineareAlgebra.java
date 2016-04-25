/**
 * Created by samstone on 25.04.2016.
 */

public class LineareAlgebra {

    private LineareAlgebra() {}

    public static void add(Double[] a, Double[] b) {
        Double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] + b[i];
        }
        else
            System.out.println("Fehler add() !");
    }

    public static void sub(Double[] a, Double[] b) {
        Double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] - b[i];
        }
        else
            System.out.println("Fehler sub() !");
    }

    public static void mult(Double[] a, Double[] b) {
        Double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] * b[i];
        }
        else
            System.out.println("Fehler mult() !");
    }

    public static void div(Double[] a, Double[] b) {
        Double[] erg = null;

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++)
                erg[i] = a[i] / b[i];
        }
        else
            System.out.println("Fehler div() !");
    }

    public static void isEqual(Double[] a, Double[] b) {

    }

    public static void isNotEqual(Double[] a, Double[] b) {

    }

    public static void lengh(Double[] a) {
        double erg = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2) + Math.pow(a[2], 2));
    }

    public static void normalize(Double[] a) {

    }

    public static void euklDistance(Double x1, Double x2, Double y1, Double y2) {
        /* euklDistance 2D */
        double PotX = Math.pow((x1 - x2), 2);   // Potenzieren
        double PotY = Math.pow((y1 - y2), 2);
        double eukl   = Math.sqrt(PotX + PotY);
    }

    public static void manhattanDistance(Double x0, Double x1, Double y0, Double y1) {
        Double dist = Math.abs(x1 - x0) + Math.abs(y1 - y0);
    }

    public static Double[] crossProduct(Double[] a, Double[] b) {
        Double[] crossP = null;
        crossP[0] = a[1] * b[2] - a[2] * b[1];
        crossP[1] = a[2] * b[0] - a[0] * b[2];
        crossP[2] = a[0] * b[2] - a[1] * b[0];
        return crossP;
    }
    public static void dotProduct(Double[] a, Double[] b) {
        Double sum = 0.0;
        for (int i = 0; i < a.length; i++)
            sum += a[i] * b[i];
    }

    public static void cosEquation(Double[] a, Double[] b) {

    }

    public static void sinEquation(Double[] a, Double[] b) {

    }

    public static void angleRad(Double a) {

    }

    public static void angleDegree(Double a) {

    }

    public static void radToDegree(Double a) {
        Math.toDegrees(a);
    }

    public static void degreeToRad(Double a) {
        Math.toRadians(a);
    }

    public static void determinante(Double[] a, Double[] b) {

    }

    public static void abs(Double a) {
        Math.abs(a);
    }

    public static void show(Double[] a) {
        System.out.println("[" + a[0] + "]");
        System.out.println("[" + a[1] + "]");
        System.out.println("[" + a[2] + "]");
    }
}
