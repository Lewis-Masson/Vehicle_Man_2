package ClassDesign;

import devtools.util.Reader;

public class StandardMotorbike extends Motorbike {

    public StandardMotorbike(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean luggageBox) {
        super(make, model, year, gearbox, colour, mileage, vin, luggageBox);
    }

    @Override
    public void displayDetails() {
        // Implement the displayDetails method specific to StandardMotorbike
        // This method should display the details of the StandardMotorbike
        System.out.println("StandardMotorbike details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("VIN: " + getVin());
        System.out.println("Luggage box: " + hasLuggageBox());
    }

    @Override
    public void addLuggageBox() {
        // Implement the logic to add a luggage box to a standard motorbike
        // For example:
        if (!hasLuggageBox()) {
            System.out.println("Luggage box added to standard motorbike.");
            super.addLuggageBox();
        } else {
            System.out.println("Motorbike already has a luggage box.");
        }
    }

    @Override
    public void removeLuggageBox() {
        // Implement the logic to remove a luggage box from a standard motorbike
        // For example:
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
            // Motorbike has luggage, so give the option to remove it
            String choice = Reader.readLine("Motorbike currently has luggage. Do you want to remove it? (yes/no): ");
            if (choice.equalsIgnoreCase("yes")) {
                removeLuggageBox();
            } else {
                System.out.println("No changes made to luggage.");
            }
        } else {
            // Motorbike doesn't have luggage, so give the option to add it
            String choice = Reader.readLine("Motorbike currently does not have luggage. Do you want to add it? (yes/no): ");
            if (choice.equalsIgnoreCase("yes")) {
                addLuggageBox();
            } else {
                System.out.println("No changes made to luggage.");
            }
        }
    }
}