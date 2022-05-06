package problem1;

import java.util.Objects;

/**
 * Class Runner stores information about the athlete - their best 5K time, best half-marathon time
 * and favorite running event
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructor for the Runner
   *
   * @param athletesName         - athlete's name, encoded as a data type Name
   * @param height               - athlete's height, stored as a Double
   * @param weight               - athlete's weight, stored as a Double
   * @param league               - runner's league, stored as a String
   * @param best5KTime           - runner's best 5K time, stored as a Double
   * @param bestHalfMarathonTime - runner's best half-marathon time, stored as a Double
   * @param favoriteRunningEvent - runner's favorite running event, stored as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for best 5K time
   *
   * @return the best 5K time, as a Double
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Setter for best 5K time
   *
   * @param best5KTime - best 5K time, as a Double
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Getter for best half-marathon time
   *
   * @return best half-marathon time, as a Double
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Setter for best half-marathon time
   *
   * @param bestHalfMarathonTime - best half-marathon time, as a Double
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * Getter for favorite running event
   *
   * @return favorite running event, as a String
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  /**
   * Setter for favorite running event
   *
   * @param favoriteRunningEvent - favorite running event, as a String
   */
  public void setFavoriteRunningEvent(String favoriteRunningEvent) {
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(best5KTime, runner.best5KTime) && Objects.equals(
        bestHalfMarathonTime, runner.bestHalfMarathonTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5KTime, bestHalfMarathonTime, favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "best5KTime=" + best5KTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        '}';
  }
}
