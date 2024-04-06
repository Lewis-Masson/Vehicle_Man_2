package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class SUV extends Car implements Serializable, Comparable<SUV> {

    private final String id;
    private boolean allWheelDrive;

    public SUV(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean allWheelDrive) {
        super(make, model, year, gearbox, colour, mileage, vin, "SUV");
        this.id = vin;
        this.allWheelDrive = allWheelDrive;
    }

    public String getId() {
        return id;
    }

    public boolean hasAllWheelDrive() {
        return allWheelDrive;
    }

    public void setAllWheelDrive(boolean allWheelDrive) {
        this.allWheelDrive = allWheelDrive;
    }

    @Override
    public String toString() {
        return super.toString() + "All-Wheel Drive: " + allWheelDrive + "\n";
    }

    @Override
    public int compareTo(SUV other) {
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final SUV other = (SUV) obj;
        return Objects.equals(this.id, other.id);
    }

    
    public void addAllWheelDrive() {
        if (!hasAllWheelDrive()) {
            setAllWheelDrive(true);
            System.out.println("All-wheel drive added successfully.");
        } else {
            System.out.println("The SUV already has all-wheel drive.");
        }
    }
}