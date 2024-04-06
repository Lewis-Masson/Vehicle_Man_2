package ClassDesign;

import devtools.io.Data;
import devtools.ui.Application;
import devtools.ui.Menu;
import devtools.util.Reader;
import devtools.util.Sequence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleManager {

    @Data
    public static List<Vehicle> vehicles = new ArrayList<>();  

    @Data
    public static Sequence seq = new Sequence(1, 100_000_000); 

    private static DataManager dataManager;

    static {
        dataManager = new DataManager();
    }

    @Menu(id = 0, command = "V",
            description = "Vehicle Menu",
            subMenuIDs = {1, 2, 3, 4, 5, 6},
            index = 0)
    public static void createVehicle() {
        String vehicleType = Reader.readLine("Enter the type of vehicle (Motorbike/SUV/Saloon/Hatchback/Estate): ");
        if (vehicleType.equalsIgnoreCase("Motorbike")) {
            addMotorbike();
        } else if (vehicleType.equalsIgnoreCase("SUV")) {
            addSUV();
        } else if (vehicleType.equalsIgnoreCase("Saloon")) {
            addSaloon();
        } else if (vehicleType.equalsIgnoreCase("Hatchback")) {
            addHatchback();
        } else if (vehicleType.equalsIgnoreCase("Estate")) {
            addEstate();
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    @Menu(id = 1, command = "1", description = "Add Motorbike")
    public static void addMotorbike() {
        Vehicle newVehicle = createMotorbike();
        vehicles.add(newVehicle);
        System.out.println("Motorbike added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 2, command = "2", description = "Add SUV")
    public static void addSUV() {
        SUV newSUV = createSUV();
        vehicles.add(newSUV);
        System.out.println("SUV added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 3, command = "3", description = "Add Saloon")
    public static void addSaloon() {
        Saloon newSaloon = createSaloon();
        vehicles.add(newSaloon);
        System.out.println("Saloon added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 4, command = "4", description = "Add Hatchback")
    public static void addHatchback() {
        Hatchback newHatchback = createHatchback();
        vehicles.add(newHatchback);
        System.out.println("Hatchback added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 5, command = "5", description = "Add Estate")
    public static void addEstate() {
        Estate newEstate = createEstate();
        vehicles.add(newEstate);
        System.out.println("Estate added successfully.");
        dataManager.saveVehicles(vehicles); 
    }

    @Menu(id = 6, command = "6", description = "Remove Vehicle")
    public static void removeVehicle() {
        String vinToRemove = Reader.readLine("Enter VIN of the vehicle to remove: ");
        boolean removed = false;
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getVin().equals(vinToRemove)) {
                iterator.remove();
                removed = true;
                System.out.println("Vehicle with VIN " + vinToRemove + " removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Vehicle with VIN " + vinToRemove + " not found.");
        } else {
            dataManager.saveVehicles(vehicles);
        }
    }

    @Menu(id = 7, command = "7", description = "Search Vehicle by VIN")
    public static void searchVehicle() {
        String vinToSearch = Reader.readLine("Enter VIN to search for: ");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equals(vinToSearch)) {
                System.out.println("Vehicle found:");
                displayVehicleDetails(vehicle);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with VIN " + vinToSearch + " not found.");
        }
    }

    @Menu(id = 8, command = "8", description = "Display All Vehicles")
    public static void displayAllVehicles() {
        List<Vehicle> loadedVehicles = dataManager.loadVehicles();
        if (!loadedVehicles.isEmpty()) {
            for (Vehicle vehicle : loadedVehicles) {
                System.out.println("Type: " + vehicle.getClass().getSimpleName()); 
                System.out.println(vehicle);
                System.out.println();
            }
        } else {
            System.out.println("There are currently no vehicles.");
        }
    }

  
    private static Motorbike createMotorbike() {
        System.out.println("Enter motorbike details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("Enter VIN: ");
        boolean initialLuggageBox = Reader.readBoolean("Does the motorbike have luggage box? (true/false): ");
        if (!initialLuggageBox) {
            String addOrRemove = Reader.readLine("Do you want to add luggage box? (yes/no): ");
            if (addOrRemove.equalsIgnoreCase("yes")) {
                return new StandardMotorbike(make, model, year, "Manual", "Black", 0, vin, true);
            } else {
                return new StandardMotorbike(make, model, year, "Manual", "Black", 0, vin, false);
            }
        } else {
            return new StandardMotorbike(make, model, year, "Manual", "Black", 0, vin, true);
        }
    }

    
    private static SUV createSUV() {
        System.out.println("Enter SUV details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("Enter VIN: ");
        String gearbox = Reader.readLine("Enter Gearbox: ");
        String colour = Reader.readLine("Enter Colour: ");
        int mileage = Reader.readInt("Enter Mileage: ");
        boolean allWheelDrive = Reader.readBoolean("Does the SUV have all-wheel drive? (true/false): ");

        if (!allWheelDrive) {
            String addAllWheelDrive = Reader.readLine("Do you want to add all-wheel drive? (yes/no): ");
            if (addAllWheelDrive.equalsIgnoreCase("yes")) {
                allWheelDrive = true;
            }
        }

        return new StandardSUV(make, model, year, gearbox, colour, mileage, vin, allWheelDrive);
    }

    
    private static Saloon createSaloon() {
        System.out.println("Enter Saloon details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("Enter VIN: ");
        String gearbox = Reader.readLine("Enter Gearbox: ");
        String colour = Reader.readLine("Enter Colour: ");
        int mileage = Reader.readInt("Enter Mileage: ");

        return new StandardSaloon(make, model, year, gearbox, colour, mileage, vin);
    }

    
    private static Hatchback createHatchback() {
        System.out.println("Enter Hatchback details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("Enter VIN: ");
        String gearbox = Reader.readLine("Enter Gearbox: ");
        String colour = Reader.readLine("Enter Colour: ");
        int mileage = Reader.readInt("Enter Mileage: ");

        return new StandardHatchback(make, model, year, gearbox, colour, mileage, vin);
    }

    
    private static Estate createEstate() {
        System.out.println("Enter Estate details:");
        String make = Reader.readLine("Make: ");
        String model = Reader.readLine("Model: ");
        int year = Reader.readInt("Year: ");
        String vin = Reader.readLine("Enter VIN: ");
        String gearbox = Reader.readLine("Enter Gearbox: ");
        String colour = Reader.readLine("Enter Colour: ");
        int mileage = Reader.readInt("Enter Mileage: ");
        boolean hasRoofRack = Reader.readBoolean("Does the Estate have a roof rack? (true/false): ");

        return new StandardEstate(make, model, year, gearbox, colour, mileage, vin, hasRoofRack);
    }

    private static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle Details:");
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            String carDetails = "Type: Car";
            if (car.getBodyType() != null) {
                carDetails += ", Body Type: " + car.getBodyType();
            }
            System.out.println(carDetails);
        } else if (vehicle instanceof Motorbike) {
            System.out.println("Type: Motorbike");
            Motorbike motorbike = (Motorbike) vehicle;
            System.out.println("Luggage Box: " + motorbike.hasLuggageBox());
        } else if (vehicle instanceof SUV) {
            System.out.println("Type: SUV");
           
        } else if (vehicle instanceof Saloon) {
            System.out.println("Type: Saloon");
            
        } else if (vehicle instanceof Hatchback) {
            System.out.println("Type: Hatchback");
           
        } else if (vehicle instanceof Estate) {
            System.out.println("Type: Estate");
            
        } else {
            System.out.println("Type: Unknown");
        }
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("VIN: " + vehicle.getVin());
    }

    public static void main(String[] args) {
        Application.start(VehicleManager.class);
    }
}
