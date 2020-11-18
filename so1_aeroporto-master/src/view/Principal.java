package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAviao;


public class Principal {
	
	public static void main(String[] args) {
	
	int permissoes = 1;
	Semaphore semaforo = new Semaphore(permissoes);
	
	for (int idAviao = 1; idAviao <= 4; idAviao++) {
		
		int lado = (int) ((Math.random()*2));
		
		if(lado == 0) {
			Thread aviao_norte = new ThreadAviao(idAviao, semaforo, lado);
			aviao_norte.start();
			
		}else {
		
			Thread aviao_sul = new ThreadAviao(idAviao, semaforo, lado);
			aviao_sul.start();
		
		}
		
	}

	
	}

}