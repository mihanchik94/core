package lambda_and_streams.homework_2.task_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> result = new ArrayList<>();

        for (Integer integer : intList) {
            if (integer > 0 && integer % 2 == 0) {
                result.add(integer);
            }
        }
        sort(result); //Collections.sort(result); - можно сделать вот так
        for (Integer integer : result) {
            System.out.print(integer +" ");
        }
    }


    public static List<Integer> sort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return list;
    }
}