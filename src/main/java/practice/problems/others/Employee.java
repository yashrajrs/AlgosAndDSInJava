package practice.problems.others;

/**
 * Employee object to hold employee information.
 *
 * @author Yashraj R. Sontakke
 */
public class Employee {
    private final Integer id;
    private final String name;
    private final String city;

    /**
     * The constructor for {@link Employee}
     *
     * @param id   the employee id
     * @param name the employee name
     * @param city the employee city
     */
    public Employee(final Integer id, final String name, final String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Retrieves the employee id.
     *
     * @return the employee id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieves the employee name.
     *
     * @return the employee name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the employee city.
     *
     * @return the employee city.
     */
    public String getCity() {
        return city;
    }
}
