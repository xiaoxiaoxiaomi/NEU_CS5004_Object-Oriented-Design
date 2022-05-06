package problem2;

public class Delivery {
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    /**
     * Constructor, creating a new Delivery object, with the provided
     start location, end location, start time, end time
     * @param startLocation - start location, encoded as String
     * @param endLocation - end location, encoded as String
     * @param startTime - start time, encoded as Time
     * @param endTime - end time, encoded as Time
     */
    public Delivery(String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the start location
     * @return the start location
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Sets start location to the given start location
     * @param startLocation - start location, encoded as String
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Returns the end location
     * @return the end location
     */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Sets end location to the given end location
     * @param endLocation - end location, encoded as String
     */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Returns the start time
     * @return the start time
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets start time to the given start time
     * @param startTime - start time, encoded as Time
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the end time
     * @return the end time
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Sets end time to the given end time
     * @param endTime - end time, encoded as Time
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * Returns the total time of the delivery which is computed as the difference between the trip’s end time and the start time
     * @return the total time of the delivery
     */
    public Time getDuration() {
        Time durationTime = new Time(0,0,0);
        int startTimeInSeconds = startTime.getHours() * SECONDS_PER_HOUR + startTime.getMinutes() * SECONDS_PER_MINUTE + startTime.getSeconds();
        int endTimeInSeconds = endTime.getHours() * SECONDS_PER_HOUR + endTime.getMinutes() * SECONDS_PER_MINUTE + endTime.getSeconds();
        int durationSeconds = endTimeInSeconds - startTimeInSeconds;
        durationTime.setHours(durationSeconds / SECONDS_PER_HOUR);
        durationSeconds = durationSeconds % SECONDS_PER_HOUR;
        durationTime.setMinutes(durationSeconds / SECONDS_PER_MINUTE);
        durationTime.setSeconds(durationSeconds % SECONDS_PER_MINUTE);
        return durationTime;
    }
}
