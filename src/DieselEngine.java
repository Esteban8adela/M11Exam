import java.util.Objects;

public final class DieselEngine implements Engine {

    private final String serialNumber;

    private DieselEngine(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public static DieselEngine of(String serialNumber) {

        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial number required");
        }

        return new DieselEngine(serialNumber);
    }

    @Override
    public void ignite() {
        // no side effects
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DieselEngine that = (DieselEngine) o;

        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "DieselEngine{" +
                "serialNumber='" + serialNumber + '\'' +
                '}';
    }
}