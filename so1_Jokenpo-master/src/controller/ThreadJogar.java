package controller;

import view.Principal;

public class ThreadJogar extends Thread{
	
	private int jogadorPar;
	private int jogadorImpar;
	private int pontosJogadorPar = 0;
	private int pontosJogadorImpar = 0;
	

	public ThreadJogar(int jogadorPar, int jogadorImpar) {
		this.jogadorPar = jogadorPar;
		this.jogadorImpar = jogadorImpar;
	}

	@Override
	public void run() {
		duelo();	
		registrarPontos();
	}

	private void duelo() {
		
		int jogadaTime1;
		int jogadaTime2;
		String[] jogadas = {"","Papel","Tesoura","Pedra"};
		
		while(pontosJogadorPar < 3 && pontosJogadorImpar < 3) {
			
			jogadaTime1 = (int)((Math.random()*3)+1);
			jogadaTime2 = (int)((Math.random()*3)+1);
			
			if(jogadaTime1 == 1 && jogadaTime2 == 3) {
				System.out.println("O jogador " + jogadorPar + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorImpar + " jogou " + jogadas[jogadaTime2]);
				pontosJogadorPar++;
			}
			
				else if(jogadaTime1 == 2 && jogadaTime2 == 1) {
					System.out.println("O jogador " +jogadorPar + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorImpar + " jogou " + jogadas[jogadaTime2]);
					pontosJogadorPar++;
				}
			
					else if(jogadaTime1 == 3 && jogadaTime2 == 2) {
						System.out.println("O jogador " + jogadorPar + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorImpar + " jogou " + jogadas[jogadaTime2]);
						pontosJogadorPar++;
					}
			
						else if(jogadaTime1 == jogadaTime2) {
							System.out.println("Empate o jogador " + jogadorPar + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorImpar + " jogou " + jogadas[jogadaTime2]);
						}
			
							else {
								System.out.println("O jogador " + jogadorPar + " jogou " + jogadas[jogadaTime1] + " e o jogador " + jogadorImpar + " jogou " + jogadas[jogadaTime2]);
								pontosJogadorImpar++;
							}

		}
		
		if(pontosJogadorPar == 3) {
			System.out.println("O vencedor do duelo entre os jogadores " + jogadorPar + " e " + jogadorImpar + " foi o " + jogadorPar);
		} else {
			System.out.println("O vencedor do duelo entre os jogadores " + jogadorPar + " e " + jogadorImpar + " foi o " + jogadorImpar);
		}
		
	}
	

	private void registrarPontos() {
		
		Principal.PlacarPar += pontosJogadorPar;
		Principal.PlacarImpar += pontosJogadorImpar;
		
	}
	
	
}
