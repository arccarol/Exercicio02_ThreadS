package controller;

import java.util.concurrent.Semaphore;

public class Exercicio02 extends Thread{
	
	private int idPrato;
	private int sopaC;
	private int lasanhaB;
	private int entrega;
	private int tempporc;
	private Semaphore semaforo;
	int percentS = 0;
	 int percentL = 0;

	
	
	public Exercicio02 (int idPrato, Semaphore semaforo) {
		
		this.idPrato = idPrato;
		this.semaforo = semaforo;
		
	}

	public void run() {
		
		pratoCozinhando();
		try {
			  percentual();;
			semaforo.acquire();
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}finally {
			pratoPronto();
			semaforo.release();
		}	
	}

	
	public void pratoCozinhando(){
		
		this.sopaC = numeroalearorio(500, 800);
		 this.lasanhaB = numeroalearorio(600, 1201);
				
		if (idPrato % 2 != 0) {
			System.out.println("Sopa de Cebola " +idPrato + " está sendo prepararado");
			} else {
				System.out.println("Lasanha Bolonhesa " +idPrato + " está sendo prepararado");
			}
	}
	
  public void pratoPronto() {
	  this.entrega = numeroalearorio(000, 500);
	  
		  try {
				Thread.sleep(this.entrega);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		  
		  if (idPrato % 2 != 0) {  
			System.out.println("A sopa" +idPrato + "foi entrega");
		  }
		  else { 
			  System.out.println("A lasanha" +idPrato +" foi entrega");
		  }
		  }
  

	  
  public void  percentual() {
	  
	 int somaL = 0;
	  int somaS = 0;
	  
	  this.tempporc = numeroalearorio(000, 100);
	  
	  while (percentS < 100 && percentL < 100) {
	  
	  try {
			Thread.sleep(this.tempporc);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	 
	  if(idPrato % 2 != 0 ) {

		  
		 somaS = somaS + this.sopaC;
		 
		  percentS = somaS / 100;

		 System.out.println("Percentual SOPA " +idPrato + " = " +percentS +"%"); 
	  
	  } else {
		 
		 somaL = somaL + this.lasanhaB;
		 percentL = somaL / 100;
		 System.out.println("Percentual LASANHA " +idPrato + " = " +percentL +"%");
  }
	  }
	  
	  
	  if(idPrato %2 != 0) {
		  
		  try {
				Thread.sleep(this.sopaC);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		System.out.println("A sopa " +idPrato + " está pronta para a entrega");
		
		
	  }else {
		  
		  try {
				Thread.sleep(this.lasanhaB);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		  
		System.out.println("A lasanha " +idPrato + " está pronta para a entrega");
	  }
	  }
  
	
	public int numeroalearorio(int min, int max) {
		Integer numeroaleatorio = min + (int)(Math.random() * (max - min));
		return numeroaleatorio;
		
	}
}
