package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer stores information about the baseball player - their team name, average
 * batting score and the number of season home runs
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;

  /**
   * Constructor for the BaseballPlayer
   *
   * @param athletesName    - athlete's name, encoded as a data type Name
   * @param height          - athlete's height, stored as a Double
   * @param weight          - athlete's weight, stored as a Double
   * @param league          - baseball player's league, stored as a String
   * @param team            - baseball player's team, stored as a String
   * @param avgBattingScore - baseball player's average batting score, stored as a Double
   * @param seasonHomeRuns  - baseball player's season home runs, stored as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Getter for team
   *
   * @return the name of the team, as a String
   */
  public String getTeam() {
    return team;
  }

  /**
   * Setter for team
   *
   * @param team team name, encoded as a String
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * Getter for average batting score
   *
   * @return - average batting score, as a Double
   */
  public Double getAvgBattingScore() {
    return avgBattingScore;
  }

  /**
   * Setter for average batting score
   *
   * @param avgBattingScore - average batting score, as a Double
   */
  public void setAvgBattingScore(Double avgBattingScore) {
    this.avgBattingScore = avgBattingScore;
  }

  /**
   * Getter for season home runs
   *
   * @return - number of season home runs, as an Integer
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
  }

  /**
   * Setter for season home runs
   *
   * @param seasonHomeRuns - season home runs, as an Integer
   */
  public void setSeasonHomeRuns(Integer seasonHomeRuns) {
    this.seasonHomeRuns = seasonHomeRuns;
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects.equals(avgBattingScore,
        that.avgBattingScore) && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBattingScore, seasonHomeRuns);
  }


  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", avgBattingScore=" + avgBattingScore +
        ", seasonHomeRuns=" + seasonHomeRuns +
        '}';
  }
}
