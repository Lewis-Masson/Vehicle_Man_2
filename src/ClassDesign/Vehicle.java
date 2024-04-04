package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Serializable {
    protected String make;
    protected String model;
    protected int year;
    protected GearboxType gearbox;
    protected String colour;
    protected int mileage;
    protected String vin;
    protected String bodyType;

    public Vehicle(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.gearbox = parseGearbox(gearbox);
        this.colour = colour;
        this.mileage = mileage;
        this.vin = vin;
        this.bodyType = bodyType;
    }

    public Vehicle(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        this(make, model, year, gearbox, colour, mileage, vin, null);
    }

    private GearboxType parseGearbox(String gearbox) {
        switch (gearbox.toUpperCase()) {
            case "MANUAL":
                return GearboxType.MANUAL;
            case "AUTOMATIC":
                return GearboxType.AUTOMATIC;
            default:
                throw new IllegalArgumentException("Invalid gearbox type: " + gearbox);
        }
    }

    public abstract void displayDetails();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getVin() {
        return vin;
    }

    public String getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {
        return "Make: " + make + "\n"
                + "Model: " + model + "\n"
                + "Year: " + year + "\n"
                + "Gearbox: " + gearbox + "\n"
                + "Colour: " + colour + "\n"
                + "Mileage: " + mileage + "\n"
                + "VIN: " + vin + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.make);
        hash = 31 * hash + Objects.hashCode(this.model);
        hash = 31 * hash + this.year;
        hash = 31 * hash + Objects.hashCode(this.gearbox);
        hash = 31 * hash + Objects.hashCode(this.colour);
        hash = 31 * hash + this.mileage;
        hash = 31 * hash + Objects.hashCode(this.vin);
        hash = 31 * hash + Objects.hashCode(this.bodyType);
        return hash;
    }
}