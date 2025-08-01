package main.com.chargepoint;

import java.util.Objects;

public class Truck {
    private int VehiclePlatformId; // Unique identifier for Vehicle(on chassis) and should be UUID || String
    private double targetSoc;
    private double soc;

    public int getVehiclePlatformId() {
        return VehiclePlatformId;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "VehiclePlatformId=" + VehiclePlatformId +
                ", targetSoc=" + targetSoc +
                ", soc=" + soc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return VehiclePlatformId == truck.VehiclePlatformId && Double.compare(targetSoc, truck.targetSoc) == 0 && Double.compare(targetSoc, truck.targetSoc) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(VehiclePlatformId);
    }

    public void setVehiclePlatformId(int vehiclePlatformId) {
        VehiclePlatformId = vehiclePlatformId;
    }

    public double getTargetSoc() {
        return targetSoc;
    }

    public void setTargetSoc(double targetSoc) {
        this.targetSoc = targetSoc;
    }

    public double getSoc() {
        return soc;
    }

    public void setSoc(double soc) {
        this.soc = soc;
    }

    public Truck(int vehiclePlatformId, double targetSoc, double soc) {
        VehiclePlatformId = vehiclePlatformId;
        this.targetSoc = targetSoc;
        this.soc = soc;
    }

    double neededCharge() {
        return targetSoc - soc;
    }
}
