import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
    private Random random;
    private Queue<Integer> queue;

    public CarQueue() {
        random = new Random();
        queue = new ArrayDeque<>();
        queue.add(random.nextInt(4));
        queue.add(random.nextInt(4));
        queue.add(random.nextInt(4));
        queue.add(random.nextInt(4));
        queue.add(random.nextInt(4));
        queue.add(random.nextInt(4));
    }
    
    public int deleteQueue() {
		int randomInt;
		randomInt=queue.remove();
		return randomInt;
		
	}

    public int getNextDirection() {
        return queue.remove();
    }

    public void addToQueue() {
        Runnable addToQueueTask = () -> {
            try {
                while (true) {
                    queue.add(random.nextInt(4));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t = new Thread(addToQueueTask);
        t.start();
    }
}
