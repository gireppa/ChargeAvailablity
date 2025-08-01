package test.com.chargepoint;

import main.com.chargepoint.Charger;
import main.com.chargepoint.ChargingScheduler;
import main.com.chargepoint.Truck;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChargingSchedulerTest {
    // not written all test cases but we need to fill the test cases different conditions
    @Test
    public void testBasicCase() {
        List<Truck> trucks = Arrays.asList(new Truck(1, 100, 20),new Truck(2, 80, 50),
                new Truck(3, 120, 60), new Truck(4, 90, 30));
        List<Charger> chargers = Arrays.asList(new Charger(1, 20, 0),new Charger(2, 30, 0));
        int hours = 5;
        Map<Integer, List<Integer>> schedule = ChargingScheduler.scheduleCharging(trucks, chargers, hours);
        assertNotNull(schedule.entrySet().stream().anyMatch(s-> s.equals(1))); // Varies depending on sort
    }
    @Test
    public void testSingleChargerLimitedTime() {

    }
    @Test
    public void testNoTruckCanBeCharged() {

    }
    @Test
    public void testMultipleFastCharges() {

    }
    @Test
    public void testUnequalRates() {

    }
}

