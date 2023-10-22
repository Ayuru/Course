package stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Continent> continentsList = new ArrayList<>();

    public void addContinent(Continent continent) {

        continentsList.add(continent);

    }

    public BigDecimal getPeopleQuantity() {

        return continentsList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum = sum.add(country));
    }
}
