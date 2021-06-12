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
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

class Renderer implements GLEventListener, KeyListener, ActionListener {
	private GLU glu = new GLU();
	private GLUT glut = new GLUT();
	private int texture;
	//Variables
	float rquad = 0.0f;
	float Tx = 0, Ty = 0;
	
	private GLCanvas display;
	private Timer animationTimer;
	private boolean animating;
	

	public Renderer(GLCanvas display) {
		this.display = display;

		startAnimation();
	}

	float rcircle = 45.0f;
	int refreshmill = 1;
	
	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();
		float theta;
     
		// vertex parameters is x,y,z of display, respectively.
		//gl.glMatrixMode(GL2.GL_MODELVIEW);
	    //gl.glLoadIdentity();
		// Clear the window if a background color
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
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
	  	gl.glTranslatef(-0.5f + Tx, 0.0f + Ty, -6.0f);
		gl.glBegin(GL2.GL_QUADS); // Draw A Quad
		gl.glColor3f(1.0f,1.0f,0.0f); // Blue Color of quad.
		gl.glVertex3f(-2.7f, 2.0f, 0.0f); // Top Left
		gl.glVertex3f(3.5f, 2.0f, 0.0f); // Top Right
		gl.glVertex3f(3.5f, -1.0f, 0.0f); // Bottom Right
		gl.glVertex3f(-2.7f, -1.0f, 0.0f); // Bottom Left
		gl.glEnd(); // Done Drawing The Quad
        
		//Quad
		gl.glLoadIdentity();
		gl.glRotatef(rquad, 0.0f, 1.0f, 0.0f);
		gl.glTranslatef(3.5f + Tx, 2.5f + Ty, -6.0f);
		gl.glBegin(GL2.GL_QUADS); // Draw A Quad
		gl.glColor3f(51.0f, 51.0f, 51.0f); // Blue Color of quad.
		gl.glVertex3f(-1.4f, 0.5f, 0.0f); // Top Left
		gl.glVertex3f(0.5f, 0.5f, 0.0f); // Top Right
		gl.glVertex3f(0.5f, -1.0f, 0.0f); // Bottom Right
		gl.glVertex3f(-1.4f, -1.0f, 0.0f); // Bottom Left
		gl.glEnd(); // Done Drawing The Quad
		
		//circle1
		int numVertices = 20;
		double radius = 0.95;
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glPushMatrix();
		gl.glTranslatef(5.0f + Tx, 0.0f + Ty, -6.0f);
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
		gl.glTranslatef(3.0f + Tx, 0.0f + Ty, -6.0f);
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
		
		rcircle -= 0.3f;
		gl.glFlush();
	}

	public void init(GLAutoDrawable gLDrawable) {
		System.out.println("init() called");

		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClearColor(0.5f, 0.3f, 0.5f, 0.9f);

		FPSCounter.StartCounter();
		gl.glEnable(GL2.GL_TEXTURE_2D);
		try{
		File im = new File("C:\\Users\\João Vitor\\Downloads\\openGL-java-master\\src\\jogl\\project\\data\\background.jpg");
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
			Ty++;

			break;
		case KeyEvent.VK_DOWN:
			Ty--;

			break;
		case KeyEvent.VK_LEFT:
			Tx--;

			break;
		case KeyEvent.VK_RIGHT:
			Tx++;
			;

			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void Animate() {
		FPSCounter.StopAndPost();
		for (int i = 0; i < 1000; i++) {
			HaInterseccao(new Ponto(i, 10), new Ponto(5, 5 * i), new Ponto(3, 3), new Ponto(4, 67));
		}
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

	/* ********************************************************************** */
	/*                                                                        */
	/* Calcula a interseccao entre 2 retas (no plano "XY" Z = 0) */
	/*                                                                        */
	/* k : ponto inicial da reta 1 */
	/* l : ponto final da reta 1 */
	/* m : ponto inicial da reta 2 */
	/* n : ponto final da reta 2 */
	/*                                                                        */
	/* s: valor do parâ€°metro no ponto de interseÂ�â€¹o (sobre a reta KL) */
	/* t: valor do parâ€°metro no ponto de interseÂ�â€¹o (sobre a reta MN) */
	/*                                                                        */
	/* ********************************************************************** */
	public ResultadoInterseccao intersec2d(Ponto k, Ponto l, Ponto m, Ponto n) {
		double det, s, t;

		det = (n.x - m.x) * (l.y - k.y) - (n.y - m.y) * (l.x - k.x);

		if (det == 0.0)
			return new ResultadoInterseccao(false, 0, 0);

		s = ((n.x - m.x) * (m.y - k.y) - (n.y - m.y) * (m.x - k.x)) / det;
		t = ((l.x - k.x) * (m.y - k.y) - (l.y - k.y) * (m.x - k.x)) / det;

		return new ResultadoInterseccao(true, s, t);
	}

	public boolean HaInterseccao(Ponto k, Ponto l, Ponto m, Ponto n) {
		ResultadoInterseccao resultado;

		resultado = intersec2d(k, l, m, n);
		if (!resultado.resultado)
			return false;
		if (resultado.s >= 0.0 && resultado.s <= 1.0 && resultado.t >= 0.0 && resultado.t <= 1.0)
			return true;
		else
			return false;
	}
}