package ClassDesign;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILENAME = "vehicles.dat";

    public void saveVehicles(List<Vehicle> vehicles) {
        try (FileOutputStream fos = new FileOutputStream(FILENAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(vehicles);
            System.out.println("Vehicles saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving vehicles: " + e.getMessage());
        }
    }

    public List<Vehicle> loadVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            vehicles = (List<Vehicle>) ois.readObject();
            System.out.println("Vehicles loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No vehicles found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading vehicles: " + e.getMessage());
        }
        return vehicles;
    }
}