package problem3;

public class Amount {
    private Integer dollarAmount;
    private Integer centAmount;

    /**
     * Constructor, creating a new Amount object, with the provided
     dollar amount and cent amount
     * @param dollarAmount - dollar amount, encoded as Integer
     * @param centAmount - cent amount, encoded as Integer
     */
    public Amount(Integer dollarAmount, Integer centAmount) {
        this.dollarAmount = dollarAmount;
        this.centAmount = centAmount;
    }

    /**
     * Returns the dollar amount
     * @return the dollar amount
     */
    public Integer getDollarAmount() {
        return dollarAmount;
    }

    /**
     * Sets dollar amount to the given dollar amount
     * @param dollarAmount - dollar amount, encoded as Integer
     */
    public void setDollarAmount(Integer dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    /**
     * Returns the cent amount
     * @return the cent amount
     */
    public Integer getCentAmount() {
        return centAmount;
    }

    /**
     * Sets cent amount to the given cent amount
     * @param centAmount - cent amount, encoded as Integer
     */
    public void setCentAmount(Integer centAmount) {
        this.centAmount = centAmount;
    }
}
