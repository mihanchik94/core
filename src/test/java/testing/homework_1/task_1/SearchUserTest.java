package testing.homework_1.task_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SearchUserTest {
    private static SearchUser sut;
    private static List<User> users;

    @Before
    public void setUp() {
        sut = new SearchUser();
        users = List.of(
                new User("Petya", 7),
                new User("Tanya", 70),
                new User("Tanya", 15),
                new User("Denis", 16),
                new User("Artur", 24)
        );
    }

    @After
    public void finish() {
        sut = null;
    }

    @Test
    public void whenFilterName() {
        List<User> expected = List.of(
                new User("Tanya", 70),
                new User("Tanya", 15)
        );
        assertEquals(sut.search(users, user -> user.getName().equals("Tanya")), expected);
    }

    @Test
    public void whenFilterAge() {
        List<User> expected = List.of(
                new User("Petya", 7),
                new User("Tanya", 15),
                new User("Denis", 16)
        );
        assertEquals(sut.search(users, user -> user.getAge() < 20), expected);
    }

    @Test
    public void whenEmpty() {
        List<User> expected = List.of();
        assertEquals(sut.search(users, user -> user.getAge() > 70), expected);
    }
}