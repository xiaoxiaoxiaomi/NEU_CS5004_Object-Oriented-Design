package problem1;

import java.util.Objects;

public abstract class FoodItem {

  protected String name;
  protected Double currentPrice;
  protected Integer currentQuantity;
  protected Integer maxAllowedQuantity;

  protected static final Integer MAX_PERISHABLE_QUANTITY = 100;
  protected static final Integer MAX_NON_PERISHABLE_QUANTITY = 250;

  public FoodItem(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity) {
    this.name = name;
    this.currentPrice = currentPrice;
    this.currentQuantity = currentQuantity;
    this.maxAllowedQuantity = maxAllowedQuantity;
  }

  public String getName() {
    return name;
  }

  public Double getCurrentPrice() {
    return currentPrice;
  }

  public Integer getCurrentQuantity() {
    return currentQuantity;
  }

  public Integer getMaxAllowedQuantity() {
    return maxAllowedQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return Objects.equals(name, foodItem.name) && Objects.equals(currentPrice,
        foodItem.currentPrice) && Objects.equals(currentQuantity, foodItem.currentQuantity)
        && Objects.equals(maxAllowedQuantity, foodItem.maxAllowedQuantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }

  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", currentPrice=" + currentPrice +
        ", currentQuantity=" + currentQuantity +
        ", maxAllowedQuantity=" + maxAllowedQuantity +
        '}';
  }
}
