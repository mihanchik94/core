package lambda_and_streams.homework_1.task_2;

@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}