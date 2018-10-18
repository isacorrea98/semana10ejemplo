package isabella_correa_semana10;

import processing.core.PApplet;

public class Jugador {
	private PApplet app;
	private int x,y,tam;
	private boolean isVivo;
	
	private float perdida;
	
	
	public Jugador(PApplet app) {
		
		this.app=app;
		tam=30;
		isVivo=true;
		
		perdida=app.radians(-90);
		
	}
	
	public void pintar() {
		x=app.mouseX;
		y=app.mouseY;
		app.noStroke();
		app.ellipseMode(app.CENTER);
		app.fill(0, 255, 0);
		app.ellipse(x, y, tam, tam);
		
		
		app.fill(255,0,0);
		app.arc(x, y, tam-5, tam-5, app.radians(-90), perdida);
		
		if(perdida>=app.radians(270)){
			isVivo=false;
		}
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getPerdida() {
		return perdida;
	}

	public void setPerdida(float perdida) {
		this.perdida = perdida;
	}

	public boolean isVivo() {
		return isVivo;
	}

	public void setVivo(boolean isVivo) {
		this.isVivo = isVivo;
	}
	
	
}


