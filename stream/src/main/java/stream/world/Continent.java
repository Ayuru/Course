package stream.world;

import stream.forumuser.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final String name;
    private final List<Country> countryList;

    public Continent(String name, List<Country> countryList) {
        this.name = name;
        this.countryList = countryList;
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
