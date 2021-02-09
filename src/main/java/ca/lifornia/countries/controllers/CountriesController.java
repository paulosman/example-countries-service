package ca.lifornia.countries.controllers;

import ca.lifornia.countries.models.Country;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.util.List;

@RestController
public class CountriesController {

    final String allUrl = "http://s3.amazonaws.com/json-countries/countries.json";

    private String getCountryUrl(int id) {
        return "http://s3.amazonaws.com/json-countries/" + String.valueOf(id) + ".json";
    }

    @RequestMapping(path = "/countries/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Country getAllCountryById(@PathVariable("id") int id) {
        final Country country = ClientBuilder.newClient().target(getCountryUrl(id))
            .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
            .get(Country.class);
        return country;
    }

    @RequestMapping(path = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getAllCountries() {
        final List<Country> countries = ClientBuilder.newClient().target(allUrl)
                .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Country>>() {});
        return countries;
    }
}
