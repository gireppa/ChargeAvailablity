package main.com.chargepoint;

import java.util.Objects;

public class Charger {
    @Override
    public String toString() {
        return "Charger{" +
                "chargerPlatformId=" + chargerPlatformId +
                ", rate=" + rate +
                ", availableHours=" + availableHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Charger charger = (Charger) o;
        return chargerPlatformId == charger.chargerPlatformId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chargerPlatformId);
    }

    public int getChargerPlatformId() {
        return chargerPlatformId;
    }

    public void setChargerPlatformId(int chargerPlatformId) {
        this.chargerPlatformId = chargerPlatformId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(double availableHours) {
        this.availableHours = availableHours;
    }

    public Charger(int chargerPlatformId, double rate, double availableHours) {
        this.chargerPlatformId = chargerPlatformId;
        this.rate = rate;
        this.availableHours = availableHours;
    }

    int chargerPlatformId; // Unique identifier for charger and should be a UUID OR String
    double rate; // in kW
    double availableHours;
}
