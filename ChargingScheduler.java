package main.com.chargepoint;

import java.util.*;

public class ChargingScheduler {

    public static Map<Integer, List<Integer>> scheduleCharging(List<Truck> trucks, List<Charger> chargers, int totalHours) {
        Map<Integer, List<Integer>> schedule = new HashMap<>();
        for (Charger c : chargers) {
            c.availableHours = totalHours;
            schedule.put(c.chargerPlatformId, new ArrayList<>());
        }
    // Generate all valid truck-charger-time combinations
        List<Assignment> possibleAssignments = new ArrayList<>();
        for (Truck truck : trucks) {
            for (Charger charger : chargers) {
                double timeNeeded = truck.neededCharge() / charger.rate;
                if (timeNeeded <= totalHours) {
                    possibleAssignments.add(new Assignment(truck, charger, timeNeeded));
                }
            }
        }
        // Sort by time needed (shortest first) to prioritize quick full charges
        possibleAssignments.sort(Comparator.comparingDouble(a -> a.time));

        Set<Integer> assignedTrucks = new HashSet<>();

        for (Assignment a : possibleAssignments) {
            if (!assignedTrucks.contains(a.truck.getVehiclePlatformId()) && a.charger.availableHours >= a.time) {
                schedule.get(a.charger.chargerPlatformId).add(a.truck.getVehiclePlatformId());
                a.charger.availableHours -= a.time;
                assignedTrucks.add(a.truck.getVehiclePlatformId());
            }
        }
        // Print the schedule
        for (Map.Entry<Integer, List<Integer>> entry : schedule.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            System.out.println(String.join(", ", entry.getValue().stream().map(String::valueOf).toArray(String[]::new)));
        }
        return schedule;
    }
}