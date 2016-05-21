package Schwarmverhalten;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import math.Vektor2D;

public class VerhaltenZufaelligerFlummi implements Verhalten {
   private Flummi flummi;
   private Random rand = ThreadLocalRandom.current();
   
   public VerhaltenZufaelligerFlummi(Flummi flummi) {
      this.flummi = flummi;
   }
   
   @Override
   public void update() {
      flummi.position.add(new Vektor2D(0, rand.nextFloat()*2 - 1));

      if (flummi.position.y>480 || flummi.position.y<0)
         flummi.velocity.y *= -1;
   }
}
