package ClassDesign;

import java.io.Serializable;
import java.util.Objects;

public abstract class Estate extends Car implements Serializable, Comparable<Estate> {

    private final String id; 

    private boolean thirdRowSeat;

    public Estate(String make, String model, int year, String gearbox, String colour, int mileage, String vin, boolean thirdRowSeat) {
        super(make, model, year, gearbox, colour, mileage, vin, "Estate");
        this.id = vin; 
        this.thirdRowSeat = thirdRowSeat;
    }

    public String getId() {
        return id;
    }

    public boolean hasThirdRowSeat() {
        return thirdRowSeat;
    }

    public void setThirdRowSeat(boolean thirdRowSeat) {
        this.thirdRowSeat = thirdRowSeat;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Third Row Seat: " + thirdRowSeat;

    }

    @Override
    public int compareTo(Estate other) {
       
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
        final Estate other = (Estate) obj;
        return Objects.equals(this.id, other.id);
    }

}