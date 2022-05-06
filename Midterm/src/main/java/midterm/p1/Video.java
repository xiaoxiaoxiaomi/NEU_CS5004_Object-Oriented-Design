package midterm.p1;

public class Video extends NFT {

  private static final Integer VIDEO_NFT_AUCTION_THRESHOLD = 7;
  private static final Double VIDEO_NFT_AUCTION_FACTOR = 0.8;

  public Video(String name, Name[] creatorNames, Name[] ownerNames, Double latestAskingPrice,
      String ethereumAndOrBitcoinStandard) {
    super(name, creatorNames, ownerNames, latestAskingPrice, ethereumAndOrBitcoinStandard);
  }

  private Double getVideoNftAuctionFactor() {
    if (this.numberOfDaysForAuction > VIDEO_NFT_AUCTION_THRESHOLD) {
      return VIDEO_NFT_AUCTION_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getVideoNftAuctionFactor();
  }
}
