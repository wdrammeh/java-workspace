package threading;

/**
 * Synchronized thread model
 */
public class Sync {

    public static void main(String[] args){
        Prototype obj = new Prototype();
        T1 t1 = new T1("Thread 1", obj);
        T2 t2 = new T2("Thread 2", obj);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
         * In this case,
         * One have to await the other to finish its computation...
         */
    }


    private static class Prototype {

        private synchronized void printTable(String name, int n) {  //  method synchronized
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

    private static class T2 extends Thread {
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