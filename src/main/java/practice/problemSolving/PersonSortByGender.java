package practice.problemSolving;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of person objects that contain a name and gender,
 * sort the array such that all females are before males in the array.
 *
 * @author Yashraj R. Sontakke
 */
public class PersonSortByGender {


    public void sort(List<Person> persons) {
        Collections.sort(persons, new PersonComparator());
        System.out.println(persons.toString());

    }


    public class PersonComparator implements Comparator<Person> {

        public int compare(Person person1, Person person2) {
            if (person1 == null || person1.getGender() == null) {
                return 1;
            }
            if (person2 == null || person2.getGender() == null) {
                return 0;
            }
            if (person1.getGender() == person2.getGender()) {
                return 0;
            } else if (person1.getGender() == Person.Gender.MALE) {
                return 1;
            }
            return -1;
        }

    }


    public static void main(String[] args) {
        Person person1 = new Person("MALE1", Person.Gender.MALE);
        Person person2 = new Person("FEMALE1", Person.Gender.FEMALE);
        Person person3 = new Person("MALE2", Person.Gender.MALE);
        Person person4 = new Person("FEMALE2", Person.Gender.FEMALE);
        Person person5 = new Person("MALE3", Person.Gender.MALE);
        Person person6 = new Person("FEMALE3", Person.Gender.FEMALE);

        PersonSortByGender personSortByGender = new PersonSortByGender();
        personSortByGender.sort(Arrays.asList(person1, person2, person3, person4, person5, person6));
    }
}
