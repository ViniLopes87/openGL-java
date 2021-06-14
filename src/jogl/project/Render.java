package jogl.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.Timer;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

class Renderer implements GLEventListener, KeyListener, ActionListener {
	private GLU glu = new GLU();
	//private GLUT glut = new GLUT();
	private int texture;
	//Variables
	float rquad = 0.0f;
	float rcone = 0.0f;
	float maxCone = 0.0f;
	float Tx = 0, Ty = 0;
	float rcircle = 45.0f;
	float xRotated = 0.01f;
	float yRotated = 0.01f;
	float zRotated = 0.01f;
	double base=1;
	double height=1.5;
	int slices =25;
	int stacks =25;
	
	private GLCanvas display;
	private Timer animationTimer;
	private boolean animating;
	
	public Renderer(GLCanvas display) {
		this.display = display;

		startAnimation();
	}

	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();
		final GLUT glut = new GLUT();
		 
     
		// vertex parameters is x,y,z of display, respectively.
		// Clear the window if a background color
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glBindTexture(GL2.GL_TEXTURE_2D,texture);

		//road
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, -5.0f, -6.0f);
		gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
		gl.glBegin(GL2.GL_QUADS); 						  // Draw A Quad
	    gl.glColor3f(140/255.0f, 140/255.0f, 140/255.0f); // Color of road
		gl.glVertex3f(-31f, 4.0f, 0.0f); 				  // Top Left
	    gl.glVertex3f(31f, 4.0f, 0.0f); 				  // Top Right
	    gl.glVertex3f(31f, -1.0f, 0.0f); 				  // Bottom Right
	    gl.glVertex3f(-31f, -1.0f, 0.0f);				  // Bottom Left
	    gl.glEnd(); // Done Drawing The Quad
        
	    //tracks
		
	    //track1
	    gl.glLoadIdentity();
	    gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	    gl.glTranslatef(-8.5f, -3.5f, -6.0f);
	    gl.glBegin(GL2.GL_QUADS); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
	  	gl.glVertex3f(-2.0f, 0.15f, 0.0f); // Top Left
	  	gl.glVertex3f(2.0f, 0.15f, 0.0f); // Top Right
	  	gl.glVertex3f(2.0f, -0.20f, 0.0f); // Bottom Right
	  	gl.glVertex3f(-2.0f, -0.20f, 0.0f); // Bottom Left
	  	gl.glEnd(); // Done Drawing The Quad
	  	
	  	//track2
	  	gl.glLoadIdentity();
	    gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	    gl.glTranslatef(-2.5f, -3.5f, -6.0f);
	    gl.glBegin(GL2.GL_QUADS); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
	  	gl.glVertex3f(-2.0f, 0.15f, 0.0f); // Top Left
	  	gl.glVertex3f(2.0f, 0.15f, 0.0f); // Top Right
	  	gl.glVertex3f(2.0f, -0.20f, 0.0f); // Bottom Right
	  	gl.glVertex3f(-2.0f, -0.20f, 0.0f); // Bottom Left
	  	gl.glEnd(); // Done Drawing The Quad
	  	
	  	//track3
	  	gl.glLoadIdentity();
	    gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	    gl.glTranslatef(3.5f, -3.5f, -6.0f);
	    gl.glBegin(GL2.GL_QUADS); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
	  	gl.glVertex3f(-2.0f, 0.15f, 0.0f); // Top Left
	  	gl.glVertex3f(2.0f, 0.15f, 0.0f); // Top Right
	  	gl.glVertex3f(2.0f, -0.20f, 0.0f); // Bottom Right
	  	gl.glVertex3f(-2.0f, -0.20f, 0.0f); // Bottom Left
	  	gl.glEnd(); // Done Drawing The Quad
	  	
	    //track4
	  	gl.glLoadIdentity();
	    gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	    gl.glTranslatef(9.5f, -3.5f, -6.0f);
	    gl.glBegin(GL2.GL_QUADS); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
	  	gl.glVertex3f(-2.0f, 0.15f, 0.0f); // Top Left
	  	gl.glVertex3f(2.0f, 0.15f, 0.0f); // Top Right
	  	gl.glVertex3f(2.0f, -0.20f, 0.0f); // Bottom Right
	  	gl.glVertex3f(-2.0f, -0.20f, 0.0f); // Bottom Left
	  	gl.glEnd(); // Done Drawing The Quad
	  	
	  	//plate
	  	
	  	//rectangle
	  	gl.glLoadIdentity();
	    gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	    gl.glTranslatef(9.5f, 0.0f, -6.0f);
	    gl.glBegin(GL2.GL_QUADS); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
	  	gl.glVertex3f(0.05f, -1.0f, 0.0f); // Top Left
	  	gl.glVertex3f(0.05f, 1.0f, 0.0f); // Top Right
	  	gl.glVertex3f(-0.05f, 1.0f, 0.0f); // Bottom Right
	  	gl.glVertex3f(-0.05f, -1.0f, 0.0f); // Bottom Left
	  	gl.glEnd(); // Done Drawing The Quad
	  	

	    //extern triangle
	  	gl.glLoadIdentity();
	  	gl.glRotatef(0, 0.0f, 0.0f, 0.0f);
	  	gl.glTranslatef(9.5f, 2.1f, -6.0f);
	    gl.glBegin(GL2.GL_TRIANGLES); // Draw A Quad
	  	gl.glColor3f(251/255f, 26/255f, 82/255f); // White Color of faixa.
		gl.glVertex3f(-0.5f, -0.5f, 0.0f); // Bottom Left
		gl.glVertex3f(0.5f, -0.5f, 0.0f); // Bottom Right
		gl.glVertex3f(0.0f, -1.5f, 0.0f); // Top
	  	gl.glEnd(); // Done Drawing The Quad
	  	
	    //intern triangle
	  	gl.glLoadIdentity();
	  	gl.glRotatef(0, 0.0f, 0.0f, 0.0f);
	  	gl.glTranslatef(9.5f, 2.1f, -6.0f);
	    gl.glBegin(GL2.GL_TRIANGLES); // Draw A Quad
	  	gl.glColor3f(51.0f, 51.0f, 51.0f); // White Color of faixa.
		gl.glVertex3f(-0.25f, -0.65f, 0.0f); // Bottom Left
		gl.glVertex3f(0.25f, -0.65f, 0.0f); // Bottom Right
		gl.glVertex3f(0.0f, -1.25f, 0.0f); // Top
	  	gl.glEnd(); // Done Drawing The Quad
	  	
		//Bus

	    //rectangle
	  	gl.glLoadIdentity();
		gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
	  	gl.glTranslatef(-7.5f + Tx, -0.75f + Ty, -6.0f);
		gl.glBegin(GL2.GL_QUADS); // Draw A Quad
		gl.glColor3f(1.0f,1.0f,0.0f); // Blue Color of quad.
		gl.glVertex3f(-2.7f, 2.0f, 0.0f); // Top Left
		gl.glVertex3f(3.5f, 2.0f, 0.0f); // Top Right
		gl.glVertex3f(3.5f, -1.0f, 0.0f); // Bottom Right
		gl.glVertex3f(-2.7f, -1.0f, 0.0f); // Bottom Left
		gl.glEnd(); // Done Drawing The Quad
        
		//Quad
		gl.glLoadIdentity();
		gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
		gl.glTranslatef(-4.4f + Tx, 0.75f + Ty, -6.0f);
		gl.glBegin(GL2.GL_QUADS); // Draw A Quad
		gl.glColor3f(51.0f, 51.0f, 51.0f); // Blue Color of quad.
		gl.glVertex3f(-0.9f, 0.5f, 0.0f); // Top Left
		gl.glVertex3f(0.4f, 0.5f, 0.0f); // Top Right
		gl.glVertex3f(0.4f, -0.75f, 0.0f); // Bottom Right
		gl.glVertex3f(-0.9f, -0.75f, 0.0f); // Bottom Left
		gl.glEnd(); // Done Drawing The Quad
		
		//circle1
		int numVertices = 30;
		double radius = 0.65;
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glPushMatrix();
		gl.glTranslatef(-9.3f + Tx, -2.0f + Ty, -6.0f);
		gl.glRotatef(rcircle, 0.0f, 0.0f, 1.0f);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(125/255f,158/255f,240/255f);
		{
			double angle = 0;
			double angleIncrement = 2 * Math.PI / numVertices;
			for (int i = 0; i < numVertices; i++) {
				angle = i * angleIncrement;
				double x = radius * Math.cos(angle);
				double y = radius * Math.sin(angle);
				gl.glVertex2d(x, y);

			}
		}
		gl.glEnd();
		gl.glPopMatrix();

	    //circle2
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glPushMatrix();
		gl.glTranslatef(-4.8f + Tx, -2.0f + Ty, -6.0f);
		gl.glRotatef(rcircle, 0.0f, 0.0f, 1.0f);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(125/255f,158/255f,240/255f);
		{
			double angle = 0;
			double angleIncrement = 2 * Math.PI / numVertices;
			for (int i = 0; i < numVertices; i++) {
				angle = i * angleIncrement;
				double x = radius * Math.cos(angle);
				double y = radius * Math.sin(angle);
				gl.glVertex2d(x, y);
			}
		}
		gl.glEnd();
		gl.glPopMatrix();

		//sun
		int auxX = 0;
		int auxY = 0;
		int auxnumVertices = 30;
		double auxradius = 0.65;
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glPushMatrix();
		gl.glTranslatef(-9.3f + auxX, 5.0f + auxY, -6.0f);
		gl.glRotatef(0, 0.0f, 0.0f, 1.0f);
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(241/255f,208/255f,0/255f);
		{
			double angle = 0;
			double angleIncrement = 2 * Math.PI / auxnumVertices;
			for (int i = 0; i < auxnumVertices; i++) {
				angle = i * angleIncrement;
				double x = auxradius * Math.cos(angle);
				double y = auxradius * Math.sin(angle);
				gl.glVertex2d(x, y);

			}
		}
		gl.glEnd();
		gl.glPopMatrix();
		
		auxY -= .05f;
		auxX += .1f;
		rcircle -= 2.0f;
		rcone += 0.2f;
		gl.glFlush();
		xRotated += + 0.1;
		yRotated += 0.1;
    	zRotated += 0.1; 


		if(Tx == 15){
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		//cube
		gl.glLoadIdentity();
		gl.glTranslatef(-4.4f, 0.75f, -6.0f); // Move Right And Into The Screen

		gl.glRotatef(rquad,0.0f, 1.0f, 1.0f); // Rotate The Cube On X, Y & Z
		  
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

		gl.glColor3f(0.0f, 1.0f, 0.0f); // Set The Color To Green
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)

		gl.glColor3f(1.0f, 0.5f, 0.0f); // Set The Color To Orange
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad (Bottom)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad (Bottom)
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Bottom)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Bottom)

		gl.glColor3f(1.0f, 0.0f, 0.0f); // Set The Color To Red
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Front)

		gl.glColor3f(1.0f, 1.0f, 0.0f); // Set The Color To Yellow
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Back)
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Back)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Back)
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Back)

		gl.glColor3f(0.0f, 0.0f, 1.0f); // Set The Color To Blue
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Left)
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad (Left)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad (Left)

		gl.glColor3f(1.0f, 0.0f, 1.0f); // Set The Color To Violet
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Right)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Right)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad (Right)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad (Right)
		gl.glEnd(); // Done Drawing The Quad
        
		//cone
		gl.glLoadIdentity();
   		// traslate the draw by z = -4.0
    	// Note this when you decrease z like -8.0 the drawing will looks far , or smaller.
    	gl.glTranslatef(0.0f,0.0f,-6.0f);
    	// Red color used to draw.
    	gl.glColor3f(0.9f, 0.3f, 0.2f); 
    	// changing in transformation matrix.
    	// rotation about X axis
    	gl.glRotatef(xRotated,1.0f,0.0f,0.0f);
    	// rotation about Y axis
    	gl.glRotatef(yRotated,0.0f,1.0f,0.0f);
   		// rotation about Z axis
   		gl.glRotatef(zRotated,0.0f,0.0f,1.0f);
    	// scaling transfomation 
    	gl.glScalef(1.0f+maxCone,1.0f+maxCone,1.0f+maxCone);
    	// built-in (glut library) function , draw you a sphere.
    	glut.glutSolidCone(base,height,slices,stacks);
    	 // Flush buffers to screen
    	
    	//sphere
    	gl.glLoadIdentity();
    	
    	gl.glTranslatef(5.0f,0.0f,-6.0f);
    	
    	gl.glColor3f(-51f,-51f,-51f);
    	
    	glut.glutWireSphere(1.0, 15, 15);	
        
    	//paralelepipedo
    	gl.glLoadIdentity();
    	
    	gl.glTranslatef(-3.4f, -3.0f, -6.0f);
    	
    	gl.glBegin(GL2.GL_QUADS);
    	
    	gl.glColor3f(0.0f, 1.0f, 0.0f); // Set The Color To Green
		gl.glVertex3f(1.0f, 1.0f, -5.0f); // Top Right Of The paralelepipedo (Top)
		gl.glVertex3f(-1.0f, 1.0f, -5.0f); // Top Left Of The Quad paralelepipedo (Top)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The paralelepipedo (Top)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The paralelepipedo (Top)

		gl.glColor3f(1.0f, 0.5f, 0.0f); // Set The Color To Orange
		gl.glVertex3f(1.0f, -1.0f, -5.0f); // Top Right Of The  paralelepipedo(Bottom)
		gl.glVertex3f(-1.0f, -1.0f, -5.0f); // Top Left Of The  paralelepipedo(Bottom)
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The paralelepipedo (Bottom)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The  paralelepipedo(Bottom)

		gl.glColor3f(1.0f, 0.0f, 0.0f); // Set The Color To Red
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The paralelepipedo (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The paralelepipedo (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The paralelepipedo (Front)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The paralelepipedo (Front)

		gl.glColor3f(1.0f, 1.0f, 0.0f); // Set The Color To Yellow
		gl.glVertex3f(1.0f, -1.0f, -5.0f); // Bottom Left Of The paralelepipedo (Back)
		gl.glVertex3f(-1.0f, -1.0f, -5.0f); // Bottom Right Of The paralelepipedo (Back)
		gl.glVertex3f(-1.0f, 1.0f, -5.0f); // Top Right Of The paralelepipedo (Back)
		gl.glVertex3f(1.0f, 1.0f, -5.0f); // Top Left Of The paralelepipedo (Back)

		gl.glColor3f(0.0f, 0.0f, 1.0f); // Set The Color To Blue
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The paralelepipedo (Left)
		gl.glVertex3f(-1.0f, 1.0f, -5.0f); // Top Left Of The paralelepipedo (Left)
		gl.glVertex3f(-1.0f, -1.0f, -5.0f); // Bottom Left Of The paralelepipedo (Left)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The paralelepipedo(Left)

		gl.glColor3f(1.0f, 0.0f, 1.0f); // Set The Color To Violet
		gl.glVertex3f(1.0f, 1.0f, -5.0f); // Top Right Of The paralelepipedo (Right)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The paralelepipedo (Right)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The paralelepipedo (Right)
		gl.glVertex3f(1.0f, -1.0f, -5.0f); // Bottom Right Of The paralelepipedo (Right)
    	
    	gl.glEnd();
    	
		}
	}
	public void init(GLAutoDrawable gLDrawable) {
		System.out.println("init() called");

		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClearColor(132/255f, 208/255f, 250/255f, 98/255f);

		FPSCounter.StartCounter();
		gl.glEnable(GL2.GL_TEXTURE_2D);
		try{
		File im = new File("C:\\Users\\Berg\\arthur\\opengl-gc\\src\\jogl\\project\\databackground.jpg");
		Texture t = TextureIO.newTexture(im, true);	
		texture = t.getTextureObject(gl);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
		System.out.println("reshape() called: x = " + x + ", y = " + y + ", width = " + width + ", height = " + height);
		final GL2 gl = gLDrawable.getGL().getGL2();

		if (height <= 0) {
			height = 1;
		}
		final float h = (float) width / height;

		// Define the area to be occupied by the openGl inside the window
		gl.glViewport(0, 0, width, height);

		// Reset the coordinate system before modifying
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();

		glu.gluPerspective(45_0f, h, 1.0, 20.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		// gl.glOrthof(0, 50, 0, 50, 0, 1);

	}

	public void dispose(GLAutoDrawable arg0) {
		System.out.println("dispose() called");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:
			if(Ty < 0){
				Ty++;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(Ty > -3){
				Ty--;
			}
			break;
		case KeyEvent.VK_LEFT:	
			if(Tx > 0){
				Tx--;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(Tx < 15){
				Tx++;
				if(Tx == 15){
					
				}
			}
			break;
		case KeyEvent.VK_R:
			rquad -=0.2f;
		break;
		case KeyEvent.VK_A:
			maxCone += 0.02f;
		break;
		case KeyEvent.VK_D:
			maxCone -= 0.02f;
		break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void Animate() {
		FPSCounter.StopAndPost();
	}

	public void startAnimation() {
		if (!animating) {
			if (animationTimer == null) {
				animationTimer = new Timer(0, this);
			}
			animationTimer.start();
			animating = true;
		}
	}

	public void pauseAnimation() {
		if (animating) {
			animationTimer.stop();
			animating = false;
		}
	}

	/** Funcao chamada a cada frame **/
	@Override
	public void actionPerformed(ActionEvent e) {
		Animate();
		display.repaint();
	}
}