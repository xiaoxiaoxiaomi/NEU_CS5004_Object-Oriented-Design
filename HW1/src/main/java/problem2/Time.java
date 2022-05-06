package problem2;

public class Time {
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    /**
     * Constructor, creating a new Time object, with the provided
     hours, minutes and seconds
     * @param hours - hours, encoded as Integer
     * @param minutes - minutes, encoded as Integer
     * @param seconds - seconds, encoded as Integer
     */
    public Time(Integer hours, Integer minutes, Integer seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Returns the hours
     * @return the hours
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * Sets hours to the given hours
     * @param hours - hours, encoded as Integer
     */
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * Returns the minutes
     * @return the minutes
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * Sets minutes to the given minutes
     * @param minutes - minutes, encoded as Integer
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /**
     * Returns the seconds
     * @return the seconds
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * Sets seconds to the given seconds
     * @param seconds - seconds, encoded as Integer
     */
    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
