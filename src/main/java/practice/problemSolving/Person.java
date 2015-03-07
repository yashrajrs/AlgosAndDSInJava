package practice.problemSolving;

/**
 * Object representing Person.
 *
 * @author Yashraj R. Sontakke
 */

public class Person {

    public enum Gender {
        MALE, FEMALE;
    }

    private final String name;
    private final Gender gender;

    public Person(final String name, final Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
