package midterm.p1;

public abstract class NFT extends ArtPiece {

  private static final Integer NFT_AUCTION_THRESHOLD = 60;
  private static final Double ERC_721_FACTOR = 0.6;
  protected String EthereumAndOrBitcoinStandard;

  public NFT(String name, Name[] creatorNames, Name[] ownerNames, Double latestAskingPrice,
      String ethereumAndOrBitcoinStandard) {
    super(name, creatorNames, ownerNames, latestAskingPrice);
    EthereumAndOrBitcoinStandard = ethereumAndOrBitcoinStandard;
  }

  private Double getErc721Factor() {
    if (this.numberOfDaysForAuction > NFT_AUCTION_THRESHOLD && this.EthereumAndOrBitcoinStandard == "ERC-721") {
      return ERC_721_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getErc721Factor();
  }
}
