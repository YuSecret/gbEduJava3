import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainTest {
    static class MyTimerTask implements Runnable {
        public void run() {
            //Этот метод будет выполняться с нужным нам периодом
            try {
                runTest();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new MyTimerTask(), 0, 1, TimeUnit.MINUTES);
    }
    public static void runTest() throws MalformedURLException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println("---runTest is run!");
        File file = new File("C:\\TestsClass\\Main.class");
        if (file.exists()) {
            Class ch = URLClassLoader.newInstance(new URL[]{
                    file.toURL()}).loadClass("Main");

            Constructor constructor = ch.getConstructor();
            Object main = constructor.newInstance();
            Method[] ms = ch.getDeclaredMethods();

            for (Method m1: ms) {
                m1.setAccessible(true);
                System.out.println("Current method: "+m1.getName()+ " return type:" +m1.getReturnType().getName());

                if (m1.getName().equals("calculate")) {
                    //2 одноименных метода
                    if (m1.getReturnType().getName().equals("int")) {
                        int a=1;
                        int b=5;
                        int c=6;
                        int d=8;
                        int res;
                        res = (int) m1.invoke(main,a,b,c,d);
                        System.out.println("result int calculate:"+ res);
                    } else if (m1.getReturnType().getName().equals("float")) {
                        float a=1f;
                        float b=5f;
                        float c=6f;
                        float d=8f;
                        float res;
                        res = (float) m1.invoke(main,a,b,c,d);
                        System.out.println("result float calculate:"+ res);
                    }
                }
                else if (m1.getName().equals("printIsPositive")) {
                    int v = 10;
                    System.out.println("result printIsPositive: ");
                    m1.invoke(main,v);
                }
                else if (m1.getName().equals("isNegative")) {
                    int v = -10;
                    System.out.println("result isNegative: ");
                    m1.invoke(main,v);
                }
                else if (m1.getName().equals("printWelocome")) {
                    String s1 = "Vasya";
                    System.out.println("result printWelocome:");
                    m1.invoke(main,s1);
                }
                else if (m1.getName().equals("isLeapYear")) {
                    int y = 2020;
                    boolean res = (boolean) m1.invoke(main,y);
                    System.out.println("result isLeapYear: " + res);

                }
                else if (m1.getName().equals("checkTwoNumbers")) {
                    int first = 10;
                    int second = 5;
                    boolean res;
                    res = (boolean) m1.invoke(main, first, second);
                    System.out.println("result checkTwoNumbers:"+ res);
                }

            }
            System.out.println("---runTest is end!");
        }
        else {
            System.out.println("File C:/TestsClass/Main.class not exist");
        }

    }

}
