package HW5;

public class Main {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void task1(){

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }
        Long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i /5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(" Time " + (System.currentTimeMillis() - a) + " ms.");

    }

    public static void task2(){

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }

        Long a = System.currentTimeMillis();
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        System.arraycopy(arr,0,a1,0,H);
        System.arraycopy(arr,H,a2,0,H);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length ; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i /5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length ; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i /5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1,0,arr,0,H);
        System.arraycopy(a2,0,arr,H,H);

        System.currentTimeMillis();
        System.out.println(" Time " + (System.currentTimeMillis() - a) + " ms.");

    }

    public static void main(String[] args) {
        task1();
        task2();
    }
}
