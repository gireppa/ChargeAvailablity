package main.com.chargepoint;

import java.util.Arrays;
import java.util.List;

public class ChargingSchedulerMain {
    public static void main(String[] args) {
      //Only One Charger Available
        List<Truck> trucks = Arrays.asList(
                new Truck(1, 100, 50),
                new Truck(2, 120, 60),
                new Truck(3, 80, 40)
        );
        List<Charger> chargers = Arrays.asList(
                new Charger(1, 20, 0)
        );
        int hoursAvailable = 4;
        ChargingScheduler.scheduleCharging(trucks, chargers, hoursAvailable);

        List<Truck> trucks1 = Arrays.asList(
                new Truck(1, 300, 0),
                new Truck(2, 400, 50)
        );
   // Trucks Need Too Much Time
        List<Charger> chargers1 = Arrays.asList(
                new Charger(1, 50, 0),
                new Charger(2, 60, 0)
        );
        int hoursAvailable1 = 4;
        ChargingScheduler.scheduleCharging(trucks1, chargers1, hoursAvailable1);
    }
}
