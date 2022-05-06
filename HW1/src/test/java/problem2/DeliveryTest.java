package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {
    private Time testStartTime;
    private Time testEndTime;
    private Delivery testDelivery;

    @BeforeEach
    void setUp() {
        testStartTime = new Time(1, 39,52);
        testEndTime = new Time(23,6,8);
        testDelivery = new Delivery("Seattle", "Boston", testStartTime, testEndTime);
    }

    @Test
    void getStartLocation() {
        assertEquals("Seattle", testDelivery.getStartLocation());
    }

    @Test
    void setStartLocation() {
        testDelivery.setStartLocation("Vancouver");
        assertEquals("Vancouver", testDelivery.getStartLocation());
    }

    @Test
    void getEndLocation() {
        assertEquals("Boston", testDelivery.getEndLocation());
    }

    @Test
    void setEndLocation() {
        testDelivery.setEndLocation("New York");
        assertEquals("New York", testDelivery.getEndLocation());
    }

    @Test
    void getStartTime() {
        Time expectedStartTime = new Time(1, 39, 52);
        assertEquals(expectedStartTime.getHours(), testDelivery.getStartTime().getHours());
        assertEquals(expectedStartTime.getMinutes(), testDelivery.getStartTime().getMinutes());
        assertEquals(expectedStartTime.getSeconds(), testDelivery.getStartTime().getSeconds());
    }

    @Test
    void setStartTime() {
        Time newStartTime = new Time(0, 24,11);
        testDelivery.setStartTime(newStartTime);
        assertEquals(newStartTime, testDelivery.getStartTime());
    }

    @Test
    void getEndTime() {
        Time expectedEndTime = new Time(23,6,8);
        assertEquals(expectedEndTime.getHours(), testDelivery.getEndTime().getHours());
        assertEquals(expectedEndTime.getMinutes(), testDelivery.getEndTime().getMinutes());
        assertEquals(expectedEndTime.getSeconds(), testDelivery.getEndTime().getSeconds());
    }

    @Test
    void setEndTime() {
        Time newEndTime = new Time(22, 19, 7);
        testDelivery.setEndTime(newEndTime);
        assertEquals(newEndTime, testDelivery.getEndTime());
    }

    @Test
    void getDuration() {
        Time expectedDuration = new Time(21, 26, 16);
        assertEquals(expectedDuration.getHours(), testDelivery.getDuration().getHours());
        assertEquals(expectedDuration.getMinutes(), testDelivery.getDuration().getMinutes());
        assertEquals(expectedDuration.getSeconds(), testDelivery.getDuration().getSeconds());
    }
}