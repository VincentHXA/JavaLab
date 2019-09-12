package MyMultiThreading;

import sun.font.TextRecord;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadLocal {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) {
        final MyThreadLocal myThreadLocal = new MyThreadLocal();

        myThreadLocal.set();
        System.out.println(myThreadLocal.getLong());
        System.out.println(myThreadLocal.getString());

        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    myThreadLocal.set();
                    System.out.println(myThreadLocal.getLong());
                    System.out.println(myThreadLocal.getString());
                }
            });
        }
        service.shutdown();

        System.out.println(myThreadLocal.getLong());
        System.out.println(myThreadLocal.getString());
    }
}
