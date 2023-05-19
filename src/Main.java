import publisher.Publisher;
import subscriber.Subscriber;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Publisher publisher1 = new Publisher(queue);
        Publisher publisher2 = new Publisher(queue);

        Subscriber subscriber1 = new Subscriber("Eduardo");

        Thread t1 = new Thread(publisher1);
        Thread t2 = new Thread(publisher2);

        t1.start();
        t2.start();

        try {
            while (true) {
                double average = queue.take();
                subscriber1.email(average);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}