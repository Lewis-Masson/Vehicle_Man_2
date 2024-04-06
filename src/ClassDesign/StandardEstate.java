package ClassDesign;

import java.io.Serializable;

public class StandardEstate extends Estate implements Serializable {

    private boolean hasSatNav;
    private boolean hasParkingSensors;
    private boolean hasTowBar;

    public StandardEstate(String make, String model, int year, String gearbox, String colour, int mileage, String vin,
            boolean hasRoofRack, boolean hasSatNav, boolean hasParkingSensors, boolean hasTowBar, boolean hasThirdRowSeat) {
        super(make, model, year, gearbox, colour, mileage, vin, hasRoofRack, hasThirdRowSeat);
        this.hasSatNav = hasSatNav;
        this.hasParkingSensors = hasParkingSensors;
        this.hasTowBar = hasTowBar;
        this.hasRoofRack = hasRoofRack;
    }

    // Getters and setters for additional features
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
}
