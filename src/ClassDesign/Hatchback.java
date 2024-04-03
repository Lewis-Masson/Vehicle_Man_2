package ClassDesign;


public abstract class Hatchback extends Vehicle {

    public Hatchback(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        super(make, model, year, gearbox, colour, mileage, vin, "Hatchback");
    }

}
