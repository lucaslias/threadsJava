package view;

import controller.ThreadJogar;

public class Principal {

	public static int PlacarPar;
	public static int PlacarImpar;

	public static void main(String[] args) throws InterruptedException {

		int[] time_par = {2, 4, 6, 8, 10 };
		int[] time_impar = { 1, 3, 5, 7, 9 };
		

		Thread jogar1 = new ThreadJogar(time_par[0], time_impar[0]);
		Thread jogar2 = new ThreadJogar(time_par[1], time_impar[1]);
		Thread jogar3 = new ThreadJogar(time_par[2], time_impar[2]);
		Thread jogar4 = new ThreadJogar(time_par[3], time_impar[3]);
		Thread jogar5 = new ThreadJogar(time_par[4], time_impar[4]);
		
		jogar1.start();
		jogar2.start();
		jogar3.start();
		jogar4.start();
		jogar5.start();
		
		
		while((jogar1.isAlive() || jogar2.isAlive() || jogar3.isAlive() || jogar4.isAlive() || jogar5.isAlive())) {
				//teste se ainda nao acabou
		}
		
		
		if(PlacarPar > PlacarImpar) {
			System.out.println("\n \n O time par ganhou com " + PlacarPar +  " O time impar perdeu com " + PlacarImpar);

		}
			else if (PlacarPar < PlacarImpar){
			System.out.println("\n \n O time impar ganhou com " + PlacarImpar + " O time par perdeu com " + PlacarPar);
			}
		
				else {
					System.out.println("o jogo acabou empatado, ambos ficaram com " + PlacarImpar);
				}

	}


}