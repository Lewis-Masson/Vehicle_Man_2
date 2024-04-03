package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class Saloon extends Vehicle implements Serializable, Comparable<Saloon> {

    private final String id; 

    public Saloon(String make, String model, int year, String gearbox, String colour, int mileage, String vin) {
        super(make, model, year, gearbox, colour, mileage, vin, "Saloon");
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
    public int compareTo(Saloon other) {
        
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
        final Saloon other = (Saloon) obj;
        return Objects.equals(this.id, other.id);
    }

}