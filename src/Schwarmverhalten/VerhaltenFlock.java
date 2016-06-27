package Schwarmverhalten;

import math.Vektor2D;
import math.LineareAlgebra;

public class VerhaltenFlock implements Verhalten {
    private Bird bird;
    private double separationDist = 10;
    private ObjektManager flock;
    private int width, height;
    private Vektor2D target = new Vektor2D();
    Vektor2D help = new Vektor2D();
    Vektor2D nullVektor = new Vektor2D(0.0,0.0);

    public VerhaltenFlock(Bird bird, int width, int height) {
        this.bird = bird;
        this.target.x = width / 2;
        this.target.y = height / 2;
        this.width = width;
        this.height = height;
        this.flock = ObjektManager.getExemplar();
    }

    @Override
    public void update() {
        Vektor2D regelSeparation, regelAlignment, regelCohesion, regelSeek;
        Vektor2D velocity = new Vektor2D(0.0, 0.0);

        regelAlignment = this.alignment();
        regelCohesion = this.cohesion();
        //LineareAlgebra.show(regelCohesion);
        regelSeparation = this.separation();

        velocity.add(bird.getVelocity());
        velocity.add(regelAlignment);
        velocity.add(regelCohesion);
        velocity.add(regelSeparation);
/*
        if (LineareAlgebra.isEqual(velocity, nullVektor)) {
            LineareAlgebra.show(bird.currentVelocity);
            LineareAlgebra.show(regelAlignment);
            LineareAlgebra.show(regelSeparation);
            LineareAlgebra.show(regelCohesion);
            System.out.println("");
        }
*/
        bird.position.add(velocity);

        if (bird.position.y >= height)
            bird.position.y = 0;
        else if (bird.position.y <= 0)
            bird.position.y = height;

        if (bird.position.x >= width)
            bird.position.x = 0;
        else if (bird.position.x <= 0)
            bird.position.y = width;
    }

    public Vektor2D separation() {
        Vektor2D steeringForce = new Vektor2D(0.0, 0.0);
        for (int i = 0; i < flock.getAllBirds(); i++) {
            if (bird.getObjID() == i)
                continue;

            BasisObjekt bObj = flock.getBird(i);
            if (bObj instanceof Bird) {
                Bird bObjF = (Bird) bObj;
                if (LineareAlgebra.euklDistance(bird.getPosition(), bObjF.getPosition())
                        > separationDist) {
                    help.differenz(bird.getPosition(), bObjF.getPosition());
                    double length = help.length();
                    help.truncate(separationDist);
                    help.div(length);
                    steeringForce.add(help);
                }
            }
        }
        return steeringForce;
    }

    public Vektor2D alignment() {
        Vektor2D steeringForce = new Vektor2D(0.0, 0.0);
        int count = 0;
        for (int i = 0; i < flock.getAllBirds(); i++) {
            if (bird.getObjID() == i)
                continue;

            BasisObjekt bObj = flock.getBird(i);
            if (bObj instanceof Bird) {
                Bird bObjF = (Bird) bObj;
                if (LineareAlgebra.euklDistance(bird.getPosition(), bObjF.getPosition()) <
                        separationDist) {
                    steeringForce.add(bObjF.velocity);
                    count++;
                }
            }
        }
        if (count > 0) {
            steeringForce.mult(1.0 / count);
            steeringForce.sub(bird.currentVelocity);
        }
        return steeringForce;
    }

    public Vektor2D cohesion() {
        Vektor2D steeringForce = new Vektor2D(0.0, 0.0);
        int count = 0;
        for (int i = 0; i < flock.getAllBirds(); i++) {
            if (bird.getObjID() == i)
                continue;
            BasisObjekt bObj = flock.getBird(i);
            if (bObj instanceof Bird) {
                Bird bObjF = (Bird) bObj;
                steeringForce.add(bObjF.getPosition());
                count++;
            }
        }
        if (count > 0) {
            steeringForce.mult(1.0 / count);
            steeringForce.sub(bird.currentVelocity);
        }
        return steeringForce;
    }

}
