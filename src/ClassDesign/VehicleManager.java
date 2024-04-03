package ClassDesign;

import devtools.io.Data;
import devtools.ui.Application;
import devtools.ui.Menu;
import devtools.util.Reader;
import devtools.util.Sequence;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {

    @Data
    public static List<Vehicle> vehicles = new ArrayList<>();  
    @Data
    public static Sequence seq = new Sequence(1, 100_000_000); 

    public static void main(String[] args) {
        Application.start(VehicleManager.class);
    }

    
    private static DataManager dataManager;

    static {
        dataManager = new DataManager();
    }

    @Menu(id = 0, command = "C",
            description = "Create Vehicle",
            subMenuIDs = {1, 2, 3, 4, 5},
            index = 0)
    public static void createVehicle() {
        Vehicle newVehicle = createCar();
        vehicles.add(newVehicle);
        System.out.println("Vehicle added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 1, command = "1", description = "Add Car")
    public static void addCar() {
        Vehicle newVehicle = createCar();
        vehicles.add(newVehicle);
        System.out.println("Car added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 2, command = "2", description = "Add Options to a Vehicle")
    public static void addOptionsToVehicle() {
    
    }

    @Menu(id = 3, command = "3", description = "Remove Vehicle")
    public static void removeVehicle() {
        
    }

    @Menu(id = 4, command = "4", description = "Search Vehicle by VIN")
    public static void searchVehicle() {
        
    }

    @Menu(id = 5, command = "5", description = "Display All Vehicles")
    public static void displayAllVehicles() {
        List<Vehicle> loadedVehicles = dataManager.loadVehicles(); 
        if (!loadedVehicles.isEmpty()) {
            for (Vehicle vehicle : loadedVehicles) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("There are currently no vehicles.");
        }
    }

    private static Car createCar() {
        System.out.println("Enter car details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("VIN: ");
        String bodyType = Reader.readLine("Body Type: ");
        return new Car(make, model, year, "Manual", "Black", 0, vin, bodyType);
    }
}