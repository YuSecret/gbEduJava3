import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.*;

public class MainClass {

    public static void main(String[] args) throws Exception {
//        Class c = Cat.class;
//        Field[] fields = c.getDeclaredFields();
//
//        for (Field o: fields) {
//            System.out.println(o);
//        }
//
//        Cat cat = new Cat("Barsik", "White", 2);
//        Class c = Cat.class;
//        cat.info1();
//        Field f = c.getDeclaredField("age");
////        f.setAccessible(true);
////        f.set(cat, 10);
////        cat.info1();
//
////        Method m = c.getDeclaredMethod("info2");
////        m.setAccessible(true);
////        m.invoke(cat);
//
//        int mods = f.getModifiers();
//        System.out.println(mods);
//        if (Modifier.isPublic(mods)) {
//            System.out.println(c.getSimpleName() + " public");
//        }

//        Class ch = URLClassLoader.newInstance(new URL[]{
//                new File("C:\\12345").toURL()}).loadClass("Human");
//
//        Constructor constructor = ch.getConstructor(String.class);
//        Object human = constructor.newInstance("Bob");
//        Method[] ms = ch.getDeclaredMethods();
//
//        for (Method m1: ms) {
//            System.out.println(m1);
//        }
//
//
//        Method m = ch.getDeclaredMethod("info");
//        m.invoke(human);

        Class c = Cat.class;
        Cat cat = new Cat("C", "A", 2);
        Method[] methods = c.getDeclaredMethods();
        for (Method o : methods) {
            if (o.isAnnotationPresent(MyAnon.class)) {
                System.out.println(o.getAnnotation(MyAnon.class).priotity());
                o.invoke(cat);
            }
        }
    }
}