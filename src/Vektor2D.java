import static java.lang.Math.*;

public class Vektor2D {

    private Vektor2D() {}

    public static double[] add(double[] a, double[] b) {
        double[] ergAdd = new double[2];
        for (int i = 0; i < a.length; i++)
            ergAdd[i] = a[i] + b[i];
        return ergAdd;
    }

    public static double[] sub(double[] a, double[] b) {
        double[] ergSub = new double[2];
        for (int i = 0; i < a.length; i++)
            ergSub[i] = a[i] - b[i];
        return ergSub;
    }

    public static double[] mult(double[] a, double s) {
        double[] ergMult = new double[2];
        for (int i = 0; i < a.length; i++)
            ergMult[i] = a[i] * s;
        return ergMult;
    }

    public static double[] div(double[] a, double s) {
        double[] ergDiv = new double[2];
        for (int i = 0; i < a.length; i++)
            ergDiv[i] = a[i] / s;
        return ergDiv;
    }

    public static boolean isEqual(double[] a, double[] b) {
        if ((a[0] == b[0]) && (a[1] == b[1]))
            return true;
        else
            return false;
    }

    public static boolean isNotEqual(double[] a, double[] b) {
        if ((a[0] != b[0]) || (a[1] != b[1]))
            return true;
        else
            return false;
    }

    public static double length(double[] a) {
        double len = sqrt(pow(a[0], 2) + pow(a[1], 2));
        return len;
    }

    public static double[] normalize(double[] a) {
        double l = length(a);
        double[] norm = new double[2];
        for (int i = 0; i < a.length; i++) {
            norm[i] = (1 / l) * a[i];
        }
        return norm;
    }

    public static double setPosition() {
        // ???
    }

    public static boolean isNullVector(double[] a) {
        if (a[0] == 0 && a[1] == 0)
            return true;
        else
            return false;
    }
}
