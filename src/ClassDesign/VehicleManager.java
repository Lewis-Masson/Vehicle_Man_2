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
    public static List<Vehicle> vehicles = new ArrayList<>();  // Make it public

    @Data
    public static Sequence seq = new Sequence(1, 100_000_000); // Make it public

    private static DataManager dataManager;

    static {
        dataManager = new DataManager();
    }

    @Menu(id = 0, command = "V",
            description = "Vehicle Menu",
            subMenuIDs = {1, 2, 3, 4, 5},
            index = 0)
    public static void createVehicle() {
        Vehicle newVehicle = createCar();
        vehicles.add(newVehicle);
        System.out.println("Vehicle added successfully.");
        dataManager.saveVehicles(vehicles); // Save vehicles
    }

    @Menu(id = 1, command = "1", description = "Add Car")
    public static void addCar() {
        Vehicle newVehicle = createCar();
        vehicles.add(newVehicle);
        System.out.println("Car added successfully.");
        dataManager.saveVehicles(vehicles); // Save vehicles
    }

    @Menu(id = 2, command = "2", description = "Add Options to a Vehicle")
    public static void addOptionsToVehicle() {
        // Add options to vehicle logic here
    }

    @Menu(id = 3, command = "3", description = "Remove Vehicle")
    public static void removeVehicle() {
        // Remove vehicle logic here
    }

    @Menu(id = 4, command = "4", description = "Search Vehicle by VIN")
    public static void searchVehicle() {
        String vinToSearch = Reader.readLine("Enter VIN to search for: ");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vinToSearch)) {
                System.out.println("Vehicle found:");
                displayVehicleDetails(vehicle);
                found = true;
                break; // Exit the loop after finding the vehicle
            }
        }
        if (!found) {
            System.out.println("Vehicle with VIN " + vinToSearch + " not found.");
        }
    }

    @Menu(id = 5, command = "5", description = "Display All Vehicles")
    public static void displayAllVehicles() {
        List<Vehicle> loadedVehicles = dataManager.loadVehicles(); // Load vehicles
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
        String vin = Reader.readLine("Enter VIN: ");
        String bodyType = Reader.readLine("Enter Body Type: ");
        return new Car(make, model, year, "Manual", "Black", 0, vin, bodyType);
    }
    
    private static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("VIN: " + vehicle.getVin());
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println("Body Type: " + car.getBodyType());
        }
    }

    public static void main(String[] args) {
        Application.start(VehicleManager.class);
    }
}