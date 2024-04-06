package ClassDesign;

import java.io.Serializable;

public class StandardSaloon extends Saloon implements Serializable {
    private boolean hasSatNav;
    private boolean hasParkingSensors;
    private boolean hasTowBar;
    private boolean hasRoofRack;

    public StandardSaloon(String make, String model, int year, String gearbox, String colour, int mileage, String vin,
                          boolean hasSatNav, boolean hasParkingSensors, boolean hasTowBar, boolean hasRoofRack) {
        super(make, model, year, gearbox, colour, mileage, vin);
        this.hasSatNav = hasSatNav;
        this.hasParkingSensors = hasParkingSensors;
        this.hasTowBar = hasTowBar;
        this.hasRoofRack = hasRoofRack;
    }

    // Additional methods for manipulating the new features can be added here

    // Getter and setter methods for the new features
    public boolean hasSatNav() {
        return hasSatNav;
    }

    public void setHasSatNav(boolean hasSatNav) {
        this.hasSatNav = hasSatNav;
    }

    public boolean hasParkingSensors() {
        return hasParkingSensors;
    }

    public void setHasParkingSensors(boolean hasParkingSensors) {
        this.hasParkingSensors = hasParkingSensors;
    }

    public boolean hasTowBar() {
        return hasTowBar;
    }

    public void setHasTowBar(boolean hasTowBar) {
        this.hasTowBar = hasTowBar;
    }

    public boolean hasRoofRack() {
        return hasRoofRack;
    }

    public void setHasRoofRack(boolean hasRoofRack) {
        this.hasRoofRack = hasRoofRack;
    }
}