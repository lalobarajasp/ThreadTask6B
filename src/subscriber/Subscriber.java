package subscriber;

import java.util.concurrent.BlockingQueue;

public class Subscriber implements contract.Subscriber {
    private final String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void email(double average) {
        System.out.println(name + " received average: " + average);
    }

}
