package Schwarmverhalten;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import math.Vektor2D;

import org.lwjgl.opengl.Display;

import frame.BasisFenster;

public class Schwarmverhalten extends BasisFenster {
	private ObjektManager flock;
	private double speedFaktor = 0.3;

	public Schwarmverhalten() {
		super("Schwarmverhalten", 1024, 768);
		flock = ObjektManager.getExemplar();
		erzeugeBirds(200);
	}

	private void erzeugeBirds(int anz) {
		Random rand = ThreadLocalRandom.current();
		for (int i=0; i<anz; i++) {
			Bird bird = new Bird(new Vektor2D(this.getWidth()/2, this.getHeight()/2), 																	 // Position
							   				new Vektor2D(((rand.nextDouble() * 2) -1) * speedFaktor, ((rand.nextDouble() * 2) - 1) * speedFaktor),		 // Speed
							   				rand.nextDouble(), rand.nextDouble(), rand.nextDouble());					 								 // RGB	 
			flock.registriereBird(bird);
		} 
	}
	
	@Override
	public void renderLoop() {
		while (!Display.isCloseRequested()) {

			glClearColor(0.1f, 0.2f, 0.3f, 1);
			glClear(GL_COLOR_BUFFER_BIT);
			glMatrixMode (GL_PROJECTION);
			glLoadIdentity ();
			glOrtho (0, this.getWidth(), this.getHeight(), 0, 0, 1);
			glMatrixMode (GL_MODELVIEW);
			glDisable(GL_DEPTH_TEST);

			for (int i = 1; i<=flock.getAllBirds(); i++) {
				Bird bird = flock.getBird(i);
				bird.setVerhalten(new VerhaltenFlock(bird, this.getWidth(), this.getHeight()));
				bird.render();
				bird.update();
			}
			Display.update();
		}
	}

	public static void main(String[] args) {
		new Schwarmverhalten().start();
	}
}


