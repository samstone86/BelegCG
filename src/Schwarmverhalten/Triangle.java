package Schwarmverhalten;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import math.Vektor2D;

public class Triangle extends BewegendesObjekt {
    private static int objCounter = 0;
    private double d;
    private double r, g, b;

    public Triangle() {
        this(new Vektor2D(0, 0), new Vektor2D(2, 0), 1, 1, 0);
    }

    public Triangle(Vektor2D position, Vektor2D velocity) {
        this(position, velocity, 1, 1, 0);
    }

    public Triangle(Vektor2D position, Vektor2D velocity, double r, double g, double b) {
        super(position, velocity);
        this.d = d;
        this.r=r;
        this.g=g;
        this.b=b;
        this.id = ++objCounter;
    }

    @Override
    public void render() {
        glColor3d(r, g, b);
        glBegin(GL_TRIANGLES);
	        glVertex2d(20 + position.x, 20 + position.y);
	        glVertex2d(30 + position.x, 40 + position.y);
	        glVertex2d(40 + position.x, 20 + position.y);
        glEnd();
    }
}

