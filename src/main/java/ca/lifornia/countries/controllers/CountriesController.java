package ca.lifornia.countries.controllers;

import ca.lifornia.countries.models.Country;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountriesController {

    @RequestMapping(path = "/countries", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getAllCountries() {
        final ArrayList<Country> countryArrayList = new ArrayList<Country>();
        return countryArrayList;
    }
}
