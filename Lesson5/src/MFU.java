import java.util.TimerTask;

public class MFU {

    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String doc, int n) {
        synchronized (printLock) {
            System.out.println("Начало печати");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец печати");
        }

    }

    public void scan(String doc, int n) {
        synchronized (scanLock) {
            System.out.println("Начало сканирования");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец сканирования");
        }
    }

    public static void main(String[] args) {
        final MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 1", 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("Doc 3", 5);
            }
        }).start();

    }

}









//    void testSc() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 22);
//        calendar.set(Calendar.MINUTE, 13);
//        calendar.set(Calendar.SECOND, 0);
//
//        Date time = calendar.getTime();
//        Timer timer = new Timer();
//        timer.schedule(new RemindTask(), time);
//    }
//}
//
//class RemindTask extends TimerTask {
//
//    @Override
//    public void run() {
//        System.out.println("up!");
//    }
//}