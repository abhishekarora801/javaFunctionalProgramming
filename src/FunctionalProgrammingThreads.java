import java.util.stream.IntStream;

public class FunctionalProgrammingThreads {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++){
                    System.out.println(Thread.currentThread().getId()+ " " +i);
                }
            }
        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//
//        Thread thread2 = new Thread(runnable);
//        thread2.start();
//
//        Thread thread3 = new Thread(runnable);
//        thread3.start();
        Runnable runnable2 = () -> {
            IntStream.range(0, 10000).forEach(x -> System.out.println(Thread.currentThread().getId()+ " " +x));
        };
        Thread thread4 = new Thread(runnable2);
        thread4.start();
        Thread thread23 = new Thread(runnable2);
        thread23.start();
        Thread thread34 = new Thread(runnable2);
        thread34.start();
    }
}
