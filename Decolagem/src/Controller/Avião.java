package Controller;

import java.util.concurrent.Semaphore;

public class Avião extends Thread {
	private int j;
	private Semaphore norte;
	private Semaphore sul;
	public Avião (int j, Semaphore norte, Semaphore sul) {
		this.j = j;
		this.norte = norte;
		this.sul = sul;
	}
	public void run() {
		int Num = (int) (Math.random()*2);
		if (Num == 0){
			try {
				norte.acquire();
				System.out.println("O avião "+j+" entrou na pista norte");
				long Tempo = (long) (Math.random()*4001+3000);
				System.out.println("O avião "+j+" esta manobrando");
				sleep(Tempo);
				System.out.println("O avião "+j+" esta taxiando");
				sleep((long) (Math.random()*5001+5000));
				System.out.println("O avião "+j+" esta decolando");
				sleep((long) (Math.random()*3001+1000));
				System.out.println("O avião "+j+" esta se afastando");
				sleep((long) (Math.random()*5001+3000));
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}finally {
				norte.release();
			}
			
		} else {
			try {

				sul.acquire();
				System.out.println("O avião "+j+" entrou na pista sul");
				long Tempo = (long) (Math.random()*4001+3000);
				System.out.println("O avião "+j+" esta manobrando");
				sleep(Tempo);
				System.out.println("O avião "+j+" esta taxiando");
				sleep((long) (Math.random()*5001+5000));
				System.out.println("O avião "+j+" esta decolando");
				sleep((long) (Math.random()*3001+1000));
				System.out.println("O avião "+j+" esta se afastando");
				sleep((long) (Math.random()*5001+3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sul.release();
			}
		}
	}
}
