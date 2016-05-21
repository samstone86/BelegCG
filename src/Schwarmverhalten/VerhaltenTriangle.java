package Schwarmverhalten;

import math.Vektor2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VerhaltenTriangle implements Verhalten {
   private Triangle triangle;
   private Random rand = ThreadLocalRandom.current();

   public VerhaltenTriangle(Triangle triangle) {
      this.triangle = triangle;
   }
   
   @Override
   public void update() {
      triangle.position.add(new Vektor2D(0, rand.nextFloat()*2 - 1));

      if (triangle.position.y>480 || triangle.position.y<0)
         triangle.velocity.y *= -1;
   }
}
