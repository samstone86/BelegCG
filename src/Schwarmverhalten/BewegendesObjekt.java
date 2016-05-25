package Schwarmverhalten;

import math.Vektor2D;

public abstract class BewegendesObjekt extends BasisObjekt {
   public Vektor2D velocity;
   public Verhalten schwarm = null;
   
   public BewegendesObjekt(Vektor2D position, Vektor2D velocity) {
      super(position);
      this.velocity = new Vektor2D(velocity);
   }
      
   public void setVerhalten(Verhalten verhalten) {
      this.schwarm = verhalten;
   }

   public void update() {
      if (schwarm!=null)
         schwarm.update();
   }
}
