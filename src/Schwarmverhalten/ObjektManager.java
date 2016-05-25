package Schwarmverhalten;

import java.util.HashMap;

public class ObjektManager {
   private HashMap<Integer, Triangle> triangle;
   private static ObjektManager exemplar = new ObjektManager();

   private ObjektManager() {
      triangle = new HashMap<Integer, Triangle>();
   }

   public static ObjektManager getExemplar() {
      return exemplar;
   }

   public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException("Clonen ist nicht erlaubt");
   }
   
   public void registriereFlummi(Triangle obj) {
      triangle.put(new Integer(obj.id), obj);
   }

   public void entferneFlummi(Triangle obj) {
      triangle.remove(obj);
   }
   
   public Triangle getFlummi(int objID) {
      return triangle.get(new Integer(objID));
   }
   
   public HashMap<Integer, Triangle> getFlummiMap() {
      return triangle;
   }
   
   public int getFlummiSize() {
      return triangle.size();
   }
}
