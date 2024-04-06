package ClassDesign;

import java.io.Serializable;

public class StandardSUV extends SUV implements Serializable {
    public StandardSUV(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean allWheelDrive) {
        super(make, model, year, gearbox, colour, mileage, vin, allWheelDrive);
    }

    
    @Override
    public void addAllWheelDrive() {
        if (!hasAllWheelDrive()) {
            setAllWheelDrive(true);
            System.out.println("All-wheel drive added successfully.");
        } else {
            System.out.println("The SUV already has all-wheel drive.");
        }
    }
}