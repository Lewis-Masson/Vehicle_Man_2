package ClassDesign;

public class Car extends Vehicle {

    boolean satNav;
    boolean parkingSensors;
    boolean towBar;
    boolean roofRack;

    public Car(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType,
            boolean satNav, boolean parkingSensors, boolean towBar, boolean roofRack) {
        super(make, model, year, gearbox, colour, mileage, vin, bodyType);
        this.satNav = satNav;
        this.parkingSensors = parkingSensors;
        this.towBar = towBar;
        this.roofRack = roofRack;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + getMake());  
        System.out.println("Model: " + getModel());  
        System.out.println("Year: " + getYear());  
        System.out.println("Gearbox: " + gearbox);  
        System.out.println("Colour: " + colour);  
        System.out.println("Mileage: " + mileage);  
        System.out.println("VIN: " + getVin());  
        System.out.println("Body Type: " + bodyType);  
        System.out.println("Sat Nav: " + satNav);
        System.out.println("Parking Sensors: " + parkingSensors);
        System.out.println("Tow Bar: " + towBar);
        System.out.println("Roof Rack: " + roofRack);
        
    }

    public Car(String make, String model, int year, String gearbox, String colour, int mileage, String vin, String bodyType) {
        super(make, model, year, gearbox, colour, mileage, vin, bodyType);
    }

    public void addSatNav() {
        satNav = true;
    }

    public void addParkingSensors() {
        parkingSensors = true;
    }

    public void addTowBar() {
        towBar = true;
    }

    public void addRoofRack() {
        roofRack = true;
    }

    public boolean hasSatNav() {
        return satNav;
    }

    public boolean hasParkingSensors() {
        return parkingSensors;
    }

    public boolean hasTowBar() {
        return towBar;
    }

    public boolean hasRoofRack() {
        return roofRack;
    }

    public void setSatNav(boolean satNav) {
        this.satNav = satNav;
    }

    public void setParkingSensors(boolean parkingSensors) {
        this.parkingSensors = parkingSensors;
    }

    public void setTowBar(boolean towBar) {
        this.towBar = towBar;
    }

    public void setRoofRack(boolean roofRack) {
        this.roofRack = roofRack;
    }

    

    String getBodyType() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}