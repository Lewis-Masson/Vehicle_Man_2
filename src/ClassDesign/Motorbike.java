package ClassDesign;


public abstract class Motorbike extends Vehicle {

    private boolean luggageBox;

    public Motorbike(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean luggageBox) {
        super(make, model, year, gearbox, colour, mileage, vin, "MOTORBIKE");
        this.luggageBox = luggageBox;
    }

    public boolean hasLuggageBox() {
        return luggageBox;
    }

    public void addLuggageBox() {
        luggageBox = true;
    }

    public void removeLuggageBox() {
        luggageBox = false;
    }

    @Override
    public String toString() {
        return super.toString() + "Luggage Box: " + luggageBox;
    }
}