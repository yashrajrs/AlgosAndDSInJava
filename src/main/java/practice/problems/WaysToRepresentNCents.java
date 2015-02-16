package practice.problems;

/**
 * Calculates the number of ways n cents can be represented using quarters (25 cents), dimes (10 cents),
 * nickels (5 cents) and pennies (1 cent).
 *
 * @author Yashraj R. Sontakke
 */
public class WaysToRepresentNCents {

    public Integer waysToRepresent(Integer nCents, Integer currentValue) {
        if (currentValue == nCents) {
            return 1;
        } else if (currentValue > nCents) {
            return 0;
        } else {
            return waysToRepresent(nCents, currentValue + 1)
                    + waysToRepresent(nCents, currentValue + 5)
                    + waysToRepresent(nCents, currentValue + 10)
                    + waysToRepresent(nCents, currentValue + 25);
        }

    }


    public static void main(String[] args) {
        WaysToRepresentNCents waysToRepresentNCents = new WaysToRepresentNCents();
        System.out.println("No of ways to represent 10 cents = " + waysToRepresentNCents.waysToRepresent(8, 0));
    }
}
