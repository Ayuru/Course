package stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        List<Country> countriesOfEurope = new ArrayList<>();
        countriesOfEurope.add(new Country("Poland", new BigDecimal(41026067)));
        countriesOfEurope.add(new Country("France", new BigDecimal(64756584)));
        countriesOfEurope.add(new Country("Germany", new BigDecimal(83294633)));
        countriesOfEurope.add(new Country("UK", new BigDecimal(67736802)));

        List<Country> countriesOfAsia = new ArrayList<>();
        countriesOfAsia.add(new Country("Japan", new BigDecimal(123294513)));
        countriesOfAsia.add(new Country("South Korea", new BigDecimal(51784059)));

        Continent europe = new Continent("Europe", countriesOfEurope);
        Continent asia = new Continent("Asia", countriesOfAsia);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        assertEquals(worldPopulation, new BigDecimal(431892658));

    }
}
