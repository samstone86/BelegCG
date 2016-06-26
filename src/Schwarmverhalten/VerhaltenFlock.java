package Schwarmverhalten;

import math.Vektor2D;
import math.LineareAlgebra;

public class VerhaltenFlock implements Verhalten {
    private Bird bird;
    private double panicDist = 10;
    private ObjektManager flock;
    private int width, height;
    private Vektor2D target = new Vektor2D();
    Vektor2D targetFlee = new Vektor2D(300, 300);
    Vektor2D targetPoint = new Vektor2D(300, 300);
    Vektor2D help = new Vektor2D();
    Vektor2D nullVektor = new Vektor2D(0.0, 0.0);

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
        Vektor2D velocity = new Vektor2D(0.0,0.0);

        //velocity.x = 0.0;
        //velocity.y = 0.0;

        regelAlignment = this.alignment();
        regelCohesion = this.cohesion();
        regelSeparation = this.separation();
        //regelAlignment.mult(0.9);

        //regelCohesion.mult(0.01);

        velocity.add(bird.currentVelocity);
        velocity.add(regelAlignment);
        velocity.add(regelCohesion);
        velocity.add(regelSeparation);


        if (LineareAlgebra.isEqual(velocity, nullVektor)) {
            LineareAlgebra.show(bird.currentVelocity);
            LineareAlgebra.show(regelAlignment);

        /*  LineareAlgebra.show(regelSeparation);
            LineareAlgebra.show(regelCohesion); */
            System.out.println("");
        }

        bird.position.add(velocity);

/*
        if (bird.position.y >= height || bird.position.y <= 0)
            bird.currentVelocity.y *= -1;

        if (bird.position.x >= width || bird.position.x <= 0)
            bird.currentVelocity.x *= -1;
*/

        if (bird.position.y >= height)
            bird.position.y = 0;
        else if (bird.position.y <= 0)
            bird.position.y = height;

        if (bird.position.x >= width)
            bird.position.x = 0;
        else if(bird.position.x <= 0)
            bird.position.y = width;
    }

    public Vektor2D seek(Vektor2D target) {
        help.differenz(target, bird.getPosition());
        help.normalize();
        help.mult(bird.getMaxSpeed());
        help.sub(bird.velocity);
        return help;
    }

    public Vektor2D arrive(Vektor2D target) {
        help.differenz(target, bird.getPosition());
        double dist = help.length();
        double speed = bird.getMaxSpeed() * (dist / 300);
        speed = Math.min(speed, bird.getMaxSpeed());
        help.mult(speed / dist);
        help.sub(bird.velocity);
        return help;
    }

    public Vektor2D flee(Vektor2D target) {
        // nur bei bestimmter Distanz, das Fliehen aktivieren
        if (LineareAlgebra.euklDistance(bird.getPosition(), targetFlee) > panicDist)
            return new Vektor2D(0, 0);
        // Fliehen
        help.differenz(bird.getPosition(), targetFlee);
        help.mult(bird.getMaxSpeed());
        help.normalize();
        help.sub(bird.velocity);
        return help;
    }

    public Vektor2D separation() {
        Vektor2D steeringForce = new Vektor2D(0.0, 0.0);
        for (int i = 0; i < flock.getBirdSize(); i++) {
            if (bird.id == i)
                continue;
            BasisObjekt bObj = flock.getBird(i);
            if (bObj instanceof Bird) {
                Bird bObjF = (Bird) bObj;
                if (LineareAlgebra.euklDistance(bird.getPosition(), bObjF.getPosition())
                        > (bird.Distance + bObjF.Distance)) {
                    Vektor2D help = new Vektor2D();
                    help = LineareAlgebra.sub(bird.getPosition(), bObjF.getPosition());
                    double length = help.length();
                    help.truncate(panicDist);
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
        for (int i = 0; i < flock.getBirdSize(); i++) {
            if (bird.id == i)
                continue;
            BasisObjekt bObj = flock.getBird(i);
            if (bObj instanceof Bird) {
                Bird bObjF = (Bird) bObj;
                if (LineareAlgebra.euklDistance(bird.getPosition(), bObjF.getPosition()) <
                        (bird.Distance + bObjF.Distance)) {
                    steeringForce.add(bObjF.currentVelocity);
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
        for (int i = 0; i < flock.getBirdSize(); i++) {
            if (bird.id == i)
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
