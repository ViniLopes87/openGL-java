package jogl.project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Main 
{   
    public static void main(String[] args) 
    {
    	// Configura OpenGL Versao 2
    	GLProfile profile = GLProfile.get(GLProfile.GL2);
    	GLCapabilities capabilities = new GLCapabilities(profile);
    	
    	// Cria canvas
    	GLCanvas glcanvas = new GLCanvas(capabilities);
    	
    	Renderer render = new Renderer(glcanvas);
    	
    	// Adiciona classe contendo as interfaces de callback
    	glcanvas.addGLEventListener((GLEventListener) render);	
    	glcanvas.addKeyListener((KeyListener) render);
    	
    	// Define o tamanho inicial da janela grafica do programa
    	glcanvas.setSize( 1280, 720 );

    	// Cria janela
        JFrame frame = new JFrame( "Projeto OpenGL" );
        // Liga o canvas com a janela
        frame.getContentPane().add( glcanvas);
        // Finaliza o programa quando a janela e fechada
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );
    }
}