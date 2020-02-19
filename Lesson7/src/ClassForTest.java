import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ClassForTest {

    public static void main(String[] args) throws Exception {
        Class c = T1.class;
        T1 t1 = new T1(1, "new name1");
        Method[] methods = c.getDeclaredMethods();

        init (methods, BeforeSuite.class, AfterSuite.class, t1);
        start(c, t1);
        end(methods, AfterSuite.class, t1);

    }
    public static void init(Method[] methods, Class BeforeSuite, Class AfterSuite, T1 t1) throws InvocationTargetException, IllegalAccessException {
        //Поиск аннотаций Before и After и вызов before
        int countBefore=0;
        int countAfter=0;
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite)) {
                countBefore++;
            }
            if (o.isAnnotationPresent(AfterSuite)) {
                countAfter++;
            }
        }
        if (countBefore!= 1) {throw new RuntimeException("Кол-во методов помеченых BeforeSuite не соответствует 1");}
        if (countAfter!= 1) {throw new RuntimeException("Кол-во методов помеченых AfterSuite не соответствует 1");}
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite)) {
                o.invoke(t1);
            }
        }
    }
    public static void end(Method[] methods, Class AfterSuite, T1 t1) throws InvocationTargetException, IllegalAccessException {
        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite)) { o.invoke(t1); }
        }
    }
    public static void start(Class c, T1 t1) throws Exception{
        Method[] methods = c.getDeclaredMethods();
        Map<Integer, ArrayList<Method>> hm = new TreeMap<>(Comparator.reverseOrder());

        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {

                Integer key = o.getAnnotation(Test.class).priority();
                if (hm.get(key) !=null) {
                    ArrayList arrayList = hm.get(key);
                    arrayList.add(o);
                }
                else {
                    ArrayList<Method> arrayList = new ArrayList<>();
                    arrayList.add(o);
                    hm.put(o.getAnnotation(Test.class).priority(), arrayList);
                }

            }
        }

        for (Map.Entry<Integer, ArrayList<Method>> entry : hm.entrySet()) {
            System.out.printf("key = %s, value = %s\r\n", entry.getKey(), entry.getValue());
            ArrayList <Method> arrayList = entry.getValue();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).invoke(t1);
            }

        }
    }
}
