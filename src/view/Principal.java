package view;

import java.util.concurrent.Semaphore;

import controller.Exercicio02;

public class Principal {
	
	public static void main(String args []) {
		
		Semaphore semaforo = new Semaphore(1);
		for (int idPrato = 1; idPrato < 6; idPrato++) {
			Exercicio02 show = new Exercicio02(idPrato, semaforo);
			show.start();
			
					}
		}

}
