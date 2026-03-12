import java.util.List;

public class HeavyTruckImmutabilityTest {

    public static void main(String[] args) {

        Engine engine = DieselEngine.of("ENG-001");

        Tire tire = Tire.of("Michelin", 22, 100);

        HeavyTruck truck = HeavyTruck.builder("ABC-123", engine)
                .maxLoadCapacity(15000)
                .addTire(tire)
                .addTire(tire)
                .addTire(tire)
                .addTire(tire)
                .build();

        System.out.println("Truck created: " + truck);

        List<Tire> tires = truck.getTires();

        try {

            tires.add(Tire.of("Illegal", 20, 90));

            System.out.println("ERROR: Truck mutated!");

        } catch (UnsupportedOperationException e) {

            System.out.println("SUCCESS: Truck is immutable.");
        }

        System.out.println("Tire count: " + truck.getTires().size());
    }
}