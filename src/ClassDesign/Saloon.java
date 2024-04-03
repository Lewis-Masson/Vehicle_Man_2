package ClassDesign;


public abstract class Saloon extends Vehicle {

    public Saloon(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        super(make, model, year, gearbox, colour, mileage, vin, "Saloon");
    }

}