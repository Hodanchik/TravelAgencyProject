package dao;


import entity.Country;

import org.springframework.stereotype.Repository;

@Repository
public interface CountryDao {
    void addCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(Country country);

    Country getCountryById(int id);

}
