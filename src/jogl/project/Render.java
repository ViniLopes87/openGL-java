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

class Renderer implements GLEventListener, KeyListener, ActionListener {
	// private GLU glu = new GLU();
	Byte R;
	Byte G;
	Byte B;
	private GLCanvas display;
	private Timer animationTimer;

	private boolean animating;

	public Renderer(GLCanvas display) {
		this.display = display;
		
		startAnimation();
	}
	
	
	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();

		// Limpa a tela coma cor de fundo
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

		gl.glMatrixMode(GL2.GL_MODELVIEW0_ARB);
		gl.glLoadIdentity();

		//Triangle
		gl.glBegin(GL2.GL_TRIANGLES);
		
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glVertex2f(1.0f, 1.0f);
		
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glVertex2f(3.0f, 1.0f);
		
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glVertex2f(2.0f, 3.0f);
		
		gl.glEnd();

		//Quad
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(100.0f, 0.0f, 0.0f);
		gl.glVertex2i(9, 6);
		
		gl.glColor3f(0.0f, 167.0f, 0.0f);
		gl.glVertex2i(6, 6);
		
		gl.glColor3f(0.0f, 0.0f, 133.0f);
		gl.glVertex2i(6, 3);

		gl.glColor3f(168.0f, 122.0f, 0.0f);
		gl.glVertex2i(9, 3);
		
		gl.glEnd();


		//vertex parameters is x,y,z of display, respectively.
		// gl.glLineWidth(3);
		// gl.glColor3f(1, 0, 0);

		// gl.glBegin(GL2.GL_LINES);
		// gl.glVertex2f(0, 0);
		// gl.glVertex2f(5, 5);
		// gl.glEnd();

		// gl.glLineWidth(3);
		// gl.glColor3f(0, 1, 0);
		// gl.glBegin(GL2.GL_LINES);
		// gl.glVertex2f(5, 5);
		// gl.glVertex2f(10, 0);
		// gl.glEnd();
		
		

		gl.glFlush();
	}

	public void init(GLAutoDrawable gLDrawable) {
		System.out.println("init() called");

		GL2 gl = gLDrawable.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
		
		FPSCounter.StartCounter();
	}

	public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
		System.out.println("reshape() called: x = " + x + ", y = " + y + ", width = " + width + ", height = " + height);
		final GL2 gl = gLDrawable.getGL().getGL2();

		// Reset the coordinate system before modifying
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// Define a area a ser ocupada pela área OpenGL dentro da Janela
		gl.glViewport(0, 0, width, height);
		gl.glOrthof(0, 10, 0, 10, 0, 1);

		// Define os limites lógicos da área OpenGL dentro da Janela
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
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