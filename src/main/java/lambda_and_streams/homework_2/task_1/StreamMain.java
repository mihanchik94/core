package lambda_and_streams.homework_2.task_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        intList.stream()
                .filter(num -> num > 0)
                .filter(num -> num % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(x -> System.out.print(x +" "));
    }
}