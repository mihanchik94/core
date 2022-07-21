package lambda_and_streams.homework_1.task_2;

public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.err::println;

        Worker worker = new Worker(listener, errorListener);
        worker.start();
    }
}