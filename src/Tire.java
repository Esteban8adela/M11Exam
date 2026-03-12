import java.util.Objects;

public final class Tire {

    private final String brand;
    private final int size;
    private final double pressure;

    private Tire(String brand, int size, double pressure) {
        this.brand = brand;
        this.size = size;
        this.pressure = pressure;
    }

    public static Tire of(String brand, int size, double pressure) {

        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand required");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }

        if (pressure <= 0) {
            throw new IllegalArgumentException("Pressure must be positive");
        }

        return new Tire(brand, size, pressure);
    }

    public String getBrand() { return brand; }
    public int getSize() { return size; }
    public double getPressure() { return pressure; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tire tire = (Tire) o;

        return size == tire.size &&
                Double.compare(tire.pressure, pressure) == 0 &&
                Objects.equals(brand, tire.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, size, pressure);
    }

    @Override
    public String toString() {
        return "Tire{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                ", pressure=" + pressure +
                '}';
    }
}