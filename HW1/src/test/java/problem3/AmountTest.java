package problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    private Amount testAmount;

    @BeforeEach
    void setUp() {
        testAmount = new Amount(123, 45);
    }

    @Test
    void getDollarAmount() {
        assertEquals(123, testAmount.getDollarAmount());
    }

    @Test
    void setDollarAmount() {
        testAmount.setDollarAmount(999);
        assertEquals(999, testAmount.getDollarAmount());
    }

    @Test
    void getCentAmount() {
        assertEquals(45, testAmount.getCentAmount());
    }

    @Test
    void setCentAmount() {
        testAmount.setCentAmount(1);
        assertEquals(1, testAmount.getCentAmount());
    }
}