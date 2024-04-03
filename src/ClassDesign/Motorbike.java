package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class Motorbike extends Vehicle implements Serializable, Comparable<Motorbike> {

    private final String id; 
    private boolean luggageBox;

    public Motorbike(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean luggageBox) {
        super(make, model, year, gearbox, colour, mileage, vin, "Motorbike");
        this.id = vin; 
        this.luggageBox = luggageBox;
    }

    public String getId() {
        return id;
    }

    public boolean hasLuggageBox() {
        return luggageBox;
    }

    public void addLuggageBox() {
        luggageBox = true;
    }

    public void removeLuggageBox() {
        luggageBox = false;
    }

    @Override
    public String toString() {
        return super.toString() + "Luggage Box: " + luggageBox;
    }

    @Override
    public int compareTo(Motorbike other) {
        
        return 0; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Motorbike other = (Motorbike) obj;
        return Objects.equals(this.id, other.id);
    }

}