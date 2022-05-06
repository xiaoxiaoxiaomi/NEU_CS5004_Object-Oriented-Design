package problem1;

import java.time.LocalDateTime;

public class Vegetable extends PerishableFoodItem{

  public Vegetable(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity, orderDate, expirationDate);
  }
}
