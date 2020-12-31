package threading;

/**
 * Implements non-synchronize thread model
 */
public class NonSync {

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        T1 t1 = new T1("Thread 1", prototype);
        T2 t2 = new T2("Thread 2", prototype);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
         * Those two threads, because does not 'synchronize' each other, will
         * execute independently of either -despite using the same resource
         */
    }


    private static class Prototype {

        private void printTable(String name, int n) {  //  method not synchronized
            for (int i = 1; i <= 5; i++) {
                System.out.println(name+" computes "+(n * i));
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class T1 extends Thread {
        private String name;
        private Prototype proto;


        private T1(String name, Prototype proto){
            this.name = name;
            this.proto = proto;
        }

        @Override
        public void run(){
            proto.printTable(name, 5);
        }
    }

    private static class T2 extends Thread{
        private Prototype proto;
        private String name;

        private T2(String name, Prototype proto){
            this.name = name;
            this.proto = proto;
        }

        @Override
        public void run(){
            proto.printTable(name, 10);
        }
    }

}