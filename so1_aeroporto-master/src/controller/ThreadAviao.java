package controller;

import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread {
	
	private int idAviao;
	private Semaphore semaforo;
	private int lado;
	private static int posSaida;
	private static int ordemSaida;
	
	public ThreadAviao(int idAviao, Semaphore semaforo, int lado) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
		this.lado = lado;
	}
	
	@Override
	public void run() {
		try {			
			semaforo.acquire();
			AviaoParado();
			aviaoManobra();
			aviaotaxi();
			aviaoDecolando();
			aviaoAfastando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			AviaoSaiu();
		}
	}

	private void aviaoAfastando() {
		
		System.out.println("aviao " + idAviao + " esta se afastando");
		int afastar = (int) ((Math.random() * 8000) + 3000);
		try {
			sleep(afastar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void aviaoDecolando() {
		
		System.out.println("aviao " + idAviao + " esta decolando");
		int decolar = (int) ((Math.random() * 4000) + 1000);
		try {
			sleep(decolar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void aviaotaxi() {
		System.out.println("aviao " + idAviao + " esta taxiando");
		int taxi = (int) ((Math.random() * 10000) + 5000);
		try {
			sleep(taxi);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void aviaoManobra() {
		
		System.out.println("aviao " + idAviao + " vai iniciar a manobra");
		int manobra = (int) ((Math.random() * 7000) + 3000);
		try {
			sleep(manobra);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void AviaoSaiu() {
		posSaida ++;
		System.out.println("aviao " + idAviao + " foi o: " + posSaida + "º a decolar");
		
	}


	private void AviaoParado() {
		ordemSaida++;
		
		String ladodapista = null;
		switch(lado) {
			case 0: ladodapista = "norte";
			break;
			case 1: ladodapista = "sul";
			break;
		}
		System.out.println("aviao: " + idAviao + " vai ser o " + ordemSaida + "º a realizar o procedimento , utilizando a pista: " + ladodapista);
		
	}




	
	
	

}