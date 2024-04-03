package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class Hatchback extends Vehicle implements Serializable, Comparable<Hatchback> {

    private final String id; 

    public Hatchback(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        super(make, model, year, gearbox, colour, mileage, vin, "Hatchback");
        this.id = vin; 
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public int compareTo(Hatchback other) {
        
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
        final Hatchback other = (Hatchback) obj;
        return Objects.equals(this.id, other.id);
    }

}