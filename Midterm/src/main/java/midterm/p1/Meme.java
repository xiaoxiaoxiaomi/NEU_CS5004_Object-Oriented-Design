package midterm.p1;

public class Meme extends NFT {

  private static final Integer MEME_NFT_AUCTION_THRESHOLD = 15;
  private static final Double MEME_NFT_AUCTION_FACTOR = 0.7;
  private static final Integer MEME_NFT_CREATOR_THRESHOLD = 3;
  private static final Double MEME_NFT_CREATOR_FACTOR = 1.2;

  public Meme(String name, Name[] creatorNames, Name[] ownerNames, Double latestAskingPrice,
      String ethereumAndOrBitcoinStandard) {
    super(name, creatorNames, ownerNames, latestAskingPrice, ethereumAndOrBitcoinStandard);
  }

  private Double getMemeNftAuctionFactor() {
    if (this.numberOfDaysForAuction > MEME_NFT_AUCTION_THRESHOLD) {
      return MEME_NFT_AUCTION_FACTOR;
    }
    return 1.0;
  }

  private Double getMemeNftCreatorFactor() {
    if (this.creatorNames.length < MEME_NFT_CREATOR_THRESHOLD) {
      return MEME_NFT_CREATOR_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getMemeNftAuctionFactor() * getMemeNftCreatorFactor();
  }
}
