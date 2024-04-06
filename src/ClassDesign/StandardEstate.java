package ClassDesign;

import java.io.Serializable;

public class StandardEstate extends Estate implements Serializable {
    public StandardEstate(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean hasRoofRack) {
        super(make, model, year, gearbox, colour, mileage, vin, hasRoofRack);
    }

    @Override
    public void displayDetails() {
        
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Gearbox: " + gearbox);
        System.out.println("Colour: " + colour);
        System.out.println("Mileage: " + mileage);
        System.out.println("VIN: " + vin);
        System.out.println("Body Type: Hatchback");
        
    }

}