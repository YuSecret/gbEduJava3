import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Double dnums[] = {1.0 , 2.0 , 3.0 , 4.0 , 5.0};
        TBox<Double> dob = new TBox<>(dnums);
        System.out.println(dob.toString());
        dob.changeTwoElements(1,4);
        System.out.println(dob.toString());
        //2. Написать метод, который преобразует массив в ArrayList;
        System.out.println(dob.convertToArrayList());
        //3. Лямда
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию:");
        String s = scanner.next();

        if (!s.equals("+") && !s.equals("-")) {
            System.out.println("Недопустимая операция");
            return;
        }
        System.out.println("Введите первое число:");
        int i = scanner.nextInt();
        System.out.println("Введите второе число:");
        int j = scanner.nextInt();
        Operable o;
        if (s.equals("+")) {
            o = (x, y) -> x + y;
        } else {
            o = (x, y) -> x - y;
        }
        System.out.println(o.calc(i,j));
    }
    interface Operable {
       int calc(int x,int y);
    }
}

