package LogisticProblem;

public class Main {
    public static void main(String[] args) {

        Driver d = new Driver("D1204", "Kavita Nair");
        RouteLinkedList<Checkpoint> route = d.getRouteHistory();

        route.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 30, 60, 70));
        route.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 20, 30, 30));
        route.addCheckpoint(new RestCheckpoint("C3", "Motel X", 10, 20, 35));

        d.saveDriver();
        route.saveToDatabase("D1204");

        System.out.println("Saved to DB!\n");

        // LOAD FROM DB
        RouteLinkedList<Checkpoint> newRoute = new RouteLinkedList<>();
        newRoute.loadFromDatabase("D1204");

        System.out.println("Loaded Route:");
        newRoute.printRoute();
    }
}