import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class MainSchedule {
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date() + " start work");
//                try {
//                    Thread.sleep(random.nextInt(5000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(new Date() + " end work");
//            }
//        }, 0, 1000L, TimeUnit.MILLISECONDS);


//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//        executorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date() + " start work");
//                try {
//                    Thread.sleep(random.nextInt(1000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(new Date() + " end work");
//            }
//        }, 0, 1000L, TimeUnit.MILLISECONDS);

//        MainSchedule mainSchedule = new MainSchedule();
//        mainSchedule.testSc();


//        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(3);
//        abq.add("abc");
//        abq.add("abc");
//        abq.add("abc");
//
//        Boolean res1 = abq.offer("asd");
//        Boolean res2 = abq.offer("asd", 100, TimeUnit.MILLISECONDS);
//
//        abq.put("as");
//
//        abq.take();
//
        //   Vector<String> vector = new Vector<>();

//        CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList<>();
//
//        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
//
//        Map<String, String> hm = Collections.synchronizedMap(new HashMap<>());

//        Semaphore smp = new Semaphore(4);
//
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        smp.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(1);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    smp.release();
//                }
//            });
//        }
//        service.shutdown();

//        CountDownLatch cdl = new CountDownLatch(10);
//
//        for (int i = 0; i < 10; i++) {
//            int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(w + " -1");
//                    try {
//                        Thread.sleep((int)Math.random() * 300000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(w + " -2");
//                    cdl.countDown();
//                }
//            }).start();
//        }
//        cdl.await();
//
//        System.out.println("END!");

//        CyclicBarrier cb = new CyclicBarrier(10);
//
//        for (int i = 0; i < 20; i++) {
//            int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(w + " start");
//                    try {
//                        Thread.sleep((int) Math.random() * 5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(w + " ready");
//                    try {
//                        cb.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(w + " end");
//
//                }
//            }).start();
//        }


//        ReentrantLock r1 = new ReentrantLock();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();
//                System.out.println(1);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(2);
//                r1.unlock();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                r1.lock();
//                System.out.println(3);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(4);
//                r1.unlock();
//            }
//        }).start();


        AtomicInteger ai = new AtomicInteger(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ai.incrementAndGet();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ai.decrementAndGet();
                }
            }
        }).start();


        System.out.println(ai);
    }


    void testSc() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.MINUTE, 10);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);
    }

}

class RemindTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("up!");
    }
}
