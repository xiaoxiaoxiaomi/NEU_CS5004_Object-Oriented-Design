package problem1;

/**
 * Class Vehicle stores information about vehicle - daily price and number of booked days
 */
public class Vehicle {

  protected Double dailyPrice;
  protected Integer bookedDays;

  /**
   * Constructor for the class Vehicle
   *
   * @param dailyPrice - the cost of a single day rental, encoded as Double
   * @param bookedDays - the number of days the vehicle has been rented out to a client, encoded as
   *                   Integer
   * @throws DailyPriceNumericException On non-positive dailyPrice
   * @throws BookedDaysNumericException On negative bookedDays
   */
  public Vehicle(Double dailyPrice, Integer bookedDays)
      throws DailyPriceNumericException, BookedDaysNumericException {
    if (dailyPrice <= 0) {
      throw new DailyPriceNumericException(
          "The cost of a single day rental must be greater than 0!");
    } else {
      this.dailyPrice = dailyPrice;
    }
    if (bookedDays < 0) {
      throw new BookedDaysNumericException(
          "The number of booked days should be greater than or equal to 0!");
    } else {
      this.bookedDays = bookedDays;
    }
  }

  /**
   * Getter for daily price
   *
   * @return - the cost of a single day rental, as a Double
   */
  public Double getDailyPrice() {
    return this.dailyPrice;
  }

  /**
   * Getter for booked days
   *
   * @return - the number of days the vehicle has been rented out to a client, as an Integer
   */
  public Integer getBookedDays() {
    return this.bookedDays;
  }

  /**
   * Setter for booked days
   *
   * @param bookedDays - the number of days the vehicle has been rented out to a client, as an
   *                   Integer
   * @throws BookedDaysNumericException On negative bookedDays
   */
  public void setBookedDays(Integer bookedDays) throws BookedDaysNumericException {
    if (bookedDays < 0) {
      throw new BookedDaysNumericException(
          "The number of booked days should be greater than or equal to 0!");
    } else {
      this.bookedDays = bookedDays;
    }
  }

  /**
   * Check if the vehicle is available or not, the vehicle is considered available if the number of
   * booked days is 0
   *
   * @return - if the vehicle is available or not, as a Boolean
   */
  public Boolean isAvailable() {
    return this.bookedDays == 0;
  }
}
