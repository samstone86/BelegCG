import static java.lang.Math.*;

public class Vektor3D {

    private Vektor3D() {}

    public static double[] add(double[] a, double[] b) {
        double[] ergAdd = new double[3];
        for (int i = 0; i < a.length; i++)
            ergAdd[i] = a[i] + b[i];
        return ergAdd;
    }

    public static double[] sub(double[] a, double[] b) {
        double[] ergSub = new double[3];
        for (int i = 0; i < a.length; i++)
            ergSub[i] = a[i] - b[i];
        return ergSub;
    }

    public static double[] mult(double[] a, double s) {
        double[] ergMult = new double[3];
        for (int i = 0; i < a.length; i++)
            ergMult[i] = a[i] * s;
        return ergMult;
    }

    public static double[] div(double[] a, double s) {
        double[] ergDiv = new double[3];
        for (int i = 0; i < a.length; i++)
            ergDiv[i] = a[i] / s;
        return ergDiv;
    }

    public static boolean isEqual(double[] a, double[] b) {
        if ((a[0] == b[0]) && (a[1] == b[1]) && (a[2] == b[2]))
            return true;
        else
            return false;
    }

    public static boolean isNotEqual(double[] a, double[] b) {
        if ((a[0] != b[0]) || (a[1] != b[1]) || (a[2] != b[2]))
            return true;
        else
            return false;
    }

    public static double length(double[] a) {
        double len = sqrt(pow(a[0], 2) + pow(a[1], 2) + pow(a[2], 2));
        return len;
    }

    public static double[] normalize(double[] a) {
        double l = length(a);
        double[] norm = new double[3];
        for (int i = 0; i < a.length; i++) {
            norm[i] = (1 / l) * a[i];
        }
        return norm;
    }

    public static void setPosition(double[] a, double new_x, double new_y, double new_z) {
        a[0]= new_x;
        a[1]=new_y;
        a[2]= new_z;
    }

    public static boolean isNullVector(double[] a) {
        if (a[0] == 0 && a[1] == 0 && a[2] == 0)
            return true;
        else
            return false;
    }
}
