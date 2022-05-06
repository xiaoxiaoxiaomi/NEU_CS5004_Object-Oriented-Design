package midterm.p1;

public abstract class PaintingAndPhoto extends ArtPiece {

  private static final Double WIDTH_THRESHOLD = 12.0;
  private static final Double HEIGHT_THRESHOLD = 16.0;
  private static final Double BIG_PAINTING_AND_PHOTO_FACTOR = 1.25;
  protected Double[] widthAndHeight;

  public PaintingAndPhoto(String name, Name[] creatorNames, Name[] ownerNames,
      Double latestAskingPrice, Double[] widthAndHeight) {
    super(name, creatorNames, ownerNames, latestAskingPrice);
    this.widthAndHeight = widthAndHeight;
  }

  private Double getPaintingAnPhotoFactor() {
    if (this.widthAndHeight[0] > WIDTH_THRESHOLD && this.widthAndHeight[1] > HEIGHT_THRESHOLD) {
      return BIG_PAINTING_AND_PHOTO_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getPaintingAnPhotoFactor();
  }
}
