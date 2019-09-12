package MyMultiThreading;

import java.util.concurrent.*;

public class MyThreadPoolExecutor1 {
    public static void main(String[] args) {
        ExecutorService executor1 = Executors.newCachedThreadPool();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 14; i++) {
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("current thread nums: " + executor.getPoolSize() +
                    ", thread num in queue: " + executor.getQueue().size() +
                    ", finished thread num: " + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println(taskNum + " is running");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("task " + taskNum + " finish");
    }
}
