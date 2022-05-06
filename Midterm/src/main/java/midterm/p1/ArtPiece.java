package midterm.p1;

public abstract class ArtPiece implements IArtPiece {

  private static final Double BASE_VALUE_FACTOR = 1.25;
  protected String name;
  protected Name[] creatorNames;
  protected Name[] ownerNames;
  protected Integer numberOfDaysForAuction;
  protected Double latestAskingPrice;

  public ArtPiece(String name, Name[] creatorNames, Name[] ownerNames, Double latestAskingPrice) {
    this.name = name;
    this.creatorNames = creatorNames;
    this.ownerNames = ownerNames;
    this.numberOfDaysForAuction = 0;
    this.latestAskingPrice = latestAskingPrice;
  }

  public void setNumberOfDaysForAuction(Integer numberOfDaysForAuction) {
    this.numberOfDaysForAuction = numberOfDaysForAuction;
  }

  @Override
  public Double calculateStartingBid() {
    return BASE_VALUE_FACTOR * this.latestAskingPrice;
  }
}
