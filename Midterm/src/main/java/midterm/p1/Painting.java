package midterm.p1;

public abstract class Painting extends PaintingAndPhoto {

  private static final Integer PAINTING_AUCTION_THRESHOLD = 100;
  private static final Double PAINTING_OFFER_THRESHOLD = 2000.0;
  private static final Double PAINTING_FACTOR = 0.8;

  public Painting(String name, Name[] creatorNames, Name[] ownerNames,
      Double latestAskingPrice, Double[] widthAndHeight) {
    super(name, creatorNames, ownerNames, latestAskingPrice, widthAndHeight);
  }

  private Double getPaintingFactor() {
    if (this.numberOfDaysForAuction > PAINTING_AUCTION_THRESHOLD
        && this.latestAskingPrice > PAINTING_OFFER_THRESHOLD) {
      return PAINTING_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getPaintingFactor();
  }
}
