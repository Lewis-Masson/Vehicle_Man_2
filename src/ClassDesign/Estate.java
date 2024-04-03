package ClassDesign;

public abstract class Estate extends Car {

    private boolean thirdRowSeat;

    public Estate(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean thirdRowSeat) {
        super(make, model, year, gearbox, colour, mileage, vin, "Estate");
        this.thirdRowSeat = thirdRowSeat;
    }

    public boolean hasThirdRowSeat() {
        return thirdRowSeat;
    }

    public void setThirdRowSeat(boolean thirdRowSeat) {
        this.thirdRowSeat = thirdRowSeat;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Third Row Seat: " + thirdRowSeat;

    }

    
}
