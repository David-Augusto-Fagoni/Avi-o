package View;
import java.util.concurrent.Semaphore;

import Controller.Avião;

public class Main {

	public static void main(String[] args) {
		Semaphore Norte = new Semaphore(1);
		Semaphore Sul = new Semaphore(1);
		for (int J =0;J<12;J++) {
			Avião A = new Avião(J,Norte,Sul);
			A.start();
				
		}

	}

}
