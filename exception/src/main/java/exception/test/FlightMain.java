package exception.test;

public class FlightMain {
    public static void main(String[] args) {

        Flight destinationExists = new Flight("Wroclaw", "Osaka");
        Flight destinationDoesntExist = new Flight("Wroclaw", "Kabul");

        FlightSearchLogic routeSearch = new FlightSearchLogic();

        try {
            routeSearch.findFlight(destinationExists);
            routeSearch.findFlight(destinationDoesntExist);
        } catch (RouteNotFoundException e) {
            System.out.println("You can't go there... " + e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
