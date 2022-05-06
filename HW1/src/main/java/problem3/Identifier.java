package problem3;

public class Identifier {
    private final String username;
    private final Integer year;
    private final String country;

    /**
     * Constructor, creating a new ID object, with the provided
     username, year and country
     * @param username - username, encoded as String
     * @param year - the year the account has been created, encoded as Integer
     * @param country - the country where the account was created, encoded as String
     */
    public Identifier(String username, Integer year, String country) {
        this.username = username;
        this.year = year;
        this.country = country;
    }

    /**
     * Returns the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the year
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Returns the country
     * @return the country
     */
    public String getCountry() {
        return country;
    }
}
