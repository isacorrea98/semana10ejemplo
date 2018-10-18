package isabella_correa_semana10;

import java.util.ArrayList;

public class Logica {
	private Main app;
	private Jugador jugador;
	private ArrayList<Luvia> bolas;
	private int contador, numeroBolas, perder, pantalla;

	Logica(Main app) {
		jugador = new Jugador(app);
		this.app = app;

		bolas = new ArrayList<Luvia>();
		contador = 0;
		numeroBolas = 0;
		perder = 0;
		pantalla = 0;

	}

	public void pintar() {
		
		switch(pantalla) {
		case 0:
			
			jugador.pintar();
			contador++;

			if (contador == 100) {
				numeroBolas++;

				for (int i = 0; i < numeroBolas; i++) {
					Luvia l = new Luvia(app);
					l.start();
					bolas.add(l);
				}

				contador = 0;
			}

			for (int i = 0; i < bolas.size(); i++) {
				bolas.get(i).pintar();
			}

			comer();
			
			break;
			
		case 1:
			
			app.textAlign(app.CENTER);
			app.textSize(40);
			app.text("PERDISTE", app.width/2, app.height/2);
			
			app.textAlign(app.CENTER);
			app.textSize(20);
			app.text("clic para volver a empezar",250, (app.height/2)+30);
			
			break;
		}
		
		
	}

	public void comer() {
		
		for (int j = 0; j < bolas.size(); j++) {
			
			if (app.dist(jugador.getX(), jugador.getY(), 
					bolas.get(j).getX(), bolas.get(j).getY()) < 20) {
				bolas.remove(j);
				jugador.setTam(jugador.getTam()+15);
				jugador.setPerdida(jugador.getPerdida()+app.radians(45));
				
				perder += 1;
				
				if ( perder == 8 ) {
					for (int i = 0; i < bolas.size(); i++) {
						bolas.removeAll(bolas);
					}
					pantalla = 1;
				}
			}
		}

	}
	
	public void reiniciar () {
		if ( pantalla == 1 ) {
			if ( app.mouseX > 0 && app.mouseX < app.width 
					&& app.mouseY > 0 && app.mouseY < app.height ) {
				
				pantalla = 0;
				contador = 0;
				numeroBolas = 0;
				jugador.setTam(30);
				jugador.setPerdida(app.radians(-90));
			}
		}
	}

}
