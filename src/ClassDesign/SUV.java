package ClassDesign;


public abstract class SUV extends Car {

    boolean allWheelDrive;

    public SUV(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean allWheelDrive) {
        super(make, model, year, gearbox, colour, mileage, vin, "SUV");
        this.allWheelDrive = allWheelDrive;
    }


    public void addAllWheelDrive() {
        allWheelDrive = true;
    }


    @Override
    public String toString() {
        return super.toString()
                + "All-Wheel Drive: " + allWheelDrive + "\n";
    }
}
