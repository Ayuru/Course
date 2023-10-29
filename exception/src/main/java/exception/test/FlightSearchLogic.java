package exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchLogic {

    public Map<String, Boolean> destinations() {

        Map<String, Boolean> destinations = new HashMap<>();

        destinations.put("Los Angeles", true);
        destinations.put("Bogota", true);
        destinations.put("Sydney", true);
        destinations.put("Osaka", true);
        destinations.put("Jerusalem", false);
        destinations.put("Kabul", false);
        destinations.put("Moscow", false);

        return destinations;
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String arrivalAirport = flight.getArrivalAirport();
        if (!destinations().containsKey(arrivalAirport) || !destinations().get(arrivalAirport)) {
            throw new RouteNotFoundException("There is no flight to " + arrivalAirport);
        }
        System.out.println("Lets go to " + arrivalAirport + "!\n");
    }
}
