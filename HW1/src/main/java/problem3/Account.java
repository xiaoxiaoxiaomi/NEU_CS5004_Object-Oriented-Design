package problem3;

public class Account {
    private static final double CONVERSION_RATE = 0.000025;
    private final Identifier identifier;
    private final Amount amount;

    /**
     * Constructor, creating a new Account object, with the provided
     user identifier and amount
     * @param identifier - identifier, encoded as Identifier
     * @param amount - amount, encoded as Amount
     */
    public Account(Identifier identifier, Amount amount) {
        this.identifier = identifier;
        this.amount = amount;
    }

    /**
     * Returns the identifier
     * @return the identifier
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Returns the amount
     * @return the amount
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Handles a deposit event, in which money is added to the account balance
     * @param depositAmount - amount of money to be added to the account balance
     * @return a new account object with an increased account balance
     */
    public Account deposit(Amount depositAmount) {
        Amount resultAmount = new Amount(0, 0);
        resultAmount.setCentAmount((amount.getCentAmount() + depositAmount.getCentAmount()) % 100);
        resultAmount.setDollarAmount(amount.getDollarAmount() + depositAmount.getDollarAmount() + (amount.getCentAmount() + depositAmount.getCentAmount()) / 100);
        return new Account(identifier, resultAmount);
    }

    /**
     * Handles a withdrawal event, in which money is withdrawn from the account
     * @param withdrawAmount - amount of money to be withdrawn from the account
     * @return a new account object with the balance decreased
     */
    public Account withdraw(Amount withdrawAmount) {
        Amount resultAmount = new Amount(0, 0);
        if (withdrawAmount.getCentAmount() > 99) {
            withdrawAmount.setDollarAmount(withdrawAmount.getDollarAmount() + withdrawAmount.getCentAmount() / 100);
            withdrawAmount.setCentAmount(withdrawAmount.getCentAmount() % 100);
        }
        if (amount.getCentAmount() < withdrawAmount.getCentAmount()) {
            resultAmount.setCentAmount(amount.getCentAmount() + 100 - withdrawAmount.getCentAmount());
            resultAmount.setDollarAmount(amount.getDollarAmount() - withdrawAmount.getDollarAmount() - 1);
        } else {
            resultAmount.setCentAmount(amount.getCentAmount() - withdrawAmount.getCentAmount());
            resultAmount.setDollarAmount(amount.getDollarAmount() - withdrawAmount.getDollarAmount());
        }
        return new Account(identifier, resultAmount);
    }

    /**
     * Handles a conversion from the US dollar amount into Bitcoins (BTC)
     * @param convertAmount - amount of money to be converted
     * @return a new Double object, representing the value of the given amount in Bitcoins
     */
    public Double convert(Amount convertAmount) {
        return CONVERSION_RATE * (convertAmount.getDollarAmount() + 0.01 * convertAmount.getCentAmount());
    }
}
