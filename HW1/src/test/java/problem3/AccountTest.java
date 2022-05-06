package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private static final double CONVERSION_RATE = 0.000025;
    private Identifier testIdentifier;
    private Amount testAmount;
    private Account testAccount;

    @BeforeEach
    void setUp() {
        testIdentifier = new Identifier("Ruxue", 2022, "US");
        testAmount = new Amount(290, 78);
        testAccount = new Account(testIdentifier, testAmount);
    }

    @Test
    void getUserIdentifier() {
        assertEquals(testIdentifier.getUsername(), testAccount.getIdentifier().getUsername());
        assertEquals(testIdentifier.getYear(), testAccount.getIdentifier().getYear());
        assertEquals(testIdentifier.getCountry(), testAccount.getIdentifier().getCountry());
    }

    @Test
    void getAmount() {
        assertEquals(testAmount.getDollarAmount(), testAccount.getAmount().getDollarAmount());
        assertEquals(testAmount.getCentAmount(), testAccount.getAmount().getCentAmount());
    }

    @Test
    void deposit() {
        Amount depositAmount1 = new Amount(35, 44);
        Amount expectedResultAmount1 = new Amount(326,22);
        Account resultAccount1 = testAccount.deposit(depositAmount1);
        assertEquals(expectedResultAmount1.getCentAmount(), resultAccount1.getAmount().getCentAmount());
        assertEquals(expectedResultAmount1.getDollarAmount(), resultAccount1.getAmount().getDollarAmount());

        Amount depositAmount2 = new Amount(10, 18);
        Amount expectedResultAmount2 = new Amount(300,96);
        Account resultAccount2 = testAccount.deposit(depositAmount2);
        assertEquals(expectedResultAmount2.getCentAmount(), resultAccount2.getAmount().getCentAmount());
        assertEquals(expectedResultAmount2.getDollarAmount(), resultAccount2.getAmount().getDollarAmount());

        Amount depositAmount3 = new Amount(34, 567);
        Amount expectedResultAmount3 = new Amount(330,45);
        Account resultAccount3 = testAccount.deposit(depositAmount3);
        assertEquals(expectedResultAmount3.getCentAmount(), resultAccount3.getAmount().getCentAmount());
        assertEquals(expectedResultAmount3.getDollarAmount(), resultAccount3.getAmount().getDollarAmount());
    }

    @Test
    void withdraw() {
        Amount withdrawAmount1 = new Amount(100, 99);
        Amount expectedResultAmount1 = new Amount(189, 79);
        Account resultAcocunt1 = testAccount.withdraw(withdrawAmount1);
        assertEquals(expectedResultAmount1.getCentAmount(), resultAcocunt1.getAmount().getCentAmount());
        assertEquals(expectedResultAmount1.getDollarAmount(), resultAcocunt1.getAmount().getDollarAmount());

        Amount withdrawAmount2 = new Amount(9, 9);
        Amount expectedResultAmount2 = new Amount(281, 69);
        Account resultAcocunt2 = testAccount.withdraw(withdrawAmount2);
        assertEquals(expectedResultAmount2.getCentAmount(), resultAcocunt2.getAmount().getCentAmount());
        assertEquals(expectedResultAmount2.getDollarAmount(), resultAcocunt2.getAmount().getDollarAmount());

        Amount withdrawAmount3 = new Amount(1, 234);
        Amount expectedResultAmount3 = new Amount(287, 44);
        Account resultAcocunt3 = testAccount.withdraw(withdrawAmount3);
        assertEquals(expectedResultAmount3.getCentAmount(), resultAcocunt3.getAmount().getCentAmount());
        assertEquals(expectedResultAmount3.getDollarAmount(), resultAcocunt3.getAmount().getDollarAmount());
    }

    @Test
    void convert() {
        Double expectedBTC = CONVERSION_RATE * (testAmount.getDollarAmount() + 0.01 * testAmount.getCentAmount());
        assertEquals(expectedBTC, testAccount.convert(testAmount), 0.000001);
    }
}