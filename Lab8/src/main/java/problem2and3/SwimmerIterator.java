package problem2and3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwimmerIterator implements Iterator<Swimmer> {

  private List<Swimmer> filteredSwimmers;
  private Integer index = 0;
  private static final Integer BUTTERFLY_SWIM_TIME_CUTOFF = 5;
  private static final Double QUALIFIED_TIME = 26.17;

  public SwimmerIterator(List<Swimmer> swimmers) {
    this.filteredSwimmers = this.filterSwimmers(swimmers);
  }

  private List<Swimmer> filterSwimmers(List<Swimmer> swimmers) {
    List<Swimmer> filteredSwimmers = new ArrayList<>();
    for (Swimmer swimmer : swimmers) {
      if (this.qualifiedButterflySwims(swimmer) && this.qualifiedFreestyleTime(swimmer)) {
        filteredSwimmers.add(swimmer);
      }
    }
    return filteredSwimmers;
  }

  private Boolean qualifiedButterflySwims(Swimmer swimmer) {
    return swimmer.getButterfly50mTimes().size() >= BUTTERFLY_SWIM_TIME_CUTOFF;
  }

  private Boolean qualifiedFreestyleTime(Swimmer swimmer) {
    for (Double swimTime : swimmer.getFreestyle50mTimes()) {
      if (swimTime <= QUALIFIED_TIME) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean hasNext() {
    return !filteredSwimmers.isEmpty();
  }

  @Override
  public Swimmer next() {
    Swimmer helperSwimmer = this.filteredSwimmers.get(index);
    this.index = this.index++;
    return helperSwimmer;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("This operation is not supported!");
  }
}
