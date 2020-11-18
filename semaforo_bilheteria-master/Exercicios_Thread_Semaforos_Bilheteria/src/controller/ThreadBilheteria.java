package controller;


public class ThreadBilheteria extends Thread {

	private int qtComprar;
	private int id;
	private static int qtIngressos = 100;
	private int ok = 0;

	public ThreadBilheteria(int qtComprar, int id) {
		this.qtComprar = qtComprar;
		this.id = id;
	}

	@Override
	public void run() {
		logar();
		if(ok==0) {
			comprar();
		}
		if(ok==0) {
			validar();
		}

	}
	
	private void logar() {
		int qtLogar = (int) ((Math.random() * 1951) + 50);
		try {
			sleep(qtLogar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (qtLogar > 1000) {
			System.out.println(id + " recebeu um timeout ao tentar logar, depois de " + qtLogar + "ms");
			ok = -1;
		}
	}
	
	private void comprar() {
		int qtCompra = (int) ((Math.random() * 2000) + 1000);
		try {
			sleep(qtCompra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (qtCompra > 2500) {
			System.out.println(id + " recebeu um timeout ao tentar comprar, depois de " + qtCompra + "ms");
			ok = -1;
		}
	}

	private void validar() {
		if (qtIngressos >= qtComprar) {
			qtIngressos -= qtComprar;
			System.out.println(id + " conseguiu comprar " + qtComprar + " ingressos");
			System.out.println("Restam " + qtIngressos + " ingressos");
		} else {
			System.out.println(id + " não conseguiu comprar ingressos o suficiente");
		}
	}





}
