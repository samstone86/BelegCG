package Schwarmverhalten;

public class VerhaltenPerfekterFlummi implements Verhalten {
   private Triangle flummi;
   
   public VerhaltenPerfekterFlummi(Triangle flummi) {
      this.flummi = flummi;
   }
   
   @Override
   public void update() {
      flummi.position.add(flummi.velocity);

      if (flummi.position.y>480 || flummi.position.y<0)
         flummi.velocity.y *= -1;
   }
}
