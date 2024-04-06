package ClassDesign;

import devtools.util.Reader;

public class StandardMotorbike extends Motorbike {

    public StandardMotorbike(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean luggageBox) {
        super(make, model, year, gearbox, colour, mileage, vin, luggageBox);
    }

    @Override
    public void displayDetails() {
        
        System.out.println("StandardMotorbike details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("VIN: " + getVin());
        System.out.println("Luggage box: " + hasLuggageBox());
    }

    @Override
    public void addLuggageBox() {
        
        if (!hasLuggageBox()) {
            System.out.println("Luggage box added to standard motorbike.");
            super.addLuggageBox();
        } else {
            System.out.println("Motorbike already has a luggage box.");
        }
    }

    @Override
    public void removeLuggageBox() {
        
        if (hasLuggageBox()) {
            System.out.println("Luggage box removed from standard motorbike.");
            super.removeLuggageBox();
        } else {
            System.out.println("Motorbike does not have a luggage box.");
        }
    }

    public void manageLuggage() {
        boolean hasLuggage = hasLuggageBox();
        if (hasLuggage) {
            
            String choice = Reader.readLine("Motorbike currently has luggage. Do you want to remove it? (yes/no): ");
            if (choice.equalsIgnoreCase("yes")) {
                removeLuggageBox();
            } else {
                System.out.println("No changes made to luggage.");
            }
        } else {
            
            String choice = Reader.readLine("Motorbike currently does not have luggage. Do you want to add it? (yes/no): ");
            if (choice.equalsIgnoreCase("yes")) {
                addLuggageBox();
            } else {
                System.out.println("No changes made to luggage.");
            }
        }
    }
}