package testing.homework_1.task_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
        assertThat(sut.search(users, user -> user.getName().equals("Tanya")), is(expected));
    }

    @Test
    public void whenFilterAge() {
        List<User> expected = List.of(
                new User("Petya", 7),
                new User("Tanya", 15),
                new User("Denis", 16)
        );
        assertThat(sut.search(users, user -> user.getAge() < 20), is(expected));
    }

    @Test
    public void whenEmptyByAge() {
        List<User> expected = List.of();
        assertThat(sut.search(users, user -> user.getAge() > 70), is(expected));
    }

    @Test (expected = NullPointerException.class)
    public void whenPredicateIsNull() {
        Predicate<User> pred = null;
        sut.search(users, pred);
    }

    @Test
    public void whenFilterPartOfName() {
        assertThat(sut.search(users, user -> user.getName().contains("ya")),
                containsInAnyOrder(
                        new User("Tanya", 70),
                        new User("Tanya", 15),
                        new User("Petya", 7)));
    }

    @Test
    public void whenEmptyByName() {
        assertThat(sut.search(users, user -> user.getName().equals("Ilya")), is(emptyCollectionOf(User.class)));
    }
}