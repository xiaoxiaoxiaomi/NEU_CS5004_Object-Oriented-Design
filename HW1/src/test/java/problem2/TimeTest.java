package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    private Time testTime;

    @BeforeEach
    void setUp() {
        testTime = new Time(16, 30, 59);
    }

    @Test
    void getHours() {
        assertEquals(16, testTime.getHours());
    }

    @Test
    void setHours() {
        testTime.setHours(23);
        assertEquals(23, testTime.getHours());
    }

    @Test
    void getMinutes() {
        assertEquals(30, testTime.getMinutes());
    }

    @Test
    void setMinutes() {
        testTime.setMinutes(44);
        assertEquals(44, testTime.getMinutes());
    }

    @Test
    void getSeconds() {
        assertEquals(59, testTime.getSeconds());
    }

    @Test
    void setSeconds() {
        testTime.setSeconds(7);
        assertEquals(7, testTime.getSeconds());
    }
}