package jogl.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

 class Renderer implements GLEventListener, KeyListener, ActionListener {
	private GLU glu = new GLU();
	
	//Rotations
	float rc = 0.0f;
	float gc = 0.0f;
	float bc = 0.0f;
	float rcircle = 0.0f;
	float rquad = 0.0f;
	float rtri = 0.0f;
	int aux1 = 1;
	int aux2 = 2;

	private GLCanvas display;
	private Timer animationTimer;
	private boolean animating;

	public Renderer(GLCanvas display) {
		this.display = display;
		
		startAnimation();
	}
	
	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();	
		float theta;

		//vertex parameters is x,y,z of display, respectively.
		
		// Clear the window if a background color
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		//gl.glMatrixMode(GL2.GL_MODELVIEW0_ARB);
		//gl.glLoadIdentity();
		
		// Move Left 1.5 Units And Into The Screen 6.0
		gl.glTranslatef(-1.5f,0.0f,-6.0f);

		//Triangle
		gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);
		gl.glBegin(GL2.GL_TRIANGLES);       // Drawing Using Triangl.gles
		gl.glColor3f(0.8f, 0.2f, 0.1f);     // First Color
		gl.glVertex3f( 0.0f, 1.0f, 0.0f);   // Top
		//gl.glColor3f(0.1f, 1.0f, 0.4f);		// Second Color
		gl.glVertex3f(-1.0f,-1.0f, 0.0f);   // Bottom Left
		//gl.glColor3f(0.1f, 0.3f, 0.8f);		// Third Color
		gl.glVertex3f( 1.0f,-1.0f, 0.0f);   // Bottom Right
		gl.glEnd();                         // Finished Drawing The Triangl.gle

		gl.glLoadIdentity();
		
		//Move Right 3 Units
		gl.glTranslatef(1.5f,0.0f,-6.0f);

		//Quad
		gl.glRotatef(rquad, 0.0f, 1.0f, 0.0f);
		gl.glColor3f(rc,gc,bc);       // Blue Color of quad.
		gl.glBegin(GL2.GL_QUADS);             // Draw A Quad
		gl.glVertex3f(-1.0f, 1.0f, 0.0f);     // Top Left
		gl.glVertex3f( 1.0f, 1.0f, 0.0f);     // Top Right
		gl.glVertex3f( 1.0f,-1.0f, 0.0f);     // Bottom Right
		gl.glVertex3f(-1.0f,-1.0f, 0.0f);     // Bottom Left
		gl.glEnd();                           // Done Drawing The Quad
		
		gl.glLoadIdentity();
		
		//retangle
		gl.glTranslatef(-4.5f,0.0f,-6.0f);
		gl.glRotatef(0, 0.0f, 1.0f, 0.0f);
		gl.glColor3f(90/255.0f, 219/255.0f, 209/255.0f); // Blue Color of quad.
		gl.glBegin(GL2.GL_QUADS);             // Draw A Quad
		gl.glVertex3f(-2.0f, 1.0f, 0.0f);     // Top Left
		gl.glVertex3f( 1.0f, 1.0f, 0.0f);     // Top Right
		gl.glVertex3f( 1.0f,-1.0f, 0.0f);     // Bottom Right
		gl.glVertex3f(-2.0f,-1.0f, 0.0f);     // Bottom Left
		gl.glEnd();                           // Done Drawing The Quad
		
		gl.glLoadIdentity();
		
		//circle
		int numVertices = 20;
		double radius = 1.2;
		gl.glRotatef(rcircle, 0.0f, 1.0f, 0.0f);
		gl.glColor3f(10/255.0f, 33/255.0f, 247/255.0f);
		gl.glTranslatef(4.5f,0.0f,-6.0f);
        gl.glBegin(GL2.GL_POLYGON);
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
		gl.glLoadIdentity();

		if(aux1 == aux2){
			bc +=2.47/255.0f;
			gc +=3.3/255.0f;
			rc += 1.0/255.0f;
			aux2 +=50;
		}
		aux1 +=1;
		rtri += 0.5f;
		rquad += 1.0f;
	}
	public void init(GLAutoDrawable gLDrawable) {
		System.out.println("init() called");

		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClearColor(0.5f, 0.3f, 0.5f, 0.9f);
		
		FPSCounter.StartCounter();
	}

	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
		System.out.println("reshape() called: x = " + x + ", y = " + y + ", width = " + width + ", height = " + height);
		final GL2 gl = gLDrawable.getGL().getGL2();
		
		if(height <= 0) {
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
		//gl.glOrthof(0, 50, 0, 50, 0, 1);

		
		
	}

	public void dispose(GLAutoDrawable arg0) {
		System.out.println("dispose() called");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:
			// TODO
			break;
		case KeyEvent.VK_DOWN:
			// TODO
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
			HaInterseccao(new Ponto(i,10), new Ponto(5,5*i), new Ponto(3,3), new Ponto(4,67));
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
	/*  Calcula a interseccao entre 2 retas (no plano "XY" Z = 0)             */
	/*                                                                        */
	/* k : ponto inicial da reta 1                                            */
	/* l : ponto final da reta 1                                              */
	/* m : ponto inicial da reta 2                                            */
	/* n : ponto final da reta 2                                              */
	/*                                                                        */
	/* s: valor do par‰metro no ponto de interse‹o (sobre a reta KL)         */
	/* t: valor do par‰metro no ponto de interse‹o (sobre a reta MN)         */
	/*                                                                        */
	/* ********************************************************************** */
	public ResultadoInterseccao intersec2d(Ponto k, Ponto l, Ponto m, Ponto n)
	{
	    double det, s, t;
	    
	    det = (n.x - m.x) * (l.y - k.y)  -  (n.y - m.y) * (l.x - k.x);
	    
	    if (det == 0.0)
	        return new ResultadoInterseccao(false, 0, 0);
	    
	    s = ((n.x - m.x) * (m.y - k.y) - (n.y - m.y) * (m.x - k.x))/ det ;
	    t = ((l.x - k.x) * (m.y - k.y) - (l.y - k.y) * (m.x - k.x))/ det ;
	    
	    return new ResultadoInterseccao(true, s, t);
	}
	
	public boolean HaInterseccao(Ponto k, Ponto l, Ponto m, Ponto n)
	{
	    ResultadoInterseccao resultado;

	    resultado = intersec2d( k,  l,  m,  n);
	    if (!resultado.resultado) return false;
	    if (resultado.s>=0.0 && resultado.s <=1.0 && resultado.t>=0.0 && resultado.t<=1.0)
	        return true;
	    else return false;
	}
}