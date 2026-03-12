import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class HeavyTruck {

    private final String licensePlate;
    private final double maxLoadCapacity;
    private final Engine engine;
    private final List<Tire> tires;

    private HeavyTruck(Builder builder) {
        this.licensePlate = builder.licensePlate;
        this.maxLoadCapacity = builder.maxLoadCapacity;
        this.engine = builder.engine;
        this.tires = List.copyOf(builder.tires);
    }

    public static Builder builder(String licensePlate, Engine engine) {
        return new Builder(licensePlate, engine);
    }

    public String getLicensePlate() { return licensePlate; }
    public double getMaxLoadCapacity() { return maxLoadCapacity; }
    public Engine getEngine() { return engine; }
    public List<Tire> getTires() { return tires; }

    public static final class Builder {

        private final String licensePlate;
        private final Engine engine;

        private double maxLoadCapacity;
        private final List<Tire> tires = new ArrayList<>();

        private Builder(String licensePlate, Engine engine) {

            if (licensePlate == null || licensePlate.isBlank()) {
                throw new IllegalArgumentException("License plate required");
            }

            if (engine == null) {
                throw new IllegalArgumentException("Engine required");
            }

            this.licensePlate = licensePlate;
            this.engine = engine;
        }

        public Builder maxLoadCapacity(double capacity) {

            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive");
            }

            this.maxLoadCapacity = capacity;
            return this;
        }

        public Builder addTire(Tire tire) {

            if (tire == null) {
                throw new IllegalArgumentException("Tire cannot be null");
            }

            tires.add(tire);
            return this;
        }

        public Builder addTires(List<Tire> tires) {

            if (tires == null) {
                throw new IllegalArgumentException("Tire list cannot be null");
            }

            tires.forEach(this::addTire);
            return this;
        }

        public HeavyTruck build() {

            if (tires.size() < 4) {
                throw new IllegalStateException("Truck must have at least 4 tires");
            }

            return new HeavyTruck(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeavyTruck that = (HeavyTruck) o;

        return Double.compare(that.maxLoadCapacity, maxLoadCapacity) == 0 &&
                Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(engine, that.engine) &&
                Objects.equals(tires, that.tires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, maxLoadCapacity, engine, tires);
    }

    @Override
    public String toString() {
        return "HeavyTruck{" +
                "licensePlate='" + licensePlate + '\'' +
                ", maxLoadCapacity=" + maxLoadCapacity +
                ", engine=" + engine +
                ", tires=" + tires +
                '}';
    }
}