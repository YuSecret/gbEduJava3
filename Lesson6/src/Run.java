import java.security.PublicKey;

public class Run {
    /*
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    иначе в методе необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    */

    public static void main(String[] args) {

        int [] inputArray = { 1, 2, 4, 4, 2, 3, 4, 1, 4 };
        int [] resultArray = calcArray(inputArray);

        StringBuilder sb = new StringBuilder(" [ ");
        for (int i = 0; i < resultArray.length; i++) {
            if (i>0 && i==resultArray.length-1) {sb.append( resultArray[i] );}
            else {sb.append( resultArray[i] +", ");}
        }
        sb.append(" ] ");
        System.out.println(sb.toString());


   }

    public static int [] calcArray(int[] input) {
        int num=0;
        boolean find4=false;
        if (input.length==0) {return new int[] {};}
        for(int i =0; i <input.length; i++) {
            if (input[i]==4) {
                find4=true;
                num=i;
            }
        }
        if (!find4) {throw  new RuntimeException("4 not found");}

        if (num==input.length-1) {
            System.out.println("выход и возврат пустого");
            return new int[] {};}
        num++;
        System.out.println("индекс выборки с "+num +" по "+(input.length-1));
        System.out.println("размер массива "+(input.length-num));
        int [] result = new int [input.length - num];
        int j=0;
        for (int i=num; i <input.length; i++) {
            result[j] = input[i];
            j++;
        }
        return result;
    }

    /*
    2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */

    public static boolean find1or4int(int [] input) {
        boolean result = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i]==1 || input[i]==4) {
                result =true;
                break;
            }
        }
        return result;
    }
}
