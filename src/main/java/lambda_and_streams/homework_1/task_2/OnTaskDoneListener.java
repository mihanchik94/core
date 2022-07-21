package lambda_and_streams.homework_1.task_2;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}