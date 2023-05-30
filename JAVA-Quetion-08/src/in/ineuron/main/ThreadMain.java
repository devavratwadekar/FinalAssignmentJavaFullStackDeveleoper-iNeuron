package in.ineuron.main;

class EvenThread extends Thread {
	public void run() {
		for (int i = 2; i <= 10; i += 2) {
			System.out.println("Even Thread: " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class OddThread extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i += 2) {
			System.out.println("Odd Thread: " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadMain {
	public static void main(String[] args) {
		EvenThread evenThread = new EvenThread();
		OddThread oddThread = new OddThread();

		evenThread.start();
		oddThread.start();
	}
}
