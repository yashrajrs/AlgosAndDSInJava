package practice.problemSolving.stackAndQueue;

import java.util.LinkedList;

/**
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in,
 * first out" basis. People must adopt either the "oldest" (based on arrival time) of
 * all animals at the shelter, or they can select whether they would prefer a dog or
 * a cat (and will receive the oldest animal of that type). They cannot select which
 * specific animal they would like. Create the data structures to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog and
 * dequeueCat.You may use the built-in LinkedList data structure.
 *
 * @author Yashraj R. Sontakke
 */
public class AnimalShelter_3_7 {
    public enum AnimalType {
        DOG, CAT;
    }

    public LinkedList<AnimalType> animalList = new LinkedList<AnimalType>();

    public void enqueue(final AnimalType animal) {
        animalList.add(animal);
    }

    public AnimalType dequeueAny() {
        return animalList.removeFirst();
    }

    public AnimalType dequeueDog() {
        if (animalList.peek() == AnimalType.DOG) {
            return animalList.removeFirst();
        }
        for (int i = 0; i < animalList.size(); i++) {
            if (AnimalType.DOG == animalList.get(i)) {
                return animalList.remove(i);
            }
        }
        return null;
    }

    public AnimalType dequeueCat() {
        if (AnimalType.CAT == animalList.peek()) {
            return animalList.removeFirst();
        } else {
            for (int i = 0; i < animalList.size(); i++) {
                if (AnimalType.CAT == animalList.get(i)) {
                    return animalList.remove(i);
                }

            }
            return null;
        }
    }

    public void printList() {
        System.out.println(animalList.toString());
    }

    public static void main(String[] args) {
        AnimalShelter_3_7 a = new AnimalShelter_3_7();

        a.enqueue(AnimalType.DOG);
        a.printList();
        a.enqueue(AnimalType.DOG);
        a.printList();
        a.enqueue(AnimalType.CAT);
        a.printList();
        a.enqueue(AnimalType.DOG);
        a.printList();
        a.enqueue(AnimalType.CAT);
        a.printList();
        System.out.println(a.dequeueCat());
        a.printList();
        System.out.println(a.dequeueDog());
        a.printList();
        a.enqueue(AnimalType.CAT);
        a.enqueue(AnimalType.DOG);
        a.printList();
        System.out.println(a.dequeueAny());
        a.printList();
    }
}
