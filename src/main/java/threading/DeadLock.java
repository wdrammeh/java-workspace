package threading;

/**
 * Illustrates how deadlock occurs.
 * Warning: this program is deadlock-prone!
 */
public  class DeadLock {
    private static final int SLEEP_TIME = 1_000;

    /**
     * Logic: thread1 will lock resource1 and sleeps,
     * by which time thread2 locked resource2 and sleeps as well.
     * When thread1 wakes from the sleeps it'll try locking resource2
     * which is locked by thread2, at the same time thread2 wakes and
     * tries locking resource1 which is locked by thread1.
     *
     * This causes the two threads to wait infinitely for the release
     * of each others' resources, hence a deadlock.
     */
    public static void main(String[] args) {
        String resource1 = "Resource one";
        String resource2 = "Resource two";

        // thread1 tries to lock resource1 then resource2
        Thread thread1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 successfully locked resource 1");
                    try {
                        sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2) {
                        System.out.println("Thread 1 successfully locked resource 2");
                    }
                }
            }
        };

        // thread2 tries to lock resource2 then resource1
        Thread thread2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 successfully locked resource 2");
                    try {
                        sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource1) {
                        System.out.println("Thread 2 successfully locked resource 1");
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}