package dao.impls;

import dao.DbSetup;
import entity.Country;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

public class CountryDaoImplTest extends DbSetup {
CountryDaoImpl countryDao;
Country country = new Country("Bobruska");
Country temp;
    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
       countryDao = ctx.getBean(CountryDaoImpl.class);
    }
    @Test
    public void addCountry() {
        countryDao.addCountry(country);
        Assert.assertNotEquals(country.getId(), 0);
        countryDao.deleteCountry(country);
    }

    @Test
    public void updateCountry() {
        countryDao.addCountry(country);
        temp = countryDao.getCountryById(country.getId());
        countryDao.updateCountry(new Country(country.getId(), "BiberLand"));
        country = countryDao.getCountryById(country.getId());
        Assert.assertNotEquals(country, temp);
    }



    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteCountry() {
        countryDao.addCountry(country);
        countryDao.deleteCountry(country);
        countryDao.getCountryById(country.getId());
    }
}