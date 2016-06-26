package Schwarmverhalten;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import math.Vektor2D;

public class Bird extends BewegendesObjekt {
    private static int objCounter = 0;
    private double r, g, b;
    public double Distance;
    
    public static double maxSpeed = 0.1;

    public Bird() {
        this(new Vektor2D(0, 0), new Vektor2D(maxSpeed, maxSpeed), 1, 1, 0);
    }

    public Bird(Vektor2D position, Vektor2D currentVelocity) {
        this(position, currentVelocity, 1, 1, 0);
    }

    public Bird(Vektor2D position, Vektor2D currentVelocity, double r, double g, double b) {
        super(position, currentVelocity);
        this.Distance = 15;
        this.r=r;
        this.g=g;
        this.b=b;
        this.id = ++objCounter;
    }
    
    @Override
    public void render() {
        glColor3d(r, g, b);
        glBegin(GL_TRIANGLES);
	        glVertex2d(10 + position.x, 10 + position.y);
	        glVertex2d(20 + position.x, 10 + position.y);
	        glVertex2d(15 + position.x, 20 + position.y);
	        
        glEnd();
    }

	public Vektor2D getPosition() {		
		return new Vektor2D(position.x, position.y);
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public Vektor2D getVelocity() {
		return this.velocity;
	}
	public int getObjID() {
		return this.id;
	}
}

