package testing.homework_1.task_1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchUser {
    public List<User> search(List<User> users, Predicate<User> pred) {
        return users.stream().filter(pred).collect(Collectors.toList());
    }
}