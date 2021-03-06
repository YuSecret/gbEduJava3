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
    public void scanNetwork(String doc, int n) {
        synchronized (scanLock) {
                System.out.println("Начало сканирования в сеть");
                for (int i = 0; i < n; i++) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Конец сканирования в сеть");
        }
    }
    public void scanPrint(String doc, int n) {
        synchronized (scanLock) {
            synchronized (printLock) {
                System.out.println("Начало сканирования на бумагу");
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Конец сканирования  на бумагу");
            }
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
                mfu.scanNetwork("Doc 2", 5);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scanPrint("Doc 3", 5);
            }
        }).start();

    }
}