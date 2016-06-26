package Schwarmverhalten;

import math.Vektor2D;

public abstract class BewegendesObjekt extends BasisObjekt {
    public Vektor2D velocity;
    public Vektor2D currentVelocity;
    public Vektor2D acceleration;
    public Verhalten schwarm = null;

    public BewegendesObjekt(Vektor2D position, Vektor2D speed) {
        super(position);
        this.velocity = new Vektor2D(0, 0);
        this.acceleration = new Vektor2D(0, 0);
        this.currentVelocity = new Vektor2D(speed);
    }

    public void setVerhalten(Verhalten verhalten) {
        this.schwarm = verhalten;
    }

    public void update() {
        if (schwarm != null)
            schwarm.update();

    }

}
