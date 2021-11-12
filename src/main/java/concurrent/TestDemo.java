package concurrent;

public class TestDemo {

    public static void main(String[] args) {
        Thread myThread=new MyThread();
        myThread.start();
    }
}
