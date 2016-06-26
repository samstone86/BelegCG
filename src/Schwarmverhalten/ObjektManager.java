package Schwarmverhalten;

import java.util.HashMap;

public class ObjektManager {
   private HashMap<Integer, Bird> bird;
   private static ObjektManager exemplar = new ObjektManager();

   private ObjektManager() {
      bird = new HashMap<Integer, Bird>();
   }

   public static ObjektManager getExemplar() {
      return exemplar;
   }

   public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException("Clonen ist nicht erlaubt");
   }
   
   public void registriereBird(Bird obj) {
      bird.put(new Integer(obj.id), obj);
   }

   public void entferneBird(Bird obj) {
      bird.remove(obj);
   }
   
   public Bird getBird(int objID) {
      return bird.get(new Integer(objID));
   }
   
   public HashMap<Integer, Bird> getBirdMap() {
      return bird;
   }
   
   public int getBirdSize() {
      return bird.size();
   }
   
   
}
