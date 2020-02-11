import java.util.concurrent.*;

public class MainCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int[] soure = {1,2,3,4};

        int[] res1 = new int[2];
        int[] res2 = new int[2];

        System.arraycopy(soure, 0, res1,0, res1.length);
        System.arraycopy(soure, 2, res2,0, res2.length);

        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res1.length; i++) {
                    res += res1[i];
                }
                return res;
            }
        };

        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res2.length; i++) {
                    res += res2[i];
                }
                return res;
            }
        };

        Future<Integer> f1 = executorService.submit(callable1);
        Future<Integer> f2 = executorService.submit(callable2);

        System.out.println(f1.get() + f2.get());
        executorService.shutdown();
    }
}
