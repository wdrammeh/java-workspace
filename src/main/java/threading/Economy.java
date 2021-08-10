package threading;

import java.util.LinkedList;

/**
 * Illustration of a smooth economy using threads.
 * Production and consumption waits on each other as appropriate.
 */
public class Economy {

    public static void main(String[] args) {
        Market market = new Market();

//        create producer thread
        Thread produceThread = new Thread() {
            public void run() {
                try {
                    market.produce();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

//        create a consumer thread
        Thread consumeThread = new Thread() {
            public void run() {
                try {
                    market.consume();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

//        start both threads
        produceThread.start();
        consumeThread.start();
        try {
            produceThread.join();
            consumeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class Market {
        LinkedList<Integer> list;
        final int capacity;

        private Market(){
            list = new LinkedList<>();
            capacity = 2;
        }

        protected void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
//                    producer thread waits while list is full
                    while (list.size() == capacity) {
                        wait();
                    }
//                    after waiting
                    System.out.println("Producer produced "+ value);
                    list.add(value++);
//                    notify the consumer thread to consume
                    notify();
                    Thread.sleep(1_000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
//                    consumer thread waits while list is empty
                    while (list.size() == 0) {
                        wait();
                    }
//                    retrieve the first
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed "+val);

//                    wake the producer thread
                    notify();
//                    and sleep again
                    Thread.sleep(1_000);
                }
            }
        }
    }

}