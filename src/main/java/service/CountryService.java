package service;

import entity.Country;

public interface CountryService {

    void addCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(Country country);

    Country getCountryById(int id);
}
