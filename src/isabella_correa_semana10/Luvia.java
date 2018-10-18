package isabella_correa_semana10;


public class Luvia extends Thread {
	private Main app;
	float x, y, vely;
	int vida;
	private boolean alive;
	private boolean chocado;
	Luvia(Main app) {
		this.app = app;
		alive = true;
		y = -20;
		x = app.random(0, 500);
		chocado = false;
		this.vely = app.random(1, 5);
	}

	public void pintar() {
		app.fill(0, 0, 255);
		app.noStroke();
		app.ellipse(x, y, 20, 20);
	}

	public void mover() {
		y += vely;
	}

	public void run() {
		while (alive) {
			try {
				mover();

				sleep(16);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean isChocado() {
		return chocado;
	}
	public void setChocado(boolean chocado) {
		this.chocado = chocado;
	}
}
