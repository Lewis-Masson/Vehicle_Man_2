package ClassDesign;

import java.io.Serializable;

public abstract class Estate extends Car implements Serializable, Comparable<Estate> {
    private final String id;
    protected boolean hasRoofRack;
    protected boolean hasThirdRowSeat;

    public Estate(String make, String model, int year, String gearbox, String colour, int mileage, String vin,
            boolean hasRoofRack, boolean hasThirdRowSeat) {
        super(make, model, year, gearbox, colour, mileage, vin, "Estate");
        this.id = vin;
        this.hasRoofRack = hasRoofRack;
        this.hasThirdRowSeat = hasThirdRowSeat;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Estate other) {
        return 0; // Implement comparison logic if needed
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (hasRoofRack ? 1 : 0);
        hash = 31 * hash + (hasThirdRowSeat ? 1 : 0);
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
        if (!super.equals(obj)) {
            return false;
        }
        Estate other = (Estate) obj;
        return hasRoofRack == other.hasRoofRack && hasThirdRowSeat == other.hasThirdRowSeat;
    }
}