package jogl.example;

public class Ponto{
	public float x,y,z;
	
	public Ponto(float x, float y, float z) {
		set(x, y, z);
	}
	
	public Ponto(float x, float y) {
		set(x, y, 0);
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void imprime() {
		System.out.println("("+x+", "+y+")");
	}
}