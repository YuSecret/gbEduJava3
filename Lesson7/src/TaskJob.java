public class TaskJob {
    private final static int ARR_LENGTH = 5;
    private static String curMethod="";
    private static int cpos = 0;
    public static int rowV = 0;
    public static int rowN = ARR_LENGTH-1;
    public static int colR = ARR_LENGTH-1;
    public static int colL = 0;
    public static void main(String[] args) {
        int[][] arr = new int[ARR_LENGTH][ARR_LENGTH];
        //инициализация
        for (int i = 0; i < ARR_LENGTH; i++) {
            for (int j = 0; j < ARR_LENGTH; j++) {
                arr[i][j] = -1;
            }
        }
        printArr(arr);
        //заполнение

        int iter = 0;
        while (!isFull(arr) ) {
            obhod(arr);
            iter++;
        }
        printArr(arr);
    }

    public static void printArr(int[][] arr) {
        System.out.println("");
        System.out.print("   ");
        for (int x = 0; x < ARR_LENGTH; x++) {
            System.out.print(x+".  ");
        }
        System.out.println("");
        for (int y = 0; y < ARR_LENGTH; y++) {
            System.out.print(y+". ");
            for (int x = 0; x < ARR_LENGTH; x++) {
                System.out.print(arr[y][x] + "  ");
            }
            System.out.println("");
        }
    }
    public static void obhod (int[][] arr) {
        if (curMethod =="" || curMethod == "bottomToTop") {
            curMethod = "leftToRight";
            obhodLeftToRight(arr);
            rowV++;
        } else if (curMethod == "leftToRight") {
            curMethod = "topToBottom";
            obhodTopToBottom(arr);
            colR--;
        } else if (curMethod == "topToBottom") {
            curMethod = "rightToLeft";
            obhodRightToLeft(arr);
            rowN--;
        } else if (curMethod == "rightToLeft") {
            curMethod = "bottomToTop";
            obhodBottomToTop(arr);
            colL++;
        } else {
            throw new RuntimeException("Не предвиденный параметр curMethod");
        }
    }

    public static void obhodLeftToRight(int[][] arr) {
        for (int x = colL; x <= colR ; x++) {
            arr[rowV][x] = cpos;
            cpos++;
        }
    }
    public static void obhodTopToBottom(int[][] arr) {
        for (int y = rowV; y <= rowN ; y++) {
            arr[y][colR] = cpos;
            cpos++;
        }
    }
    public static void obhodRightToLeft(int[][] arr) {
        for (int x = colR ; x >= colL ; x--) {
            arr[rowN][x] = cpos;
            cpos++;
        }
    }
    public static void obhodBottomToTop(int[][] arr) {
        for (int y = rowN; y >= rowV ; y--) {
            arr[y][colL] = cpos;
            cpos++;
        }
    }
    public static boolean isFull(int[][] arr) {
        boolean res = true;
        for (int i = 0; i < ARR_LENGTH; i++) {
            for (int j = 0; j < ARR_LENGTH; j++) {
               if (arr[i][j]==-1) {
                   return false;
                }
            }
        }
        return res;
    }
}
