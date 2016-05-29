package Schwarmverhalten;

public class VerhaltenPerfekterFlummi implements Verhalten {
   private Triangle triangle;
   
   public VerhaltenPerfekterFlummi(Triangle triangle) {
      this.triangle = triangle;
   }
   
   @Override
   public void update() {
      triangle.position.add(triangle.velocity);

      if (triangle.position.y>480 || triangle.position.y<0)
         triangle.velocity.y *= -1;
   }
}
