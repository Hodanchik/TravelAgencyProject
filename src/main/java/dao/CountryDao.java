package dao;


import entity.Country;

public interface CountryDao {
    void addCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(Country country);


}
