package isabella_correa_semana10;

import processing.core.PApplet;

public class Main extends PApplet {
	private Logica l;

	public static void main(String[] args) {
		PApplet.main("isabella_correa_semana10.Main");
	}
	@Override
	public void settings() {
		size(500, 500);
	}
	@Override
	public void setup() {
		l = new Logica(this);
		noCursor();
	}
	@Override
	public void draw() {
		background(255);
		l.pintar();
	}

	@Override
	public void mouseClicked() {
		l.reiniciar();
	}
}
