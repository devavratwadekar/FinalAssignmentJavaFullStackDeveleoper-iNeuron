package in.ineuron.main;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerExample {
	private static final int QUEUE_CAPACITY = 10;
	private static final int NUM_ITERATIONS = 20;

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

		Thread producerThread = new Thread(new Producer(queue));
		Thread consumerThread = new Thread(new Consumer(queue));

		producerThread.start();
		consumerThread.start();
	}

	static class Producer implements Runnable {
		private final Queue<Integer> queue;
		private final Random random;

		public Producer(Queue<Integer> queue) {
			this.queue = queue;
			this.random = new Random();
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					int number = random.nextInt(100);
					synchronized (queue) {
						while (queue.size() == QUEUE_CAPACITY) {
							System.out.println("Queue is full, waiting...");
							queue.wait();
						}
						queue.add(number);
						System.out.println("Produced: " + number);
						queue.notifyAll();
					}
					Thread.sleep(random.nextInt(1000)); // Simulate some processing time
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	static class Consumer implements Runnable {
		private final Queue<Integer> queue;

		public Consumer(Queue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					synchronized (queue) {
						while (queue.isEmpty()) {
							System.out.println("Queue is empty, waiting...");
							queue.wait();
						}
						int number = queue.poll();
						System.out.println("Consumed: " + number);
						queue.notifyAll();
					}
					Thread.sleep(500); // Simulate some processing time
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
