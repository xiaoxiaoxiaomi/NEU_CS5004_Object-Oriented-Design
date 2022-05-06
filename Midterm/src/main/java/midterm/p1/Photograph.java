package midterm.p1;

public abstract class Photograph extends PaintingAndPhoto {

  private static final Double CANON_EOS_R5_FACTOR = 1.35;
  protected String makeOfCamera;
  protected String model;

  public Photograph(String name, Name[] creatorNames, Name[] ownerNames,
      Double latestAskingPrice, Double[] widthAndHeight, String makeOfCamera, String model) {
    super(name, creatorNames, ownerNames, latestAskingPrice, widthAndHeight);
    this.makeOfCamera = makeOfCamera;
    this.model = model;
  }

  private Double getCanonEosR5Factor() {
    if (this.model == "Canon" && this.makeOfCamera == "EOS R5") {
      return CANON_EOS_R5_FACTOR;
    }
    return 1.0;
  }

  @Override
  public Double calculateStartingBid() {
    return super.calculateStartingBid() * getCanonEosR5Factor();
  }
}
