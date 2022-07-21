package lambda_and_streams.homework_1.task_1;

import java.util.function.*;

/**
 * В случае реализации деления как BinaryOperator<Integer> divide = (x, y) -> x / y
 * отсутсвует проверка на то, что второй аргумент не равен 0. В связи с этим программа может выбросить исключение ArithmeticException.
 */

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = Integer::sum;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y == 0) {
            System.err.println("Ошибка! Деление на 0!");
            return 0;
        }
        return x / y;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}