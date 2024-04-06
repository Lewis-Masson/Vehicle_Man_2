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

    static {
        dataManager = new DataManager();
        initializeVehicles();
    }

    private static void initializeVehicles() {
        vehicles.add(new StandardSUV("Toyota", "RAV4", 2022, "Automatic", "Red", 0, "VIN1", true, true, true, false, false));
        vehicles.add(new StandardSUV("Honda", "CR-V", 2021, "Automatic", "Blue", 5000, "VIN2", true, true, false, false, false));
        vehicles.add(new StandardEstate("Volkswagen", "Passat", 2020, "Automatic", "Black", 10000, "VIN3", true, true, true, true, true));
        vehicles.add(new StandardHatchback("Ford", "Focus", 2019, "Manual", "Silver", 20000, "VIN4", false, true, false, false));
        vehicles.add(new StandardSaloon("Toyota", "HILUX", 2018, "Automatic", "White", 30000, "VIN5", false, true, true, false));
        vehicles.add(new StandardSUV("Audi", "Q8", 2021, "Manual", "Black", 1000, "VIN6", false, true, true, true, true));
        vehicles.add(new StandardSUV("Ford", "Kuga", 2020, "Automatic", "Gray", 15000, "VIN7", true, false, true, false, false));
        vehicles.add(new StandardEstate("Audi", "A4 Avant", 2019, "Automatic", "Silver", 25000, "VIN8", false, false, true, false, true));
        vehicles.add(new StandardHatchback("Volkswagen", "Golf", 2021, "Automatic", "Blue", 8000, "VIN9", false, true, false, true));
        vehicles.add(new StandardSaloon("BMW", "3 Series", 2020, "Automatic", "Black", 20000, "VIN10", true, false, true, true));
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

        boolean hasRoofRack = Reader.readBoolean("Does the SUV have a roof rack? (true/false): ");
        boolean hasSatNav = Reader.readBoolean("Does the SUV have sat nav? (true/false): ");
        boolean hasParkingSensors = Reader.readBoolean("Does the SUV have parking sensors? (true/false): ");
        boolean hasTowBar = Reader.readBoolean("Does the SUV have a tow bar? (true/false): ");

      
        if (!hasRoofRack) {
            String addRoofRack = Reader.readLine("Do you want to add a roof rack? (yes/no): ");
            if (addRoofRack.equalsIgnoreCase("yes")) {
                hasRoofRack = true;
            }
        }

        if (!hasSatNav) {
            String addSatNav = Reader.readLine("Do you want to add sat nav? (yes/no): ");
            if (addSatNav.equalsIgnoreCase("yes")) {
                hasSatNav = true;
            }
        }

        if (!hasParkingSensors) {
            String addParkingSensors = Reader.readLine("Do you want to add parking sensors? (yes/no): ");
            if (addParkingSensors.equalsIgnoreCase("yes")) {
                hasParkingSensors = true;
            }
        }

        if (!hasTowBar) {
            String addTowBar = Reader.readLine("Do you want to add a tow bar? (yes/no): ");
            if (addTowBar.equalsIgnoreCase("yes")) {
                hasTowBar = true;
            }
        }

        return new StandardSUV(make, model, year, gearbox, colour, mileage, vin, allWheelDrive, hasRoofRack, hasSatNav, hasParkingSensors, hasTowBar);
    }

    @Menu(id = 3, command = "3", description = "Add Saloon")
    public static void addSaloon() {
        Saloon newSaloon = createSaloon();
        vehicles.add(newSaloon);
        System.out.println("Saloon added successfully.");
        dataManager.saveVehicles(vehicles);
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

       
        boolean hasRoofRack = Reader.readBoolean("Does the Saloon have a roof rack? (true/false): ");
        boolean hasSatNav = Reader.readBoolean("Does the Saloon have sat nav? (true/false): ");
        boolean hasParkingSensors = Reader.readBoolean("Does the Saloon have parking sensors? (true/false): ");
        boolean hasTowBar = Reader.readBoolean("Does the Saloon have a tow bar? (true/false): ");

      
        if (!hasRoofRack) {
            String addRoofRack = Reader.readLine("Do you want to add a roof rack? (yes/no): ");
            if (addRoofRack.equalsIgnoreCase("yes")) {
                hasRoofRack = true;
            }
        }

        if (!hasSatNav) {
            String addSatNav = Reader.readLine("Do you want to add sat nav? (yes/no): ");
            if (addSatNav.equalsIgnoreCase("yes")) {
                hasSatNav = true;
            }
        }

        if (!hasParkingSensors) {
            String addParkingSensors = Reader.readLine("Do you want to add parking sensors? (yes/no): ");
            if (addParkingSensors.equalsIgnoreCase("yes")) {
                hasParkingSensors = true;
            }
        }

        if (!hasTowBar) {
            String addTowBar = Reader.readLine("Do you want to add a tow bar? (yes/no): ");
            if (addTowBar.equalsIgnoreCase("yes")) {
                hasTowBar = true;
            }
        }

       
        return new StandardSaloon(make, model, year, gearbox, colour, mileage, vin, hasRoofRack, hasSatNav, hasParkingSensors, hasTowBar);
    }

    @Menu(id = 4, command = "4", description = "Add Hatchback")
    public static void addHatchback() {
        Hatchback newHatchback = createHatchback();
        vehicles.add(newHatchback);
        System.out.println("Hatchback added successfully.");
        dataManager.saveVehicles(vehicles);
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
        boolean hasRoofRack = Reader.readBoolean("Does the Hatchback have a roof rack? (true/false): ");
        boolean hasSatNav = Reader.readBoolean("Does the Hatchback have sat nav? (true/false): ");
        boolean hasParkingSensors = Reader.readBoolean("Does the Hatchback have parking sensors? (true/false): ");
        boolean hasTowBar = Reader.readBoolean("Does the Hatchback have a tow bar? (true/false): ");

       
        if (!hasRoofRack) {
            String addRoofRack = Reader.readLine("Do you want to add a roof rack? (yes/no): ");
            if (addRoofRack.equalsIgnoreCase("yes")) {
                hasRoofRack = true;
            }
        }

        if (!hasSatNav) {
            String addSatNav = Reader.readLine("Do you want to add sat nav? (yes/no): ");
            if (addSatNav.equalsIgnoreCase("yes")) {
                hasSatNav = true;
            }
        }

        if (!hasParkingSensors) {
            String addParkingSensors = Reader.readLine("Do you want to add parking sensors? (yes/no): ");
            if (addParkingSensors.equalsIgnoreCase("yes")) {
                hasParkingSensors = true;
            }
        }

        if (!hasTowBar) {
            String addTowBar = Reader.readLine("Do you want to add a tow bar? (yes/no): ");
            if (addTowBar.equalsIgnoreCase("yes")) {
                hasTowBar = true;
            }
        }

        return new StandardHatchback(make, model, year, gearbox, colour, mileage, vin, hasRoofRack, hasSatNav, hasParkingSensors, hasTowBar);
    }

    @Menu(id = 5, command = "5", description = "Add Estate")
    public static void addEstate() {
        Estate newEstate = createEstate();
        vehicles.add(newEstate);
        System.out.println("Estate added successfully.");
        dataManager.saveVehicles(vehicles);
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
        boolean hasSatNav = Reader.readBoolean("Does the Estate have sat nav? (true/false): ");
        boolean hasParkingSensors = Reader.readBoolean("Does the Estate have parking sensors? (true/false): ");
        boolean hasTowBar = Reader.readBoolean("Does the Estate have a tow bar? (true/false): ");
        boolean hasThirdRowSeat = Reader.readBoolean("Does the Estate have a third row seat? (true/false): ");

        if (!hasThirdRowSeat) {
            String addThirdRowSeat = Reader.readLine("Do you want to add a third row seat? (yes/no): ");
            if (addThirdRowSeat.equalsIgnoreCase("yes")) {
                hasThirdRowSeat = true;
            }
        }

        if (!hasRoofRack) {
            String addRoofRack = Reader.readLine("Do you want to add a roof rack? (yes/no): ");
            if (addRoofRack.equalsIgnoreCase("yes")) {
                hasRoofRack = true;
            }
        }

        if (!hasSatNav) {
            String addSatNav = Reader.readLine("Do you want to add sat nav? (yes/no): ");
            if (addSatNav.equalsIgnoreCase("yes")) {
                hasSatNav = true;
            }
        }

        if (!hasParkingSensors) {
            String addParkingSensors = Reader.readLine("Do you want to add parking sensors? (yes/no): ");
            if (addParkingSensors.equalsIgnoreCase("yes")) {
                hasParkingSensors = true;
            }
        }

        if (!hasTowBar) {
            String addTowBar = Reader.readLine("Do you want to add a tow bar? (yes/no): ");
            if (addTowBar.equalsIgnoreCase("yes")) {
                hasTowBar = true;
            }
        }

        return new StandardEstate(make, model, year, gearbox, colour, mileage, vin, hasRoofRack, hasSatNav, hasParkingSensors, hasTowBar, hasThirdRowSeat);
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
    if (!vehicles.isEmpty()) {
        System.out.println("List of Vehicles:");
        for (Vehicle vehicle : vehicles) {
            displayVehicleDetails(vehicle);
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

    @Menu(id = 9, command = "9", description = "List Vehicles by Type")
    public static void listVehiclesByType() {
        String vehicleType = Reader.readLine("Enter the type of vehicle to list (SUV/Estates/Hatchbacks/Saloons/Motorbikes): ");

        switch (vehicleType.toLowerCase()) {
            case "suv":
                listSUVs();
                break;
            case "estate":
                listEstates();
                break;
            case "hatchback":
                listHatchbacks();
                break;
            case "saloon":
                listSaloons();
                break;
            case "motorbike":
                listMotorbikes();
                break;
            default:
                System.out.println("Invalid vehicle type.");
                break;
        }
    }

    public static void listSUVs() {
        System.out.println("List of SUVs:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof SUV) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    public static void listEstates() {
        System.out.println("List of Estates:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Estate) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    public static void listHatchbacks() {
        System.out.println("List of Hatchbacks:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Hatchback) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    public static void listSaloons() {
        System.out.println("List of Saloons:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saloon) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    public static void listMotorbikes() {
        System.out.println("List of Motorbikes:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorbike) {
                displayVehicleDetails(vehicle);
            }
        }
    }

    @Menu(id = 10, command = "6", description = "Remove Vehicle")
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
