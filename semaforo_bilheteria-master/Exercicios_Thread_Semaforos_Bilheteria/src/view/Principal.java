package view;

import controller.ThreadBilheteria;

public class Principal {

	public static void main(String[] args) {

		for(int i = 1; i<=300; i++) {
			int qtComprar = (int) ((Math.random()*4)+1);
			Thread bilheteria = new ThreadBilheteria(qtComprar, i);
			bilheteria.start();
		}
	}

}
