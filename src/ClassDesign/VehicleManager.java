package ClassDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManager {
    private Scanner scanner;
    private List<Vehicle> vehicles;
    private DataManager dataManager;

    public VehicleManager() {
        scanner = new Scanner(System.in);
        vehicles = new ArrayList<>();
        dataManager = new DataManager();
    }

    public void startInteractiveSystem() {
        while (true) {
            displayMainMenu();
            int choice = getMenuChoice();
            handleMenuAction(choice);
        }
    }

    private void displayMainMenu() {
        System.out.println("\nVehicle Management System");
        System.out.println("1. Add Car");
        System.out.println("2. Add Options to a Vehicle");
        System.out.println("3. Remove Vehicle");
        System.out.println("4. Search Vehicle by VIN");
        System.out.println("5. Display All Vehicles");
        System.out.println("6. Quit");
    }

    private int getMenuChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private void handleMenuAction(int choice) {
        switch (choice) {
            case 1:
                addCar();
                break;
            case 2:
                addOptionsToVehicle();
                break;
            case 3:
                removeVehicle();
                break;
            case 4:
                searchVehicle();
                break;
            case 5:
                displayAllVehicles();
                break;
            case 6:
                dataManager.saveVehicles(vehicles); 
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addCar() {
        Car newCar = createCar();
        vehicles.add(newCar);
        System.out.println("Car added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

  private void addOptionsToVehicle() {
    System.out.print("Enter VIN of the vehicle to add options: ");
    String vin = scanner.next();
    boolean found = false;
    for (Vehicle vehicle : vehicles) {
        if (vehicle.getVin().equals(vin)) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("Select options to add:");
                System.out.println("1. Sat Nav");
                System.out.println("2. Parking Sensors");
                System.out.println("3. Tow Bar");
                System.out.println("4. Roof Rack");
                int optionChoice = scanner.nextInt();
                switch (optionChoice) {
                    case 1:
                        car.addSatNav();
                        break;
                    case 2:
                        car.addParkingSensors();
                        break;
                    case 3:
                        car.addTowBar();
                        break;
                    case 4:
                        car.addRoofRack();
                        break;
                    default:
                        System.out.println("Invalid option choice.");
                        break;
                }
                System.out.println("Options added to the vehicle successfully.");
            } else {
                System.out.println("Options can only be added to cars.");
            }
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Vehicle with VIN " + vin + " not found.");
    }
}
  
  
    private void removeVehicle() {
        System.out.print("Enter VIN of the vehicle to remove: ");
        String vin = scanner.next();
        boolean removed = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVin().equals(vin)) {
                vehicles.remove(i);
                removed = true;
                System.out.println("Vehicle removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    private void searchVehicle() {
        System.out.print("Enter VIN of the vehicle to search: ");
        String vin = scanner.next();
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vin)) {
                displayVehicleDetails(vehicle);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    private void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            System.out.println("All Vehicles:");
            for (Vehicle vehicle : vehicles) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    private Car createCar() {
        System.out.println("Enter car details:");

        System.out.print("Make: ");
        String make = scanner.next();

        System.out.print("Model: ");
        String model = scanner.next();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("VIN: ");
        String vin = scanner.next();

        System.out.print("Body Type: ");
        String bodyType = scanner.next();

       
        return new Car(make, model, year, "Manual", "Black", 0, vin, bodyType);
    }

    private void displayVehicleDetails(Vehicle vehicle) {
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
        VehicleManager manager = new VehicleManager();
        manager.startInteractiveSystem();
    }
}