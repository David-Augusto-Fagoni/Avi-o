package Controller;

import java.util.concurrent.Semaphore;

public class Avião extends Thread {
	private int j;
	private Semaphore norte;
	private Semaphore sul;
	public Avião (int j, Semaphore norte, Semaphore sul) {
		this.j = j;
	}
	public void run() {
		int Num = (int) (Math.random()*2);
		if (Num == 0){
			try {
				norte.acquire();
				long Tempo = (long) (Math.random()*5+3);
				System.out.println("O avião "+j+" esta manobrando");
				sleep(Tempo);
				System.out.println("O avião "+j+" esta taxiando");
				sleep((long) (Math.random()*6+5));
				System.out.println("O avião "+j+" esta decolando");
				sleep((long) (Math.random()*4+1));
				System.out.println("O avião "+j+" esta se afastando");
				sleep((long) (Math.random()*6+3));
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}finally {
				norte.release();
			}
			
		} else {
			try {

				sul.acquire();
				long Tempo = (long) (Math.random()*5+3);
				System.out.println("O avião "+j+" esta manobrando");
				sleep(Tempo);
				System.out.println("O avião "+j+" esta taxiando");
				sleep((long) (Math.random()*6+5));
				System.out.println("O avião "+j+" esta decolando");
				sleep((long) (Math.random()*4+1));
				System.out.println("O avião "+j+" esta se afastando");
				sleep((long) (Math.random()*6+3));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sul.release();
			}
		}
	}
}
