package lambda_and_streams.homework_2.task_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> people = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            people.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long underAges = people.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + underAges);
        System.out.println();

        System.out.println("Фамилии призывников: ");
        List<String> conscripts = people.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getSurname).toList();
        conscripts.forEach(System.out::println);
        System.out.println();

        System.out.println("Работоспособное население: ");
        people.stream()
                .filter(person -> person.getAge() >= 18 && person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getSex().equals(Sex.WOMAN) && person.getAge() <= 60
                        || person.getSex().equals(Sex.MAN) && person.getAge() <= 65).toList()
                .forEach(person -> System.out.println(person.toString()));
    }
}