import java.util.Objects;

public final class Order {

    private final int orderId;
    private final String destination;
    private final double weight;
    private final boolean isPaid;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.destination = builder.destination;
        this.weight = builder.weight;
        this.isPaid = builder.isPaid;
    }

    public static Builder builder(int orderId, String destination) {
        return new Builder(orderId, destination);
    }

    public int getOrderId() { return orderId; }
    public String getDestination() { return destination; }
    public double getWeight() { return weight; }
    public boolean isPaid() { return isPaid; }

    public static final class Builder {

        private final int orderId;
        private final String destination;

        private double weight = 0.0;
        private boolean isPaid = false;

        private Builder(int orderId, String destination) {
            if (destination == null || destination.isBlank()) {
                throw new IllegalArgumentException("Destination cannot be null or blank");
            }

            this.orderId = orderId;
            this.destination = destination;
        }

        public Builder weight(double weight) {
            if (weight < 0) {
                throw new IllegalArgumentException("Weight cannot be negative");
            }

            this.weight = weight;
            return this;
        }

        public Builder isPaid(boolean isPaid) {
            this.isPaid = isPaid;
            return this;
        }

        public Order build() {
            if (destination == null || destination.isBlank()) {
                throw new IllegalStateException("Destination required");
            }

            return new Order(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderId == order.orderId &&
                Double.compare(order.weight, weight) == 0 &&
                isPaid == order.isPaid &&
                Objects.equals(destination, order.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, destination, weight, isPaid);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                ", isPaid=" + isPaid +
                '}';
    }
}